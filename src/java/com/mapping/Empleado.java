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
 * Empleado generated by hbm2java
 */
@Entity
@Table(name="empleado"
    ,catalog="marisqueriapv"
)
public class Empleado  implements java.io.Serializable {


     private String idEmpleado;
     private Puesto puesto;
     private Barra barra;
     private String nombre;
     private String apellidos;
     private String mail;
     private String passEmail;
     private String sexo;
     private String nacimiento;
     private String registro;
     private String telefono;
     private String foto;
     private String tarjeta;
     private String impreso;
     private String empleadocol;
     private String estado;
     private String pass;
     private Set<Mesas> mesases = new HashSet<Mesas>(0);
     private Set<Pagoscorte> pagoscortes = new HashSet<Pagoscorte>(0);
     private Set<MesaVenta> mesaVentas = new HashSet<MesaVenta>(0);

    public Empleado() {
    }

	
    public Empleado(String idEmpleado, Puesto puesto, Barra barra) {
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
        this.barra = barra;
    }
    public Empleado(String idEmpleado, Puesto puesto, Barra barra, String nombre, String apellidos, String mail, String passEmail, String sexo, String nacimiento, String registro, String telefono, String foto, String tarjeta, String impreso, String empleadocol, String estado, String pass, Set<Mesas> mesases, Set<Pagoscorte> pagoscortes, Set<MesaVenta> mesaVentas) {
       this.idEmpleado = idEmpleado;
       this.puesto = puesto;
       this.barra = barra;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.mail = mail;
       this.passEmail = passEmail;
       this.sexo = sexo;
       this.nacimiento = nacimiento;
       this.registro = registro;
       this.telefono = telefono;
       this.foto = foto;
       this.tarjeta = tarjeta;
       this.impreso = impreso;
       this.empleadocol = empleadocol;
       this.estado = estado;
       this.pass = pass;
       this.mesases = mesases;
       this.pagoscortes = pagoscortes;
       this.mesaVentas = mesaVentas;
    }
   
     @Id 
    
    @Column(name="idEmpleado", unique=true, nullable=false, length=200)
    public String getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idpuesto", nullable=false)
    public Puesto getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idBarra", nullable=false)
    public Barra getBarra() {
        return this.barra;
    }
    
    public void setBarra(Barra barra) {
        this.barra = barra;
    }
    
    @Column(name="Nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="apellidos", length=100)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    @Column(name="mail", length=100)
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    @Column(name="passEmail", length=450)
    public String getPassEmail() {
        return this.passEmail;
    }
    
    public void setPassEmail(String passEmail) {
        this.passEmail = passEmail;
    }
    
    @Column(name="sexo", length=45)
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
    @Column(name="nacimiento", length=10)
    public String getNacimiento() {
        return this.nacimiento;
    }
    
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
   
    @Column(name="registro", length=19)
    public String getRegistro() {
        return this.registro;
    }
    
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    @Column(name="telefono", length=100)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Column(name="foto", length=400)
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    @Column(name="tarjeta", length=45)
    public String getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    @Column(name="impreso", length=45)
    public String getImpreso() {
        return this.impreso;
    }
    
    public void setImpreso(String impreso) {
        this.impreso = impreso;
    }
    
    @Column(name="Empleadocol", length=45)
    public String getEmpleadocol() {
        return this.empleadocol;
    }
    
    public void setEmpleadocol(String empleadocol) {
        this.empleadocol = empleadocol;
    }
    
    @Column(name="estado", length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name="pass", length=450)
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<Mesas> getMesases() {
        return this.mesases;
    }
    
    public void setMesases(Set<Mesas> mesases) {
        this.mesases = mesases;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<Pagoscorte> getPagoscortes() {
        return this.pagoscortes;
    }
    
    public void setPagoscortes(Set<Pagoscorte> pagoscortes) {
        this.pagoscortes = pagoscortes;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<MesaVenta> getMesaVentas() {
        return this.mesaVentas;
    }
    
    public void setMesaVentas(Set<MesaVenta> mesaVentas) {
        this.mesaVentas = mesaVentas;
    }




}


