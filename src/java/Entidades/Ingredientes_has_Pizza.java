/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "Ingredientes_has_Pizza")
@NamedQueries({
    @NamedQuery(name = "Ingredientes_has_Pizza.findAll", query = "SELECT f FROM Ingredientes_has_Pizza f")})
public class Ingredientes_has_Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroderegistro")
    private Integer numeroderegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JoinColumn(name = "Ingredientes_idingredientes", referencedColumnName = "idingredientes")
    @ManyToOne
    private Ingredientes Ingredientes_idingredientes;
    @JoinColumn(name = "Pizza_idtable1", referencedColumnName = "idtable1")
    @ManyToOne
    private Pizza Pizza_idtable1;

    public Ingredientes_has_Pizza() {
    }

    public Ingredientes_has_Pizza(Integer numeroderegistro) {
        this.numeroderegistro = numeroderegistro;
    }

    public Integer getnumeroderegistro() {
        return numeroderegistro;
    }

    public void setnumeroderegistro(Integer numeroderegistro) {
        this.numeroderegistro = numeroderegistro;
    }

    public Ingredientes getIngredientes_idingredientes() {
        return Ingredientes_idingredientes;
    }

    public void setIngredientes_idingredientes(Ingredientes Ingredientes_idingredientes) {
        this.Ingredientes_idingredientes = Ingredientes_idingredientes;
    }

    public Pizza getPizza_idtable1() {
        return Pizza_idtable1;
    }

    public void setPizza_idtable1(Pizza Pizza_idtable1) {
        this.Pizza_idtable1 = Pizza_idtable1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroderegistro != null ? numeroderegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes_has_Pizza)) {
            return false;
        }
        Ingredientes_has_Pizza other = (Ingredientes_has_Pizza) object;
        return !((this.numeroderegistro == null && other.numeroderegistro != null) || (this.numeroderegistro != null && !this.numeroderegistro.equals(other.numeroderegistro)));
    }

    @Override
    public String toString() {
        return numeroderegistro
                + ";" + (Ingredientes_idingredientes.getIdingredientes() + " - " + Ingredientes_idingredientes.getNome())
                + ";" + (Pizza_idtable1.getIdtable1() + " - " + Pizza_idtable1.getNomepizza());
    }

}
