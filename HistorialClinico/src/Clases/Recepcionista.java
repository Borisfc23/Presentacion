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
public class Recepcionista extends Empleado{
    private String turno;
    Institucion institucion = new Institucion();
    public Recepcionista(){
        
    }
    public Recepcionista(String id, String contra, String nombre, String apellido, String correo,String cargo,long dni,String turno){
        super(id, contra, nombre, apellido, correo,cargo,dni);
        this.turno = turno;
    }      

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    public  void AgregarAtencion(Atencion e) {
        institucion.alA.add(e);
    }
     public void EliminarAtencion(int dni) {
        for (int i = 0; i < institucion.alA.size(); i++) {
            if (institucion.alA.get(i).getDniPaciente() == dni) {
                institucion.alA.remove(i);
                break;
            }
        }
    }
    public void AgregarPaciente(Paciente e) {
        institucion.alP.add(e);
    }
    
    public Paciente BuscarPaciente(int dni) {
        for (int i = 0; i < institucion.alP.size(); i++) {
            if (institucion.alP.get(i).getDni() == dni) {
                return institucion.alP.get(i);
            }
        }
        return null;
    }
    public void EliminarPaciente(int dni) {
        for (int i = 0; i < institucion.alP.size(); i++) {
            if (institucion.alP.get(i).getDni() == dni) {
                institucion.alP.remove(i);
                break;
            }
        }
    }
    
    public void AgregarHC(HistoriaClinica hc){
        institucion.alHC.add(hc);
    }
    
    @Override
    public Empleado Login(String id, String contra, String cargo) {        
        for (int i = 0; i < institucion.alR.size(); i++) {
            if (institucion.alR.get(i).getId().equals(id) && institucion.alR.get(i).getContra().equals(contra)) {
                return institucion.alR.get(i);
            }
        }
        return null;
    }
    
}
