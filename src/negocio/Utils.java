/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Empleado;
import datos.Entidad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author oscarribera
 */
public class Utils {

    public static List<Object[]> toArrayList(Collection<?> items) {
        List<Object[]> arrayCursos = new ArrayList<Object[]>();
        for (Object obj : items) {
            Entidad item = (Entidad) obj;
            arrayCursos.add(item.toArray());
        }
        return arrayCursos;
    }
}
