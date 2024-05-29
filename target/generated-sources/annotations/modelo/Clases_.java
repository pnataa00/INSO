package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Asignaturas;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-29T13:48:56")
@StaticMetamodel(Clases.class)
public class Clases_ { 

    public static volatile SingularAttribute<Clases, Date> fecha;
    public static volatile SingularAttribute<Clases, Asignaturas> asignatura;
    public static volatile SingularAttribute<Clases, Integer> precio;
    public static volatile SingularAttribute<Clases, Boolean> estado;
    public static volatile SingularAttribute<Clases, Integer> duracion;
    public static volatile SingularAttribute<Clases, Integer> idClase;
    public static volatile ListAttribute<Clases, Usuario> usuarios;

}