/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package totai3capas;

import datos.Alumno;
import datos.Docente;
import datos.Edicion;
import datos.Empleado;
import datos.ManejadorDatos;
import java.util.Date;

/**
 *
 * @author timoteo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejadorDatos manejadorDatos = new ManejadorDatos();

//        Curso curso = new Curso();
//        entityManager.persist(curso);
        Docente docente = new Docente();
        docente.setCi(5896508);
        docente.setNombre("Oscar ribera");
        docente.setFechaIngreso(new Date());
        docente.setEspecialidad("sistemas");
        manejadorDatos.save(docente);

        Alumno alumno = new Alumno();
        alumno.setCi(5054559);
        alumno.setFechaIngreso(new Date());
        alumno.setNombre("Timoteo Ponce");
        manejadorDatos.save(alumno);

        for(Docente doc :manejadorDatos.list(Docente.class)){
            System.out.println(doc.toString());
        }

        for(Empleado emp :manejadorDatos.list(Empleado.class)){
            System.out.println(emp.toString());
        }

        Edicion edicion = new Edicion();
        edicion.setDocente(docente);
        edicion.getAlumnos().add(alumno);
        manejadorDatos.save(edicion);

    }

}
