/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import datos.Alumno;
import datos.Aula;
import datos.Curso;
import datos.Docente;
import datos.Edicion;
import datos.ManejadorDatos;
import java.util.Date;

/**
 *
 * @author timoteo
 */
public class ControlInscripcion {

    public static void main(String[] args){
        ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();
        Curso curso = new Curso();
        manejadorDatos.save(curso);

        Docente docente = new Docente();
        docente.setCi(555559);
        docente.setFechaIngreso(new Date());
        docente.setNombre("Test doceten");
        docente.setEspecialidad("docencia");
        manejadorDatos.save(docente);

        Aula aula = new Aula();
        aula.setId("test-aula5");
        aula.setCapacidad(50);
        manejadorDatos.save(aula);

        Edicion edicion = new Edicion();
        edicion.setAula(aula);
        edicion.setCurso(curso);
        edicion.setDocente(docente);
        manejadorDatos.save(edicion);

        Alumno alumno = new Alumno();
        alumno.setCi(4554554);
        alumno.setFechaIngreso(new Date());
        alumno.setNombre("test alumno");
        manejadorDatos.save(alumno);

//        Inscripcion inscripcion = new Inscripcion();
//        inscripcion.setFechaInscripion(new Date());
//        inscripcion.setNota(50);
//        IdInscripcion idInscripcion = new IdInscripcion();
//        idInscripcion.setIdAlumno(alumno.getCi());
//        idInscripcion.setIdEdicion(edicion.getId());
//        inscripcion.setIdInscripcion(idInscripcion);
//        manejadorDatos.save(inscripcion);
    }
}
