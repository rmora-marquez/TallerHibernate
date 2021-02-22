/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user10
 */
@Entity
@Table(name = "mercados")
@NamedQueries({
    @NamedQuery(name = "Mercado.findAll", query = "SELECT m FROM Mercado m")
    , @NamedQuery(name = "Mercado.findById", query = "SELECT m FROM Mercado m WHERE m.id = :id")
    , @NamedQuery(name = "Mercado.findByUbicacion", query = "SELECT m FROM Mercado m WHERE m.ubicacion = :ubicacion")})
public class Mercado implements Serializable {
    @ManyToMany(mappedBy = "mercadoList",cascade = CascadeType.ALL)
    private List<Producto> productoList;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ubicacion")
    private String ubicacion;
    

    public Mercado() {
    }

    public Mercado(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercado)) {
            return false;
        }
        Mercado other = (Mercado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orm.dominio.Mercado[ id=" + id + " ]";
    }
    
}
