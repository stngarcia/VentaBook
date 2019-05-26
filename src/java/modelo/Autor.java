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
@Table(name = "AUTOR", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
    , @NamedQuery(name = "Autor.findByNombreAutor", query = "SELECT a FROM Autor a WHERE a.nombreAutor = :nombreAutor")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AUTOR", nullable = false, precision = 0, scale = -127)
    private BigDecimal idAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "NOMBRE_AUTOR", nullable = false, length = 75)
    private String nombreAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutor")
    private List<Libro> libroList;

    public Autor() {
    }


    public Autor(BigDecimal idAutor) {
        this.idAutor = idAutor;
    }


    public Autor(BigDecimal idAutor, String nombreAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
    }


    public BigDecimal getIdAutor() {
        return idAutor;
    }


    public void setIdAutor(BigDecimal idAutor) {
        this.idAutor = idAutor;
    }


    public String getNombreAutor() {
        return nombreAutor;
    }


    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }


    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }


    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.nombreAutor;
    }
    
}
