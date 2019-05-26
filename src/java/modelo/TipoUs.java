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
@Table(name = "TIPO_US", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUs.findAll", query = "SELECT t FROM TipoUs t")
    , @NamedQuery(name = "TipoUs.findByIdTipo", query = "SELECT t FROM TipoUs t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TipoUs.findByNombreTipo", query = "SELECT t FROM TipoUs t WHERE t.nombreTipo = :nombreTipo")})
public class TipoUs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO", nullable = false, precision = 0, scale = -127)
    private BigDecimal idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_TIPO", nullable = false, length = 20)
    private String nombreTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<Usuario> usuarioList;

    public TipoUs() {
    }


    public TipoUs(BigDecimal idTipo) {
        this.idTipo = idTipo;
    }


    public TipoUs(BigDecimal idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }


    public BigDecimal getIdTipo() {
        return idTipo;
    }


    public void setIdTipo(BigDecimal idTipo) {
        this.idTipo = idTipo;
    }


    public String getNombreTipo() {
        return nombreTipo;
    }


    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUs)) {
            return false;
        }
        TipoUs other = (TipoUs) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.nombreTipo;
    }
    
}
