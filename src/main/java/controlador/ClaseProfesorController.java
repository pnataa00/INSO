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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
public class ClaseProfesorController implements Serializable{
    private Clases clase;
    private String asignatura;
    private List<String> asignaturas;
    private Usuario usuario;
    private List<Clases> listaClases;
    private String accion;
    private String comentario;
    
    
    
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
    
    public void establecerClase(Clases clase){
        this.clase=clase;
    }
    public void establecerClaseInsertar(){
        this.setAccion("R");
        this.clase=new Clases();
        
        
        
    }
    public void insertarClase(){
        clase.setAsignatura(asignaturaEJB.findByName(asignatura));
        List<Usuario> usuarios=new ArrayList<>();
        clase.setUsuarios(usuarios);
        clase.getUsuarios().add(usuario);
        usuario.getClases().add(clase);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date today = cal.getTime();
        if(clase.getFecha().after(today)){
            if(clase.getDuracion()<=4){
                claseEJB.create(this.clase);
                usuarioEJB.edit(usuario);
                listaClases=usuario.getClases();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase creada correctamente.", null));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase no creada, la duración debe ser menor de 4 horas.", null));
            }
        }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase no creada, la fecha debe ser posterior a hoy.", null));   
        }
        
        
    }
    
    public void establecerClaseELiminar(Clases clase){
        setAccion("E");
        this.clase=clase;
    }
    
    public void eliminarClase(){
        for(Usuario user : clase.getUsuarios()){
            user.getClases().remove(clase);
            usuarioEJB.edit(user);
        }
        
        claseEJB.remove(clase);
        listaClases=usuario.getClases();
        
    }
    
     public void comentarClase(){
        usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        listaClases=usuario.getClases();
        
        
        
        clase.setComentarioProfesor(comentario);
        
        claseEJB.edit(clase);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Hecho",""));
        
        
        
        

    }
    
    public void establecerClaseModificar(Clases clase){
        setAccion("M");
        this.clase=clase;
        
    }
    
    public void modificarClase(){
        
        claseEJB.edit(clase);
        listaClases=usuario.getClases();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Clase modificada",""));
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    
    

    
    
    
    
    
}
