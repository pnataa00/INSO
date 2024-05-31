/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pablo
 */

@Entity
@Table(name="clases")
public class Clases implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClase;
    
    @Column(name="Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name="Duracion")
    private int duracion;
    
    @JoinColumn(name="IdAsignatura")
    @ManyToOne
    private Asignaturas asignatura;
    
    @Column(name="Precio")
    private int precio;
    
    @Column(name="Pagado")
    private String pagado;
    
    @Column(name="ComentarioProfesor")
    private String comentarioProfesor;
    
    @Column(name="ComentarioAlumno")
    private String comentarioAlumno;
    
    @Column(name="Valoracion")
    private int valoracion;
    
    
    @ManyToMany
    @JoinTable(
            name="clases_usuarios",
            joinColumns= @JoinColumn(name="IdClase"),
            inverseJoinColumns = @JoinColumn(name = "IdUsuario")
    )
    private List<Usuario> usuarios;

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getComentarioProfesor() {
        return comentarioProfesor;
    }

    public void setComentarioProfesor(String comentarioProfesor) {
        this.comentarioProfesor = comentarioProfesor;
    }

    public String getComentarioAlumno() {
        return comentarioAlumno;
    }

    public void setComentarioAlumno(String comentarioAlumno) {
        this.comentarioAlumno = comentarioAlumno;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getComentariosFormattedProfesor() {
        if (this.getComentarioProfesor() != null) {
            return this.getComentarioProfesor().replace("||", "<br/>");
        }
        return "";
    }
    
    public String getComentariosFormattedAlumno() {
        if (this.getComentarioAlumno() != null) {
            return this.getComentarioAlumno().replace("||", "<br/>");
        }
        return "";
    }

    

    
    
    
    

    
    

    

    

    
    

    
    
    
    
}
