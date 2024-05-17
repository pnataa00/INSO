package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alumno;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-17T11:30:11")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Boolean> pagado;
    public static volatile SingularAttribute<Pago, Integer> idPago;
    public static volatile SingularAttribute<Pago, Profesor> profesor;
    public static volatile SingularAttribute<Pago, Alumno> alumno;
    public static volatile SingularAttribute<Pago, Float> cantidad;
    public static volatile SingularAttribute<Pago, Date> fechaPago;

}