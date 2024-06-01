/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import EJB.UsuarioFacadeLocal;
import EJB.RolFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Persona;

import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class AltaUsuarioController implements Serializable{
    
    private Usuario usuario;
    private Persona persona;
    private String rol;
    private List<String> roles;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
        
    @EJB
    private RolFacadeLocal rolEJB;
    
    @PostConstruct
    public void init(){
        usuario= new Usuario();
        persona=new Persona();
        roles=new ArrayList<>();
        
        List<Rol> rolesBD = rolEJB.findAll();
        rolesBD.forEach((rActual) -> {
            roles.add(rActual.getNombre());
        });
    }
    
    
    
    
    
    public void volverAtras() throws IOException{
       
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.xhtml");
    }
    
    public void insertarUsuario(){
        try{
            
            usuario.setRol(rolEJB.findByNombre(rol));
            usuario.setPersona(persona);
            usuarioEJB.create(usuario);
                
                
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario creado exitosamente.", null));
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/");
            
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al registrar", "Error al registrar el usuario"));
            System.out.println("Error al insertar el usuario "+e.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.persona);
        hash = 67 * hash + Objects.hashCode(this.rol);
        hash = 67 * hash + Objects.hashCode(this.roles);
        hash = 67 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 67 * hash + Objects.hashCode(this.rolEJB);
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
        final AltaUsuarioController other = (AltaUsuarioController) obj;
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        return true;
    }

    

    
 

    
    
    
    
    
    
    
}
