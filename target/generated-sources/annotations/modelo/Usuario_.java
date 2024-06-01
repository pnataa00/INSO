package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Clases;
import modelo.Persona;
import modelo.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-06-01T15:20:53")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Date> ultimaConexion;
    public static volatile SingularAttribute<Usuario, Persona> persona;
    public static volatile ListAttribute<Usuario, Clases> clases;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> userName;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}