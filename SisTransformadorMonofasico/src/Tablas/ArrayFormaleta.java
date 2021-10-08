/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.util.ArrayList;
import Tablas.Formaleta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 *
 * @author Boris
 */
public class ArrayFormaleta {    
    public static ArrayList<Formaleta>v;
    
    public ArrayFormaleta(){
       v=new ArrayList<Formaleta>();
    }
    public int Tamaño(){
        return v.size();
    }
    
    public Formaleta Obtener(int pos){
        return v.get(pos);
    }
    
    public Formaleta Buscar(double potenciaMax){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getPotenciaMax()==potenciaMax){
                return v.get(i);
            }
        }
        return null;
    }
    
    public void Agregar(Formaleta f){
        v.add(f);
    }
    
    public void Eliminar(double potenciaMax){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getPotenciaMax()==potenciaMax){
                v.remove(i);
                break;
            }
        }
    }
    
    public void CargarTabla(){        
        try {
            BufferedReader br=new BufferedReader(new FileReader("Formaleta.txt"));
            String linea;
            while((linea=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(linea,"/");                
                double x=Double.parseDouble(st.nextToken().trim());
                double y=Double.parseDouble(st.nextToken().trim());                
                double potenciaMax=Double.parseDouble(st.nextToken().trim());
                double area=Double.parseDouble(st.nextToken().trim());
                Formaleta forma=new Formaleta(x, y,potenciaMax, area) ;
                Agregar(forma);                
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void GrabarFormaleta(){
        try {
            PrintWriter pw=new PrintWriter(new FileWriter("Formaleta.txt"));
            String linea;
            for(int i=0;i<v.size();i++){
                linea=v.get(i).getX()+"/"+v.get(i).getY()+"/"+v.get(i).getPotenciaMax()+"/"+
                        v.get(i).getArea();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }        
  ///////////////////////////////////////////////////////////
  /*public double MedidaArea(double sn){
      for(int i=0;i<v.size();i++){
          if(sn>=v.get(i).getArea() && sn<v.get(i+1).getArea()){
              return v.get(i+1).getArea();
          }
      }
      return 0;
  }*/
  //////////////////////////////////////////////////  
}
