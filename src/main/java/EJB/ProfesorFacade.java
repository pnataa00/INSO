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
import modelo.Profesor;
import modelo.Usuario;

/**
 *
 * @author pablo
 */
@Stateless
public class ProfesorFacade extends AbstractFacade<Profesor> implements ProfesorFacadeLocal {

    @PersistenceContext(unitName = "ClasesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesorFacade() {
        super(Profesor.class);
    }
    
    @Override
    public Profesor finByUsuario(Usuario usuario){
        List<Profesor> allProf=findAll();
        for(int i=0; i<allProf.size();i++){
            if(allProf.get(i).getUsuario().getIdUsuario()==(usuario.getIdUsuario())){
                return allProf.get(i);
            }
        }
        return null;
    }
    
}
