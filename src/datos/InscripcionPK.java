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
    public int hashCode() {
        int hash = 0;
        hash += idEdicion.hashCode();
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
