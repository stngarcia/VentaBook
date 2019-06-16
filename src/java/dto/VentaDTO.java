package dto;

import java.io.Serializable;


/**
 * @author asathor
 */
public class VentaDTO implements Serializable {

    private String idVenta;
    private String fechaVenta;
    private String rutUsuario;
    private String nombreUsuario;
    private String rutCliente;
    private String nombreCliente;
    private String tipoDocumento;
    private int idTipoDocumento;
    private String nombreSucursal;
    private String formaPago;
    private int idFormaPago;

    public VentaDTO() {
    }


    public String getIdVenta() {
        return idVenta;
    }


    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }


    public String getFechaVenta() {
        return fechaVenta;
    }


    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public String getRutUsuario() {
        return rutUsuario;
    }


    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getRutCliente() {
        return rutCliente;
    }


    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }


    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }


    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }


    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }


    public String getNombreSucursal() {
        return nombreSucursal;
    }


    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }


    public String getFormaPago() {
        return formaPago;
    }


    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }


    public int getIdFormaPago() {
        return idFormaPago;
    }


    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }


}
