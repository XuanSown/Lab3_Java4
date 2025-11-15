package impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.XJPA;

public abstract class AbstractDAO<T, K> {
	private Class<T> entityClass;

	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	// tạo mới
	public T create(T entity) {
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			throw new RuntimeException("Error create: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	// cập nhật
	public T update(T entity) {
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			throw new RuntimeException("Error update: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	// xóa theo id
	public void deleteById(K id) {
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			T entity = em.find(entityClass, id);
			if (entity != null) {
				em.remove(entity);
			}
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			throw new RuntimeException("Error delete: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	// tìm theo id
	public T findById(K id) {
		EntityManager em = XJPA.getEntityManager();
		try {
			return em.find(entityClass, id);
		} finally {
			em.close();
		}
	}

	// try vấn tất cả
	public List<T> findAll() {
		EntityManager em = XJPA.getEntityManager();
		try {
			// Dùng entityClass.getSimpleName() để lấy tên lớp (VD: "User")
			String jpql = "SELECT o FROM " + entityClass.getSimpleName() + " o";
			TypedQuery<T> query = em.createQuery(jpql, entityClass);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
