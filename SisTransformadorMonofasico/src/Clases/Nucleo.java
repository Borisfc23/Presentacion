/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Tablas.ArrayFormaleta;

/**
 *
 * @author Boris
 */
public class Nucleo {
    ArrayFormaleta xx=new ArrayFormaleta();
    private int espesor;
    private double x[]={1.6, 2.8, 2.5, 2.2, 2.5, 2.8, 2.8, 3.2, 3.2, 2.8, 3.8, 3.2, 3.8, 3.2, 3.8, 3.8, 3.8, 3.8, 3.8, 4.4, 3.8, 4.4, 3.8, 4.4, 4.4};
    private double y[]={1.9, 1.5, 1.8, 2.8, 2.8, 2.5, 3.5, 3.5, 4, 5, 4, 5, 5, 6, 6, 7, 8, 9, 10, 9, 11, 10, 12, 11, 12};

    public Nucleo() {
    }

    public Nucleo(int espesor) {
        
        this.espesor=espesor;
    }   

    public int getEspesor() {
        return espesor;
    }

    public void setEspesor(int espesor) {
        this.espesor = espesor;
    }
    
    public double CalculoSeccionNucleo(double p){
        double sn=0;
        sn=Math.sqrt(p)*Math.sqrt(1.4142);
        return sn;
    }
    
   public double CalculoNuevoSeccionNucleo(double sn){//LISTO
        for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return xx.Obtener(i+1).getArea();
          }
      }
      return 0;
    }
    public String MedidaChapa(double sn){//LISTO
        for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return xx.Obtener(i+1).getX()+" x "+xx.Obtener(i+1).getY()+" cm2";
          }
      }
      return null;
    }
    public double Espesor(){
        double espe=0;
        switch(espesor){
            case 1:
                espe=0.35;break;
            case 2:
                espe=0.5;break;
            case 3:
                espe=1;break;
            case 4:
                espe=1.5;break;          
        }
        return espe;
    }
    public double CantChapas(double sn,int espe){
        double n=0;        
        for(int i=1;i<25;i++){
            if(sn>=x[i-1]*y[i-1]  &&sn<=x[i]*y[i]){
              n=y[i]*10/espe;
            }
        }
        return n;
    }
    public double PotenciaMax(double sn){//LISTO
        for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return (Math.pow(xx.Obtener(i+1).getX()*xx.Obtener(i+1).getY(),2))/1.4142;              
          }
      }
      return 0; 
    }    
    
    public double PerdidaHierro(int espesor,int frecuencia){
        double perdidaFe=0;
        switch(espesor){
            case 1:
                perdidaFe=(2.2*frecuencia*0.35)/1000;break;
            case 2:
                perdidaFe=(2.2*frecuencia*0.35)/1000;break;
            case 3:
                perdidaFe=(2.2*frecuencia*0.35)/1000;break;
            case 4:
                perdidaFe=(2.2*frecuencia*0.35)/1000;break;                
        }
        return perdidaFe;
    }
    
    public double Perimetro(double sn){//LISTO
       for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return xx.Obtener(i+1).getX()*2+xx.Obtener(i+1).getY()*2;
          }
      }
      return 0;
    }
         
    /*
    if(sn<=3.04){
            perimetro=(1.6 *2 + 1.9*2);
        }
        else if(sn>3.04 && sn<=4.20){
            perimetro=(2.8*2 + 1.5*2);                
        }
        else if(sn>4.20 && sn<=4.50){
            perimetro=(2.5*2 + 1.8*2);                
        }
        else if(sn>4.50 && sn<=6.16){
            perimetro=(2.2*2 + 2.8*2);                
        }
        else if(sn>6.16 && sn<=7){
            perimetro=(2.5*2 + 2.8*2);                
        }
        else if(sn>7 && sn<=9.80){
            perimetro=(2.8*2 + 3.5*2);                
        }
        else if(sn>9.80 && sn<=11.20){
            perimetro=(3.2*2 + 3.5*2);                
        }
        else if(sn>11.20 && sn<=12.80){
            perimetro=(3.2*2 + 4*2);                
        }
        else if(sn>12.80 && sn<=14){
            perimetro=(2.8*2 + 5*2);                
        }
        else if(sn>14 && sn<=15.2){
            perimetro=(3.8*2 + 4*2);                
        }
        else if(sn>15.2 && sn<=16){
            perimetro=(3.2*2 + 5*2);                
        }  
        else if(sn>16 && sn<=19){
            perimetro=(3.8*2 + 5*2);                
        }  
        else if(sn>19 && sn<=19.2){
            perimetro=(3.2*2 + 6*2);                
        }  
        else if(sn>19.2 && sn<=22.8){
            perimetro=(3.8*2 + 6*2);                
        }  
        else if(sn>22.8 && sn<=26.6){
            perimetro=(3.8*2 + 7*2);                
        }                    
        else if(sn>26.6 && sn<=30.4){
            perimetro=(3.8*2 + 8*2);                
        } 
        else if(sn>30.4 && sn<=34.20){
            perimetro=(3.8*2 + 9*2);                
        } 
        else if(sn>34.20 && sn<=38){
            perimetro=(3.8*2 + 10*2);                
        } 
        else if(sn>38 && sn<=39.6){
            perimetro=(4.4*2 + 9*2);                
        } 
        else if(sn>39.6 && sn<=41.8){
            perimetro=(3.8*2 + 11*2);                
        } 
        else if(sn>41.8 && sn<=44){
            perimetro=(4.4*2 + 10*2);                
        } 
        else if(sn>44 && sn<=45.6){
            perimetro=(3.8*2 + 12*2);                
        } 
        else if(sn>45.6 && sn<=48.4){
            perimetro=(4.4*2 + 11*2);                
        }             
        else if(sn>48.4 && sn<=52.80){
            perimetro=(4.4*2 + 12*2);                
        }
        return perimetro;*/
}
