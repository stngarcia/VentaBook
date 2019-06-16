package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * @author asathor
 */
@Entity
@Table(name = "VENTA", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Venta.findByRutcliente", query = "SELECT v FROM Venta v WHERE v.rutcliente = :rutcliente")
    , @NamedQuery(name = "Venta.findByNombrecliente", query = "SELECT v FROM Venta v WHERE v.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Venta.findByRazonsocialFactura", query = "SELECT v FROM Venta v WHERE v.razonsocialFactura = :razonsocialFactura")
    , @NamedQuery(name = "Venta.findByRutFactura", query = "SELECT v FROM Venta v WHERE v.rutFactura = :rutFactura")
    , @NamedQuery(name = "Venta.findByDireccionFactura", query = "SELECT v FROM Venta v WHERE v.direccionFactura = :direccionFactura")
    , @NamedQuery(name = "Venta.findByGiroFactura", query = "SELECT v FROM Venta v WHERE v.giroFactura = :giroFactura")
    , @NamedQuery(name = "Venta.findByContactoFactura", query = "SELECT v FROM Venta v WHERE v.contactoFactura = :contactoFactura")
    , @NamedQuery(name = "Venta.findByCiudadFactura", query = "SELECT v FROM Venta v WHERE v.ciudadFactura = :ciudadFactura")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 36)
    @Column(name = "ID_VENTA", nullable = false, length = 36)
    private String idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RUTCLIENTE", nullable = false, length = 10)
    private String rutcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRECLIENTE", nullable = false, length = 50)
    private String nombrecliente;
    @Size(max = 80)
    @Column(name = "RAZONSOCIAL_FACTURA", length = 80)
    private String razonsocialFactura;
    @Size(max = 10)
    @Column(name = "RUT_FACTURA", length = 10)
    private String rutFactura;
    @Size(max = 100)
    @Column(name = "DIRECCION_FACTURA", length = 100)
    private String direccionFactura;
    @Size(max = 50)
    @Column(name = "GIRO_FACTURA", length = 50)
    private String giroFactura;
    @Size(max = 50)
    @Column(name = "CONTACTO_FACTURA", length = 50)
    private String contactoFactura;
    @Size(max = 20)
    @Column(name = "CIUDAD_FACTURA", length = 20)
    private String ciudadFactura;
    @JoinColumn(name = "ID_TIPO_DOC", referencedColumnName = "ID_TIPO_DOC", nullable = false)
    @ManyToOne(optional = false)
    private TipoDoc idTipoDoc;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetVenta> detVentaList;

    public Venta() {
        this.idVenta = UUID.randomUUID().toString();
        this.fechaVenta = new Date();
        this.limpiarDatosFacturacion();
        this.detVentaList = new ArrayList<>();
    }


    public Venta(String idVenta) {
        this.idVenta = idVenta;
    }


    public Venta(String idVenta, Date fechaVenta, String rutcliente, String nombrecliente) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.rutcliente = rutcliente;
        this.nombrecliente = nombrecliente;
    }


    public String getIdVenta() {
        return idVenta;
    }


    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }


    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public String getRutcliente() {
        return rutcliente;
    }


    public void setRutcliente(String rutcliente) {
        this.rutcliente = rutcliente;
    }


    public String getNombrecliente() {
        return nombrecliente;
    }


    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }


    public String getRazonsocialFactura() {
        return razonsocialFactura;
    }


    public void setRazonsocialFactura(String razonsocialFactura) {
        this.razonsocialFactura = razonsocialFactura;
    }


    public String getRutFactura() {
        return rutFactura;
    }


    public void setRutFactura(String rutFactura) {
        this.rutFactura = rutFactura;
    }


    public String getDireccionFactura() {
        return direccionFactura;
    }


    public void setDireccionFactura(String direccionFactura) {
        this.direccionFactura = direccionFactura;
    }


    public String getGiroFactura() {
        return giroFactura;
    }


    public void setGiroFactura(String giroFactura) {
        this.giroFactura = giroFactura;
    }


    public String getContactoFactura() {
        return contactoFactura;
    }


    public void setContactoFactura(String contactoFactura) {
        this.contactoFactura = contactoFactura;
    }


    public String getCiudadFactura() {
        return ciudadFactura;
    }


    public void setCiudadFactura(String ciudadFactura) {
        this.ciudadFactura = ciudadFactura;
    }


    public TipoDoc getIdTipoDoc() {
        return idTipoDoc;
    }


    public void setIdTipoDoc(TipoDoc idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }


    public Usuario getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }


    @XmlTransient
    public List<DetVenta> getDetVentaList() {
        return detVentaList;
    }


    public void setDetVentaList(List<DetVenta> detVentaList) {
        this.detVentaList = detVentaList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }


    public void agregarDetalle(DetVenta miDetalle) {
        this.detVentaList.add(miDetalle);
    }


    public void removerDetalle(DetVenta miDetalle) {
        this.detVentaList.remove(miDetalle);
    }


    public void limpiarDetalles() {
        this.detVentaList.clear();
    }


    public void limpiarDatosFacturacion() {
        this.razonsocialFactura = "";
        this.rutFactura = "";
        this.direccionFactura = "";
        this.giroFactura = "";
        this.contactoFactura = "";
        this.ciudadFactura = "";
    }


    @Override
    public String toString() {
        return "modelo.Venta[ idVenta=" + idVenta + " ]";
    }


}
