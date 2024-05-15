/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */

@Entity
@Table(name="asignaturas")
public class Asignaturas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignatura;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Curso")
    private int curso;
    
    @ManyToMany
    @JoinTable(
        name = "asignatura_profesor",
        joinColumns = @JoinColumn(name = "IdAsignatura"),
        inverseJoinColumns = @JoinColumn(name = "IdProfesor")
    )
    private List<Profesor> profesores;

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    
    
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idAsignatura;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + this.curso;
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
        final Asignaturas other = (Asignaturas) obj;
        if (this.idAsignatura != other.idAsignatura) {
            return false;
        }
        if (this.curso != other.curso) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    
}