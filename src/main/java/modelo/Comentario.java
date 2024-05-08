/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pablo
 */

@Entity
@Table(name="comentarios")
public class Comentario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    
    @JoinColumn(name="IdProfesor")
    @ManyToOne
    private Profesor profesor;
    
    @JoinColumn(name="IdAlumno")
    @ManyToOne
    private Alumno alumno;
    
    @JoinColumn(name="IdClase")
    @ManyToOne
    private Clases clase;
    
    @Column(name="Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fecha;
    
    @Column(name="Comentario")
    private String comentario;
    
    @Column(name="Puntuacion")
    private int puntuacion;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idComentario;
        hash = 23 * hash + Objects.hashCode(this.profesor);
        hash = 23 * hash + Objects.hashCode(this.alumno);
        hash = 23 * hash + Objects.hashCode(this.clase);
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.comentario);
        hash = 23 * hash + this.puntuacion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (this.idComentario != other.idComentario) {
            return false;
        }
        if (this.puntuacion != other.puntuacion) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.clase, other.clase)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
