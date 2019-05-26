package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author asathor
 */
@Embeddable
public class DetVentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "ID_VENTA", nullable = false, length = 36)
    private String idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LIBRO", nullable = false)
    private BigDecimal idLibro;

    public DetVentaPK() {
    }


    public DetVentaPK(String idVenta, BigDecimal idLibro) {
        this.idVenta = idVenta;
        this.idLibro = idLibro;
    }


    public String getIdVenta() {
        return idVenta;
    }


    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }


    public BigDecimal getIdLibro() {
        return idLibro;
    }


    public void setIdLibro(BigDecimal idLibro) {
        this.idLibro = idLibro;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetVentaPK)) {
            return false;
        }
        DetVentaPK other = (DetVentaPK) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "modelo.DetVentaPK[ idVenta=" + idVenta + ", idLibro=" + idLibro + " ]";
    }


}
