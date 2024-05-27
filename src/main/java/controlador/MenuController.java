/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.MenuFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Menu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.DefaultMenuModel;
import modelo.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;

/**
 *
 * @author pablo
 */

@Named
@SessionScoped
public class MenuController implements Serializable{
    private MenuModel modelo;
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    @PostConstruct
    public void init(){
        modelo=obtenerMenu();
    }
    
    public MenuModel obtenerMenu(){
        //crear menuModel
        MenuModel modeloUsuario=new DefaultMenuModel();
        //CPger usuario actual
        Usuario usuarioActual=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        //SOlicitar menus según que usuario
        List<Menu> menusUsuario=menuEJB.obtenerMenusUsuario(usuarioActual);
        for(Menu mActual : menusUsuario){
            if(mActual.getTipo() == 'S'){
                DefaultSubMenu submenu=DefaultSubMenu.builder().label(mActual.getNombre()).build();
                for(Menu restoMenus : menusUsuario){
                    //ver si tiene padre, si no es item
                    if(restoMenus.getMenu()!=null){
                        //comprobar si es hijo del submenu
                        if(restoMenus.getMenu().getIdMenu() == mActual.getIdMenu()){
                            DefaultMenuItem item = DefaultMenuItem.builder().value(restoMenus.getNombre()).url("/proyecto/faces" + restoMenus.getUrl()).build();
                            submenu.getElements().add(item);
                        }
                    }
                }
                modeloUsuario.getElements().add(submenu);
            }else{
                if(mActual.getMenu()==null){
                    DefaultMenuItem item= DefaultMenuItem.builder().value(mActual.getNombre()).url("/proyecto/faces" + mActual.getUrl()).build();
                    modeloUsuario.getElements().add(item);
                }
            }
                
        }
        return modeloUsuario;
        
    }
    
     public void destrurirSesionActual() {
        try {
            // Se destruye la sesion del usuario
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/index.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.modelo);
        hash = 17 * hash + Objects.hashCode(this.menuEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuController other = (MenuController) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.menuEJB, other.menuEJB)) {
            return false;
        }
        return true;
    }
     
     
    
}
