/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.HorarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Horario;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class HorarioController implements Serializable{
    private Horario horario;
    
    @EJB
    private HorarioFacadeLocal horarioEJB;
    
    @PostConstruct
    public void init(){
        horario=new Horario();
    }
    
    public void insertarHorario(){
        horarioEJB.create(horario);
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
