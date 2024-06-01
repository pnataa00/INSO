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
    
   
    public void inicio() throws IOException{
        String url="/proyecto/faces/privado/principal.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
    }
    
}
