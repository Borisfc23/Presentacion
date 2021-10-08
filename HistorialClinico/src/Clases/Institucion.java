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

public class Institucion {        
    public static ArrayList<Medico> alM = new ArrayList<>();
    public static ArrayList<Recepcionista> alR = new ArrayList<>();    
    public static ArrayList<Paciente> alP = new ArrayList<>();
    public static ArrayList<Atencion> alA = new ArrayList<>();
    public static ArrayList<HistoriaClinica> alHC = new ArrayList<>();   
    public static Recepcionista recepcionista = new Recepcionista();
    public static HistoriaClinica hc = new HistoriaClinica();
    public static Medico medico = new Medico();    
    /*METODO PARA MEDICO*/
    public Medico BuscarMedico(long dni) {
        for (int i = 0; i < alM.size(); i++) {
            if (alM.get(i).getDni() == dni) {
                return alM.get(i);
            }
        }
        return null;
    }

    public void AgregarMedico(Medico e) {
        alM.add(e);
    }

    public Medico ObtenerMedico(int pos) {
        return alM.get(pos);
    }      
    
    public void EliminarMedico(long dni) {
        for (int i = 0; i < alM.size(); i++) {
            if (alM.get(i).getDni() == dni) {
                alM.remove(i);
                break;
            }
        }
    }
    
