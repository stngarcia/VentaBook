package controlador.jsf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.DetalleVentaDTO;
import dto.VentaAggregate;
import ejb.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.jms.JMSException;
import modelo.DetVenta;
import modelo.DetVentaPK;
import modelo.Libro;
import modelo.Venta;
import org.primefaces.event.SelectEvent;
import utils.MensajesAMQ;


/**
 * @author asathor
 */
@Named(value = "ventaBean")
@SessionScoped
public class ventaBean implements Serializable {

    @EJB
    private ejb.VentaFacade ventaFacade;

    private Venta venta = new Venta();
    private DetVenta detalle;
    private long total = 0;
    private String ventaJson = "";

    @ManagedProperty("#{LibroController}")
    private LibroController libroController;

    public ventaBean() {
    }


    private VentaFacade getFacade() {
        return ventaFacade;
    }


    @PostConstruct
    public void init() {
        venta = new Venta();
    }


    public LibroController getLibroController() {
        return libroController;
    }


    public Venta getVenta() {
        return venta;
    }


    public void setVenta(Venta venta) {
        this.venta = venta;
    }


    public Venta prepareCreate() {
        venta = new Venta();
        return venta;
    }


    public String getVentaJson() {
        return this.ventaJson;
    }


    public DetVenta getDetalle() {
        return detalle;
    }


    public void setDetalle(DetVenta detalle) {
        this.detalle = detalle;
    }


    public long getTotal() {
        return total;
    }


    public void prepararDetalle() {
        try {
            detalle = new DetVenta();
            short cantidad = 1;
            detalle.setCantidad(cantidad);
            detalle.setDetVentaPK(new DetVentaPK());
            detalle.setVenta(venta);
            detalle.setLibro(new Libro());
            this.mostrarMensaje("Mostrando", detalle.getVenta().getIdVenta());
        } catch (Exception ex) {
            this.mostrarMensaje("Error al crear" + ex.getMessage(), "");
            ex.getStackTrace();
        }
    }


    public void anularDetalle() {
        detalle = null;
        this.mostrarMensaje("Cancelando", "Selección de libro cancelada.");
    }


    public void confirmarCompra() {
        if (detalle.getLibro() == null) {
            return;
        }
        try {
            detalle.setDetVentaPK(new DetVentaPK(venta.getIdVenta(), detalle.getLibro().getIdLibro()));
            this.venta.agregarDetalle(detalle);
            calcularTotal();
            this.mostrarMensaje("Libro agregado", "Se agregaron " + detalle.getCantidad() + " libros " + detalle.getLibro().getTituloLibro() + " a la lista.");
        } catch (Exception ex) {
            this.mostrarMensaje("Error", ex.getMessage());
        }
    }


    public void quitarLibro() {
        venta.removerDetalle(detalle);
        calcularTotal();
        detalle = null;
    }


    public void limpiarLibros() {
        venta.limpiarDetalles();
        calcularTotal();
        detalle = null;
    }


    private void mostrarMensaje(String evento, String mensaje) {
        FacesMessage msg = new FacesMessage(evento, mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void calcularTotal() {
        if (venta.getDetVentaList().isEmpty() || venta.getDetVentaList() == null) {
            total = 0;
            return;
        }
        venta.getDetVentaList().forEach(o -> total = total + (o.getCantidad() * o.getLibro().getPrecioLibro()));
    }


    public void grabarVenta() {
        if (venta == null) {
            return;
        }
        getFacade().edit(venta);
        mostrarMensaje("Venta registrada", "La venta ha sido registrada correctamente.");
        this.convertirVentaToJson();
    }


    public void onDateSelect(SelectEvent event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha;
        try {
            fecha = format.parse((String) event.getObject());
        } catch (ParseException ex) {
            fecha = new Date();
        }
        venta.setFechaVenta(fecha);
    }


    private void convertirVentaToJson() {
        VentaAggregate vta = new VentaAggregate();
        try {
            this.traspasarVenta(vta);
            this.traspasarFactura(vta);
            this.traspasarDetalle(vta);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            ventaJson = mapper.writeValueAsString(vta);
            this.enviarMensaje();
        } catch (JsonProcessingException ex) {
            ventaJson = "Error de mierda!!!!" + ex.getMessage();
        }
        mostrarMensaje("Json", ventaJson);
    }


    private void traspasarVenta(VentaAggregate vta) {
        vta.getVentaInfo().setIdVenta(venta.getIdVenta());
        vta.getVentaInfo().setFechaVenta(venta.getFechaVenta());
        vta.getVentaInfo().setRutUsuario(venta.getIdUsuario().getRutUsuario());
        vta.getVentaInfo().setNombreUsuario(venta.getIdUsuario().getNombreUsuario());
        vta.getVentaInfo().setRutCliente(venta.getRutcliente());
        vta.getVentaInfo().setNombreCliente(venta.getNombrecliente());
        vta.getVentaInfo().setTipoDocumento(venta.getIdTipoDoc().getNombreTipoDocumento());
        vta.getVentaInfo().setIdTipoDocumento(venta.getIdTipoDoc().getIdTipoDoc().intValue());
        vta.getVentaInfo().setNombreSucursal(venta.getIdUsuario().getIdSucursal().getNombreSucursal());
        vta.getVentaInfo().setFormaPago("Efectivo");
        vta.getVentaInfo().setIdFormaPago(1);
    }


    private void traspasarFactura(VentaAggregate vta) {
        vta.getDatosFacturacionInfo().setRazonSocial(venta.getRazonsocialFactura());
        vta.getDatosFacturacionInfo().setRut(venta.getRutFactura());
        vta.getDatosFacturacionInfo().setDireccion(venta.getDireccionFactura());
        vta.getDatosFacturacionInfo().setGiro(venta.getGiroFactura());
        vta.getDatosFacturacionInfo().setContacto(venta.getContactoFactura());
        vta.getDatosFacturacionInfo().setCiudad(venta.getCiudadFactura());
        vta.getDatosFacturacionInfo().setCantidadDetalle(venta.getDetVentaList().size());
    }


    private void traspasarDetalle(VentaAggregate vta) {
        DetalleVentaDTO miDetalle;
        for (DetVenta d : venta.getDetVentaList()) {
            miDetalle = new DetalleVentaDTO();
            miDetalle.setIdEjemplar(d.getLibro().getIdLibro().toString());
            miDetalle.setNombreEjemplar(d.getLibro().getTituloLibro());
            miDetalle.setPrecioUnitario(d.getLibro().getPrecioLibro());
            miDetalle.setCantidad(d.getCantidad());
            miDetalle.setPrecioTotal((d.getCantidad() * d.getLibro().getPrecioLibro()));
            vta.agregarDetalle(miDetalle);
        }
    }


    private void enviarMensaje() {
        MensajesAMQ miMensaje = MensajesAMQ.crear();
        miMensaje.setMensaje(ventaJson);
        try {
            miMensaje.enviarMensaje();
        } catch (JMSException ex) {
            Logger.getLogger(ventaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
