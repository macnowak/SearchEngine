package pl.net.nowak.core.db;

import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Author: Maciek
 */
public class BaseFinder {

    @PersistenceContext
    protected EntityManager em;

    public Session getSession() {
        return (Session)em.getDelegate();
    }

    public Criteria getBaseCriteria(Class clazz) {
        return getSession().createCriteria(clazz);
    }
}
