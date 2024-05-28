/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.HorarioFacadeLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Horario;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class AltaHorarioController implements Serializable{
    private Horario horario;
    
    @EJB
    private HorarioFacadeLocal horarioEJB;
    
    @PostConstruct
    public void init(){
        horario=new Horario();
    }
    
    public void insertarHorario(){
        
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date today = cal.getTime();
            if(horario.getFecha().after(today)){
                if(horario.getDuracion()>4){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"La clase no puede durar más de 4 horas",""));
                }else{
                    horarioEJB.create(horario);
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Horario añadido correctamente",""));
                }
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"La fecha debe ser posterior a hoy",""));
            }
            
       
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public HorarioFacadeLocal getHorarioEJB() {
        return horarioEJB;
    }

    public void setHorarioEJB(HorarioFacadeLocal horarioEJB) {
        this.horarioEJB = horarioEJB;
    }
    
    
    
}
