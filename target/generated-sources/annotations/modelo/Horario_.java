package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-27T13:07:15")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Date> horaFin;
    public static volatile SingularAttribute<Horario, Integer> idHorario;
    public static volatile ListAttribute<Horario, Profesor> profesores;
    public static volatile SingularAttribute<Horario, Date> dia;
    public static volatile SingularAttribute<Horario, Date> horaInicio;

}