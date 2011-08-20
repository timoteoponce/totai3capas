/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Curso;
import datos.ManejadorDatos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author oscarribera
 */
public class ControlCurso {

    ManejadorDatos manejadorDatos = ManejadorDatos.getInstance();

    public String addCurso(String codigo, String titulo, String tema, Integer hora, Object[] requisitos) {
        String resultado;
        Curso curso = (Curso) manejadorDatos.getById(Curso.class, codigo);
        if (curso == null) {
            curso = new Curso();
            curso.setCodigo(codigo);
            curso.setTitulo(titulo);
            curso.setTema(tema);
            curso.setDuracionHoras(hora);
            setRequisitos(curso, requisitos);

            manejadorDatos.save(curso);
            resultado = "Curso guardado : " + codigo;
        } else {
            resultado = "Curso duplicado : " + codigo;
        }
        return resultado;
    }

    public String modificarCurso(String codigo, String titulo, String tema, Integer hora, Object[] requisitos) {
        String resultado;
        Curso curso = (Curso) manejadorDatos.getById(Curso.class, codigo);
        if (curso == null) {
            resultado = "No existe este Curso a Modificar : " + codigo;
        } else {
            curso.setTitulo(titulo);
            curso.setTema(tema);
            curso.setDuracionHoras(hora);
            setRequisitos(curso, requisitos);
            manejadorDatos.save(curso);
            resultado = "Curso Modificado exitosamente" + codigo;
        }
        return resultado;
    }

    public List<Object[]> getCursos() {
        List<Curso> cursos = manejadorDatos.list(Curso.class);
        return toArrayList(cursos);
    }

    public String delCurso(String codigo) {
        String resultado;
        Curso curso = (Curso) manejadorDatos.getById(Curso.class, codigo);
        if (curso == null) {
            resultado = "No existe este Curso a Eliminar : " + codigo;
        } else {
            curso.getRequisitos().clear();
            manejadorDatos.delete(curso);
            resultado = "Curso eliminado exitosamente" + codigo;
        }
        return resultado;
    }

    public List<Object[]> getRequisitos(String codigo) {
        Curso curso = manejadorDatos.getById(Curso.class, codigo);
        List<Object[]> resultado;
        if (curso == null) {
            resultado = Collections.EMPTY_LIST;
        } else {
            resultado = toArrayList(curso.getRequisitos());
        }
        return resultado;
    }

    private List<Object[]> toArrayList(Collection<Curso> cursos) {
        List<Object[]> arrayCursos = new ArrayList<Object[]>();
        for (Curso curso : cursos) {
            arrayCursos.add(curso.toArray());
        }
        return arrayCursos;
    }

    public List<Object[]> filtrarCursos(Object[] arrayCodigos) {
        StringBuilder buffer = new StringBuilder();
        if (arrayCodigos.length > 0) {
            buffer.append(" WHERE t.codigo NOT IN (");

            for (int i = 0; i < arrayCodigos.length; i++) {
                buffer.append("'" + arrayCodigos[i] + "'");
                if ((i + 1) < arrayCodigos.length) {
                    buffer.append(",");
                }
            }
            buffer.append(")");
        }
        return toArrayList(manejadorDatos.list(Curso.class, buffer.toString()));
    }

    private void setRequisitos(Curso curso, Object[] requisitos) {
        curso.getRequisitos().clear();
        for (Object item : requisitos) {
            Curso requisito = manejadorDatos.getById(Curso.class, item.toString());
            curso.getRequisitos().add(requisito);
        }
    }
}
