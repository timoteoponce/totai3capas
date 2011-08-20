/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author timoteo
 */
@Entity
public class Inscripcion implements Serializable,Entidad {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionPK inscripcionPK;
    @Column(name = "NOTA")
    private Integer nota;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInscripcion;

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public InscripcionPK getInscripcionPK() {
        return inscripcionPK;
    }

    public void setInscripcionPK(InscripcionPK inscripcionPK) {
        this.inscripcionPK = inscripcionPK;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.inscripcionPK != other.inscripcionPK && (this.inscripcionPK == null || !this.inscripcionPK.equals(other.inscripcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.inscripcionPK != null ? this.inscripcionPK.hashCode() : 0);
        return hash;
    }

    public Object[] toArray() {
        return new Object[]{this.inscripcionPK.getIdEdicion(),this.inscripcionPK.getIdAlumno(),this.fechaInscripcion,this.nota};
    }
}
