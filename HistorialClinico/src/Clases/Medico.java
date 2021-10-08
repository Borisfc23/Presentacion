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
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Boris
 */
public class Medico extends Empleado{
    Institucion institucion = new Institucion();
    HistoriaClinica hc = new HistoriaClinica();
    private long codigoMedico;

    public Medico() {

    }

    public Medico(String id, String contra, String nombre, String apellido, String correo, String cargo, long dni, long codMedico) {
        super(id, contra, nombre, apellido, correo, cargo, dni);
        this.codigoMedico = codMedico;
    }    
    
    public long getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(long codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
    public Atencion BuscarAtencion(int dni) {
    for (int i = 0; i < institucion.alA.size(); i++) {
        if (institucion.alA.get(i).getDniPaciente()== dni) {
            return institucion.alA.get(i);
        }
    }
        return null;
    }
    
    public void AgregarRegistroHC(registroHistoria e) {
        hc.alRHC.add(e);
    }
    
    public registroHistoria BuscarRegistroHC(String historiaPaciente) {
        for (int i = 0; i < hc.alRHC.size(); i++) {
            if (hc.alRHC.get(i).getHistoriaPaciente().equalsIgnoreCase(historiaPaciente)) {
                return hc.alRHC.get(i);
            }
        }
        return null;
    }   
    
    @Override
    public Empleado Login(String id, String contra, String cargo) {        
        for (int i = 0; i < institucion.alM.size(); i++) {
            if (institucion.alM.get(i).getId().equals(id) && institucion.alM.get(i).getContra().equals(contra)) {
                return institucion.alM.get(i);
            }
        }
        return null;
    }
}
