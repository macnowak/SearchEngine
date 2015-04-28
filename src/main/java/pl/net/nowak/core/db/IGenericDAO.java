package pl.net.nowak.core.db;

import java.io.Serializable;
import java.util.List;


/**
 * Author: Maciek
 */
public interface IGenericDAO<T, ID extends Serializable> {
 
    public T save(T entity);
 
    public T update(T entity);
 
    public void delete(T entity);

    public List<T> loadAll() ;

    Number countAll();

    public T findByID(ID id) ;


}
