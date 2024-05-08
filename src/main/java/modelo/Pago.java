/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pablo
 */
@Entity
@Table(name="pagos")
public class Pago implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    
    @JoinColumn(name="IdProfesor")
    @ManyToOne
    private Profesor profesor;
    
    @JoinColumn(name="IdAlumno")
    @ManyToOne
    private Alumno alumno;
    
    @Column(name="Cantidad")
    private float cantidad;
    
    @Column(name="FechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaPago;
    
    @Column(name="Pagado")
    private boolean pagado =false;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idPago;
        hash = 37 * hash + Objects.hashCode(this.profesor);
        hash = 37 * hash + Objects.hashCode(this.alumno);
        hash = 37 * hash + Float.floatToIntBits(this.cantidad);
        hash = 37 * hash + Objects.hashCode(this.fechaPago);
        hash = 37 * hash + (this.pagado ? 1 : 0);
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
        final Pago other = (Pago) obj;
        if (this.idPago != other.idPago) {
            return false;
        }
        if (Float.floatToIntBits(this.cantidad) != Float.floatToIntBits(other.cantidad)) {
            return false;
        }
        if (this.pagado != other.pagado) {
            return false;
        }
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.fechaPago, other.fechaPago)) {
            return false;
        }
        return true;
    }
    
    
    
}
