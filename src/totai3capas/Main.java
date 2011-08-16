/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package totai3capas;

import datos.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author timoteo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("totai3capasPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Curso curso = new Curso();
        entityManager.persist(curso);

        entityManager.getTransaction().commit();
    }

}
