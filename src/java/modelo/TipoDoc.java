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
@Table(name = "TIPO_DOC", catalog = "", schema = "VENTABOOK_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDoc.findAll", query = "SELECT t FROM TipoDoc t")
    , @NamedQuery(name = "TipoDoc.findByIdTipoDoc", query = "SELECT t FROM TipoDoc t WHERE t.idTipoDoc = :idTipoDoc")
    , @NamedQuery(name = "TipoDoc.findByNombreTipoDocumento", query = "SELECT t FROM TipoDoc t WHERE t.nombreTipoDocumento = :nombreTipoDocumento")})
public class TipoDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DOC", nullable = false, precision = 0, scale = -127)
    private BigDecimal idTipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_TIPO_DOCUMENTO", nullable = false, length = 15)
    private String nombreTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDoc")
    private List<Venta> ventaList;

    public TipoDoc() {
    }


    public TipoDoc(BigDecimal idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }


    public TipoDoc(BigDecimal idTipoDoc, String nombreTipoDocumento) {
        this.idTipoDoc = idTipoDoc;
        this.nombreTipoDocumento = nombreTipoDocumento;
    }


    public BigDecimal getIdTipoDoc() {
        return idTipoDoc;
    }


    public void setIdTipoDoc(BigDecimal idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }


    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }


    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }


    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }


    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDoc != null ? idTipoDoc.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDoc)) {
            return false;
        }
        TipoDoc other = (TipoDoc) object;
        if ((this.idTipoDoc == null && other.idTipoDoc != null) || (this.idTipoDoc != null && !this.idTipoDoc.equals(other.idTipoDoc))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.nombreTipoDocumento;
    }
    
}
