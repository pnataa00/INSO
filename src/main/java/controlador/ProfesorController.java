/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AsignaturasFacadeLocal;
import EJB.HorarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Asignaturas;
import modelo.Horario;
import modelo.Profesor;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class ProfesorController implements Serializable{
    private Asignaturas asignatura;
    private List<Asignaturas> asignaturas;
    private Horario horario;
    private List<Horario> horarios;
    Profesor profesor;
    
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    @EJB 
    private HorarioFacadeLocal horarioEJB;
    
    @PostConstruct
    public void init(){
        asignaturas=asignaturaEJB.findAll();
        horarios=new ArrayList<>();
        profesor=new Profesor();
    }
    public void gestionProfesor(){
       profesor.setAsignaturas(asignaturas);
       profesor.setHorarios(horarios);
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public AsignaturasFacadeLocal getAsignaturaEJB() {
        return asignaturaEJB;
    }

    public void setAsignaturaEJB(AsignaturasFacadeLocal asignaturaEJB) {
        this.asignaturaEJB = asignaturaEJB;
    }

    public HorarioFacadeLocal getHorarioEJB() {
        return horarioEJB;
    }

    public void setHorarioEJB(HorarioFacadeLocal horarioEJB) {
        this.horarioEJB = horarioEJB;
    }
    
    
    
    
}
