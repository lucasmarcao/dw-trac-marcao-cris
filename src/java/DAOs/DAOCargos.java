package DAOs;

import Entidades.Cargos;
import java.util.ArrayList;
import java.util.List;

public class DAOCargos extends DAOGenerico<Cargos> {

    private List<Cargos> lista = new ArrayList<>();

    public DAOCargos() {
        super(Cargos.class);
    }

    public int autoIdCargos() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idcargos) FROM Cargos e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cargos> listByNome(String nomecargo) {
        return em.createQuery("SELECT e FROM Cargos e WHERE e.idcargos) LIKE :nomecargo").setParameter("nomecargo", "%" + nomecargo + "%").getResultList();
    }

    public List<Cargos> listById(int id) {
        return em.createQuery("SELECT e FROM Cargos + e WHERE e.idcargos= :id").setParameter("id", id).getResultList();
    }

    public List<Cargos> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cargos e ORDER BY e.nomecargo").getResultList();
    }

    public List<Cargos> listInOrderId() {
        return em.createQuery("SELECT e FROM Cargos e ORDER BY e.idcargos").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cargos> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdcargos()+ "-" + lf.get(i).getNomecargo());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOCargos daoCargos = new DAOCargos();
        
        List<Cargos> listaCargos = daoCargos.list();
        for (Cargos trabalhador : listaCargos) {
            System.out.println(trabalhador.getIdcargos()+ "-" + trabalhador.getNomecargo());
        }
    }
}
