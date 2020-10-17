package lt.sdacademy.university.repositories;

import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lt.sdacademy.university.services.ConnectionService;

public abstract class AbstractRepository<T> {

    protected final EntityManager em;

    protected abstract Class<T> getEntityClass();

    public AbstractRepository() {
        em = ConnectionService.getSessionFactory().createEntityManager();
    }

    public List<T> findAll() {
        String hqlQuery = "select e from " + getEntityClass().getName() + " e";
        return em.createQuery(hqlQuery, getEntityClass()).getResultList();
    }

    public T findOne(Long id) {
        return em.find(getEntityClass(), id);
    }

    public T save(T entity) {
        return persist(entity, em::persist);
    }

    public T update(T entity) {
        return persist(entity, em::merge);
    }

    public void delete(T entity) {
        persist(entity, em::remove);
    }

    private T persist(T entity, Consumer<T> consumer) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            consumer.accept(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return entity;
    }
}
