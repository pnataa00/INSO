/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClasesFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clases;

/**
 *
 * @author pablo
 */
@Named
@ViewScoped
public class ListarClasesController implements Serializable{
    private List<Clases> clases;
    
    @EJB
    private ClasesFacadeLocal claseEJB;
    
    private Clases clase;
    
    @PostConstruct
    public void init(){
        clases=claseEJB.findAll();
    }

    public List<Clases> getClases() {
        return clases;
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }

    public ClasesFacadeLocal getClaseEJB() {
        return claseEJB;
    }

    public void setClaseEJB(ClasesFacadeLocal claseEJB) {
        this.claseEJB = claseEJB;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }
    
    
}
