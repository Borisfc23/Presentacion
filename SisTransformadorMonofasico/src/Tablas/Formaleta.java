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
public class Formaleta {
    private double x,y,potenciaMax,area;

    public Formaleta() {
    }

    public Formaleta(double x, double y, double potenciaMax, double area) {
        this.x = x;
        this.y = y;
        this.potenciaMax = potenciaMax;
        this.area = area;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPotenciaMax() {
        return potenciaMax;
    }

    public void setPotenciaMax(double potenciaMax) {
        this.potenciaMax = potenciaMax;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }      
    
}
