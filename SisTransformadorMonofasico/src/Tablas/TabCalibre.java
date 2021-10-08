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
public class TabCalibre {
    private int numero;
    private double amperaje;

    public TabCalibre() {
    }

    public TabCalibre(int numero, double amperaje) {
        this.numero = numero;
        this.amperaje = amperaje;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getAmperaje() {
        return amperaje;
    }

    public void setAmperaje(double amperaje) {
        this.amperaje = amperaje;
    }
    
}
