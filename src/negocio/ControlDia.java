/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import datos.Dia;
import datos.DiaEnum;
import datos.ManejadorDatos;
import java.util.List;

/**
 *
 * @author timoteo
 */
public class ControlDia {

    public void init(){
        ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();
        List<Dia> dias = manejadorDatos.list(Dia.class);

        if(dias.isEmpty()){
            for(DiaEnum diaEnum:DiaEnum.values()){
                Dia dia = new Dia(diaEnum.name());
                manejadorDatos.save(dia);
            }
        }
    }

    public static void main(String[] args){
        new ControlDia().init();
    }
}
