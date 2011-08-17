/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author timoteo
 */
public class ManejadorDatos {

    private EntityManager entityManager;

    public ManejadorDatos() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("totai3capasPU");
        entityManager = managerFactory.createEntityManager();
    }

    public void save(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    public void delete(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

    public <T>List<T> list(Class<T> classToFind) {
        javax.persistence.Query query = entityManager.createQuery("SELECT t FROM "+classToFind.getSimpleName()+" t");
        return query.getResultList();

    }

    public Object getById(Class<?> classToFind,Integer id) {
        return entityManager.find(classToFind, id);
    }
}
