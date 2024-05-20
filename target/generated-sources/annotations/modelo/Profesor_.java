package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Asignaturas;
import modelo.Horario;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-20T13:47:01")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile ListAttribute<Profesor, Horario> horarios;
    public static volatile SingularAttribute<Profesor, Usuario> usuario;
    public static volatile ListAttribute<Profesor, Asignaturas> asignaturas;

}