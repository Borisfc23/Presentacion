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
public class registroHistoria {
    Institucion it = new Institucion();    
    private String historiaPaciente,fecha;
    private String diagnostico,receta;
    private int frecCard;
    private double tensionArterial,temperatura,peso,talla,imc;

    public registroHistoria() {
    }

    public registroHistoria(String historiaPaciente,String fecha, String diagnostico, String receta, int frecCard, double tensionArterial, double temperatura, double peso, double talla, double imc) {                
        this.historiaPaciente = historiaPaciente;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.frecCard = frecCard;
        this.tensionArterial = tensionArterial;
        this.temperatura = temperatura;
        this.peso = peso;
        this.talla = talla;
        this.imc = imc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    

    public String getHistoriaPaciente() {
        return historiaPaciente;
    }

    public void setHistoriaPaciente(String historiaPaciente) {
        this.historiaPaciente = historiaPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public int getFrecCard() {
        return frecCard;
    }

    public void setFrecCard(int frecCard) {
        this.frecCard = frecCard;
    }

    public double getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(double tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
