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
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author pablo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ClasesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario verificarUsuario(Usuario usuario){
        
            String consulta="FROM Usuario u WHERE u.correoElectronico=:param1 and u.contraseña=:param2";
            Query query=em.createQuery(consulta);
            query.setParameter("param1", usuario.getCorreoElectronico());
            query.setParameter("param2", usuario.getContraseña());
            
            List<Usuario> resultado=query.getResultList();
            
            if(resultado.isEmpty()){
            
                return null;
            }
            return resultado.get(0);
        
            
        
    }
    
}
