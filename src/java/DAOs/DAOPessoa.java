package DAOs;

import Entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class DAOPessoa extends DAOGenerico<Pessoa> {

    private List<Pessoa> lista = new ArrayList<>();

    public DAOPessoa() {
        super(Pessoa.class);
    }

    public int autoIdPessoa() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idpessoa) FROM Pessoa e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pessoa> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.idpessoa) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Pessoa> listById(int id) {
        return em.createQuery("SELECT e FROM Pessoa + e WHERE e.idpessoa= :id").setParameter("id", id).getResultList();
    }

    public List<Pessoa> listInOrderNome() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.nome").getResultList();
    }

    public List<Pessoa> listInOrderId() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.idpessoa").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pessoa> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdpessoa()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPessoa daoPessoa = new DAOPessoa();
        
        List<Pessoa> listaPessoa = daoPessoa.list();
        for (Pessoa trabalhador : listaPessoa) {
            System.out.println(trabalhador.getIdpessoa()+ "-" + trabalhador.getNome());
        }
    }
}
