/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Clases.Atencion;
import Clases.HistoriaClinica;
import Clases.Institucion;
import Clases.Medico;
import Clases.Paciente;
import Clases.Recepcionista;
import Clases.registroHistoria;
import static Inicio.Principal.cmbCargo;
import static Inicio.VPregistro.txtArea;
import PlaceHolder.TextPrompt;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXLabel;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rojerusan.RSPanelsSlider;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author BORISFLORES
 */
public class PrincipalDoctor extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     * 
     */
    boolean v=true;
    boolean nuevo ;
    long codMedico = 0;
    DefaultTableModel modelR;
    DefaultTableModel modelD;    
    DefaultTableModel modelP;    
    DefaultTableModel modelLA;
    DefaultTableModel modelHC;
    Medico medico = new Medico();
    Recepcionista recepcionista = new Recepcionista();    
    Institucion institucion = new Institucion();
    Paciente p = new Paciente();
    Atencion a = new Atencion();
    HistoriaClinica historiaClinica = new HistoriaClinica();     
    registroHistoria dap = new registroHistoria();
    VPregistro vp = new VPregistro();
    private TableRowSorter tr;
    public void Logo(){
        ImageIcon imagenChapa=new ImageIcon("src/Imagenes/logo.png");
        ImageIcon imgFondo = new ImageIcon("src/Imagenes/fondoPrincipal.jpg");
        Icon ico=new ImageIcon(imagenChapa.getImage().getScaledInstance(imglogo.getWidth(),imglogo.getHeight(),Image.SCALE_DEFAULT));
        Icon ico2=new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT));
        imglogo.setIcon(ico);
        lblFondo.setIcon(ico2);
    }
    public void Atenciones(){      
        Icon icono1=new ImageIcon(ClassLoader.getSystemResource("Recursos/listaAtencion.png"));
        final JXLabel label1=new JXLabel("Lista de Citas Medicas", icono1, JXLabel.LEFT);
        label1.addMouseListener(new MouseAdapter() {
                      
            @Override
            public void mouseClicked(MouseEvent e){
               rSPanelsSlider1.setPanelSlider(20, pnlListaAtencion,RSPanelsSlider.DIRECT.RIGHT);
            }
});         
        eventosmouse(label1);                
        jXTaskPane2.add(label1);        
    }
 
        public void HistoriaClinica(){
        Icon icono=new ImageIcon(ClassLoader.getSystemResource("Recursos/text-lines.png"));
         JXLabel label=new JXLabel("Agregar Registro", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {
                       
        @Override
            public void mouseClicked(MouseEvent e){               
                rSPanelsSlider1.setPanelSlider(20, pnlHistorialClinico,RSPanelsSlider.DIRECT.RIGHT);
               
            }
});
        
        Icon icono1=new ImageIcon(ClassLoader.getSystemResource("Recursos/text-lines.png"));
        final JXLabel label1=new JXLabel("Listas Historia Clinica", icono1, JXLabel.LEFT);
        label1.addMouseListener(new MouseAdapter() {
                      
            @Override
            public void mouseClicked(MouseEvent e){
                rSPanelsSlider1.setPanelSlider(20, pnlListaHistoriaClinica,RSPanelsSlider.DIRECT.RIGHT);
            }
});
        
        eventosmouse(label);
        eventosmouse(label1);        
        jXTaskPane3.add(label);
        jXTaskPane3.add(label1);        
    }

    //para que se sombree cunado entre
    public void eventosmouse(final JXLabel label){
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){
                //tipo de letra
                Font font=new Font("tahoma", Font.BOLD, 14);
                label.setFont(font);
            }            
            
});
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e){
                //tipo de letra
                Font font=new Font("tahoma", Font.PLAIN, 13);
                label.setFont(font);
            }                        
});                        
        
    }
    public PrincipalDoctor() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/heart.png")).getImage());
        //EmpleadosRM();
        Atenciones();
        HistoriaClinica();
        Logo();
        this.setLocationRelativeTo(null);        
        this.PlaceHolder();
        //codigoAleatorio();        
        institucion.CargarRecepcionista();
        institucion.CargarMedico();
        institucion.CargarPaciente();
        institucion.CargarAtencion();        
        historiaClinica.CargarRegistroHC();
        CargarInterfaz();
        CargarTabla();                                  
    }        
    
     public void PlaceHolder(){       
        /*AGREGAR REGISTRO A HISTORIA*/
        TextPrompt rhc1 = new TextPrompt("N° DNI", txtHCbuscar);
        TextPrompt rhc2 = new TextPrompt("Cod Historia", txtHCcodHistoria);
        TextPrompt rhc3 = new TextPrompt("Nombre", txtHCnombre);
        TextPrompt rhc4 = new TextPrompt("Apellido", txtHCapellido);
        TextPrompt rhc5 = new TextPrompt("N° DNI", txtHCdni);
        TextPrompt rhc6 = new TextPrompt("Sexo", txtHCsexo);
        TextPrompt rhc7 = new TextPrompt("Peso (Kg)", txtHCpeso);
        TextPrompt rhc8 = new TextPrompt("Temp (C°)", txtHCtemperatura);
        TextPrompt rhc9 = new TextPrompt("Altura (mts)", txtHCaltura);
        TextPrompt rhc10 = new TextPrompt("F.C (lat/min)", txtHCfrecuenciaCardiaca);
        TextPrompt rhc11 = new TextPrompt("Ten Art (mm/Hg)", txtHCtensionArterial);
        TextPrompt rhc12 = new TextPrompt("I.M.C", txtHCimc);
        TextPrompt rhc13 = new TextPrompt("Edad", txtHCedad);
        
        TextPrompt LHC1 = new TextPrompt("DNI o HC", txtHCbuscarHistorial);
        TextPrompt LHC3 = new TextPrompt("dd-mm-yy", txtHCfecha);                
    }

     public void CargarInterfaz(){
     
        String camposP[] = {"Cod Historial","Nombre","Apellido Paterno","Apellido Materno","DNI","Sexo","Edad","Direccion"};
        String camposLA[] ={"DNI","Paciente","Fecha Atencion","Doctor"};
        String camposHC[] = {"N°Registro","Fecha"};
        String dataP[][] = {};
        String dataLA[][] = {};
        String dataHC[][] = {};

        modelP = new DefaultTableModel(dataP, camposP);
        modelLA = new DefaultTableModel(dataLA,camposLA);
        modelHC = new DefaultTableModel(dataHC, camposHC);               
        this.jtLApacientes.setModel(modelLA);
        this.jtListaHC.setModel(modelHC);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        /*CENTER HEADER*/
        ((DefaultTableCellRenderer) jtLApacientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtListaHC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        /*DATA LISTA DE ATENCIONES*/
        jtLApacientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtLApacientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtLApacientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtLApacientes.getColumnModel().getColumn(3).setCellRenderer(tcr);              
        /*DATA LISTA DE HISTORIAS CLINICAS*/        
        jtListaHC.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtListaHC.getColumnModel().getColumn(1).setCellRenderer(tcr);          
    }
    public void CargarTabla(){ //Tablas 
        int tamP = institucion.TamañoPaciente();   
        int tamLA = institucion.TamañoAtencion();                               
        if(tamP > 0){
            for (int i = 0; i < tamP; i++) {
                Paciente pc = institucion.ObtenerPaciente(i);                
                Object datosP[] = {pc.getHistoria(),pc.getNombre(),pc.getApellidoP(),pc.getApellidoM(),pc.getDni(),pc.getSexo(),pc.getEdad(),pc.getDireccion()};                
                modelP.addRow(datosP);                     
            }
        }
        if(tamLA > 0){                        
            for (int i = 0; i < tamLA; i++) {    
                Atencion at= institucion.ObtenerAtencion(i);
                Object datosLA[] = {at.getDniPaciente(),at.getPaciente(),at.getFecha(),at.getDoctor()};
                modelLA.addRow(datosLA);
            }
        }         
    }        
    /*HISTORIAL CLINICO*/
    public void LimpiarRegHC(){
        txtHCcodHistoria.setText("");
        txtHCnombre.setText("");
        txtHCapellido.setText("");
        txtHCdni.setText("");
        txtHCedad.setText("");
        txtHCfrecuenciaCardiaca.setText("");
        txtHCtensionArterial.setText("");
        txtHCtemperatura.setText("");
        txtHCpeso.setText("");
        txtHCaltura.setText("");
        txtHCimc.setText("");
        taHCmotivoConsulta.setText("");
        txtHCenfermedad.setText("");
        txtHCantecedenteFamiliar.setText("");
        taHCdiagnostico.setText("");
        taHCreceta.setText("");
        txtHCfecha.setText("");
    }
    public void BuscarHistorialClinico(){
        int dni = Integer.parseInt(txtHCbuscar.getText());        
        Paciente pa=recepcionista.BuscarPaciente(dni);
        if(pa!=null){
            for (int i = 0; i < institucion.TamañoPaciente(); i++) {
            if(institucion.ObtenerPaciente(i).getDni()==dni){
                txtHCcodHistoria.setText(institucion.ObtenerPaciente(i).getHistoria());
                txtHCnombre.setText(institucion.ObtenerPaciente(i).getNombre());
                txtHCapellido.setText(institucion.ObtenerPaciente(i).getApellidoP());
                txtHCdni.setText(String.valueOf(institucion.ObtenerPaciente(i).getDni()));
                txtHCedad.setText(String.valueOf(institucion.ObtenerPaciente(i).getEdad()));
                txtHCsexo.setText(institucion.ObtenerPaciente(i).getSexo());
                break;
            }               
        }
            JOptionPane.showMessageDialog(this,"Paciente Encontrado","Historial Clinico",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Paciente No Registrado ","Historial Clinico",JOptionPane.WARNING_MESSAGE);
        }        
    }
     public void LimpiarRegistroHC(){
        txtHCcodHistoria.setText("");
        txtHCnombre.setText("");
        txtHCapellido.setText("");
        txtHCsexo.setText("");
        txtHCdni.setText("");
        txtHCedad.setText("");
        txtHCfrecuenciaCardiaca.setText("");
        txtHCtensionArterial.setText("");
        txtHCtemperatura.setText("");
        taHCmotivoConsulta.setText("");
        txtHCenfermedad.setText("");
        txtHCantecedenteFamiliar.setText("");
        txtHCpeso.setText("");
        txtHCaltura.setText("");
        txtHCimc.setText("");
        taHCdiagnostico.setText("");
        taHCreceta.setText("");
        txtHCbuscar.setText("");        
    }
    public void AgregarRegistroHC(){
        try {                                                          
            registroHistoria datp = new registroHistoria(txtHCcodHistoria.getText(),txtHCfecha.getText(),taHCdiagnostico.getText(),taHCreceta.getText(),
            Integer.parseInt(txtHCfrecuenciaCardiaca.getText()),Double.parseDouble(txtHCtensionArterial.getText()),Double.parseDouble(txtHCtemperatura.getText()),
            Double.parseDouble(txtHCpeso.getText()),Double.parseDouble(txtHCaltura.getText()),
            Double.parseDouble(txtHCimc.getText()));            
            medico.AgregarRegistroHC(datp);            
            JOptionPane.showMessageDialog(this,"Nuevo Registo de "+txtHCnombre.getText()+" "+txtHCapellido.getText()+" en su Historial Clinico","Historial Clinico",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
        }
            historiaClinica.GrabarRegistroHC();
    }  
    
    public void BuscarHC(){        //txtListaHC txtListaNombre  txtListaApellido 
        int num=1;
        String hc =txtHCbuscarHistorial.getText();                        
        registroHistoria dat= medico.BuscarRegistroHC(hc);   
        String historia ="";
        String paciente="";    
        if(cmbLHCfiltro.getSelectedIndex()==2){
            for (int i = 0; i < institucion.TamañoPaciente(); i++) {
            if(institucion.ObtenerPaciente(i).getHistoria().equalsIgnoreCase(hc)){
                paciente = institucion.ObtenerPaciente(i).getNombre() + " "+ institucion.ObtenerPaciente(i).getApellidoP()+ " "+institucion.ObtenerPaciente(i).getApellidoM();
                historia  = institucion.ObtenerPaciente(i).getHistoria();
                break;
                }
            }
            if(historia!=""){        
            for (int i = 0; i < historiaClinica.TamañoRegistroHC(); i++) {
                if(historiaClinica.ObtenerRegistroHC(i).getHistoriaPaciente().equalsIgnoreCase(hc)){
                    Object dato[]={num,historiaClinica.ObtenerRegistroHC(i).getFecha()};                                
                    modelHC.addRow(dato); 
                    num++;
                }
            }
                if(jtListaHC.getRowCount() != 0){
                    txtListaHC.setText(txtHCbuscarHistorial.getText());
                    txtListaNombre.setText(paciente);   
                    JOptionPane.showMessageDialog(this,"Historial Encontrado","Historial Clinico",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Registro de Historial Vacio","Historial Clinico",JOptionPane.PLAIN_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Historial No Encontrado","Historial Clinico",JOptionPane.WARNING_MESSAGE);
            }  
            
        }  
        else if(cmbLHCfiltro.getSelectedIndex()==1){
             int dni = Integer.parseInt(txtHCbuscarHistorial.getText());                              
             String hclinico="";
             Paciente paci = recepcionista.BuscarPaciente(dni);
             String nomPaciente="";
             for (int i = 0; i < institucion.TamañoPaciente(); i++) {
                 if(institucion.ObtenerPaciente(i).getDni()==dni){
                    hclinico= institucion.ObtenerPaciente(i).getHistoria();
                    nomPaciente = institucion.ObtenerPaciente(i).getNombre() + " "+ institucion.ObtenerPaciente(i).getApellidoP()+ " "+institucion.ObtenerPaciente(i).getApellidoM();
                    break;
                }
            }
             if(paci!=null){        
                for (int i = 0; i < historiaClinica.TamañoRegistroHC(); i++) {
                if(historiaClinica.ObtenerRegistroHC(i).getHistoriaPaciente().equalsIgnoreCase(hclinico)){
                    Object dato[]={num,historiaClinica.ObtenerRegistroHC(i).getFecha()};                                
                    modelHC.addRow(dato); 
                    num++;
                }
            } 
                if(jtListaHC.getRowCount() != 0){
                    txtListaHC.setText(hclinico);
                    txtListaNombre.setText(nomPaciente);
                    JOptionPane.showMessageDialog(this,"Historial Encontrado","Historial Clinico",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Registro de Historial Vacio","Historial Clinico",JOptionPane.PLAIN_MESSAGE);
                }                
            }else{
                JOptionPane.showMessageDialog(this,"Historial No Encontrado","Historial Clinico",JOptionPane.WARNING_MESSAGE);
            }                            
        }
        else{
            JOptionPane.showMessageDialog(this,"Por favor Selecciona una Categoria","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void filtroLCM(){       
        int campo = 0;
        if(cmbLCMcombo.getSelectedIndex() == 1){            
            campo = 1;
        }
        else if(cmbLCMcombo.getSelectedIndex() == 2){            
            campo = 0;
        }
        else if(cmbLCMcombo.getSelectedIndex() == 3){            
            campo = 3;
        }
        tr.setRowFilter(RowFilter.regexFilter(txtLCMbuscar.getText(), campo));
    }
    public void consultarPacientesHC(){ //Tabla RegistroHC  
        int fila=this.jtLApacientes.getSelectedRow();                
        txtHCdni.setText(this.jtLApacientes.getValueAt(fila, 0).toString());          
        int dni =(int) this.jtLApacientes.getValueAt(fila, 0);       
        Paciente pt = recepcionista.BuscarPaciente(dni);
        if(pt!=null){
        for(int i=0;i< institucion.TamañoPaciente();i++){
            if(institucion.ObtenerPaciente(i).getDni() == dni){
                txtHCcodHistoria.setText(institucion.ObtenerPaciente(i).getHistoria());
                txtHCnombre.setText(institucion.ObtenerPaciente(i).getNombre());
                txtHCapellido.setText(institucion.ObtenerPaciente(i).getApellidoP());
                txtHCedad.setText(institucion.ObtenerPaciente(i).getEdad()+"");
                txtHCsexo.setText(institucion.ObtenerPaciente(i).getSexo());
                break;
            }
        }
        }else{
            JOptionPane.showMessageDialog(this,"Paciente No Registrado ","Historial Clinico",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void consultarRegistroHC(){ 
        txtArea.setText("");
        int fila=this.jtListaHC.getSelectedRow();         
        String fecha =this.jtListaHC.getValueAt(fila, 1).toString();
        String historial = txtListaHC.getText();
        String codhc="",receta="",diagnostico="",sexo="",nombre="",apellido="",ante="";
        int edad=0;
        double peso=0,imc=0,talla=0,temp=0,pa=0;
        for(int i = 0;i< institucion.TamañoPaciente();i++){
            if(institucion.ObtenerPaciente(i).getHistoria().equals(historial)){
                nombre = institucion.ObtenerPaciente(i).getNombre();
                apellido = institucion.ObtenerPaciente(i).getApellidoP();
                edad = institucion.ObtenerPaciente(i).getEdad();
                sexo = institucion.ObtenerPaciente(i).getSexo();
                break;
            }
        }
        for(int i =0; i< historiaClinica.TamañoRegistroHC();i++){
            if(historiaClinica.ObtenerRegistroHC(i).getFecha().equals(fecha) && historiaClinica.ObtenerRegistroHC(i).getHistoriaPaciente().equals(historial) ){                
                codhc = historiaClinica.ObtenerRegistroHC(i).getHistoriaPaciente();
                receta = historiaClinica.ObtenerRegistroHC(i).getReceta();
                diagnostico = historiaClinica.ObtenerRegistroHC(i).getDiagnostico();                             
                peso= historiaClinica.ObtenerRegistroHC(i).getPeso();
                imc=historiaClinica.ObtenerRegistroHC(i).getImc();
                talla= historiaClinica.ObtenerRegistroHC(i).getTalla();
                temp= historiaClinica.ObtenerRegistroHC(i).getTemperatura();
                pa= historiaClinica.ObtenerRegistroHC(i).getTensionArterial();                
                break;
            }            
        }           
          
        taRegistroHC.append("Fecha de Atencion: "+fecha+"\n"+
                            "------Datos Personales---\n"+
                            "Codigo Historial : "+codhc+"\n "+
                            "Nombre : "+nombre+"\n "+
                            "Apellido : "+apellido+"\n "+
                            "Edad : "+edad+"\n "+
                            "Sexo : "+sexo+"\n "+                            
                                    "---------Examen Fisico-----"+"\n"+
                            "Temperatura : "+temp+"\n "+  
                            "Presión Arterial : "+pa+"\n "+          
                            "Peso : "+peso+"\n "+  
                            "Talla : "+talla+"\n "+
                            "Imc : "+imc+"\n "
                                    +"------Resultado de Atencion-----"+"\n"+
                            "Receta : "+receta+"\n "+
                            "Diagnostico : "+diagnostico+"\n");   
        txt1.setText(fecha);
        txt2.setText(codhc);
        txt3.setText(nombre);
        txt4.setText(apellido);
        txt5.setText(edad+"");
        txt6.setText(sexo);                
        txt7.setText(temp+" ");
        txt8.setText(pa+"");
        txt9.setText(peso+"");
        txt10.setText(talla+"");
        txt11.setText(imc+"");
        txt12.setText(receta+"");
        txt13.setText(diagnostico+"");
    }
     public void PDF(){
        try{
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido =  new PDPageContentStream(documento,pagina);        
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-20);             
            contenido.showText("Fecha atencion :"+txt1.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-40);             
            contenido.showText("Datos Personales");            
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-60);             
            contenido.showText("Codigo historial :"+txt2.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-80);             
            contenido.showText("Nombre paciente :"+txt3.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-100);             
            contenido.showText("Apellidos paciente :"+txt4.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-120);             
            contenido.showText("Edad :"+txt5.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-140);             
            contenido.showText("Sexo :"+txt6.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-160);             
            contenido.showText("Examen Fisico");
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-180);             
            contenido.showText("Temperatura :"+txt7.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-200);             
            contenido.showText("Presion Arterial :"+txt8.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-220);             
            contenido.showText("Peso :"+txt9.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-240);             
            contenido.showText("Talla :"+txt10.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-260);             
            contenido.showText("IMC :"+txt11.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-280);             
            contenido.showText("Resultado de Atencion");
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-300);             
            contenido.showText("Receta :"+txt12.getText());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD,18);
            contenido.newLineAtOffset(10, pagina.getMediaBox().getHeight()-320);             
            contenido.showText("Diagnostico :"+txt13.getText());
            contenido.endText();
            contenido.close();            
            documento.save("C:\\Users\\Boris\\Documents\\NetBeansProjects\\HistorialClinico_1\\PDF\\"+txt2.getText()+".pdf");
            
            JOptionPane.showMessageDialog(null,"PDF  Generado");
        }catch(Exception e)
        {        
            JOptionPane.showMessageDialog(null,"PDF No Generado");
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imglogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
        jPanel4 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlFondoPrincipal = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();
        pnlListaAtencion = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtLApacientes = new javax.swing.JTable();
        txtLCMbuscar = new javax.swing.JTextField();
        cmbLCMcombo = new javax.swing.JComboBox<>();
        pnlHistorialClinico = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtHCbuscar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtHCcodHistoria = new javax.swing.JTextField();
        txtHCnombre = new javax.swing.JTextField();
        txtHCapellido = new javax.swing.JTextField();
        txtHCdni = new javax.swing.JTextField();
        txtHCedad = new javax.swing.JTextField();
        txtHCsexo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtHCimc = new javax.swing.JTextField();
        txtHCaltura = new javax.swing.JTextField();
        txtHCpeso = new javax.swing.JTextField();
        txtHCtemperatura = new javax.swing.JTextField();
        txtHCfrecuenciaCardiaca = new javax.swing.JTextField();
        txtHCtensionArterial = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        taHCmotivoConsulta = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtHCenfermedad = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtHCantecedenteFamiliar = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        taHCdiagnostico = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        taHCreceta = new javax.swing.JTextArea();
        btnEliminarDP_HC = new javax.swing.JLabel();
        txtHCfecha = new javax.swing.JTextField();
        pnlListaHistoriaClinica = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jtListaHC = new javax.swing.JTable();
        txtHCbuscarHistorial = new javax.swing.JTextField();
        btnBuscarHistoria = new javax.swing.JLabel();
        cmbLHCfiltro = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        taRegistroHC = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        btnLimpiarHC1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        txt9 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        txt11 = new javax.swing.JTextField();
        txt12 = new javax.swing.JTextField();
        txt13 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtListaHC = new javax.swing.JTextField();
        txtListaNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CIDON PERU");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imglogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imglogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imglogoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Central  ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("987549912");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText(" 987549907");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(imglogo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 611, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imglogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 368));

        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jXTaskPaneContainer1.setLayout(verticalLayout1);

        jXTaskPane2.setTitle("Atenciones");
        jXTaskPaneContainer1.add(jXTaskPane2);

        jXTaskPane3.setTitle("Historias Clinicas");
        jXTaskPaneContainer1.add(jXTaskPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        pnlFondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoPrincipal.setName("pnlFondoPrincipal"); // NOI18N

        javax.swing.GroupLayout pnlFondoPrincipalLayout = new javax.swing.GroupLayout(pnlFondoPrincipal);
        pnlFondoPrincipal.setLayout(pnlFondoPrincipalLayout);
        pnlFondoPrincipalLayout.setHorizontalGroup(
            pnlFondoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        pnlFondoPrincipalLayout.setVerticalGroup(
            pnlFondoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        rSPanelsSlider1.add(pnlFondoPrincipal, "card6");

        pnlListaAtencion.setBackground(new java.awt.Color(255, 255, 255));
        pnlListaAtencion.setName("pnlListaAtencion"); // NOI18N

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("LISTA DE CITAS MEDICAS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(311, 311, 311))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtLApacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtLApacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLApacientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtLApacientes);

        txtLCMbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLCMbuscarKeyTyped(evt);
            }
        });

        cmbLCMcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bucar por:", "Nombre", "DNI", "Doctor" }));

        javax.swing.GroupLayout pnlListaAtencionLayout = new javax.swing.GroupLayout(pnlListaAtencion);
        pnlListaAtencion.setLayout(pnlListaAtencionLayout);
        pnlListaAtencionLayout.setHorizontalGroup(
            pnlListaAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlListaAtencionLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaAtencionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbLCMcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtLCMbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        pnlListaAtencionLayout.setVerticalGroup(
            pnlListaAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaAtencionLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlListaAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLCMbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLCMcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlListaAtencion, "card5");

        pnlHistorialClinico.setBackground(new java.awt.Color(255, 255, 255));
        pnlHistorialClinico.setName("pnlHistorialClinico"); // NOI18N

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("REGISTRO PARA HISTORIA CLINICA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(233, 233, 233))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Datos Personales");

        txtHCcodHistoria.setEnabled(false);

        txtHCnombre.setEnabled(false);

        txtHCapellido.setEnabled(false);

        txtHCdni.setEnabled(false);

        txtHCedad.setEnabled(false);

        txtHCsexo.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Examen Fisico");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Motivo de Consulta");

        taHCmotivoConsulta.setColumns(20);
        taHCmotivoConsulta.setRows(5);
        jScrollPane7.setViewportView(taHCmotivoConsulta);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Observacion y Antecedentes");

        txtHCenfermedad.setColumns(20);
        txtHCenfermedad.setRows(5);
        jScrollPane8.setViewportView(txtHCenfermedad);

        txtHCantecedenteFamiliar.setColumns(20);
        txtHCantecedenteFamiliar.setRows(5);
        jScrollPane9.setViewportView(txtHCantecedenteFamiliar);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("Diagnostico y Receta");

        taHCdiagnostico.setColumns(20);
        taHCdiagnostico.setRows(5);
        jScrollPane10.setViewportView(taHCdiagnostico);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        taHCreceta.setColumns(20);
        taHCreceta.setRows(5);
        jScrollPane11.setViewportView(taHCreceta);

        btnEliminarDP_HC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menos.png"))); // NOI18N
        btnEliminarDP_HC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarDP_HC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarDP_HCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHistorialClinicoLayout = new javax.swing.GroupLayout(pnlHistorialClinico);
        pnlHistorialClinico.setLayout(pnlHistorialClinicoLayout);
        pnlHistorialClinicoLayout.setHorizontalGroup(
            pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistorialClinicoLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistorialClinicoLayout.createSequentialGroup()
                        .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                                .addComponent(txtHCtensionArterial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCfrecuenciaCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCtemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCaltura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCimc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                                .addComponent(txtHCcodHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCdni, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCedad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHCsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHistorialClinicoLayout.createSequentialGroup()
                                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(jScrollPane9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarDP_HC)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistorialClinicoLayout.createSequentialGroup()
                        .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistorialClinicoLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(424, 424, 424))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistorialClinicoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(txtHCfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtHCbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(71, 71, 71))
        );
        pnlHistorialClinicoLayout.setVerticalGroup(
            pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHCbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHCfecha))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHCsexo)
                        .addComponent(txtHCedad)
                        .addComponent(txtHCdni)
                        .addComponent(txtHCapellido)
                        .addComponent(txtHCnombre)
                        .addComponent(txtHCcodHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarDP_HC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHCimc)
                    .addComponent(txtHCaltura)
                    .addComponent(txtHCpeso)
                    .addComponent(txtHCtemperatura)
                    .addComponent(txtHCfrecuenciaCardiaca)
                    .addComponent(txtHCtensionArterial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHistorialClinicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistorialClinicoLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlHistorialClinico, "card7");

        pnlListaHistoriaClinica.setBackground(new java.awt.Color(255, 255, 255));
        pnlListaHistoriaClinica.setName("pnlListaHistoriaClinica"); // NOI18N

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("LISTA DE HISTORIAS CLINICA");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel25)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtListaHC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListaHC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaHCMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jtListaHC);

        btnBuscarHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        btnBuscarHistoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarHistoriaMouseClicked(evt);
            }
        });

        cmbLHCfiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por:", "DNI", "Historia Clinica" }));

        taRegistroHC.setColumns(20);
        taRegistroHC.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        taRegistroHC.setRows(5);
        jScrollPane13.setViewportView(taRegistroHC);

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye.png"))); // NOI18N
        jButton3.setText("Ver Registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnLimpiarHC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menos.png"))); // NOI18N
        btnLimpiarHC1.setText("Limpiar");
        btnLimpiarHC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarHC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarHC1MouseClicked(evt);
            }
        });

        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setBorder(null);

        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setBorder(null);

        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setBorder(null);

        txt4.setForeground(new java.awt.Color(255, 255, 255));
        txt4.setBorder(null);

        txt5.setForeground(new java.awt.Color(255, 255, 255));
        txt5.setBorder(null);

        txt6.setForeground(new java.awt.Color(255, 255, 255));
        txt6.setBorder(null);

        txt7.setForeground(new java.awt.Color(255, 255, 255));
        txt7.setBorder(null);

        txt8.setForeground(new java.awt.Color(255, 255, 255));
        txt8.setBorder(null);

        txt9.setForeground(new java.awt.Color(255, 255, 255));
        txt9.setBorder(null);

        txt10.setForeground(new java.awt.Color(255, 255, 255));
        txt10.setBorder(null);

        txt11.setForeground(new java.awt.Color(255, 255, 255));
        txt11.setBorder(null);

        txt12.setForeground(new java.awt.Color(255, 255, 255));
        txt12.setBorder(null);

        txt13.setForeground(new java.awt.Color(255, 255, 255));
        txt13.setBorder(null);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        jButton4.setText("Generar");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListaHistoriaClinicaLayout = new javax.swing.GroupLayout(pnlListaHistoriaClinica);
        pnlListaHistoriaClinica.setLayout(pnlListaHistoriaClinicaLayout);
        pnlListaHistoriaClinicaLayout.setHorizontalGroup(
            pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(jButton3)
                                .addGap(49, 49, 49)
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt12))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarHC1)
                            .addComponent(jButton4))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(txtListaHC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtListaNombre))
                            .addComponent(cmbLHCfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtHCbuscarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarHistoria)
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlListaHistoriaClinicaLayout.setVerticalGroup(
            pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtHCbuscarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbLHCfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtListaHC, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtListaNombre))
                .addGap(18, 18, 18)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnLimpiarHC1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel27))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(39, 39, 39))
        );

        rSPanelsSlider1.add(pnlListaHistoriaClinica, "card8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtLApacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLApacientesMouseClicked
        consultarPacientesHC();
    }//GEN-LAST:event_jtLApacientesMouseClicked

    private void imglogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imglogoMouseClicked
        rSPanelsSlider1.setPanelSlider(20, pnlFondoPrincipal,RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_imglogoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AgregarRegistroHC();
        LimpiarRegistroHC();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        BuscarHistorialClinico();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void btnEliminarDP_HCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDP_HCMouseClicked
        txtHCcodHistoria.setText("");
        txtHCnombre.setText("");
        txtHCapellido.setText("");
        txtHCedad.setText("");
        txtHCsexo.setText("");
        txtHCdni.setText("");
    }//GEN-LAST:event_btnEliminarDP_HCMouseClicked

    private void btnBuscarHistoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarHistoriaMouseClicked
        modelHC.setRowCount(0);
        BuscarHC();
        txtHCbuscarHistorial.setText("");
    }//GEN-LAST:event_btnBuscarHistoriaMouseClicked

    private void txtLCMbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLCMbuscarKeyTyped
        txtLCMbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e){
                String cadena=txtLCMbuscar.getText();
                txtLCMbuscar.setText(cadena);                
                filtroLCM();
            }
        });
        tr=new TableRowSorter(this.jtLApacientes.getModel());
        jtLApacientes.setRowSorter(tr);   
    }//GEN-LAST:event_txtLCMbuscarKeyTyped

    private void jtListaHCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaHCMouseClicked
        consultarRegistroHC();
    }//GEN-LAST:event_jtListaHCMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtArea.setText(taRegistroHC.getText());           
        taRegistroHC.setText("");
        vp.setVisible(true);                  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLimpiarHC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarHC1MouseClicked
         modelHC.setRowCount(0);
         txtListaHC.setText("");
         txtListaNombre.setText("");
    }//GEN-LAST:event_btnLimpiarHC1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PDF();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        txt10.setText("");
        txt11.setText("");
        txt12.setText("");
        txt13.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscarHistoria;
    private javax.swing.JLabel btnEliminarDP_HC;
    private javax.swing.JLabel btnLimpiarHC1;
    private javax.swing.JComboBox<String> cmbLCMcombo;
    private javax.swing.JComboBox<String> cmbLHCfiltro;
    private javax.swing.JLabel imglogo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JTable jtLApacientes;
    private javax.swing.JTable jtListaHC;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPanel pnlFondoPrincipal;
    private javax.swing.JPanel pnlHistorialClinico;
    private javax.swing.JPanel pnlListaAtencion;
    private javax.swing.JPanel pnlListaHistoriaClinica;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JTextArea taHCdiagnostico;
    private javax.swing.JTextArea taHCmotivoConsulta;
    private javax.swing.JTextArea taHCreceta;
    public static javax.swing.JTextArea taRegistroHC;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt10;
    private javax.swing.JTextField txt11;
    private javax.swing.JTextField txt12;
    private javax.swing.JTextField txt13;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    private javax.swing.JTextField txtHCaltura;
    private javax.swing.JTextArea txtHCantecedenteFamiliar;
    private javax.swing.JTextField txtHCapellido;
    private javax.swing.JTextField txtHCbuscar;
    private javax.swing.JTextField txtHCbuscarHistorial;
    private javax.swing.JTextField txtHCcodHistoria;
    private javax.swing.JTextField txtHCdni;
    private javax.swing.JTextField txtHCedad;
    private javax.swing.JTextArea txtHCenfermedad;
    private javax.swing.JTextField txtHCfecha;
    private javax.swing.JTextField txtHCfrecuenciaCardiaca;
    private javax.swing.JTextField txtHCimc;
    private javax.swing.JTextField txtHCnombre;
    private javax.swing.JTextField txtHCpeso;
    private javax.swing.JTextField txtHCsexo;
    private javax.swing.JTextField txtHCtemperatura;
    private javax.swing.JTextField txtHCtensionArterial;
    private javax.swing.JTextField txtLCMbuscar;
    private javax.swing.JTextField txtListaHC;
    private javax.swing.JTextField txtListaNombre;
    // End of variables declaration//GEN-END:variables
}

