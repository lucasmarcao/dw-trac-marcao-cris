package DAOs;

import Entidades.Pedido_has_Pizza;
import java.util.ArrayList;
import java.util.List;

public class DAOPedido_has_Pizza extends DAOGenerico<Pedido_has_Pizza> {

    private List<Pedido_has_Pizza> lista = new ArrayList<>();

    public DAOPedido_has_Pizza() {
        super(Pedido_has_Pizza.class);
    }

    public int autoIdPedido_has_Pizza() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.numeroderegistro) FROM Pedido_has_Pizza e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pedido_has_Pizza> listByNome(String Pedido_idpedido) {
        return em.createQuery("SELECT e FROM Pedido_has_Pizza e WHERE e.numeroderegistro) LIKE :Pedido_idpedido").setParameter("Pedido_idpedido", "%" + Pedido_idpedido + "%").getResultList();
    }

    public List<Pedido_has_Pizza> listById(int id) {
        return em.createQuery("SELECT e FROM Pedido_has_Pizza + e WHERE e.numeroderegistro= :id").setParameter("id", id).getResultList();
    }

    public List<Pedido_has_Pizza> listInOrderNome() {
        return em.createQuery("SELECT e FROM Pedido_has_Pizza e ORDER BY e.Pedido_idpedido").getResultList();
    }

    public List<Pedido_has_Pizza> listInOrderId() {
        return em.createQuery("SELECT e FROM Pedido_has_Pizza e ORDER BY e.numeroderegistro").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pedido_has_Pizza> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getnumeroderegistro() + "-" + lf.get(i).getPedido_idpedido());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPedido_has_Pizza daoPedido_has_Pizza = new DAOPedido_has_Pizza();

        List<Pedido_has_Pizza> listaPedido_has_Pizza = daoPedido_has_Pizza.list();
        for (Pedido_has_Pizza pedido_has_pizza : listaPedido_has_Pizza) {
            System.out.println(pedido_has_pizza.getnumeroderegistro() + "-" + pedido_has_pizza.getPedido_idpedido());
        }
    }
}
