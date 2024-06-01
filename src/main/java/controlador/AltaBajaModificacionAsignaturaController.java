/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AsignaturasFacadeLocal;
import EJB.ClasesFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import modelo.Asignaturas;
import modelo.Clases;
import modelo.Usuario;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class AltaBajaModificacionAsignaturaController implements Serializable{
    
    private Asignaturas asignatura;
    private List<Asignaturas> asignaturas;
    private String accion;
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    
    @PostConstruct
    public void init(){
        asignatura= new Asignaturas();
        asignaturas=asignaturaEJB.findAll();
    }
    
    public void establecerAsignaturaInsertar(){
        setAccion("R");
        asignatura=new Asignaturas();
    }
    
    public void insertarAsignatura(){
        asignaturaEJB.create(asignatura);
        asignaturas=asignaturaEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Asignatura añadida correctamente",""));
        
    }
    
    public void establecerAsignaturaEliminar(Asignaturas asig){
        setAccion("E");
        asignatura=asig;
    }
    
    public void eliminarAsignatura(){
        List<Clases> clases=claseEJB.findByAsignatura(asignatura);
        for(Clases clase : clases){
            for(Usuario us : new ArrayList<>(clase.getUsuarios())){
                us.getClases().remove(clase);
                usuarioEJB.edit(us);
            }
            claseEJB.remove(clase);
                
        }
        
        asignaturaEJB.remove(asignatura);
        asignaturas=asignaturaEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Asignatura eliminada",""));
    }
    
    public void establecerAsignaturaModificar(Asignaturas asig){
        setAccion("M");
        asignatura=asig;
    }
    
    public void modificarAsignatura(){
        asignaturaEJB.edit(asignatura);
        asignaturas=asignaturaEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Asignatura modificada",""));
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

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
}
