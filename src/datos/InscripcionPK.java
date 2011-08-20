/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author timoteo
 */
@Embeddable
public class InscripcionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_EDICION")
    private String idEdicion;
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO")
    private Integer idAlumno;

    public InscripcionPK() {
    }

    public InscripcionPK(String idEdicion, Integer idAlumno) {
        this.idEdicion = idEdicion;
        this.idAlumno = idAlumno;
    }

    public String getIdEdicion() {
        return idEdicion;
    }

    public void setIdEdicion(String idEdicion) {
        this.idEdicion = idEdicion;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InscripcionPK other = (InscripcionPK) obj;
        if ((this.idEdicion == null) ? (other.idEdicion != null) : !this.idEdicion.equals(other.idEdicion)) {
            return false;
        }
        if (this.idAlumno != other.idAlumno && (this.idAlumno == null || !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.idEdicion != null ? this.idEdicion.hashCode() : 0);
        hash = 41 * hash + (this.idAlumno != null ? this.idAlumno.hashCode() : 0);
        return hash;
    }
}
