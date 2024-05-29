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
public class AltaClaseController implements Serializable{
    private Clases clase;
    private String asignatura;
    private List<String> asignaturas;
    private Usuario usuario;
    private List<Clases> listaClases;
    
    
    
    
    @EJB
    private AsignaturasFacadeLocal asignaturaEJB;
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    @EJB 
    private UsuarioFacadeLocal usuarioEJB;
    
    
    
    @PostConstruct
    public void init(){
        clase=new Clases();
        
        asignaturas=new ArrayList<>();
        
        List<Asignaturas> allAsignaturas=asignaturaEJB.findAll();
        for(int i=0; i<allAsignaturas.size(); i++){
            asignaturas.add(allAsignaturas.get(i).getNombre());
        }
        asignatura=asignaturas.get(0);
        usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        listaClases=usuario.getClases();
        
        
    }
    public void insertarClase(){
        clase.setAsignatura(asignaturaEJB.findByName(asignatura));
        List<Usuario> usuarios=new ArrayList<>();
        clase.setUsuarios(usuarios);
        clase.getUsuarios().add(usuario);
        usuario.getClases().add(clase);
        claseEJB.create(this.clase);
        usuarioEJB.edit(usuario);
        if(clase.getDuracion()<=4){
            listaClases=usuario.getClases();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase creada correctamente.", null));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase no creada, la duración debe ser menor de 4 horas.", null));
        }
        
        
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Clases> getListaClases() {
        return listaClases;
    }

    public void setListaClases(List<Clases> listaClases) {
        this.listaClases = listaClases;
    }

    public AsignaturasFacadeLocal getAsignaturaEJB() {
        return asignaturaEJB;
    }

    public void setAsignaturaEJB(AsignaturasFacadeLocal asignaturaEJB) {
        this.asignaturaEJB = asignaturaEJB;
    }

    public ClasesFacadeLocal getClaseEJB() {
        return claseEJB;
    }

    public void setClaseEJB(ClasesFacadeLocal claseEJB) {
        this.claseEJB = claseEJB;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
    

    
    
    
    
    
}
