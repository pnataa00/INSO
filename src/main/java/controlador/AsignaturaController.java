/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AsignaturasFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import modelo.Asignaturas;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class AsignaturaController implements Serializable{
    
    private Asignaturas asignatura;
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    
    @PostConstruct
    public void init(){
        asignatura= new Asignaturas();
    }
    
    public void insertarAsignatura(){
        asignaturaEJB.create(asignatura);
        
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public AsignaturasFacadeLocal getAsignaturaEJB() {
        return asignaturaEJB;
    }

    public void setAsignaturaEJB(AsignaturasFacadeLocal asignaturaEJB) {
        this.asignaturaEJB = asignaturaEJB;
    }
    
    
}
