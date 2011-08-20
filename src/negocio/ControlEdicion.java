/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Edicion;
import datos.ManejadorDatos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author oscarribera
 */
public class ControlEdicion {
    
    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public List<Object[]> getEdiciones() {
        List<Edicion> ediciones = manejadorDatos.list(Edicion.class);
        return toArrayList(ediciones);        
    }

    private List<Object[]> toArrayList(Collection<Edicion> ediciones) {
        List<Object[]> arrayCursos = new ArrayList<Object[]>();
        for (Edicion item : ediciones) {
            arrayCursos.add(item.toArray());
        }
        return arrayCursos;
    }

    
    
}
