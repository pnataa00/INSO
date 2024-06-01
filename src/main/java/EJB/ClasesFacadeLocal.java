/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Asignaturas;
import modelo.Clases;

/**
 *
 * @author pablo
 */
@Local
public interface ClasesFacadeLocal {

    void create(Clases clases);

    void edit(Clases clases);

    void remove(Clases clases);

    Clases find(Object id);
    
    List<Clases> findByAsignatura(Asignaturas asignatura);

    List<Clases> findAll();

    List<Clases> findRange(int[] range);

    int count();
    
}
