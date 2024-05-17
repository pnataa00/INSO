/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
public class IndexController implements Serializable{
    private Usuario usuario;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @PostConstruct
    public void init(){
        usuario=new Usuario();
    }
    
    

    public String verificarUsuario() throws IOException{
        String navegacion;
        Usuario us= usuarioEJB.verificarUsuario(usuario);
        
        if(us!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
            FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
            navegacion="principal.xhtml";
            
        }else{
            navegacion="index.xhtml";
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciales no válidas",""));
            
        }
        return navegacion;
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.usuario);
        hash = 29 * hash + Objects.hashCode(this.usuarioEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IndexController other = (IndexController) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        return true;
    }
    
    
}
