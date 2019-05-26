package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author asathor
 */
@Entity
@Table(name = "DET_VENTA", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetVenta.findAll", query = "SELECT d FROM DetVenta d")
    , @NamedQuery(name = "DetVenta.findByIdVenta", query = "SELECT d FROM DetVenta d WHERE d.detVentaPK.idVenta = :idVenta")
    , @NamedQuery(name = "DetVenta.findByIdLibro", query = "SELECT d FROM DetVenta d WHERE d.detVentaPK.idLibro = :idLibro")
    , @NamedQuery(name = "DetVenta.findByCantidad", query = "SELECT d FROM DetVenta d WHERE d.cantidad = :cantidad")})
public class DetVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetVentaPK detVentaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false)
    private short cantidad;
    @JoinColumn(name = "ID_LIBRO", referencedColumnName = "ID_LIBRO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public DetVenta() {
    }


    public DetVenta(DetVentaPK detVentaPK) {
        this.detVentaPK = detVentaPK;
    }


    public DetVenta(DetVentaPK detVentaPK, short cantidad) {
        this.detVentaPK = detVentaPK;
        this.cantidad = cantidad;
    }


    public DetVenta(String idVenta, BigDecimal idLibro) {
        this.detVentaPK = new DetVentaPK(idVenta, idLibro);
    }


    public DetVentaPK getDetVentaPK() {
        return detVentaPK;
    }


    public void setDetVentaPK(DetVentaPK detVentaPK) {
        this.detVentaPK = detVentaPK;
    }


    public short getCantidad() {
        return cantidad;
    }


    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }


    public Libro getLibro() {
        return libro;
    }


    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    public Venta getVenta() {
        return venta;
    }


    public void setVenta(Venta venta) {
        this.venta = venta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detVentaPK != null ? detVentaPK.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetVenta)) {
            return false;
        }
        DetVenta other = (DetVenta) object;
        if ((this.detVentaPK == null && other.detVentaPK != null) || (this.detVentaPK != null && !this.detVentaPK.equals(other.detVentaPK))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "modelo.DetVenta[ detVentaPK=" + detVentaPK + " ]";
    }


}
