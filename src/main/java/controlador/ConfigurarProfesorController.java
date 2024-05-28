/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AsignaturasFacadeLocal;
import EJB.HorarioFacadeLocal;
import EJB.ProfesorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Asignaturas;
import modelo.Horario;
import modelo.Profesor;
import modelo.Usuario;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class ConfigurarProfesorController implements Serializable{
    private Profesor profesor;
    private List<Asignaturas> asignaturas;
    private List<Horario> horarios;
    
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    @EJB
    private HorarioFacadeLocal horarioEJB;
    
    @PostConstruct
    public void init(){
        asignaturas=asignaturaEJB.findAll();
        Usuario usu=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(usu!=null){
            profesor=profesorEJB.finByUsuario(usu);
        }
        horarios=horarioEJB.findAll();
        asignaturas=asignaturaEJB.findAll();
    }
    
    public void configurarProfesor(){
        profesor.setAsignaturas(asignaturas);
        profesor.setHorarios(horarios);
        profesorEJB.edit(profesor);
        
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public ProfesorFacadeLocal getProfesorEJB() {
        return profesorEJB;
    }

    public void setProfesorEJB(ProfesorFacadeLocal profesorEJB) {
        this.profesorEJB = profesorEJB;
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
