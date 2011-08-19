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
    private int idEdicion;
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO")
    private int idAlumno;

    public InscripcionPK() {
    }

    public InscripcionPK(int idEdicion, int idAlumno) {
        this.idEdicion = idEdicion;
        this.idAlumno = idAlumno;
    }

    public int getIdEdicion() {
        return idEdicion;
    }

    public void setIdEdicion(int idEdicion) {
        this.idEdicion = idEdicion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEdicion;
        hash += (int) idAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionPK)) {
            return false;
        }
        InscripcionPK other = (InscripcionPK) object;
        if (this.idEdicion != other.idEdicion) {
            return false;
        }
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.InscripcionPK[idEdicion=" + idEdicion + ", idAlumno=" + idAlumno + "]";
    }

}
