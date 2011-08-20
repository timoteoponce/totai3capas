/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author timoteo
 */
@Entity
//@Table(name="Curso")
public class Curso implements Serializable,Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    private String codigo;
    private String titulo;
    private Integer duracionHoras;
    private String tema;
    @ManyToMany
    @JoinTable(name="requisito")
    private final Set<Curso> requisitos = new HashSet<Curso>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Curso> getRequisitos() {
        return requisitos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    
    public Object[] toArray() {
        return new Object[]{this.codigo,this.titulo,this.tema,this.duracionHoras};
    }
}
