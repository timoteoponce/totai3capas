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
}
