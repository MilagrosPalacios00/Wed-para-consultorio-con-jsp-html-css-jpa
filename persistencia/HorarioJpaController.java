package persistencia;

import Logica.Horario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HorarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public HorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public HorarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("consultorioOdontologico_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horario horario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(horario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Horario horario) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            horario = em.merge(horario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHorario(horario.getIdHorario()) == null) {
                throw new Exception("The horario with id " + horario.getIdHorario() + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horario horario;
            try {
                horario = em.getReference(Horario.class, id);
                horario.getIdHorario();
            } catch (Exception ex) {
                throw new Exception("The horario with id " + id + " no longer exists.", ex);
            }
            em.remove(horario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Horario> findHorarioEntities() {
        return findHorarioEntities(true, -1, -1);
    }

    public List<Horario> findHorarioEntities(int maxResults, int firstResult) {
        return findHorarioEntities(false, maxResults, firstResult);
    }

    private List<Horario> findHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Horario findHorario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horario.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Horario> rt = cq.from(Horario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
