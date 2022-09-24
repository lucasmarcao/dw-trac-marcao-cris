package DAOs;

import Entidades.Ingredientes_has_Pizza;
import java.util.ArrayList;
import java.util.List;

public class DAOIngredientes_has_Pizza extends DAOGenerico<Ingredientes_has_Pizza> {

    private List<Ingredientes_has_Pizza> lista = new ArrayList<>();

    public DAOIngredientes_has_Pizza() {
        super(Ingredientes_has_Pizza.class);
    }

    public int autoIdIngredientes_has_Pizza() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.numeroderegistro) FROM Ingredientes_has_Pizza e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Ingredientes_has_Pizza> listByNome(String Ingredientes_idingredientes) {
        return em.createQuery("SELECT e FROM Ingredientes_has_Pizza e WHERE e.numeroderegistro) LIKE :Ingredientes_idingredientes").setParameter("Ingredientes_idingredientes", "%" + Ingredientes_idingredientes + "%").getResultList();
    }

    public List<Ingredientes_has_Pizza> listById(int id) {
        return em.createQuery("SELECT e FROM Ingredientes_has_Pizza + e WHERE e.numeroderegistro= :id").setParameter("id", id).getResultList();
    }

    public List<Ingredientes_has_Pizza> listInOrderNome() {
        return em.createQuery("SELECT e FROM Ingredientes_has_Pizza e ORDER BY e.Ingredientes_idingredientes").getResultList();
    }

    public List<Ingredientes_has_Pizza> listInOrderId() {
        return em.createQuery("SELECT e FROM Ingredientes_has_Pizza e ORDER BY e.numeroderegistro").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Ingredientes_has_Pizza> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getnumeroderegistro() + "-" + lf.get(i).getIngredientes_idingredientes());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOIngredientes_has_Pizza daoIngredientes_has_Pizza = new DAOIngredientes_has_Pizza();

        List<Ingredientes_has_Pizza> listaIngredientes_has_Pizza = daoIngredientes_has_Pizza.list();
        for (Ingredientes_has_Pizza pedido_has_pizza : listaIngredientes_has_Pizza) {
            System.out.println(pedido_has_pizza.getnumeroderegistro() + "-" + pedido_has_pizza.getIngredientes_idingredientes());
        }
    }
}
