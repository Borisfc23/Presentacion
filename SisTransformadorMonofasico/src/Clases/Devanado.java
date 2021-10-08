/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Tablas.ArrayTablaCalibre;

/**
 *
 * @author Boris
 */
public class Devanado {
    ArrayTablaCalibre atc =new ArrayTablaCalibre();  
    protected int voltaje;

    public Devanado() {
    }

    public Devanado(int voltaje) {
        this.voltaje = voltaje;
    }

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }
    
    public double NumeroEspirasPrimario(double sn){
        double nespiraP=0;
        switch(voltaje){
            case 1:
                nespiraP=(10000*110)/(60*sn*4.44);break;            
            case 2:
                nespiraP=(220*10000)/(50*sn*4.44);break;
            case 3:
                nespiraP=(230*10000)/(50*sn*4.44);break;
            case 4:
                nespiraP=(240*10000)/(50*sn*4.44);break;                
                                                             
        }
        return nespiraP;
    }    
    public double IntensidadPrimario(double p){
        double ip=0;
        switch(voltaje){
            case 1:
                ip=p/110;break;
            case 2:
                ip=p/220;break;
            case 3:
                ip=p/230;break;
            case 4:
                ip=p/240;break;                
        }
        return ip;
    }
    
    public double Densidad(double p){
        double d=0;
        if(p<50){
            d=4;
        }
        else if(p>=50 && p<=100){
            d=3.5;
        }
        else if(p>=101 && p<=200){
            d=3;
        }
        else if(p>=201 && p<=500){
            d=2.5;
        }
        else if(p>=501 && p<=1000){
            d=2;
        }
        else if(p>=1001 && p<=1500){
            d=1.5;
        }
        return d;
    }     
    
    public int Frecuencia(int frecuencia){
        int f=0;
        switch(frecuencia){
            case 1:
                f=60;break;
            case 2:
                f=50;break;
            case 3:
                f=50;break;
            case 4:
                f=50;break;                
        }
        return f;
    }    
    
    public int CalcularCalibre(double amperaje){
      for(int i=0;i<atc.Tamaño();i++){
          if(amperaje<=atc.obtener(i).getAmperaje() && amperaje>atc.obtener(i+1).getAmperaje() ){
              return atc.obtener(i).getNumero();
          }  
          if(amperaje==0){
              return 0;
          }
      }
      return 0;
    }
    
    public double LongitudCable(double perimetro,double NumEspiras){
        double longitud=0;
        longitud=(perimetro*NumEspiras)/100;
        return longitud;
    }   
}
