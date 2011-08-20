/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Aula;
import datos.Curso;
import datos.Dia;
import datos.Edicion;
import datos.Empleado;
import datos.ManejadorDatos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author oscarribera
 */
public class ControlEdicion {
    
    private ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public List<Object[]> getEdiciones() {
        List<Edicion> ediciones = manejadorDatos.list(Edicion.class);
        return Utils.toArrayList(ediciones);        
    }


    public String addEdicion(String id, String cursoId, Integer docenteId, String aulaId, Date fechaInicio, Date fechaFin, Object[] diasClase) {
        String resultado;
        Edicion edicion = manejadorDatos.getById(Edicion.class, id);
        if(edicion == null){
            Curso curso = manejadorDatos.getById(Curso.class, cursoId);
            Empleado docente = manejadorDatos.getById(Empleado.class, docenteId);
            Aula aula = manejadorDatos.getById(Aula.class, aulaId);            
            edicion = new Edicion();
            edicion.setId(id);
            edicion.setFechaInicio(fechaInicio);
            edicion.setFechaFin(fechaFin);
            edicion.setAula(aula);
            edicion.setCurso(curso);
            edicion.setDocente(docente);
            for(Object item: diasClase){
                Dia dia = manejadorDatos.getById(Dia.class, item.toString());
                edicion.getDiasClase().add(dia);
            }
            
            manejadorDatos.save(edicion);
            resultado = "Edicion guardada : " + id;
        }else{
            resultado = "Edicion duplicada : "+id;
        }
        return resultado;
    }

    public List<Object[]> getDiasClase(String id) {
        Edicion edicion = manejadorDatos.getById(Edicion.class, id);
        return Utils.toArrayList(edicion.getDiasClase());
    }


    
    
}
