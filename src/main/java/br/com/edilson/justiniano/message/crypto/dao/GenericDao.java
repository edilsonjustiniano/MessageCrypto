package br.com.edilson.justiniano.message.crypto.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T, PK> {

	@PersistenceContext
	protected EntityManager em;

	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public T getById(PK id) {
		@SuppressWarnings("unchecked")
		T entity = (T) em.find(getTypeClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query q = em.createQuery(" from " + getTypeClass().getName(), getTypeClass());
		return q.getResultList();
	}

	protected Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
		        .getActualTypeArguments()[0];

		return clazz;
	}
}
