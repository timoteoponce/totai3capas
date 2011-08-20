/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Aula;
import datos.ManejadorDatos;
import java.util.List;

/**
 *
 * @author timoteo
 */
public class ControlAula {

    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public List<Object[]> getAulas() {
        return Utils.toArrayList(manejadorDatos.list(Aula.class));
    }

    public String addAula(String id, Integer capacidad) {
        String resultado;
        Aula aula = manejadorDatos.getById(Aula.class, id);
        if (aula == null) {
            aula = new Aula();
            aula.setId(id);
            aula.setCapacidad(capacidad);
            manejadorDatos.save(aula);

            resultado = "Aula guardada : " + id;
        } else {
            resultado = "Aula duplicada : " + id;
        }
        return resultado;
    }

    public String modificarAula(String id, Integer capacidad) {
        String resultado;
        Aula aula = manejadorDatos.getById(Aula.class, id);
        if (aula == null) {
            resultado = "Aula inexistente: " + id;
        } else {
            aula.setCapacidad(capacidad);
            manejadorDatos.save(aula);
            resultado = "Aula guardada : " + id;
        }
        return resultado;
    }

    public String delAula(String id) {
        String resultado;
        Aula aula = manejadorDatos.getById(Aula.class, id);
        if (aula.getEdiciones().isEmpty()) {
            manejadorDatos.delete(aula);
            resultado = "Aula eliminada : " + id;
        } else {
            resultado = "El aula no se puede eliminar, tiene [" + aula.getEdiciones().size() + "] ediciones activas";
        }
        return resultado;
    }
}
