package DAOs;

import Entidades.Pedido;
import java.util.ArrayList;
import java.util.List;

public class DAOPedido extends DAOGenerico<Pedido> {

    private List<Pedido> lista = new ArrayList<>();

    public DAOPedido() {
        super(Pedido.class);
    }

    public int autoIdPedido() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idpedido) FROM Pedido e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pedido> listByNome(String datapedido) {
        return em.createQuery("SELECT e FROM Pedido e WHERE e.idpedido) LIKE :datapedido").setParameter("datapedido", "%" + datapedido + "%").getResultList();
    }

    public List<Pedido> listById(int id) {
        return em.createQuery("SELECT e FROM Pedido + e WHERE e.idpedido= :id").setParameter("id", id).getResultList();
    }

    public List<Pedido> listInOrderNome() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.datapedido").getResultList();
    }

    public List<Pedido> listInOrderId() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.idpedido").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pedido> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdpedido()+ "-" + lf.get(i).getDatapedido());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPedido daoPedido = new DAOPedido();
        
        List<Pedido> listaPedido = daoPedido.list();
        for (Pedido trabalhador : listaPedido) {
            System.out.println(trabalhador.getIdpedido()+ "-" + trabalhador.getDatapedido());
        }
    }
}
