package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author asathor
 */
@Entity
@Table(name = "LIBRO", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro")
    , @NamedQuery(name = "Libro.findByTituloLibro", query = "SELECT l FROM Libro l WHERE l.tituloLibro = :tituloLibro")
    , @NamedQuery(name = "Libro.findByIsbnLibro", query = "SELECT l FROM Libro l WHERE l.isbnLibro = :isbnLibro")
    , @NamedQuery(name = "Libro.findBySinopsisLibro", query = "SELECT l FROM Libro l WHERE l.sinopsisLibro = :sinopsisLibro")
    , @NamedQuery(name = "Libro.findByCantidadejemplaresLibro", query = "SELECT l FROM Libro l WHERE l.cantidadejemplaresLibro = :cantidadejemplaresLibro")
    , @NamedQuery(name = "Libro.findByPrecioLibro", query = "SELECT l FROM Libro l WHERE l.precioLibro = :precioLibro")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIBRO", nullable = false, precision = 0, scale = -127)
    private BigDecimal idLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITULO_LIBRO", nullable = false, length = 50)
    private String tituloLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ISBN_LIBRO", nullable = false, length = 25)
    private String isbnLibro;
    @Size(max = 1000)
    @Column(name = "SINOPSIS_LIBRO", length = 1000)
    private String sinopsisLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDADEJEMPLARES_LIBRO", nullable = false)
    private short cantidadejemplaresLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_LIBRO", nullable = false)
    private int precioLibro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<DetVenta> detVentaList;
    @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR", nullable = false)
    @ManyToOne(optional = false)
    private Autor idAutor;

    public Libro() {
        this.idLibro = null;
    }

    public Libro(BigDecimal idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(BigDecimal idLibro, String tituloLibro, String isbnLibro, short cantidadejemplaresLibro, int precioLibro) {
        this.idLibro = idLibro;
        this.tituloLibro = tituloLibro;
        this.isbnLibro = isbnLibro;
        this.cantidadejemplaresLibro = cantidadejemplaresLibro;
        this.precioLibro = precioLibro;
    }

    public BigDecimal getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(BigDecimal idLibro) {
        this.idLibro = idLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getSinopsisLibro() {
        return sinopsisLibro;
    }

    public void setSinopsisLibro(String sinopsisLibro) {
        this.sinopsisLibro = sinopsisLibro;
    }

    public short getCantidadejemplaresLibro() {
        return cantidadejemplaresLibro;
    }

    public void setCantidadejemplaresLibro(short cantidadejemplaresLibro) {
        this.cantidadejemplaresLibro = cantidadejemplaresLibro;
    }

    public int getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(int precioLibro) {
        this.precioLibro = precioLibro;
    }

    @XmlTransient
    public List<DetVenta> getDetVentaList() {
        return detVentaList;
    }

    public void setDetVentaList(List<DetVenta> detVentaList) {
        this.detVentaList = detVentaList;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tituloLibro;
    }

}
