package pl.net.nowak.core.db;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements IGenericDAO<T, ID> ,Serializable {

    private static final long serialVersionUID = 1L;

    Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	/*
	 * The JPA entity manager to be used from all derived DAO classes
	 */
	@PersistenceContext
	protected EntityManager em;

    protected Class entityClass;

    public GenericDAOImpl() {
        ParameterizedType parameterizedType = null;

        if(getClass().getGenericSuperclass() instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        }else if(getClass().getGenericSuperclass() instanceof Class) {
            parameterizedType = (ParameterizedType) ((Class)getClass().getGenericSuperclass()).getGenericSuperclass();
        }

        this.entityClass = ((Class<T>) parameterizedType.getActualTypeArguments()[0]);
    }



	public T save(T entity) throws PersistenceException{
        em.persist(entity);
		em.flush();
	    return entity;
	}

	public T update(T entity) throws PersistenceException  {
		em.merge(entity);
		em.flush();
		return entity;
	}

	public void delete(T entity) throws PersistenceException {
		em.remove(entity);
		em.flush();
//			getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public T findByID( ID id)  {
//			return (T) em.find(clazz, id);
		    T t = null;
			t = (T) getSession().get(entityClass, id);
			return t;
	}

    public List<T> loadAll()  {
			List<T> T = null;
			Query query = getSession().createQuery("from " + entityClass.getName());
			T = query.list();
			return T;
	}




	public Session getSession() {
		return (Session)em.getDelegate();
	}

    public Criteria getBaseCriteria() {
        return getSession().createCriteria(entityClass);
    }

    public Number countAll() {
        return (Number) getBaseCriteria().setProjection(Projections.rowCount()).uniqueResult();
    }

}