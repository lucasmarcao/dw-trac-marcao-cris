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
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;
    @Column(name = "trabalhando")
    private Short trabalhando;
    @JoinColumn(name = "Cargos_idcargos", referencedColumnName = "idcargos")
    @ManyToOne
    private Cargos cargosidcargos;
    @JoinColumn(name = "Pessoa_idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne
    private Pessoa pessoaidpessoa;

    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Short getTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(Short trabalhando) {
        this.trabalhando = trabalhando;
    }

    public Cargos getCargosidcargos() {
        return cargosidcargos;
    }

    public void setCargosidcargos(Cargos cargosidcargos) {
        this.cargosidcargos = cargosidcargos;
    }

    public Pessoa getPessoaidpessoa() {
        return pessoaidpessoa;
    }

    public void setPessoaidpessoa(Pessoa pessoaidpessoa) {
        this.pessoaidpessoa = pessoaidpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        return !((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario)));
    }

    @Override
    public String toString() {
        String confirma;
        if (trabalhando==0) {
            confirma = "NAO trabalha";
        }else{
            confirma = "SIM trabalha";
        }
        
        return idfuncionario + ";" + salario + ";" + confirma + ";"
                + (pessoaidpessoa.getIdpessoa() + " --> " + pessoaidpessoa.getNome() + " ->  cep { " + pessoaidpessoa.getCep()+ " } anos ") + ";"
                + (cargosidcargos.getIdcargos()+" ==> " + cargosidcargos.getNomecargo());
    }

}
