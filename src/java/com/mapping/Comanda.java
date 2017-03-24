package com.mapping;
// Generated 11/04/2015 07:19:37 PM by Hibernate Tools 3.2.1.GA



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comanda generated by hbm2java
 */
@Entity
@Table(name="comanda"
    ,catalog="marisqueriapv"
)
public class Comanda  implements java.io.Serializable {


     private String idComanda;
     private Altadia altadia;
     private MesaVenta mesaVenta;
     private String fechaHora;
     private String tipo;
     private String estado;
     private String observa;
     private String autorizacion;
     private String impreso;
     private String impresocopia;
     private Set<VentaComanda> ventaComandas = new HashSet<VentaComanda>(0);
     private Set<CancelacionComanda> cancelacionComandas = new HashSet<CancelacionComanda>(0);
     private Set<TrasladoComanda> trasladoComandas = new HashSet<TrasladoComanda>(0);

    public Comanda() {
    }

	
    public Comanda(String idComanda, Altadia altadia, MesaVenta mesaVenta) {
        this.idComanda = idComanda;
        this.altadia = altadia;
        this.mesaVenta = mesaVenta;
    }
    public Comanda(String idComanda, Altadia altadia, MesaVenta mesaVenta, String fechaHora, String tipo, String estado, String observa, String autorizacion, String impreso, String impresocopia, Set<VentaComanda> ventaComandas, Set<CancelacionComanda> cancelacionComandas, Set<TrasladoComanda> trasladoComandas) {
       this.idComanda = idComanda;
       this.altadia = altadia;
       this.mesaVenta = mesaVenta;
       this.fechaHora = fechaHora;
       this.tipo = tipo;
       this.estado = estado;
       this.observa = observa;
       this.autorizacion = autorizacion;
       this.impreso = impreso;
       this.impresocopia = impresocopia;
       this.ventaComandas = ventaComandas;
       this.cancelacionComandas = cancelacionComandas;
       this.trasladoComandas = trasladoComandas;
    }
   
     @Id 
    
    @Column(name="idComanda", unique=true, nullable=false, length=45)
    public String getIdComanda() {
        return this.idComanda;
    }
    
    public void setIdComanda(String idComanda) {
        this.idComanda = idComanda;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idaltadia", nullable=false)
    public Altadia getAltadia() {
        return this.altadia;
    }
    
    public void setAltadia(Altadia altadia) {
        this.altadia = altadia;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMesa_venta", nullable=false)
    public MesaVenta getMesaVenta() {
        return this.mesaVenta;
    }
    
    public void setMesaVenta(MesaVenta mesaVenta) {
        this.mesaVenta = mesaVenta;
    }
   
    @Column(name="fecha_hora", length=19)
    public String getFechaHora() {
        return this.fechaHora;
    }
    
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    @Column(name="tipo", length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Column(name="estado", length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name="observa", length=450)
    public String getObserva() {
        return this.observa;
    }
    
    public void setObserva(String observa) {
        this.observa = observa;
    }
    
    @Column(name="Autorizacion", length=450)
    public String getAutorizacion() {
        return this.autorizacion;
    }
    
    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }
    
    @Column(name="impreso", length=45)
    public String getImpreso() {
        return this.impreso;
    }
    
    public void setImpreso(String impreso) {
        this.impreso = impreso;
    }
    
    @Column(name="impresocopia", length=45)
    public String getImpresocopia() {
        return this.impresocopia;
    }
    
    public void setImpresocopia(String impresocopia) {
        this.impresocopia = impresocopia;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="comanda")
    public Set<VentaComanda> getVentaComandas() {
        return this.ventaComandas;
    }
    
    public void setVentaComandas(Set<VentaComanda> ventaComandas) {
        this.ventaComandas = ventaComandas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="comanda")
    public Set<CancelacionComanda> getCancelacionComandas() {
        return this.cancelacionComandas;
    }
    
    public void setCancelacionComandas(Set<CancelacionComanda> cancelacionComandas) {
        this.cancelacionComandas = cancelacionComandas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="comanda")
    public Set<TrasladoComanda> getTrasladoComandas() {
        return this.trasladoComandas;
    }
    
    public void setTrasladoComandas(Set<TrasladoComanda> trasladoComandas) {
        this.trasladoComandas = trasladoComandas;
    }




}

