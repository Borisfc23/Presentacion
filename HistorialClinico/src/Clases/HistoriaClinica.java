/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Institucion.medico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import Clases.Paciente;
import java.util.ArrayList;
/**
 *
 * @author Boris
 */
public class HistoriaClinica{        
    private String  codHistorial,antecedentes, patologias,tipoSangre,alergias;    
    public static ArrayList<registroHistoria> alRHC = new ArrayList<>();
    public HistoriaClinica(){
        
    }

    public HistoriaClinica(String codHistorial, String antecedentes, String patologias, String tipoSangre, String alergias) {
        this.codHistorial = codHistorial;
        this.antecedentes = antecedentes;
        this.patologias = patologias;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
    }

    public String getCodHistorial() {
        return codHistorial;
    }

    public void setCodHistorial(String codHistorial) {
        this.codHistorial = codHistorial;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getPatologias() {
        return patologias;
    }

    public void setPatologias(String patologias) {
        this.patologias = patologias;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }        
    public registroHistoria ObtenerRegistroHC(int pos) {
        return alRHC.get(pos);
    }        
    
    public int TamañoRegistroHC() {
        return alRHC.size();
    }
     public void GrabarRegistroHC() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("RegistroHistoria.txt"));
            String linea;
            for (int i = 0; i < TamañoRegistroHC(); i++) {
                linea = ObtenerRegistroHC(i).getHistoriaPaciente()+ "/" + ObtenerRegistroHC(i).getFecha()+ "/"
                        + ObtenerRegistroHC(i).getDiagnostico()+ "/" + ObtenerRegistroHC(i).getReceta()+ "/"+ ObtenerRegistroHC(i).getFrecCard()+ "/"
                        + ObtenerRegistroHC(i).getTensionArterial()+ "/" + ObtenerRegistroHC(i).getTemperatura()+ "/"
                        + ObtenerRegistroHC(i).getPeso()+ "/" + ObtenerRegistroHC(i).getTalla()+ "/"+ ObtenerRegistroHC(i).getImc();                        
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
    public void CargarRegistroHC() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("RegistroHistoria.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "/");                  
                String historiaPaciente = st.nextToken().trim();
                String fecha = st.nextToken().trim();
                String diagnostico = st.nextToken().trim();
                String receta = st.nextToken().trim();
                int frecCard = Integer.parseInt(st.nextToken().trim());
                double tensionArterial = Double.parseDouble(st.nextToken().trim());                
                double temperatura = Double.parseDouble(st.nextToken().trim());                                                                                
                double peso = Double.parseDouble(st.nextToken().trim());
                double talla = Double.parseDouble(st.nextToken().trim());
                double imc = Double.parseDouble(st.nextToken().trim());    
                registroHistoria da = new registroHistoria(historiaPaciente, fecha, diagnostico, receta, frecCard, tensionArterial, temperatura, peso, talla, imc);                
                medico.AgregarRegistroHC(da);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
