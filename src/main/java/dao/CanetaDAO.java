package dao;

import entidades.Caneta;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

public class CanetaDAO {

    public static void salvar(Caneta caneta) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(caneta);
		em.getTransaction().commit();
		em.close();
    }
	public static void atualizar(Caneta caneta) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(caneta);
		em.getTransaction().commit();
		em.close();
	}

    public static void excluir(Caneta caneta) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		caneta = em.find(Caneta.class, caneta.getId());
		em.remove(caneta);
		em.getTransaction().commit();
		em.close();
    }
	public static Caneta buscarPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Caneta caneta = em.find(Caneta.class, id);
		em.close();
		return caneta;
	}
    @SuppressWarnings("unchecked")
	public static List<Caneta> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select c from Caneta c");
		List<Caneta> canetas = q.getResultList();
		em.close();
		return canetas;
    }
}
