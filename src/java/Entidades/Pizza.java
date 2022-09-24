/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "pizza")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")})
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtable1")
    private Integer idtable1;
    @Column(name = "nomepizza")
    private String nomepizza;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @Column(name = "sabor")
    private String sabor;
    @Column(name = "tamanho")
    private String tamanho;
    @JoinTable(name = "ingredientes_has_pizza", joinColumns = {
        @JoinColumn(name = "Pizza_idtable1", referencedColumnName = "idtable1")}, inverseJoinColumns = {
        @JoinColumn(name = "Ingredientes_idingredientes", referencedColumnName = "idingredientes")})
    @ManyToMany
    private List<Ingredientes> ingredientesList;
    @ManyToMany(mappedBy = "pizzaList")
    private List<Pedido> pedidoList;

    public Pizza() {
    }

    public Pizza(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Integer getIdtable1() {
        return idtable1;
    }

    public void setIdtable1(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public String getNomepizza() {
        return nomepizza;
    }

    public void setNomepizza(String nomepizza) {
        this.nomepizza = nomepizza;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtable1 != null ? idtable1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        return !((this.idtable1 == null && other.idtable1 != null) || (this.idtable1 != null && !this.idtable1.equals(other.idtable1)));
    }

    @Override
    public String toString() {
        return idtable1 + ";" + nomepizza + ";" + sabor + ";" + preco + ";" + tamanho;
    }

}
