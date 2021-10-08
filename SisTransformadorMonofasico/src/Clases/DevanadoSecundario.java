/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Boris
 */
public class DevanadoSecundario extends Devanado{    
    private double intensidad1; 

    public DevanadoSecundario() {
    }   
    
    public DevanadoSecundario( double intensidad1, int voltaje) {
        super(voltaje);        
        this.intensidad1 = intensidad1;
    }

    public double getIntensidad1() {
        return intensidad1;
    }

    public void setIntensidad1(double intensidad1) {
        this.intensidad1 = intensidad1;
    }
    
    public double CalculoPotenciaAparente(){
        double p;
        p=voltaje*intensidad1;
        return p;
    }
        
    public double NumeroEspirasSecundario1(double sn,int voltajes1){
        double nespiraS=0;
        switch(voltaje){
            case 1:
                nespiraS=voltajes1*10000/(60*sn*4.44);break;
            case 2:
                nespiraS=voltajes1*10000/(50*sn*4.44);break;                
            case 3:
                nespiraS=voltajes1*10000/(50*sn*4.44);break;                
            case 4:
                nespiraS=voltajes1*10000/(50*sn*4.44);break;                
        }
        return nespiraS;
    }    
    
    public double NumeroEspirasSecundario2(double nEspirasS1,int voltajeS1,int voltajeSN){
        double nEspiras=0;
        nEspiras=(voltajeSN*nEspirasS1)/voltajeS1;
        return nEspiras;
    }
}
