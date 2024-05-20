package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alumno;
import modelo.Clases;
import modelo.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-20T12:13:38")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Date> fecha;
    public static volatile SingularAttribute<Comentario, Integer> puntuacion;
    public static volatile SingularAttribute<Comentario, Profesor> profesor;
    public static volatile SingularAttribute<Comentario, Alumno> alumno;
    public static volatile SingularAttribute<Comentario, String> comentario;
    public static volatile SingularAttribute<Comentario, Integer> idComentario;
    public static volatile SingularAttribute<Comentario, Clases> clase;

}