/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Asignaturas;

/**
 *
 * @author pablo
 */
@Local
public interface AsignaturasFacadeLocal {

    void create(Asignaturas asignaturas);

    void edit(Asignaturas asignaturas);

    void remove(Asignaturas asignaturas);

    Asignaturas find(Object id);

    List<Asignaturas> findAll();

    List<Asignaturas> findRange(int[] range);

    int count();
    
}
