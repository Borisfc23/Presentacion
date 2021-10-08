/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Boris
 */
public class Atencion {
    Institucion it = new Institucion();
    private String paciente, fecha, doctor;          
    private int dniPaciente;    
                        
    public Atencion(){
        
    }

    public Atencion(int dniPaciente,String paciente, String fecha, String doctor) {         
        this.dniPaciente = dniPaciente;        
        this.paciente = paciente;
        this.fecha = fecha;
        this.doctor = doctor;        
    }    
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(int dniPaciente) {
        this.dniPaciente = dniPaciente;
    } 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }    
}
