/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Empleado;
import datos.Inscripcion;
import datos.InscripcionPK;
import datos.ManejadorDatos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author timoteo
 */
public class ControlInscripcion {

    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public void eliminarByEmpleado(Empleado empleado) {
        List<Inscripcion> inscripciones = getInscripciones(empleado);

        for (Inscripcion item : inscripciones) {
            manejadorDatos.delete(item);
        }
    }

    List<Inscripcion> getInscripciones(Empleado empleado) {
        List<Inscripcion> inscripciones = manejadorDatos.list(Inscripcion.class, " WHERE t.inscripcionPK.idAlumno = " + empleado.getCi());
        return inscripciones;
    }

    public List<Object[]> getNoInscritos(String edicion) {
        List<Empleado> noInscritos;
        if (edicion.isEmpty()) {
            noInscritos = manejadorDatos.list(Empleado.class);
        } else {
            noInscritos = manejadorDatos.list("SELECT e FROM Empleado e "
                    + "WHERE e.ci NOT IN (SELECT i.inscripcionPK.idAlumno from Inscripcion i WHERE i.inscripcionPK.idEdicion = '" + edicion + "') "
                    + "AND e.ci NOT IN (SELECT ed.docente.ci FROM Edicion ed WHERE ed.id='" + edicion + "' )");
        }
        return Utils.toArrayList(noInscritos);
    }

    public List<Object[]> getInscripciones(String edicion) {
        List<Inscripcion> inscripciones;
        if (edicion.isEmpty()) {
            inscripciones = manejadorDatos.list(Inscripcion.class);
        } else {
            inscripciones = manejadorDatos.list(Inscripcion.class, " WHERE t.inscripcionPK.idEdicion = '" + edicion + "'");
        }
        return Utils.toArrayList(inscripciones);
    }

    public String addInscripcion(String idEdicion, Integer idAlumno, Date fechaInscripcion, int nota) {
        String resultado;
        Inscripcion inscripcion = getInscripcion(idEdicion, idAlumno);
        if (inscripcion == null) {
            inscripcion = new Inscripcion();
            inscripcion.setInscripcionPK(new InscripcionPK(idEdicion, idAlumno));
            inscripcion.setFechaInscripcion(fechaInscripcion);
            inscripcion.setNota(nota);
            manejadorDatos.save(inscripcion);
            resultado = "Inscripcion guardada : [" + idEdicion + " - " + idAlumno + "]";
        } else {
            resultado = "Inscripcion duplicada : [" + idEdicion + " - " + idAlumno + "]";
        }
        return resultado;
    }

    public String modificarInscripcion(String idEdicion, Integer idAlumno, int nota) {
        String resultado;
        Inscripcion inscripcion = getInscripcion(idEdicion, idAlumno);
        if (inscripcion == null) {
            resultado = "Inscripcion inexistente : [" + idEdicion + " - " + idAlumno + "]";
        } else {
            inscripcion.setNota(nota);
            manejadorDatos.save(inscripcion);
            resultado = "Inscripcion guardada : [" + idEdicion + " - " + idAlumno + "]";
        }
        return resultado;
    }

    public String delInscripcion(String idEdicion, Integer idAlumno) {
        String resultado;
        Inscripcion inscripcion = getInscripcion(idEdicion, idAlumno);
        if (inscripcion == null) {
            resultado = "Inscripcion inexistente : [" + idEdicion + " - " + idAlumno + "]";
        } else {
            manejadorDatos.delete(inscripcion);
            resultado = "Inscripcion eliminada : [" + idEdicion + " - " + idAlumno + "]";
        }
        return resultado;
    }

    private Inscripcion getInscripcion(String idEdicion, Integer idAlumno) {
        List<Inscripcion> inscripciones = manejadorDatos.list(Inscripcion.class, " WHERE t.inscripcionPK.idEdicion = '" + idEdicion + "' AND t.inscripcionPK.idAlumno = " + idAlumno);
        System.out.println(" WHERE t.inscripcionPK.idEdicion = '" + idEdicion + "' AND t.inscripcionPK.idAlumno = " + idAlumno + " : "+inscripciones.size());
        Inscripcion inscripcion = null;
        
        if (!inscripciones.isEmpty()) {
            inscripcion = inscripciones.get(0);
        }
        return inscripcion;
    }
}
