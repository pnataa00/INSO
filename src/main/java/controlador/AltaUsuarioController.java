/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlumnoFacadeLocal;
import EJB.ProfesorFacadeLocal;
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
import modelo.Alumno;
import modelo.Profesor;
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
    private Profesor profesor;
    private Alumno alumno;
    private String rol;
    private List<String> roles;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    @EJB
    private AlumnoFacadeLocal alumnoEJB;
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    @PostConstruct
    public void init(){
        usuario= new Usuario();
        profesor=new Profesor();
        alumno=new Alumno();
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
                
                if (usuario.getRol().getNombre().equals("Alumno")) {
                    alumno.setUsuario(usuario);                    
                    alumnoEJB.create(alumno);
                    
                } else if (usuario.getRol().getNombre().equals("Profesor")) {
                    profesor.setUsuario(usuario);
                    profesorEJB.create(profesor);
                }
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ProfesorFacadeLocal getProfesorEJB() {
        return profesorEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        hash = 23 * hash + Objects.hashCode(this.profesor);
        hash = 23 * hash + Objects.hashCode(this.alumno);
        hash = 23 * hash + Objects.hashCode(this.rol);
        hash = 23 * hash + Objects.hashCode(this.roles);
        hash = 23 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 23 * hash + Objects.hashCode(this.profesorEJB);
        hash = 23 * hash + Objects.hashCode(this.alumnoEJB);
        hash = 23 * hash + Objects.hashCode(this.rolEJB);
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
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.profesorEJB, other.profesorEJB)) {
            return false;
        }
        if (!Objects.equals(this.alumnoEJB, other.alumnoEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        return true;
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

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }
    
    

    public void setProfesorEJB(ProfesorFacadeLocal profesorEJB) {
        this.profesorEJB = profesorEJB;
    }

    public AlumnoFacadeLocal getAlumnoEJB() {
        return alumnoEJB;
    }

    public void setAlumnoEJB(AlumnoFacadeLocal alumnoEJB) {
        this.alumnoEJB = alumnoEJB;
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
    
    
    
    
    
    
}
