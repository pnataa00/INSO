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

/**
 *
 * @author pablo
 */
@Stateless
public class AsignaturasFacade extends AbstractFacade<Asignaturas> implements AsignaturasFacadeLocal {

    @PersistenceContext(unitName = "ClasesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturasFacade() {
        super(Asignaturas.class);
    }
    
    @Override
    public Asignaturas findByName(String name){
        List<Asignaturas> allAsigs = findAll();
        for(int i=0; i<allAsigs.size(); i++){
            if(allAsigs.get(i).getNombre().equals(name)){
                return allAsigs.get(i);
            }
        }
        
        return null;
    }
    
}
