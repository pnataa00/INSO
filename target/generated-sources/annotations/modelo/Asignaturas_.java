package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-25T18:17:12")
@StaticMetamodel(Asignaturas.class)
public class Asignaturas_ { 

    public static volatile ListAttribute<Asignaturas, Profesor> profesores;
    public static volatile SingularAttribute<Asignaturas, Integer> curso;
    public static volatile SingularAttribute<Asignaturas, Integer> idAsignatura;
    public static volatile SingularAttribute<Asignaturas, String> nombre;

}