/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "pet")
@XmlRootElement

public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "especie")
    private String especie;

    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;

    @Basic(optional = false)
    @Column(name = "tutor")
    private String tutor;

    public Pet() {
    }

    public Pet(Integer identificador) {
        this.identificador = identificador;
    }

    public Pet(Integer identificador, String nome, String especie, int idade, String tutor) {
        this.identificador = identificador;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.tutor = tutor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }

        Pet other = (Pet) object;
        return !((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador)));
    }

    @Override
    public String toString() {
        return identificador + ";"
                + nome + ";"
                + especie + ";"
                + idade + ";"
                + tutor;
    }

}
