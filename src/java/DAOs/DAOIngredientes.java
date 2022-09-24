package DAOs;

import Entidades.Ingredientes;
import java.util.ArrayList;
import java.util.List;

public class DAOIngredientes extends DAOGenerico<Ingredientes> {

    private List<Ingredientes> lista = new ArrayList<>();

    public DAOIngredientes() {
        super(Ingredientes.class);
    }

    public int autoIdIngredientes() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idingredientes) FROM Ingredientes e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Ingredientes> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Ingredientes e WHERE e.idingredientes) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Ingredientes> listById(int id) {
        return em.createQuery("SELECT e FROM Ingredientes + e WHERE e.idingredientes= :id").setParameter("id", id).getResultList();
    }

    public List<Ingredientes> listInOrderNome() {
        return em.createQuery("SELECT e FROM Ingredientes e ORDER BY e.nome").getResultList();
    }

    public List<Ingredientes> listInOrderId() {
        return em.createQuery("SELECT e FROM Ingredientes e ORDER BY e.idingredientes").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Ingredientes> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdingredientes()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOIngredientes daoIngredientes = new DAOIngredientes();
        
        List<Ingredientes> listaIngredientes = daoIngredientes.list();
        for (Ingredientes trabalhador : listaIngredientes) {
            System.out.println(trabalhador.getIdingredientes()+ "-" + trabalhador.getNome());
        }
    }
}
