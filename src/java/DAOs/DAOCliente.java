package DAOs;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends DAOGenerico<Cliente> {

    private List<Cliente> lista = new ArrayList<>();

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idcliente) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByNome(String total_de_compras) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.idcliente) LIKE :total_de_compras").setParameter("total_de_compras", "%" + total_de_compras + "%").getResultList();
    }

    public List<Cliente> listById(int id) {
        return em.createQuery("SELECT e FROM Cliente + e WHERE e.idcliente= :id").setParameter("id", id).getResultList();
    }

    public List<Cliente> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.total_de_compras").getResultList();
    }

    public List<Cliente> listInOrderId() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.idcliente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdcliente()+ "-" + lf.get(i).getAvaliacaoDoServico());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOCliente daoCliente = new DAOCliente();
        
        List<Cliente> listaCliente = daoCliente.list();
        for (Cliente trabalhador : listaCliente) {
            System.out.println(trabalhador.getIdcliente()+ "-" + trabalhador.getAvaliacaoDoServico());
        }
    }
}
