/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author asathor
 */
@Entity
@Table(name = "ESTADO", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByIdEstado", query = "SELECT e FROM Estado e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "Estado.findByNombreEstado", query = "SELECT e FROM Estado e WHERE e.nombreEstado = :nombreEstado")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO", nullable = false, precision = 0, scale = -127)
    private BigDecimal idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "NOMBRE_ESTADO", nullable = false, length = 12)
    private String nombreEstado;

    public Estado() {
    }


    public Estado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }


    public Estado(BigDecimal idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }


    public BigDecimal getIdEstado() {
        return idEstado;
    }


    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }


    public String getNombreEstado() {
        return nombreEstado;
    }


    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.nombreEstado;
    }
    
}
