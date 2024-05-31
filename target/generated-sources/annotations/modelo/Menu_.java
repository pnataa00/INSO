package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Menu;
import modelo.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-31T20:32:51")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Character> tipo;
    public static volatile SingularAttribute<Menu, Integer> idMenu;
    public static volatile SingularAttribute<Menu, Menu> menu;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, Rol> rol;
    public static volatile SingularAttribute<Menu, String> url;

}