    public int TamañoMedico() {
        return alM.size();
    }
    public void CargarMedico() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Doctores.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "/");
                String id = st.nextToken().trim();
                String contra = st.nextToken().trim();
                String nombre = st.nextToken().trim();
                String apellido = st.nextToken().trim();
                String correo = st.nextToken().trim();
                String cargo = st.nextToken().trim();
                long dni = Long.parseLong(st.nextToken().trim());
                long codMedico = Long.parseLong(st.nextToken().trim());
                Medico m = new Medico(id, contra, nombre, apellido, correo, cargo, dni, codMedico);
                AgregarMedico(m);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void GrabarMedico() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Doctores.txt"));
            String linea;
            for (int i = 0; i < alM.size(); i++) {
                linea = ObtenerMedico(i).getId() + "/" + ObtenerMedico(i).getContra() + "/"
                        + ObtenerMedico(i).getNombre() + "/" + ObtenerMedico(i).getApellido() + "/"
                        + ObtenerMedico(i).getCorreo() + "/" + ObtenerMedico(i).getCargo() + "/"
                        + ObtenerMedico(i).getDni() + "/" + ObtenerMedico(i).getCodigoMedico();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
        
    /*METODO PARA RECEPCIONISTA*/        
     public Recepcionista BuscarRecepcionista(long dni){
        for (int i = 0; i < alR.size(); i++) {
            if(alR.get(i).getDni() == dni){
                return alR.get(i);
            }
        }
        return null;
    }
     
    public Recepcionista ObtenerRecepcionista(int pos){
        return alR.get(pos);
    }
    public void AgregarRecepcionista(Recepcionista d){
        alR.add(d);
    } 
    
    public void EliminarRecepcionista(long dni){
        for (int i = 0; i < alR.size(); i++) {
            if(alR.get(i).getDni() == dni){
                alR.remove(i);
                break;
            }
        }
    }
    
    public int TamañoRecepcionista(){
        return alR.size();
    }
       public void CargarRecepcionista(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Recepcionista.txt"));
            String linea;
            while ((linea = br.readLine())!= null) {                
                StringTokenizer st = new  StringTokenizer(linea,"/");
                String id = st.nextToken().trim();
                String contra = st.nextToken().trim();
                String nombre = st.nextToken().trim();
                String apellido = st.nextToken().trim();
                String correo = st.nextToken().trim();
                String cargo = st.nextToken().trim();
                long dni = Long.parseLong(st.nextToken().trim());
                String turno  = st.nextToken().trim();
                Recepcionista rec = new Recepcionista(id, contra, nombre, apellido, correo, cargo, dni,turno);
                AgregarRecepcionista(rec);
            }
            br.close();
        } catch (Exception e) {
        }
    }    
    public void GrabarRecepcionista(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Recepcionista.txt"));
            String linea;
            for (int i = 0; i < TamañoRecepcionista(); i++) {
                linea = ObtenerRecepcionista(i).getId() + "/" + ObtenerRecepcionista(i).getContra()+ "/" + 
                        ObtenerRecepcionista(i).getNombre() + "/" + ObtenerRecepcionista(i).getApellido() + "/" + 
                        ObtenerRecepcionista(i).getCorreo() + "/" + ObtenerRecepcionista(i).getCargo() + "/" + 
                        ObtenerRecepcionista(i).getDni() +"/" + ObtenerRecepcionista(i).getTurno();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }    
    /*METODO PARA ATENCION*/
    public int TamañoAtencion() {
        return alA.size();
    }
    public Atencion ObtenerAtencion(int pos) {
        return alA.get(pos);
    }    
    public void CargarAtencion() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Atencion.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "/");
                int dniPaciente = Integer.parseInt(st.nextToken().trim());                
                String paciente = st.nextToken().trim();
                String fecha = st.nextToken().trim();
                String doctor = st.nextToken().trim();                                
                Atencion d = new Atencion(dniPaciente,paciente,fecha, doctor);
                recepcionista.AgregarAtencion(d);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    public void GrabarAtencion() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Atencion.txt"));
            String linea;
            for (int i = 0; i < alA.size(); i++) {
                linea = ObtenerAtencion(i).getDniPaciente()+ "/" + ObtenerAtencion(i).getPaciente()+ "/"                        
                        + ObtenerAtencion(i).getFecha()+ "/" + ObtenerAtencion(i).getDoctor();                        
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
    
    /*METODO DE PACIENTE*/
    public int TamañoPaciente() {
        return alP.size();
    }
    public Paciente ObtenerPaciente(int pos) {
        return alP.get(pos);
    }  
    public void CargarPaciente() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Paciente.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "/");
                String codHistoria = st.nextToken().trim();
                String nombre = st.nextToken().trim();
                String apellidoP = st.nextToken().trim();
                String apellidoM = st.nextToken().trim();                
                String direccion = st.nextToken().trim();                
                String sexo = st.nextToken().trim();
                String ocupacion = st.nextToken().trim();
                String nacionalidad = st.nextToken().trim();
                String estadoC = st.nextToken().trim();                
                int edad = Integer.parseInt(st.nextToken().trim());
                int dni = Integer.parseInt(st.nextToken().trim());                
                Paciente d = new Paciente(codHistoria, nombre, apellidoP, apellidoM, direccion, sexo, ocupacion, nacionalidad, estadoC, edad, dni);
                recepcionista.AgregarPaciente(d);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void GrabarPaciente() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Paciente.txt"));
            String linea;
            for (int i = 0; i < alP.size(); i++) {
                linea = ObtenerPaciente(i).getHistoria()+ "/" + ObtenerPaciente(i).getNombre()+ "/"
                        + ObtenerPaciente(i).getApellidoP()+ "/" + ObtenerPaciente(i).getApellidoM()+ "/"
                        + ObtenerPaciente(i).getDireccion()+ "/" + ObtenerPaciente(i).getSexo()+ "/"
                        + ObtenerPaciente(i).getOcupacion()+ "/" + ObtenerPaciente(i).getNacionalidad()+ "/"
                        + ObtenerPaciente(i).getEstadoC()+ "/"
                        + ObtenerPaciente(i).getEdad()+ "/" + ObtenerPaciente(i).getDni();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
        
    /*GRABAR HC*/
    public HistoriaClinica obtenerHistoriaClinica(int pos) {
        return alHC.get(pos);
    }        
    
    public int TamañoHistoriaClinica() {
        return alHC.size();
    }
    public void CargarHistoriaClinica() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("HistoriaClinica.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {          
                StringTokenizer st = new StringTokenizer(linea, "/");                  
                String codhistoria = st.nextToken().trim();
                String antecedentes = st.nextToken().trim();
                String patologias = st.nextToken().trim();
                String tipoSangre = st.nextToken().trim();
                String alergias = st.nextToken().trim(); 
                HistoriaClinica da = new HistoriaClinica(codhistoria, antecedentes, patologias, tipoSangre, alergias);
                recepcionista.AgregarHC(da);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    public void GrabarHC() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("HistoriaClinica.txt"));
            String linea;
            for (int i = 0; i < TamañoHistoriaClinica(); i++) {
                linea = obtenerHistoriaClinica(i).getCodHistorial()+ "/" + obtenerHistoriaClinica(i).getAntecedentes()+ "/"
                        + obtenerHistoriaClinica(i).getPatologias()+ "/" + obtenerHistoriaClinica(i).getTipoSangre() + "/"+obtenerHistoriaClinica(i).getAlergias();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
}
