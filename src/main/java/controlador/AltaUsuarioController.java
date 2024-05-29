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
    
    private String rol;
    private List<String> roles;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
        
    @EJB
    private RolFacadeLocal rolEJB;
    
    @PostConstruct
    public void init(){
        usuario= new Usuario();
        
        roles=new ArrayList<>();
        
        List<Rol> rolesBD = rolEJB.findAll();
        rolesBD.forEach((rActual) -> {
            roles.add(rActual.getNombre());
        });
    }
    
    
    //Método para comprobar que el DNI sea válido
    public boolean validarDNI(String dni) {
     
        if (dni.length() != 9) {
            return false;
        }

        String numeros = dni.substring(0, 8);
        try {
            Integer.parseInt(numeros);
        } catch (NumberFormatException e) {
            return false;
        }

        char letra = dni.charAt(8);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = Integer.parseInt(numeros) % 23;
        if (letra != letras.charAt(indice)) {
            return false;
        }

        return true;
    }
    
    
    public void volverAtras() throws IOException{
       
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.xhtml");
    }
    
    public void insertarUsuario(){
        try{
            if(validarDNI(usuario.getDNI())){
                usuario.setRol(rolEJB.findByNombre(rol));
                usuarioEJB.create(usuario);
                
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario creado exitosamente.", null));
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/");
            }else{
                if(!validarDNI(usuario.getDNI())){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DNI no valido.", null));
                }
            }
        }catch (Exception e){
            
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.rol);
        hash = 79 * hash + Objects.hashCode(this.roles);
        hash = 79 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 79 * hash + Objects.hashCode(this.rolEJB);
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
