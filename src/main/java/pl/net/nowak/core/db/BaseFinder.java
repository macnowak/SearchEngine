package pl.net.nowak.core.db;

import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 21.10.14
 * Time: 23:53
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
