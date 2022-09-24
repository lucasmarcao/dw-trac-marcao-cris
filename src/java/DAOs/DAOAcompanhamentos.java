package DAOs;

import Entidades.Acompanhamentos;
import java.util.ArrayList;
import java.util.List;

public class DAOAcompanhamentos extends DAOGenerico<Acompanhamentos> {

    private List<Acompanhamentos> lista = new ArrayList<>();

    public DAOAcompanhamentos() {
        super(Acompanhamentos.class);
    }

    public int autoIdAcompanhamentos() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idacompanhamentos) FROM Acompanhamentos e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Acompanhamentos> listByNome(String nomeacompanhamento) {
        return em.createQuery("SELECT e FROM Acompanhamentos e WHERE e.idacompanhamentos) LIKE :nomeacompanhamento").setParameter("nomeacompanhamento", "%" + nomeacompanhamento + "%").getResultList();
    }

    public List<Acompanhamentos> listById(int id) {
        return em.createQuery("SELECT e FROM Acompanhamentos + e WHERE e.idacompanhamentos= :id").setParameter("id", id).getResultList();
    }

    public List<Acompanhamentos> listInOrderNome() {
        return em.createQuery("SELECT e FROM Acompanhamentos e ORDER BY e.nomeacompanhamento").getResultList();
    }

    public List<Acompanhamentos> listInOrderId() {
        return em.createQuery("SELECT e FROM Acompanhamentos e ORDER BY e.idacompanhamentos").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Acompanhamentos> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdacompanhamentos()+ "-" + lf.get(i).getNomeaconpanhamento());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOAcompanhamentos daoAcompanhamentos = new DAOAcompanhamentos();
        
        List<Acompanhamentos> listaAcompanhamentos = daoAcompanhamentos.list();
        for (Acompanhamentos trabalhador : listaAcompanhamentos) {
            System.out.println(trabalhador.getIdacompanhamentos()+ "-" + trabalhador.getNomeaconpanhamento());
        }
    }
}
