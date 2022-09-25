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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cargos")
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcargos")
    private Integer idcargos;
    @Lob
    @Column(name = "descricao_cargo")
    private String descricaoCargo;
    @Column(name = "nomecargo")
    private String nomecargo;
    @OneToMany(mappedBy = "cargosidcargos")
    private List<Funcionario> funcionarioList;

    public Cargos() {
    }

    public Cargos(Integer idcargos) {
        this.idcargos = idcargos;
    }

    public Integer getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(Integer idcargos) {
        this.idcargos = idcargos;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public String getNomecargo() {
        return nomecargo;
    }

    public void setNomecargo(String nomecargo) {
        this.nomecargo = nomecargo;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargos != null ? idcargos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        return !((this.idcargos == null && other.idcargos != null) || (this.idcargos != null && !this.idcargos.equals(other.idcargos)));
    }

    @Override
    public String toString() {
        return "Id: "+idcargos + "<br>"+nomecargo+" - { "+descricaoCargo+" }";
    }
    
}
