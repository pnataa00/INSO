/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlumnoFacadeLocal;
import EJB.ProfesorFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Alumno;
import modelo.Profesor;
import modelo.Usuario;

/**
 *
 * @author pablo
 */

@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    private Usuario usuario;
    private Profesor profesor;
    private Alumno alumno;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @EJB
    private ProfesorFacadeLocal profesorEJB;
    
    @EJB
    private AlumnoFacadeLocal alumnoEJB;
    
    @PostConstruct
    public void init(){
        usuario= new Usuario();
        profesor=new Profesor();
        alumno=new Alumno();
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
    
    public void insertarUsuario(){
        try{
            if(validarDNI(usuario.getDNI())){
                usuarioEJB.create(usuario);
                System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
                if (usuario.getTipoUsuario().equals("Alumno")) {
                    alumno.setUsuario(usuario);                    
                    alumnoEJB.create(alumno);
                    
                } else if (usuario.getTipoUsuario().equals("Profesor")) {
                    profesor.setUsuario(usuario);
                    profesorEJB.create(profesor);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario creado exitosamente.", null));
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
