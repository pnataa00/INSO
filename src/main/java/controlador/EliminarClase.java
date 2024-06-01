/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClasesFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clases;
import modelo.Usuario;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class EliminarClase implements Serializable{
    private List<Clases> clases;
    private Clases clase;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    @PostConstruct
    public void init(){
        clases=claseEJB.findAll();
    }
    public void establecerClase(Clases clas){
        clase=clas;
    }
    public void eliminarClase(){
        for(Usuario usuario : clase.getUsuarios()){
            usuario.getClases().remove(clase);
            usuarioEJB.edit(usuario);
        }
        claseEJB.remove(clase);
        clases=claseEJB.findAll();
    }

    public List<Clases> getClases() {
        return clases;
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public ClasesFacadeLocal getClaseEJB() {
        return claseEJB;
    }

    public void setClaseEJB(ClasesFacadeLocal claseEJB) {
        this.claseEJB = claseEJB;
    }
    
    
    
}
