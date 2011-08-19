/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import datos.Aula;
import datos.ManejadorDatos;

/**
 *
 * @author timoteo
 */
public class ControlAula {

    public static void main(String[] args){
        ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();
        Aula aula = new Aula();
        aula.setId("aula01");
        aula.setCapacidad(50);

        manejadorDatos.save(aula);
    }
}
