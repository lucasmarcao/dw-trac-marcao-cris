package DAOs;

import Entidades.User;
import java.util.ArrayList;
import java.util.List;

public class DAOUser extends DAOGenerico<User> {

    private List<User> lista = new ArrayList<>();

    public DAOUser() {
        super(User.class);
    }

    public int autoIdUser() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.email) FROM User e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<User> listByNome(String nome) {
        return em.createQuery("SELECT e FROM User e WHERE e.email) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<User> listById(int id) {
        return em.createQuery("SELECT e FROM User + e WHERE e.email= :id").setParameter("id", id).getResultList();
    }

    public List<User> listInOrderNome() {
        return em.createQuery("SELECT e FROM User e ORDER BY e.nome").getResultList();
    }

    public List<User> listInOrderId() {
        return em.createQuery("SELECT e FROM User e ORDER BY e.email").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<User> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getEmail()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOUser daoUser = new DAOUser();
        
        List<User> listaUser = daoUser.list();
        for (User trabalhador : listaUser) {
            System.out.println(trabalhador.getEmail()+ "-" + trabalhador.getNome());
        }
    }
}
