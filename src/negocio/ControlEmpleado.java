/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Empleado;
import datos.ManejadorDatos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author timoteo
 */
public class ControlEmpleado {

    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public List<Object[]> getEmpleados() {
        return Utils.toArrayList(manejadorDatos.list(Empleado.class));
    }

    public String addEmpleado(Integer ci, String nombre, Date fechaIngreso) {
        String resultado;
        Empleado empleado = manejadorDatos.getById(Empleado.class, ci);

        if (empleado == null) {
            empleado = new Empleado();
            empleado.setCi(ci);
            empleado.setNombre(nombre);
            empleado.setFechaIngreso(fechaIngreso);
            manejadorDatos.save(empleado);

            resultado = "Empleado guardado : " + ci;
        } else {
            resultado = "Empleado duplicado : " + ci;
        }
        return resultado;
    }

    public String modificarEmpleado(Integer ci, String nombre, Date fechaIngreso) {
        String resultado;
        Empleado empleado = manejadorDatos.getById(Empleado.class, ci);

        if (empleado == null) {
            resultado = "Empleado inexistente : " + ci;
        } else {
            empleado.setNombre(nombre);
            empleado.setFechaIngreso(fechaIngreso);
            manejadorDatos.save(empleado);

            resultado = "Empleado modificado : " + ci;
        }
        return resultado;
    }

    public String eliminarEmpleado(Integer ci) {
        String resultado;
        Empleado empleado = manejadorDatos.getById(Empleado.class, ci);

        if (empleado == null) {
            resultado = "Empleado inexistente : " + ci;
        } else {
            if (empleado.getEdiciones().isEmpty()) {
                //eliminar todas las inscripciones
                ControlInscripcion controlInscripcion = new ControlInscripcion();
                controlInscripcion.eliminarByEmpleado(empleado);
                manejadorDatos.delete(empleado);
                resultado = "Empleado eliminado : " + ci;
            } else {
                resultado = "El empleado tiene [" + empleado.getEdiciones().size() + "] ediciones de curso registradas como docente : " + ci;
            }
        }
        return resultado;
    }

    

}
