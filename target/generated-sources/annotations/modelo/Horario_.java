package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-28T21:56:59")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Date> fecha;
    public static volatile SingularAttribute<Horario, Integer> idHorario;
    public static volatile ListAttribute<Horario, Profesor> profesores;
    public static volatile SingularAttribute<Horario, Integer> duracion;

}