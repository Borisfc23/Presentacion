/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

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
public class ArrayChapa {
    ArrayFormaleta xx=new ArrayFormaleta();
    public static ArrayList<Chapa>v;
    
    public ArrayChapa(){
       v=new ArrayList<Chapa>();
    }
    
    public void Adicionar(Chapa c){
        v.add(c);
    }
    public int Tamaño(){
        return v.size();
    }
    
    public void Eliminar(int peso){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getPeso()==peso){
                v.remove(i);
                break;
            }
        }
    }
    
    public Chapa Obtener(int pos){
        return v.get(pos);
    }
    
    public Chapa Buscar(int peso){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getPeso()==peso){
                return v.get(i);
            }
        }
        return null;
    }
    
    public void CargarTabla(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("Chapas.txt"));
            String linea;
            while ((linea=br.readLine())!=null) {                
                StringTokenizer st=new StringTokenizer(linea,"/");
                double a=Double.parseDouble(st.nextToken().trim());
                double b=Double.parseDouble(st.nextToken().trim());
                double c=Double.parseDouble(st.nextToken().trim());
                double d=Double.parseDouble(st.nextToken().trim());
                String e=st.nextToken().trim();
                double peso=Double.parseDouble(st.nextToken().trim());
                Chapa ch=new Chapa(a, b, c, d, e, peso);
                Adicionar(ch);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void GrabarChapas(){
        try {
            PrintWriter pw=new PrintWriter(new FileWriter("Chapas.txt"));
            String linea;
            for(int i=0;i<v.size();i++){
                linea=v.get(i).getA()+"/"+v.get(i).getB()+"/"+v.get(i).getC()+"/"+
                        v.get(i).getD()+"/"+v.get(i).getE()+"/"+v.get(i).getPeso();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }    
    //////////////////////////////////////////////////////////////////  
    public double MedidaX(double sn){
        for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return xx.Obtener(i+1).getX();
          }
      }
      return 0;
    }
    
    public double MedidaY(double sn){
        for(int i=0;i<xx.Tamaño();i++){
          if(sn>=xx.Obtener(i).getArea() && sn<xx.Obtener(i+1).getArea()){
              return xx.Obtener(i+1).getY();
          }
      }
      return 0;
    }
    
    public double MedidaA(double x){
        for(int i=0;i<Tamaño();i++){
          if((x*10)>=Obtener(i).getC() && (10*x)<=Obtener(i+1).getC()){
              return Obtener(i+1).getA();
          }
      }
      return 0;
    }
    public double MedidaB(double x){
        for(int i=0;i<Tamaño();i++){
          if((x*10)>=Obtener(i).getC() && (10*x)<=Obtener(i+1).getC()){
              return Obtener(i+1).getB();
          }
      }
      return 0;
    }
    
    public double MedidaC(double x){
        for(int i=0;i<Tamaño();i++){
          if((x*10)>=Obtener(i).getC() && (10*x)<=Obtener(i+1).getC()){
              return Obtener(i+1).getC();
          }
      }
      return 0;
    }
   
    public double MedidaD(double x){
        for(int i=0;i<Tamaño();i++){
          if((x*10)>=Obtener(i).getC() && (10*x)<=Obtener(i+1).getC()){
              return Obtener(i+1).getD();
          }
      }
      return 0;
    }
    //////////////////////////////////////////////////////////////////
}
