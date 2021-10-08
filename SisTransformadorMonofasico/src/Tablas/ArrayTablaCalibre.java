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
public class ArrayTablaCalibre {
    public static ArrayList<TabCalibre>v;
    
    public ArrayTablaCalibre(){
        v=new ArrayList<TabCalibre>();
    }
    
    public void adicionar(TabCalibre t){
        v.add(t);
    }
    public void Eliminar(double amperaje){
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).getAmperaje()==amperaje){
                v.remove(i);
                break;
            }
        }
    }
    
    public int Tamaño(){
        return v.size();
    }
    
    public TabCalibre obtener(int pos){
        return v.get(pos);
    }
    
    public TabCalibre buscar(double amperaje){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getAmperaje()==amperaje){
                return v.get(i);
            }            
        }
        return null;
    }
        
    public void CargarTabla(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("Calibre.txt"));
            String Linea;
            while((Linea=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(Linea,"/");
                int numero=Integer.parseInt(st.nextToken().trim());
                double calibre=Double.parseDouble(st.nextToken().trim());
                TabCalibre t=new TabCalibre(numero,calibre);
                adicionar(t);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void GrabarTabla(){
        try {
            PrintWriter pw=new PrintWriter(new FileWriter("Calibre.txt"));
            String linea;
            for (int i = 0; i < v.size(); i++) {
                linea=v.get(i).getNumero()+"/"+v.get(i).getAmperaje();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }

}
