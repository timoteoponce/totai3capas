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
public class Alumno extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Alumno{" + "ci=" + getCi() + "nombre=" + getNombre() + "fechaIngreso=" + getFechaIngreso() + '}';
    }

}
