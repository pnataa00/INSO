/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Menu;
import modelo.Usuario;


/**
 *
 * @author pablo
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "ClasesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
   @Override
    public List<Menu> obtenerMenusUsuario(Usuario usuario){
        List<Menu> resultado=new ArrayList<>();
        try{
            String consulta="FROM Menu m WHERE m.rol.idRol=:param1";
            Query query= em.createQuery(consulta);
            query.setParameter("param1", usuario.getRol().getIdRol());
            resultado=query.getResultList();
            
        }catch(Exception e){
            
            System.out.println(e.toString());
        }
        return resultado;
    }

    
    
}
