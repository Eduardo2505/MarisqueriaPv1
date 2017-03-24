package com.mapping;
// Generated 11/04/2015 07:19:37 PM by Hibernate Tools 3.2.1.GA



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TrasladoMesa generated by hbm2java
 */
@Entity
@Table(name="traslado_mesa"
    ,catalog="marisqueriapv"
)
public class TrasladoMesa  implements java.io.Serializable {


     private Integer idTrasladoMesa;
     private MesaVenta mesaVenta;
     private String descripcion;
     private String registro;
     private String autorizacion;

    public TrasladoMesa() {
    }

	
    public TrasladoMesa(MesaVenta mesaVenta) {
        this.mesaVenta = mesaVenta;
    }
    public TrasladoMesa(MesaVenta mesaVenta, String descripcion, String registro, String autorizacion) {
       this.mesaVenta = mesaVenta;
       this.descripcion = descripcion;
       this.registro = registro;
       this.autorizacion = autorizacion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idTraslado_Mesa", unique=true, nullable=false)
    public Integer getIdTrasladoMesa() {
        return this.idTrasladoMesa;
    }
    
    public void setIdTrasladoMesa(Integer idTrasladoMesa) {
        this.idTrasladoMesa = idTrasladoMesa;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMesa_venta", nullable=false)
    public MesaVenta getMesaVenta() {
        return this.mesaVenta;
    }
    
    public void setMesaVenta(MesaVenta mesaVenta) {
        this.mesaVenta = mesaVenta;
    }
    
    @Column(name="descripcion", length=450)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    @Column(name="Registro", length=19)
    public String getRegistro() {
        return this.registro;
    }
    
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    @Column(name="Autorizacion", length=450)
    public String getAutorizacion() {
        return this.autorizacion;
    }
    
    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }




}


