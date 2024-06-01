/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.Clases;
import modelo.Usuario;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class EditarEliminarUsuarioController implements Serializable{
    private List<Usuario> usuarios;
    private Usuario usuario;
    private String accion;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    @PostConstruct
    public void init(){
        usuarios=usuarioEJB.findAll();
    }

    public void establecerUsuarioEliminar(Usuario usu){
        usuario=usu;
        setAccion("E");
    }
    
    public void eliminarUsuario(){
        if(usuario.getRol().getNombre().equals("Alumno")){
            usuario.getClases().clear();
        }else{
            List<Clases> clasesEliminar=new ArrayList<>(usuario.getClases());
            for(Clases clase : clasesEliminar){
                for(Usuario us : new ArrayList<>(clase.getUsuarios())){
                    us.getClases().remove(clase);
                    usuarioEJB.edit(us);
                }
                claseEJB.remove(clase);
                
            }
        }
        usuarioEJB.remove(usuario);
        usuarios=usuarioEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Eliminado",""));
    }
    
    public void establecerUsuarioModificar(Usuario usu){
        usuario=usu;
        setAccion("M");
    }
    
    public void modificarUsuario(){
        usuarioEJB.edit(usuario);
        usuarios=usuarioEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario modificado",""));
    }
    
    
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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
