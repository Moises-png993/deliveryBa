/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moimo98
 */
@Entity
@Table(name = "producto_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoComercio.findAll", query = "SELECT p FROM ProductoComercio p"),
    @NamedQuery(name = "ProductoComercio.findByIdProducto", query = "SELECT p FROM ProductoComercio p WHERE p.productoComercioPK.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoComercio.findByIdComercio", query = "SELECT p FROM ProductoComercio p WHERE p.productoComercioPK.idComercio = :idComercio"),
    @NamedQuery(name = "ProductoComercio.findByActivo", query = "SELECT p FROM ProductoComercio p WHERE p.activo = :activo"),
    @NamedQuery(name = "ProductoComercio.findByFechaCreacion", query = "SELECT p FROM ProductoComercio p WHERE p.fechaCreacion = :fechaCreacion")})
public class ProductoComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoComercioPK productoComercioPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercio comercio;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(mappedBy = "productoComercio")
    
    @JsonbTransient
    private Collection<MenuComercio> menuComercioCollection;

    public ProductoComercio() {
    }

    public ProductoComercio(ProductoComercioPK productoComercioPK) {
        this.productoComercioPK = productoComercioPK;
    }

    public ProductoComercio(int idProducto, long idComercio) {
        this.productoComercioPK = new ProductoComercioPK(idProducto, idComercio);
    }

    public ProductoComercioPK getProductoComercioPK() {
        return productoComercioPK;
    }

    public void setProductoComercioPK(ProductoComercioPK productoComercioPK) {
        this.productoComercioPK = productoComercioPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public Collection<MenuComercio> getMenuComercioCollection() {
        return menuComercioCollection;
    }

    public void setMenuComercioCollection(Collection<MenuComercio> menuComercioCollection) {
        this.menuComercioCollection = menuComercioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoComercioPK != null ? productoComercioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoComercio)) {
            return false;
        }
        ProductoComercio other = (ProductoComercio) object;
        if ((this.productoComercioPK == null && other.productoComercioPK != null) || (this.productoComercioPK != null && !this.productoComercioPK.equals(other.productoComercioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.control.entity.ProductoComercio[ productoComercioPK=" + productoComercioPK + " ]";
    }
    
}
