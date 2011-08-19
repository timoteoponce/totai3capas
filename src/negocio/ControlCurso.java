/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Curso;
import datos.ManejadorDatos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscarribera
 */
public class ControlCurso {

    ManejadorDatos manejadorDatos = new ManejadorDatos();

    public String addCurso(String codigo, String titulo, String tema, Integer hora) {
        String resultado;
        Curso curso = (Curso) manejadorDatos.getById(Curso.class, codigo);
        if (curso == null) {
            curso = new Curso();
            curso.setCodigo(codigo);
            curso.setTitulo(titulo);
            curso.setTema(tema);
            curso.setDuracionHoras(hora);

            manejadorDatos.save(curso);
            resultado = "Curso guardado : " + codigo;
        } else {
            resultado = "Curso duplicado : " + codigo;
        }
        return resultado;
    }

    public List<Object[]> getCursos() {
        List<Curso> cursos = manejadorDatos.list(Curso.class);
        List<Object[]> arrayCursos = new ArrayList<Object[]>();
        for (Curso curso : cursos) {
            arrayCursos.add(curso.toArray());
        }
        return arrayCursos;
    }
}
