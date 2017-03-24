package com.mapping;
// Generated 11/04/2015 07:19:37 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Barra generated by hbm2java
 */
@Entity
@Table(name="barra"
    ,catalog="marisqueriapv"
)
public class Barra  implements java.io.Serializable {


     private String idBarra;
     private String zona;
     private Set<VentaComanda> ventaComandas = new HashSet<VentaComanda>(0);
     private Set<Empleado> empleados = new HashSet<Empleado>(0);

    public Barra() {
    }

	
    public Barra(String idBarra) {
        this.idBarra = idBarra;
    }
    public Barra(String idBarra, String zona, Set<VentaComanda> ventaComandas, Set<Empleado> empleados) {
       this.idBarra = idBarra;
       this.zona = zona;
       this.ventaComandas = ventaComandas;
       this.empleados = empleados;
    }
   
     @Id 
    
    @Column(name="idBarra", unique=true, nullable=false, length=45)
    public String getIdBarra() {
        return this.idBarra;
    }
    
    public void setIdBarra(String idBarra) {
        this.idBarra = idBarra;
    }
    
    @Column(name="Zona", length=45)
    public String getZona() {
        return this.zona;
    }
    
    public void setZona(String zona) {
        this.zona = zona;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="barra")
    public Set<VentaComanda> getVentaComandas() {
        return this.ventaComandas;
    }
    
    public void setVentaComandas(Set<VentaComanda> ventaComandas) {
        this.ventaComandas = ventaComandas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="barra")
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


