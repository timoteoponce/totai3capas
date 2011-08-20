/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author timoteo
 */
@Entity
public class Edicion implements Serializable,Entidad {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    @ManyToOne
    private Empleado docente;
    @ManyToOne
    private Curso curso;
    @ManyToOne
    private Aula aula;
    @ManyToMany
    @JoinTable(name = "dias_clase")
    private Set<Dia> diasClase = new HashSet<Dia>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empleado getDocente() {
        return docente;
    }

    public void setDocente(Empleado docente) {
        this.docente = docente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Set<Dia> getDiasClase() {
        return diasClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edicion)) {
            return false;
        }
        Edicion other = (Edicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Edicion[id=" + id + "]";
    }
    
    public Object[] toArray(){
        return new Object[]{this.id,this.curso.getCodigo(),this.docente.getNombre(),this.aula.getId(),this.getFechaInicio(),this.fechaFin};
    }
}
