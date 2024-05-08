/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */

@Entity
@Table(name="clases")
public class Clases implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClase;
    
    @JoinColumn(name="IdAlumno")
    @ManyToOne
    private Alumno alumno;
    
    @JoinColumn(name="IdProfesor")
    @ManyToOne
    private Profesor profesor;
    
    @JoinColumn(name="IdHorario")
    @ManyToOne
    private Horario horario;
    
    
}
