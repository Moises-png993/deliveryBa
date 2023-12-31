/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moimo98
 */
@Entity
@Table(name = "tipo_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComercio.findAll", query = "SELECT t FROM TipoComercio t"),
    @NamedQuery(name = "TipoComercio.findByIdTipoComercio", query = "SELECT t FROM TipoComercio t WHERE t.idTipoComercio = :idTipoComercio"),
    @NamedQuery(name = "TipoComercio.findByNombre", query = "SELECT t FROM TipoComercio t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoComercio.findByActivo", query = "SELECT t FROM TipoComercio t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoComercio.findByComentarios", query = "SELECT t FROM TipoComercio t WHERE t.comentarios = :comentarios")})
public class TipoComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_comercio")
    private Integer idTipoComercio;
    @Size(max = 155)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 2147483647)
    @Column(name = "comentarios")
    private String comentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComercio")
    
       @JsonbTransient
    private Collection<ComercioTipoComercio> comercioTipoComercioCollection;
    @OneToMany(mappedBy = "idTipoComercioPadre")
    
       @JsonbTransient
    private Collection<TipoComercio> tipoComercioCollection;
    @JoinColumn(name = "id_tipo_comercio_padre", referencedColumnName = "id_tipo_comercio")
    @ManyToOne
    
       @JsonbTransient
    private TipoComercio idTipoComercioPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComercio")
    
       @JsonbTransient
    private Collection<TipoProductoTipoComercio> tipoProductoTipoComercioCollection;

    public TipoComercio() {
    }

    public TipoComercio(Integer idTipoComercio) {
        this.idTipoComercio = idTipoComercio;
    }

    public Integer getIdTipoComercio() {
        return idTipoComercio;
    }

    public void setIdTipoComercio(Integer idTipoComercio) {
        this.idTipoComercio = idTipoComercio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public Collection<ComercioTipoComercio> getComercioTipoComercioCollection() {
        return comercioTipoComercioCollection;
    }

    public void setComercioTipoComercioCollection(Collection<ComercioTipoComercio> comercioTipoComercioCollection) {
        this.comercioTipoComercioCollection = comercioTipoComercioCollection;
    }

    @XmlTransient
    public Collection<TipoComercio> getTipoComercioCollection() {
        return tipoComercioCollection;
    }

    public void setTipoComercioCollection(Collection<TipoComercio> tipoComercioCollection) {
        this.tipoComercioCollection = tipoComercioCollection;
    }

    public TipoComercio getIdTipoComercioPadre() {
        return idTipoComercioPadre;
    }

    public void setIdTipoComercioPadre(TipoComercio idTipoComercioPadre) {
        this.idTipoComercioPadre = idTipoComercioPadre;
    }

    @XmlTransient
    public Collection<TipoProductoTipoComercio> getTipoProductoTipoComercioCollection() {
        return tipoProductoTipoComercioCollection;
    }

    public void setTipoProductoTipoComercioCollection(Collection<TipoProductoTipoComercio> tipoProductoTipoComercioCollection) {
        this.tipoProductoTipoComercioCollection = tipoProductoTipoComercioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComercio != null ? idTipoComercio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComercio)) {
            return false;
        }
        TipoComercio other = (TipoComercio) object;
        if ((this.idTipoComercio == null && other.idTipoComercio != null) || (this.idTipoComercio != null && !this.idTipoComercio.equals(other.idTipoComercio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.control.entity.TipoComercio[ idTipoComercio=" + idTipoComercio + " ]";
    }
    
}
