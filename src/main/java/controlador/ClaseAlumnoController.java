/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clases;
import modelo.Usuario;

import EJB.ClasesFacadeLocal;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;
import EJB.UsuarioFacadeLocal;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class ClaseAlumnoController implements Serializable{
    private List<Clases> listaClases;
    private Clases clase;
    private Usuario user;
    private String accion;
    private String comentario;
    private String valoracion;
    private Persona persona;
    
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @PostConstruct
    public void init(){
        user=new Usuario();
        persona=new Persona();
        user=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        listaClases=user.getClases();
        
    }
    
    public void apuntarse(){
        user=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        System.out.println(user.getPersona().getNombre());
        boolean found=false;
        for(int i=0;i<clase.getUsuarios().size();i++){
            if(user.getUserName().equals(this.clase.getUsuarios().get(i).getUserName())){
                found=true;
            }
        }
        
        if(!found && clase.getUsuarios().size()<2){
            System.out.println("Puede apuntarse");
            clase.getUsuarios().add(user);
            user.getClases().add(clase);
            listaClases=user.getClases();
            claseEJB.edit(clase);
            usuarioEJB.edit(user);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Apuntado",""));
        }else{
            System.out.println("NO puede apuntarse");
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No es posible apuntarse",""));
        }
        
    }
    
    public void valorarComentarClase(){
        user=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        listaClases=user.getClases();
        
        
        clase.setValoracion(valoracion);
        clase.setComentarioAlumno(comentario);
        
        claseEJB.edit(clase);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Hecho",""));
        
        
        
        

    }
    
    public void pagar(){
        if(clase.getPagado().equals("Y")){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Ya habías pagado",""));
        }else{
            clase.setPagado("Y");
            claseEJB.edit(clase);
        }
    }
    
   public void establecerClase(Clases clase){
        this.clase=clase;
    }

    public List<Clases> getListaClases() {
        return listaClases;
    }

    public void setListaClases(List<Clases> listaClases) {
        this.listaClases = listaClases;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ClasesFacadeLocal getClaseEJB() {
        return claseEJB;
    }

    public void setClaseEJB(ClasesFacadeLocal claseEJB) {
        this.claseEJB = claseEJB;
    }

    
    
    
    
    
}
