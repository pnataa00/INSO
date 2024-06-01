/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Asignaturas;
import modelo.Clases;

/**
 *
 * @author pablo
 */
@Stateless
public class ClasesFacade extends AbstractFacade<Clases> implements ClasesFacadeLocal {

    @PersistenceContext(unitName = "ClasesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClasesFacade() {
        super(Clases.class);
    }
    
    @Override
    public List<Clases> findByAsignatura(Asignaturas asignatura){
        List<Clases> clases=findAll();
        for(Clases cl : clases){
            if(cl.getAsignatura().equals(asignatura)){
                clases.add(cl);
            }
        }
        return clases;
    }
}
