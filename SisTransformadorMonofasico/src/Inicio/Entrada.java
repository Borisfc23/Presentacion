/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;
import Clases.DevanadoPrimario;
import Clases.DevanadoSecundario;
import PlaceHolder.Fecha;
import Clases.Nucleo;
import static Inicio.Salida.txtArea;

import PlaceHolder.TextPrompt;
import Tablas.ArrayChapa;
import Tablas.ArrayFormaleta;
import Tablas.TabCalibre;
import Tablas.ArrayTablaCalibre;
import Tablas.Chapa;
import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.UUID;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Boris
 */
public class Entrada extends javax.swing.JFrame {

    /**
     * Creates new form Entrada
     */
    Fecha f=new Fecha();
    DecimalFormat obj=new DecimalFormat("###.##"); 
    DecimalFormat obj2=new DecimalFormat("###");
    DevanadoSecundario ds=new DevanadoSecundario();
    DevanadoPrimario dp=new DevanadoPrimario();
    Nucleo n=new Nucleo();
    Salida s=new Salida();    
    ArrayTablaCalibre atc;        
    ArrayFormaleta af=new ArrayFormaleta();
    String barra=File.separator;        
    public Entrada() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/bobina.png")).getImage());
        this.setLocationRelativeTo(null);
        this.PlaceHolder();        
        atc=new ArrayTablaCalibre();          
        this.CodigoAleatorio();
        atc.CargarTabla();                    
        af.CargarTabla();
                        
    }
    public void PlaceHolder(){
        TextPrompt phNombre=new TextPrompt("Ingrese Nombre y Apellido",txtnombre);        
        TextPrompt phVoltajeS1=new TextPrompt("Voltaje(V)",txtVoltajeS1);
        TextPrompt phAmperajeS1=new TextPrompt("Amperaje(A)",txtAmperio1);                  
        TextPrompt phVoltajeS2=new TextPrompt("Voltaje(V)",txtvoltajeS2);
        TextPrompt phAmperajeS2=new TextPrompt("Amperaje(A)",txtAmperaje2);
        TextPrompt phVoltajeS3=new TextPrompt("Voltaje(V)",txtvoltajeS3);
        TextPrompt phAmperajeS3=new TextPrompt("Amperaje(A)",txtAmperaje3);
        TextPrompt phVoltajeS4=new TextPrompt("Voltaje(V)",txtvoltajeS4);
        TextPrompt phAmperajeS4=new TextPrompt("Amperaje(A)",txtAmperaje4);
    }
    
    public void Limpiar(){
        txtnombre.setText("");
        txtVoltajeS1.setText("");
        txtvoltajeS2.setText("");
        txtvoltajeS3.setText("");
        txtvoltajeS4.setText("");
        txtAmperio1.setText("");
        txtAmperaje2.setText("");
        txtAmperaje3.setText("");
        txtAmperaje4.setText("");        
        cmbEspesor.setSelectedIndex(0);
        cmbVoltajeP.setSelectedIndex(0);                
    }
    
    public String FormaNucleo(){
        String forma="";
        if(rbtnAcorazado.isSelected()){
            forma="Acorazado";
        }
        else if(rbtnSinAcorazado.isSelected()){
            forma="Sin Acorazado";
        }
        return forma;
    }
    public void Calcular(){
        Object calibreP,calibreS1=null,calibreS2=null,calibreS3=null,calibreS4=null;//PRIMARIO Y SECUNDARIO CALIBRES
        String nombre,codigo;//DATOS CLIENTE
        String forma;//NUCLEO
        int voltajes1,espesor,voltajeS2,voltajeS3,voltajeS4,frecuencia;
        double potenciaAparente,amperajeS1,amperajeS2,amperajeS3,amperajeS4;
        double seccionNucleo,seccionNucleoNuevo,cantidaChapas,potenciaMax,perdidaHierro,perimetro;//NUCLEO
        double numeroEspiras,IntensidadPrimaria,densidad,seccionPrimaria,longP;//PRIMARIO        
        double numeroEspirasSec1,seccionSecundario1,numeroEspirasSec2,numeroEspirasSec3,numeroEspirasSec4,longS1,longS2,longS3,longS4;//SECUNDARIO
        forma=FormaNucleo();
        String medidas,espesorMedida;
        nombre=txtnombre.getText();
        codigo=txtCodigo.getText();        
        amperajeS1=Double.parseDouble(txtAmperio1.getText());        
        amperajeS2=Double.parseDouble(txtAmperaje2.getText());
        amperajeS3=Double.parseDouble(txtAmperaje3.getText());
        amperajeS4=Double.parseDouble(txtAmperaje4.getText());        
        espesor=cmbEspesor.getSelectedIndex();
        frecuencia=dp.Frecuencia(cmbVoltajeP.getSelectedIndex());
        voltajes1=Integer.parseInt(txtVoltajeS1.getText());
        voltajeS2=Integer.parseInt(txtvoltajeS2.getText());
        voltajeS3=Integer.parseInt(txtvoltajeS3.getText());
        voltajeS4=Integer.parseInt(txtvoltajeS4.getText());
        espesorMedida=cmbEspesor.getSelectedItem().toString();        
        ds.setIntensidad1(amperajeS1);  
        ds.setVoltaje(voltajes1);
        n.setEspesor(espesor);
        
        // SECCION DEL NUCLEO        
        potenciaAparente=ds.CalculoPotenciaAparente();        
        seccionNucleo=n.CalculoSeccionNucleo(potenciaAparente);
        seccionNucleoNuevo=n.CalculoNuevoSeccionNucleo(seccionNucleo);//NUEVA SECCION
        perimetro=n.Perimetro(seccionNucleo);
        potenciaMax=n.PotenciaMax(seccionNucleo);
        medidas=n.MedidaChapa(seccionNucleo);
        cantidaChapas=n.CantChapas(seccionNucleo,espesor);        
        perdidaHierro=n.PerdidaHierro(espesor, frecuencia);
                
        //DEVANADO PRIMARIO
        dp.setVoltaje(cmbVoltajeP.getSelectedIndex());
        numeroEspiras=dp.NumeroEspirasPrimario(seccionNucleoNuevo);//NUEVO
        longP=dp.LongitudCable(perimetro, numeroEspiras);
        IntensidadPrimaria=dp.IntensidadPrimario(potenciaAparente);
        densidad=dp.Densidad(potenciaAparente);             
        calibreP=dp.CalcularCalibre(IntensidadPrimaria); //*********     
        
        //DEVANO SECUNDARIO  
        ds.setVoltaje(cmbVoltajeP.getSelectedIndex());
        //DEVANO #1 SECUNDARIO
            numeroEspirasSec1=ds.NumeroEspirasSecundario1(seccionNucleoNuevo, voltajes1);//NUEVO
            longS1=dp.LongitudCable(perimetro, numeroEspirasSec1);
            //seccionSecundario1=ds.SeccionSecundario1(densidad);        
            calibreS1=dp.CalcularCalibre(amperajeS1); //*********                          
        //DEVANO #2 SECUNDARIO        
            numeroEspirasSec2=ds.NumeroEspirasSecundario2(numeroEspirasSec1, voltajes1, voltajeS2);
            longS2=dp.LongitudCable(perimetro, numeroEspirasSec2);
            calibreS2=dp.CalcularCalibre(amperajeS2);        
        //DEVANO #3 SECUNDARIO        
            numeroEspirasSec3=ds.NumeroEspirasSecundario2(numeroEspirasSec1, voltajes1, voltajeS3);
            longS3=dp.LongitudCable(perimetro, numeroEspirasSec3);
            calibreS3=dp.CalcularCalibre(amperajeS3);        
        //DEVANO #4 SECUNDARIO        
            numeroEspirasSec4=ds.NumeroEspirasSecundario2(numeroEspirasSec1, voltajes1, voltajeS4);               
            calibreS4=dp.CalcularCalibre(amperajeS4);        
            longS4=dp.LongitudCable(perimetro, numeroEspirasSec4);
                                              
         //PASAR DATOS A SALIDA
         Salida.capturarSeccionNucleo=seccionNucleo;
         
        txtarea2.append("----------DATOS DEL CLIENTE-----------"+"\n"+
                        "Codigo: "+codigo+"\n"+
                        "Nombre: "+nombre+"\n"+
                        "Fecha y Hora: "+f.Fecha()+" - "+f.Hora()+"\n"+"\n"+
                        "-------------------NUCLEO---------------------"+"\n"+
                        "Potencia Aparente: "+potenciaAparente+" watts(w)"+"\n"+
                        "Potencia Maxima: "+obj.format(potenciaMax)+" watts(w)"+"\n"+
                        "Densidad Maxima: "+obj.format(densidad)+" A/mm2"+"\n"+
                        "Perdida Hierro: "+obj.format(perdidaHierro)+" w/Kg"+"\n"+
                        "Seccion Area: "+obj.format(seccionNucleo)+" cm2"+"\n"+
                        "Medida Formatela: "+medidas+"\n"+
                        "Forma: "+forma+"\n"+
                        "Cantidad Chapas: "+obj2.format(cantidaChapas)+"   de"+espesorMedida+"\n"+"\n"+                                                                                            
                                                                                                
                        "------------DEVANO PRIMARIO--------------"+"\n"+
                        "N° Espiras: "+obj2.format(numeroEspiras)+" en "+obj2.format(longP)+"mts"+"\n"+
                        "Intensidad: "+obj.format(IntensidadPrimaria)+" A"+"\n"+                                                
                        "N° Calibre: "+calibreP+"\n"+"\n"+                                                                                         
                                                      
                        "----------DEVANO SECUNDARIO----------"+"\n"+
                        "N° Espiras(1): "+obj2.format(numeroEspirasSec1)+" en "+obj2.format(longS1)+"mts"+"\n"+
                        "N° Calibre(1): "+calibreS1+" de "+amperajeS1+"A"+"\n"+"\n"+
                        
                        "N° Espiras(2): "+obj2.format(numeroEspirasSec2)+" en "+obj2.format(longS2)+"mts"+"\n"+
                        "N° Calibre(2): "+calibreS2+" de "+amperajeS2+"A"+"\n"+"\n"+
                                
                        "N° Espiras(3): "+obj2.format(numeroEspirasSec3)+" en "+obj2.format(longS3)+"mts"+"\n"+
                        "N° Calibre(3): "+calibreS3+" de "+amperajeS3+"A"+"\n"+"\n"+
                                
                        "N° Espiras(4): "+obj2.format(numeroEspirasSec4)+" en "+obj2.format(longS4)+"mts"+"\n"+
                        "N° Calibre(4): "+calibreS4+" de "+amperajeS4+"A"+"\n"+
                        ".------------------------------------------------"+"\n"
                        //"Asistente: "+Login.txtid.getText().toUpperCase()
        );
    }
 
    public void CodigoAleatorio(){
        txtCodigo.setText(UUID.randomUUID().toString().toUpperCase().substring(0,10));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Nucleo = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVoltajeS1 = new javax.swing.JTextField();
        txtAmperio1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbVoltajeP = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbEspesor = new javax.swing.JComboBox<>();
        txtvoltajeS2 = new javax.swing.JTextField();
        txtAmperaje2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarea2 = new javax.swing.JTextArea();
        txtvoltajeS3 = new javax.swing.JTextField();
        txtAmperaje3 = new javax.swing.JTextField();
        txtvoltajeS4 = new javax.swing.JTextField();
        txtAmperaje4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbtnAcorazado = new javax.swing.JRadioButton();
        rbtnSinAcorazado = new javax.swing.JRadioButton();
        btnCondicion = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Power Electronic");
        setPreferredSize(new java.awt.Dimension(447, 559));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Datos del Cliente");

        txtCodigo.setEnabled(false);

        btnCalcular.setBackground(new java.awt.Color(153, 153, 153));
        btnCalcular.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calcular.png"))); // NOI18N
        btnCalcular.setText(" Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Clean.png"))); // NOI18N
        btnLimpiar.setText(" Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Datos del Transformador");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Devanado Primario");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Devanado Secundario");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Chapas del Nucleo");

        cmbVoltajeP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    Opciones", "  110 v   60Hz", "  220 v   50Hz", "  230 v   50Hz", "  240 v   50Hz" }));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSFORMADOR MONOFASICO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmbEspesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "      Espesor", "      0.35 mm", "      0.5 mm", "       1 mm", "     1.5 mm" }));

        jScrollPane3.setEnabled(false);

        txtarea2.setColumns(20);
        txtarea2.setRows(5);
        jScrollPane3.setViewportView(txtarea2);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Foma del Nucleo");

        Nucleo.add(rbtnAcorazado);
        rbtnAcorazado.setText("Acorazado");

        Nucleo.add(rbtnSinAcorazado);
        rbtnSinAcorazado.setText("Sin Acorazado");

        btnCondicion.setBackground(new java.awt.Color(153, 153, 153));
        btnCondicion.setForeground(new java.awt.Color(255, 255, 255));
        btnCondicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/stop.png"))); // NOI18N
        btnCondicion.setText("Stop");
        btnCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCondicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cmbVoltajeP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rbtnSinAcorazado)
                                                    .addComponent(rbtnAcorazado)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btnCalcular))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cmbEspesor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3))
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnCondicion)
                        .addGap(97, 97, 97))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtvoltajeS2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtVoltajeS1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAmperio1)
                                            .addComponent(txtAmperaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtvoltajeS4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtvoltajeS3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAmperaje3)
                                            .addComponent(txtAmperaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(btnLimpiar)
                                    .addGap(29, 29, 29)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtnombre))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbVoltajeP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEspesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(rbtnAcorazado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnSinAcorazado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAmperio1)
                            .addComponent(txtVoltajeS1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtvoltajeS2)
                            .addComponent(txtAmperaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvoltajeS3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmperaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtvoltajeS4)
                            .addComponent(txtAmperaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(btnCondicion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCalcular))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        this.Calcular();        
        txtArea.setText(txtarea2.getText());        
        s.setVisible(true);          
        this.setVisible(false);
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCondicionActionPerformed
        if(txtvoltajeS2.getText().equals("") && txtAmperaje2.getText().equals("")){
            txtvoltajeS2.setText("0");
            txtAmperaje2.setText("0");
        }
        if(txtvoltajeS3.getText().equals("") && txtAmperaje3.getText().equals("")){
            txtvoltajeS3.setText("0");
            txtAmperaje3.setText("0");
        }
        if(txtvoltajeS4.getText().equals("") && txtAmperaje4.getText().equals("")){
            txtvoltajeS4.setText("0");
            txtAmperaje4.setText("0");
        }
    }//GEN-LAST:event_btnCondicionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Nucleo;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCondicion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbEspesor;
    private javax.swing.JComboBox<String> cmbVoltajeP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JRadioButton rbtnAcorazado;
    private javax.swing.JRadioButton rbtnSinAcorazado;
    private javax.swing.JTextField txtAmperaje2;
    private javax.swing.JTextField txtAmperaje3;
    private javax.swing.JTextField txtAmperaje4;
    private javax.swing.JTextField txtAmperio1;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtVoltajeS1;
    public static javax.swing.JTextArea txtarea2;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtvoltajeS2;
    private javax.swing.JTextField txtvoltajeS3;
    private javax.swing.JTextField txtvoltajeS4;
    // End of variables declaration//GEN-END:variables
}
