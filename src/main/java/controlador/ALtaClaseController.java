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
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Asignaturas;
import modelo.Clases;
import modelo.Horario;
import modelo.Profesor;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class AltaClaseController implements Serializable{
    private Clases clase;
    private String asignatura;
    private List<String> asignaturas;
    private Horario horario;
    private List<Horario> horarios;
    Profesor profesor;
    
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    @EJB 
    private HorarioFacadeLocal horarioEJB;
    
    @PostConstruct
    public void init(){
        clase=new Clases();
        horarios=new ArrayList<>();
        asignaturas=new ArrayList<>();
        
        List<Asignaturas> allAsignaturas=asignaturaEJB.findAll();
        for(int i=0; i<allAsignaturas.size(); i++){
            asignaturas.add(allAsignaturas.get(i).getNombre());
        }
        asignatura=asignaturas.get(0);
        
        List<Horario> allHorarios=horarioEJB.findAll();
        for(int i=0; i<allHorarios.size(); i++){
            horarios.add(allHorarios.get(i));
        }
        
    }
    public void insertarClase(){
      
    }

    
    
    
    
    
}
