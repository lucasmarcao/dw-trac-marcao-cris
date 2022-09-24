package DAOs;

import Entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class DAOFornecedor extends DAOGenerico<Fornecedor> {

    private List<Fornecedor> lista = new ArrayList<>();

    public DAOFornecedor() {
        super(Fornecedor.class);
    }

    public int autoIdFornecedor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idfornecedor) FROM Fornecedor e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Fornecedor> listByNome(String nomefornecedor) {
        return em.createQuery("SELECT e FROM Fornecedor e WHERE e.idfornecedor) LIKE :nomefornecedor").setParameter("nomefornecedor", "%" + nomefornecedor + "%").getResultList();
    }

    public List<Fornecedor> listById(int id) {
        return em.createQuery("SELECT e FROM Fornecedor + e WHERE e.idfornecedor= :id").setParameter("id", id).getResultList();
    }

    public List<Fornecedor> listInOrderNome() {
        return em.createQuery("SELECT e FROM Fornecedor e ORDER BY e.nomefornecedor").getResultList();
    }

    public List<Fornecedor> listInOrderId() {
        return em.createQuery("SELECT e FROM Fornecedor e ORDER BY e.idfornecedor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Fornecedor> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdfornecedor()+ "-" + lf.get(i).getNomefornecedor());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOFornecedor daoFornecedor = new DAOFornecedor();
        
        List<Fornecedor> listaFornecedor = daoFornecedor.list();
        for (Fornecedor trabalhador : listaFornecedor) {
            System.out.println(trabalhador.getIdfornecedor()+ "-" + trabalhador.getNomefornecedor());
        }
    }
}
