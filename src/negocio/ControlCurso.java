/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Curso;
import datos.ManejadorDatos;

/**
 *
 * @author oscarribera
 */
public class ControlCurso {

    public static void main(String[] args) {
        ManejadorDatos manejadorDatos = new ManejadorDatos();

        Curso curso1 = new Curso();
        curso1.setCodigo("CU-1");
        curso1.setDuracionHoras(20);
        curso1.setTema("tema1");
        curso1.setTitulo("titulo 1");
        manejadorDatos.save(curso1);

        Curso curso2 = new Curso();
        curso2.setCodigo("CU-2");
        curso2.getRequisitos().add(curso1);
        manejadorDatos.save(curso2);

        Curso curso3 = new Curso();
        curso3.setCodigo("CU-3");
        curso3.getRequisitos().add(curso1);
        curso3.getRequisitos().add(curso2);
        manejadorDatos.save(curso3);
    }
}
