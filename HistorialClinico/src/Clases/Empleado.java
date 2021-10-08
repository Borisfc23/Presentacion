/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Boris
 */
public abstract class Empleado implements Login{
    private String id,contra,correo,nombre,apellido,cargo;
    private long dni;
    public Empleado() {
    }

    public Empleado(String id, String contra, String nombre, String apellido, String correo,String cargo,long dni) {
        this.id = id;
        this.contra = contra;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.dni = dni;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }      
    
    @Override
    public abstract Empleado Login(String id, String contra, String cargo);     
}
