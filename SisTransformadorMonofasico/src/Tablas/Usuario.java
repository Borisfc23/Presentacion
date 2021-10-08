/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

/**
 *
 * @author Boris
 */
public class Usuario {
    private String id,contra,correo,nombre,apellido;//no private

    public Usuario() {
    }

    public Usuario(String id, String contra, String nombre, String apellido, String correo) {
        this.id = id;
        this.contra = contra;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
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
    
}
