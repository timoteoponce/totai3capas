/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Empleado;
import datos.Inscripcion;
import datos.ManejadorDatos;
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
        List<Inscripcion> inscripciones = manejadorDatos.list(Inscripcion.class," WHERE t.inscripcionPK.idAlumno = "+empleado.getCi());
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
}
