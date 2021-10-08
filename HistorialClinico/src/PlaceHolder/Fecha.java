/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaceHolder;

import java.util.Calendar;

/**
 *
 * @author Boris
 */
public class Fecha {
    Calendar calendario=Calendar.getInstance();
    int anio=calendario.get(Calendar.YEAR);
    int mes=calendario.get(Calendar.MONTH);
    int dia=calendario.get(Calendar.DAY_OF_MONTH);
    int hora=calendario.get(Calendar.HOUR_OF_DAY);
    int min=calendario.get(Calendar.MINUTE);
    
    public String Fecha(){
        String fecha;
        mes=mes+1;
        fecha=dia+"/"+mes+"/"+anio;
        return fecha;
    }
    public String Hora(){
        String hor;
        if(hora<10 ){
            hor="0"+hora+":"+min;
        }else{
            hor=hora+":"+min;
        }        
        return hor;
    }
}
