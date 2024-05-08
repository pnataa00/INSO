/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@Table(name="hoarios_profesores")
public class Horarios_Profesores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdHorarioProfesor;
    
    @JoinColumn(name="IdProfesor")
    @ManyToMany
    private Profesor profesor;
    
    
    @JoinColumn(name="IdHorario")
    @ManyToMany
    private Horario horario;

    public int getIdHorarioProfesor() {
        return IdHorarioProfesor;
    }

    public void setIdHorarioProfesor(int IdHorarioProfesor) {
        this.IdHorarioProfesor = IdHorarioProfesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.IdHorarioProfesor;
        hash = 37 * hash + Objects.hashCode(this.profesor);
        hash = 37 * hash + Objects.hashCode(this.horario);
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
        final Horarios_Profesores other = (Horarios_Profesores) obj;
        if (this.IdHorarioProfesor != other.IdHorarioProfesor) {
            return false;
        }
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }
    
    
}
