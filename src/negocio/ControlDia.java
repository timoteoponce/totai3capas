/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import datos.Dia;
import datos.DiaEnum;
import datos.ManejadorDatos;
import java.util.ArrayList;
import java.util.Collection;
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
        return toArrayList(dias);
    }
    
    private List<Object[]> toArrayList(Collection<Dia> items) {
        List<Object[]> arrayCursos = new ArrayList<Object[]>();
        for (Dia item : items) {
            arrayCursos.add(item.toArray());
        }
        return arrayCursos;
    }
}
