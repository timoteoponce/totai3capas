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
    
    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public void init(){        
        List<Dia> dias = manejadorDatos.list(Dia.class);

        if(dias.isEmpty()){
            for(DiaEnum diaEnum:DiaEnum.values()){
                Dia dia = new Dia(diaEnum.name());
                manejadorDatos.save(dia);
            }
        }
    }

    public List<Object[]> getDias() {
        init();
        List<Dia> dias = manejadorDatos.list(Dia.class);
        return Utils.toArrayList(dias);
    }
    
}
