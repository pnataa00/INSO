package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alumno;
import modelo.Horario;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T12:27:49")
@StaticMetamodel(Clases.class)
public class Clases_ { 

    public static volatile SingularAttribute<Clases, Horario> horario;
    public static volatile SingularAttribute<Clases, Integer> idClase;
    public static volatile SingularAttribute<Clases, Alumno> alumno;
    public static volatile SingularAttribute<Clases, Profesor> profesor;

}