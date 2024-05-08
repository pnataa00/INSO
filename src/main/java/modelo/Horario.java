/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pablo
 */

@Entity
@Table(name="horarios")
public class Horario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    
    @Column(name="Dia")
    @Temporal(TemporalType.DATE)
    private Date ultimaConexion;
    
    @Column(name="HoraInicio")
    @Temporal(TemporalType.TIME)
    private java.time.LocalTime horaInicio;
    
    @Column(name="HoraFin")
    @Temporal(TemporalType.TIME)
    private java.time.LocalTime horaFin;

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idHorario;
        hash = 17 * hash + Objects.hashCode(this.ultimaConexion);
        hash = 17 * hash + Objects.hashCode(this.horaInicio);
        hash = 17 * hash + Objects.hashCode(this.horaFin);
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
        final Horario other = (Horario) obj;
        if (this.idHorario != other.idHorario) {
            return false;
        }
        if (!Objects.equals(this.ultimaConexion, other.ultimaConexion)) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horaFin, other.horaFin)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
