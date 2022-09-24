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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "acompanhamentos")
@NamedQueries({
    @NamedQuery(name = "Acompanhamentos.findAll", query = "SELECT a FROM Acompanhamentos a")})
public class Acompanhamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idacompanhamentos")
    private Integer idacompanhamentos;
    @Column(name = "nomeaconpanhamento")
    private String nomeaconpanhamento;
    @JoinColumn(name = "Fornecedor_idfornecedor", referencedColumnName = "idfornecedor")
    @ManyToOne
    private Fornecedor fornecedoridfornecedor;
    @OneToMany(mappedBy = "acompanhamentosidacompanhamentos")
    private List<Pedido> pedidoList;

    public Acompanhamentos() {
    }

    public Acompanhamentos(Integer idacompanhamentos) {
        this.idacompanhamentos = idacompanhamentos;
    }

    public Integer getIdacompanhamentos() {
        return idacompanhamentos;
    }

    public void setIdacompanhamentos(Integer idacompanhamentos) {
        this.idacompanhamentos = idacompanhamentos;
    }

    public String getNomeaconpanhamento() {
        return nomeaconpanhamento;
    }

    public void setNomeaconpanhamento(String nomeaconpanhamento) {
        this.nomeaconpanhamento = nomeaconpanhamento;
    }

    public Fornecedor getFornecedoridfornecedor() {
        return fornecedoridfornecedor;
    }

    public void setFornecedoridfornecedor(Fornecedor fornecedoridfornecedor) {
        this.fornecedoridfornecedor = fornecedoridfornecedor;
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
        hash += (idacompanhamentos != null ? idacompanhamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompanhamentos)) {
            return false;
        }
        Acompanhamentos other = (Acompanhamentos) object;
        return !((this.idacompanhamentos == null && other.idacompanhamentos != null) || (this.idacompanhamentos != null && !this.idacompanhamentos.equals(other.idacompanhamentos)));
    }

    @Override
    public String toString() {
        return idacompanhamentos + " - " + nomeaconpanhamento + "<br>"
                + ("Fornecedor: " + fornecedoridfornecedor.getNomefornecedor());
    }

    public void setFornecedoridfornecedor(int idade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
