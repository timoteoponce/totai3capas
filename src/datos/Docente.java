/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author timoteo
 */
@Entity
public class Docente extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Docente{" + "ci=" + getCi() + "nombre=" + getNombre() + "fechaIngreso=" + getFechaIngreso() +",especialidad="+especialidad +'}';
    }


}
