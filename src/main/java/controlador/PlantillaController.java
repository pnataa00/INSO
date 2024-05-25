/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarYMostrar() throws IOException {
        Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(us==null){
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/publico/permisosinsuficientes.xhtml?faces-redirect=true");
        }
    }
    
    public void verificarYMostrarAlumno(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        if(us==null || us.getRol().getNombre().compareTo("Alumno")!=0){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/publico/permisosinsuficientes.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(PlantillaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void verificarYMostrarProfesor(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        if(us==null || us.getRol().getNombre().compareTo("Profesor")!=0){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/publico/permisosinsuficientes.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(PlantillaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void verificarYMostrarAdmin(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        if(us==null || us.getRol().getNombre().compareTo("Admin")!=0){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/publico/permisosinsuficientes.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(PlantillaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public boolean esAlumno(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") != null && us.getRol().getNombre().compareTo("Alumno")==0;
    }
    
    public boolean esProfesor(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") != null && us.getRol().getNombre().compareTo("Profesor")==0;
    }
    
    public boolean esAdmin(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") != null && us.getRol().getNombre().compareTo("Admin")==0;
    }
    
    public void cerrarSesion(){
        
        try {
            // Se destruye la sesion del usuario
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/index.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
