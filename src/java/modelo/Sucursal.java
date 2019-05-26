/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



/**
 *
 * @author asathor
 */
@Entity
@Table(name = "SUCURSAL", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.idSucursal = :idSucursal")
    , @NamedQuery(name = "Sucursal.findByNombreSucursal", query = "SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal")
    , @NamedQuery(name = "Sucursal.findByDireccionSucursal", query = "SELECT s FROM Sucursal s WHERE s.direccionSucursal = :direccionSucursal")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL", nullable = false, precision = 0, scale = -127)
    private BigDecimal idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_SUCURSAL", nullable = false, length = 50)
    private String nombreSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DIRECCION_SUCURSAL", nullable = false, length = 80)
    private String direccionSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Usuario> usuarioList;

    public Sucursal() {
    }


    public Sucursal(BigDecimal idSucursal) {
        this.idSucursal = idSucursal;
    }


    public Sucursal(BigDecimal idSucursal, String nombreSucursal, String direccionSucursal) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
    }


    public BigDecimal getIdSucursal() {
        return idSucursal;
    }


    public void setIdSucursal(BigDecimal idSucursal) {
        this.idSucursal = idSucursal;
    }


    public String getNombreSucursal() {
        return nombreSucursal;
    }


    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }


    public String getDireccionSucursal() {
        return direccionSucursal;
    }


    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }


    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }


    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.nombreSucursal;
    }
    
}
