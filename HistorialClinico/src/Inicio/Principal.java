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
import static Inicio.PrincipalDoctor.taRegistroHC;
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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author BORISFLORES
 */
public class Principal extends javax.swing.JFrame {

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
    Paciente p = new Paciente();
    Atencion a = new Atencion();
    HistoriaClinica historiaClinica = new HistoriaClinica(); 
    VPregistro vp = new VPregistro();
    registroHistoria dap = new registroHistoria();
    Institucion institucion = new Institucion();
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
        Icon icono=new ImageIcon(ClassLoader.getSystemResource("Recursos/boss.png"));
        final JXLabel label=new JXLabel("Nueva Cita Medica", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {
                      
            @Override
            public void mouseClicked(MouseEvent e){               
                rSPanelsSlider1.setPanelSlider(20, pnlRegAtencion,RSPanelsSlider.DIRECT.RIGHT);
            }
});
        
        Icon icono1=new ImageIcon(ClassLoader.getSystemResource("Recursos/listaAtencion.png"));
        final JXLabel label1=new JXLabel("Lista de Citas Medicas", icono1, JXLabel.LEFT);
        label1.addMouseListener(new MouseAdapter() {
                      
            @Override
            public void mouseClicked(MouseEvent e){
               rSPanelsSlider1.setPanelSlider(20, pnlListaAtencion,RSPanelsSlider.DIRECT.RIGHT);
            }
}); 
        eventosmouse(label);
        eventosmouse(label1);        
        jXTaskPane2.add(label);
        jXTaskPane2.add(label1);        
    }
    
    public void EmpleadosRM(){
        Icon icono=new ImageIcon(ClassLoader.getSystemResource("Recursos/enfermo.png"));
         JXLabel label=new JXLabel("Pacientes", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {
                       
        @Override
            public void mouseClicked(MouseEvent e){               
                rSPanelsSlider1.setPanelSlider(20, pnlRegPacientes,RSPanelsSlider.DIRECT.RIGHT);
            }
});
        
        Icon icono1=new ImageIcon(ClassLoader.getSystemResource("Recursos/boss.png"));
        final JXLabel label1=new JXLabel("Empleados", icono1, JXLabel.LEFT);
        label1.addMouseListener(new MouseAdapter() {
                      
            @Override
            public void mouseClicked(MouseEvent e){
                rSPanelsSlider1.setPanelSlider(20, pnlRegEmpleado,RSPanelsSlider.DIRECT.RIGHT);
            }
});
                
        eventosmouse(label);
        eventosmouse(label1);        
        jXTaskPane1.add(label);
        jXTaskPane1.add(label1);        
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
    public Principal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/heart.png")).getImage());
        EmpleadosRM();
        Atenciones();
        HistoriaClinica();
        Logo();
        this.setLocationRelativeTo(null);        
        this.PlaceHolder();
        codigoAleatorio();        
        institucion.CargarRecepcionista();
        institucion.CargarMedico();
        institucion.CargarPaciente();
        institucion.CargarAtencion();        
        historiaClinica.CargarRegistroHC();
        CargarInterfaz();
        CargarTabla();            
        LlenarComboDoctor();                
    }        
    
     public void PlaceHolder(){
         /*PANEL REGISTRO EMPLEADO*/
        TextPrompt re1=new TextPrompt("Nombre",txtnombre);
        TextPrompt re2=new TextPrompt("Apellido",txtapellido);
        TextPrompt re3=new TextPrompt("Direccion de Correo",txtcorreo);
        TextPrompt re4=new TextPrompt("Usuario",txtusuario);
        TextPrompt re5=new TextPrompt("Contraseña",txtcontra);
        TextPrompt re6=new TextPrompt("Repetir Contraseña",txtrecontra);
        TextPrompt re7 = new TextPrompt("Numero DNI", txtDni);
        
        /*PANEL REGISTRO PACIENTE*/
        TextPrompt rp1 = new TextPrompt("Nombre", txtRPNombre);
        TextPrompt rp = new TextPrompt("Apellido Paterno", txtRPapellido);        
        TextPrompt rp3 = new TextPrompt("Direccion", txtRPdireccion);
        TextPrompt rp4 = new TextPrompt("N° DNI", txtRPdni);
        TextPrompt rp5 = new TextPrompt("Edad", txtRPedad);        
        TextPrompt rp8 = new TextPrompt("Apellido Materno", txtRPapellidom);
        TextPrompt rp9 = new TextPrompt("Codigo Paciente", txtRPcodigoHistoria);
        TextPrompt rp10 = new TextPrompt("Ocupacion", txtRPocupacion);
        TextPrompt rp11 = new TextPrompt("Antecedentes", taRPantecedente);
        TextPrompt rp12 = new TextPrompt("Patologias", taRPpatologias);       
        
        /*PANEL REGISTRO ATENCIONES*/
        TextPrompt ra1 = new TextPrompt("Nombre Paciente", txtRAnombre);        
        TextPrompt ra3 = new TextPrompt("Apellido Paciente", txtRAapellido);
        TextPrompt ra4 = new TextPrompt("Dia(dd-mm-yy)", txtRAfecha);
        TextPrompt ra5 = new TextPrompt("N° DNI", txtRAdni);
        TextPrompt ra6 = new TextPrompt("Ingresar Dato", txtRAbuscar);        
        TextPrompt ra7 = new TextPrompt("Cod Historial", txtRAcodHistorial); 
        
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
        
        TextPrompt LHC1 = new TextPrompt("Historial Clinico", txtHCbuscarHistorial);
        TextPrompt LHC3 = new TextPrompt("dd-mm-yy", txtHCfecha);
        
        
    }
     /*PANEL DE REGISTRO DE EMPLEADO*/
    public void Limpiar(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtDni.setText("");
        txtcorreo.setText("");
        txtusuario.setText("");
        txtcontra.setText("");
        txtrecontra.setText("");
     }
    public void Registrar(){ //Tabla Empleados       
        ImageIcon iiR=new ImageIcon(getClass().getResource("/Icons/AgregarUsuario.png"));
        ImageIcon iiC=new ImageIcon(getClass().getResource("/Icons/crossC.png"));
        ImageIcon iiD=new ImageIcon(getClass().getResource("/Icons/doctorico.png"));
        try {            
            String cargo,turno="";
            String[] turnos = {"Mañana", "Tarde"};            
            if(cmbCargo.getSelectedIndex() == 0){
                turno = (String) JOptionPane.showInputDialog(null, "Seleccione un Turno", "Turnos", JOptionPane.PLAIN_MESSAGE,iiC, turnos, turnos[0]);
                cargo = "Recepcionista";
            }else{
                cargo = "Doctor";                        
                codMedico = Long.parseLong(JOptionPane.showInputDialog(null,"Ingrese Codigo Medico","Medico", JOptionPane.INFORMATION_MESSAGE));                                    
            }
            long NumDni=Long.parseLong(txtDni.getText());            
            Recepcionista obj1 = institucion.BuscarRecepcionista(NumDni);                
            Medico obj2 = institucion.BuscarMedico(NumDni);
            Object repX[] = {cargo,txtusuario.getText(),txtcontra .getText(),txtnombre.getText(),txtapellido.getText(),txtcorreo.getText(),NumDni,turno};
            Object medY[] ={cargo,txtusuario.getText(),txtcontra .getText(),txtnombre.getText(),txtapellido.getText(),txtcorreo.getText(),NumDni,codMedico};
            
                if(nuevo){
                    if(obj1 == null || obj2 == null){
                        Recepcionista x = new Recepcionista(txtusuario.getText(),txtcontra .getText(),txtnombre.getText(),txtapellido.getText(),                                                       
                        txtcorreo.getText(),cargo,NumDni,turno);                        
                        Medico y = new Medico(txtusuario.getText(),txtcontra .getText(),txtnombre.getText(),txtapellido.getText(),
                        txtcorreo.getText(),cargo,NumDni,codMedico);
                    if(txtcontra.getText().equals(txtrecontra.getText())){
                        v=true;
                        if(cmbCargo.getSelectedIndex() == 0){                                                        
                            institucion.AgregarRecepcionista(x);  
                            modelR.addRow(repX);                            
                        }else{
                            modelD.addRow(medY);
                            institucion.AgregarMedico(y);
                        }                        
                        JOptionPane.showMessageDialog(this, "Agregm@: "+txtusuario.getText(),"Mensaje de confirmacion",JOptionPane.PLAIN_MESSAGE,iiR);                                            
                    }else{
                        v=false;
                        JOptionPane.showMessageDialog(this, "Contraseñas Incorrecta","Mensaje de confirmacion",JOptionPane.PLAIN_MESSAGE,iiC);                                        
                        txtcontra.setText("");
                        txtrecontra.setText("");
                    }                    
                }
                    else{
                        JOptionPane.showMessageDialog(this, "Ya Existe","Mensaje de confirmacion",JOptionPane.INFORMATION_MESSAGE);                                        
                    }
                }else{
                    int fila = this.jtDoctor.getSelectedRow();
                    Medico med = institucion.BuscarMedico(Long.parseLong(this.jtDoctor.getValueAt(fila, 6).toString()));
                    med.setNombre(txtnombre.getText());
                    med.setApellido(txtapellido.getText());
                    med.setDni(Long.parseLong(txtDni.getText()));
                    med.setCorreo(txtcorreo.getText());
                    med.setId(txtusuario.getText());
                    med.setContra(txtcontra.getText());
                    med.setCodigoMedico(codMedico);
                    modelD.insertRow(fila, medY);
                    modelD.removeRow(fila+1);
                    JOptionPane.showMessageDialog(this, "Datos modificados","Mensaje de Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                }                               
        } catch (Exception e) {
        } 
        nuevo = false;
        Limpiar();
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtDni.setEnabled(false);
        txtcontra.setEnabled(false);
        txtrecontra.setEnabled(false);
        txtusuario.setEnabled(false);
        txtcorreo.setEnabled(false);
        cmbCargo.setEnabled(false);
        btnGuardar.setEnabled(false);    
        institucion.GrabarRecepcionista();
        institucion.GrabarMedico();
    }
     public void CargarInterfaz(){
        String camposR[] = {"Cargo","ID" ,"Contraseña","Nombre","Apellido","Correo","DNI","Turno"};         
        String camposD[] = {"Cargo","ID" ,"Contraseña","Nombre","Apellido","Correo","DNI","C.Medico"};        
        String camposP[] = {"Cod Historial","Nombre","Apellido Paterno","Apellido Materno","DNI","Sexo","Edad","Direccion"};
        String camposLA[] ={"DNI","Paciente","Fecha Atencion","Doctor"};
        String camposHC[] = {"N°Registro","Fecha"};
        String dataR[][] = {};
        String dataD[][] = {};
        String dataP[][] = {};
        String dataLA[][] = {};
        String dataHC[][] = {};
        modelR = new DefaultTableModel(dataR, camposR);
        modelD = new DefaultTableModel(dataD, camposD);
        modelP = new DefaultTableModel(dataP, camposP);
        modelLA = new DefaultTableModel(dataLA,camposLA);
        modelHC = new DefaultTableModel(dataHC, camposHC);       
        this.jtRecepcionista.setModel(modelR);
        this.jtDoctor.setModel(modelD);
        this.jtPacientes.setModel(modelP);
        this.jtLApacientes.setModel(modelLA);
        this.jtListaHC.setModel(modelHC);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        /*CENTER HEADER*/
        ((DefaultTableCellRenderer) jtPacientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtDoctor.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtRecepcionista.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtLApacientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtListaHC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        /*DATA RECEPCIONISTA*/
        jtRecepcionista.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jtRecepcionista.getColumnModel().getColumn(7).setCellRenderer(tcr);
        /*DATA DOCTOR*/
        jtDoctor.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jtDoctor.getColumnModel().getColumn(7).setCellRenderer(tcr);
        /*DATA PACIENTE*/
        jtPacientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(7).setCellRenderer(tcr);       
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
        int tamR = institucion.TamañoRecepcionista();
        int tamD = institucion.TamañoMedico();   
        int tamP = institucion.TamañoPaciente();   
        int tamLA = institucion.TamañoAtencion();        
        
        if(tamR > 0){
            for (int i = 0; i < tamR; i++) {
                Recepcionista rep = institucion.ObtenerRecepcionista(i);
                Object datosR[] = {rep.getCargo(),rep.getId(),rep.getContra(),rep.getNombre(),rep.getApellido(),
                rep.getCorreo(),rep.getDni(),rep.getTurno()};
                modelR.addRow(datosR);                               
            }
        }
        if(tamD > 0){
            for (int i = 0; i < tamD; i++) {
                Medico doc = institucion.ObtenerMedico(i);                
                Object datosD[] = {doc.getCargo(),doc.getId(),doc.getContra(),doc.getNombre(),doc.getApellido(),
                doc.getCorreo(),doc.getDni(),doc.getCodigoMedico()};                
                modelD.addRow(datosD);                     
            }
        }                 
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
    public void Agregar(){ //Tabla Empleados
        nuevo = true;
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtDni.setEnabled(true);
        txtcontra.setEnabled(true);
        txtrecontra.setEnabled(true);
        txtusuario.setEnabled(true);
        txtcorreo.setEnabled(true);
        cmbCargo.setEnabled(true);
        btnGuardar.setEnabled(true);                
    }
    public void Eliminar1(){ //Tabla Empleados       
        ImageIcon iiE=new ImageIcon(getClass().getResource("/Icons/deleteaccount.png"));
        int filasR = this.jtRecepcionista.getSelectedRowCount();        
            if(filasR == 0){
                JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar Fila", "Eliminar", JOptionPane.INFORMATION_MESSAGE);            
            }else{
                Limpiar();                
                int filaR = this.jtRecepcionista.getSelectedRow();
                String dni = this.jtRecepcionista.getValueAt(filaR, 6).toString();
                institucion.EliminarRecepcionista(Long.parseLong(dni));
                modelR.removeRow(filaR);
                institucion.GrabarRecepcionista();
                JOptionPane.showMessageDialog(rootPane, "Recepcionist@ Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE,iiE);
            }                     
    }
    public void consultardatos(){ //Tabla Empleados
        int fila=this.jtDoctor.getSelectedRow();        
        cmbCargo.setSelectedIndex(1);
        txtusuario.setText(this.jtDoctor.getValueAt(fila, 1).toString());        
        txtcontra.setText(this.jtDoctor.getValueAt(fila, 2).toString());        
        txtrecontra.setText(this.jtDoctor.getValueAt(fila, 2).toString()); 
        txtnombre.setText(this.jtDoctor.getValueAt(fila, 3).toString());        
        txtapellido.setText(this.jtDoctor.getValueAt(fila, 4).toString());        
        txtcorreo.setText(this.jtDoctor.getValueAt(fila, 5).toString());        
        txtDni.setText(this.jtDoctor.getValueAt(fila, 6).toString());        
    }
    public void ModificarTablaMedico(){ //Tabla Empleados
        int fila = this.jtDoctor.getSelectedRow();
        if(fila > 0){
            txtnombre.setEnabled(true);
            txtapellido.setEnabled(true);
            txtDni.setEnabled(true);
            txtcontra.setEnabled(true);
            txtrecontra.setEnabled(true);
            txtusuario.setEnabled(true);
            txtcorreo.setEnabled(true);
            cmbCargo.setEnabled(true);
            btnGuardar.setEnabled(true); 
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione una fila","Mensaje de Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }    
    public void Eliminar(){ //Tabla Empleados
        ImageIcon iiE=new ImageIcon(getClass().getResource("/Icons/deleteaccount.png"));        
        int filasD = this.jtDoctor.getSelectedRowCount();                    
            if(filasD == 0){
                JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar Fila", "Eliminar", JOptionPane.INFORMATION_MESSAGE);            
            }else{
                Limpiar();                
                int filaD = this.jtDoctor.getSelectedRow();
                String dniD = this.jtDoctor.getValueAt(filaD,6).toString();
                institucion.EliminarMedico(Long.parseLong(dniD));
                modelD.removeRow(filaD);
                institucion.GrabarMedico();
                JOptionPane.showMessageDialog(rootPane, "Doctor Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE,iiE);
            }                     
    } 
    /*PANEL DE REGISTRO DE  PACIENTES*/
    public String codigoAleatorio(){/*REGSITRO PACIENTE*/
         txtRPcodigoHistoria.setText(UUID.randomUUID().toString().toUpperCase().substring(0,10));   
         txtRPfecha.setText(Fecha());
        return UUID.randomUUID().toString().toUpperCase().substring(0,10);
    }
    public String Fecha(){/*REGSITRO PACIENTE*/
        Calendar calendario=Calendar.getInstance();
        int anio=calendario.get(Calendar.YEAR);
        int mes=calendario.get(Calendar.MONTH);
        int dia=calendario.get(Calendar.DAY_OF_MONTH);
        int hora=calendario.get(Calendar.HOUR_OF_DAY);
        int min=calendario.get(Calendar.MINUTE);
        
        String fecha;
        mes=mes+1;
        fecha=dia+"-"+mes+"-"+anio;
        return fecha;    
    }
    public void LimpiarRegistroPaciente(){/*REGSITRO PACIENTE*/        
        txtRPNombre.setText("");
        txtRPapellido.setText("");
        txtRPapellidom.setText("");
        txtRPdireccion.setText("");
        txtRPdni.setText("");
        txtRPedad.setText("");
        txtRPocupacion.setText("");
        txtRPfecha.setText(Fecha());
        taRPpatologias.setText("");
        taRPantecedente.setText("");
        cmbRPestadoC.setSelectedIndex(0);
        cmbRPnacionalidad.setSelectedIndex(0);
        cmbRPsexo.setSelectedIndex(0);
        txtRPcodigoHistoria.setText(codigoAleatorio());
    }
    public void GrabarPaciente(){/*REGSITRO PACIENTE*/        
        ImageIcon iiR=new ImageIcon(getClass().getResource("/Icons/AgregarUsuario.png"));
        try {
            Object repX[] = {txtRPcodigoHistoria.getText(),txtRPNombre.getText(),txtRPapellido .getText(),txtRPapellidom.getText(),txtRPdni.getText(),cmbRPsexo.getSelectedItem().toString(),txtRPedad.getText(),txtRPdireccion.getText()};
            Paciente obj1 = recepcionista.BuscarPaciente(Integer.parseInt(txtRPdni.getText()));
            if(obj1 == null){    
                Paciente pac = new Paciente(txtRPcodigoHistoria.getText(),txtRPNombre.getText() , txtRPapellido.getText(),
                txtRPapellidom.getText(), txtRPdireccion.getText(),/* taRPpatologias.getText(), taRPantecedente.getText(),*/
                cmbRPsexo.getSelectedItem().toString(), txtRPocupacion.getText(),cmbRPnacionalidad.getSelectedItem().toString(),
                cmbRPestadoC.getSelectedItem().toString(), Integer.parseInt(txtRPedad.getText()),Integer.parseInt(txtRPdni.getText()));
                modelP.addRow(repX);      
                recepcionista.AgregarPaciente(pac);                
                JOptionPane.showMessageDialog(this,"Registraste Exitosamente a: "+txtRPNombre.getText()+" "+txtRPapellido.getText(),"Mensaje de Registro",JOptionPane.PLAIN_MESSAGE,iiR);
            }else{
                JOptionPane.showMessageDialog(this, "Ya Existe Paciente","Mensaje de confirmacion",JOptionPane.ERROR_MESSAGE);                                        
            }                
        } catch (Exception e) {
        }
                institucion.GrabarPaciente();
    }
    /*PANEL DE REGISTRO DE ATENCIONES*/
    public void limpiarRA(){
        txtRAcodHistorial.setText("");
        txtRAapellido.setText("");
        txtRAnombre.setText("");
        txtRAdni.setText("");
        txtRAfecha.setText("");
    }
    public void LlenarComboDoctor(){
        int t = institucion.TamañoMedico();
        for (int i = 0; i < t; i++) {
            Medico md = institucion.ObtenerMedico(i);
            cmbRAdoctores.addItem(md.getNombre()+" "+md.getApellido());            
        }
    }    
    public void filtro(){       
        int campo = 0;
        if(cmbRAtipo.getSelectedIndex() == 1){            
            campo = 4;
        }
        else if(cmbRAtipo.getSelectedIndex() == 2){            
            campo = 1;
        }
        else if(cmbRAtipo.getSelectedIndex() == 3){            
            campo = 2;
        }
        tr.setRowFilter(RowFilter.regexFilter(txtRAbuscar.getText(), campo));
    }
    public void consultarTablaPacientes(){
        int fila = this.jtPacientes.getSelectedRow();
        txtRAdni.setText(this.jtPacientes.getValueAt(fila, 4).toString());
        txtRAnombre.setText(this.jtPacientes.getValueAt(fila, 1).toString());
        txtRAapellido.setText(this.jtPacientes.getValueAt(fila, 2).toString());          
        txtRAcodHistorial.setText(this.jtPacientes.getValueAt(fila, 0).toString());
    }   
    public void RegistrarAtenciones(){
        try {
            Object dat[]={txtRAdni.getText(),txtRAnombre.getText()+" "+txtRAapellido.getText(),txtRAfecha.getText(),cmbRAdoctores.getSelectedItem()};
            Atencion at = new Atencion(Integer.parseInt(txtRAdni.getText()),txtRAnombre.getText(),txtRAfecha.getText(),cmbRAdoctores.getSelectedItem().toString());
            modelLA.addRow(dat);
            recepcionista.AgregarAtencion(at);
            JOptionPane.showMessageDialog(this,"Registro de Atencion Exitoso: "+txtRAnombre.getText()+" "+txtRAapellido.getText()+" el "+txtRAfecha.getText(),"Mensaje de Registro",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
        }
            institucion.GrabarAtencion();
    }
    /*LISTA DE ATENCIONES*/
    public void EliminarAtencionPaciente(){
        int fila = this.jtLApacientes.getSelectedRowCount();
        if(fila>0){
            int filaLA = this.jtLApacientes.getSelectedRow();
            String dni = this.jtLApacientes.getValueAt(filaLA, 0).toString();
            recepcionista.EliminarAtencion(Integer.parseInt(dni));
            modelLA.removeRow(fila);
            institucion.GrabarAtencion();
            JOptionPane.showMessageDialog(rootPane, "Atencion Eliminada", "Eliminar", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccionar una Fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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
    }
    public void BuscarHistorialClinico(){
        int dni = Integer.parseInt(txtHCbuscar.getText());        
        Paciente pa= recepcionista.BuscarPaciente(dni);
        if(pa!=null){
            for (int i = 0; i < institucion.TamañoPaciente(); i++) {
            if( institucion.ObtenerPaciente(i).getDni()==dni){
                txtHCcodHistoria.setText(institucion.ObtenerPaciente(i).getHistoria());
                txtHCnombre.setText(institucion.ObtenerPaciente(i).getNombre());
                txtHCapellido.setText(institucion.ObtenerPaciente(i).getApellidoP());
                txtHCdni.setText(String.valueOf(institucion.ObtenerPaciente(i).getDni()));
                txtHCedad.setText(String.valueOf(institucion.ObtenerPaciente(i).getEdad()));
                txtHCsexo.setText(institucion.ObtenerPaciente(i).getSexo());
                break;
            }   
        }
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
    public void BuscarHC(){        
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
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
        jPanel4 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlFondoPrincipal = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();
        pnlRegEmpleado = new javax.swing.JPanel();
        btnAgregarRecepcionista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRecepcionista = new javax.swing.JTable();
        cmbCargo = new javax.swing.JComboBox<>();
        txtcontra = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDoctor = new javax.swing.JTable();
        txtrecontra = new javax.swing.JPasswordField();
        txtDni = new javax.swing.JTextField();
        btnEditar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnAgregarDoctor = new javax.swing.JLabel();
        btnEliminarrDoctor = new javax.swing.JLabel();
        btnEliminarRecepcionista = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnlRegAtencion = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtRAbuscar = new javax.swing.JTextField();
        txtRAnombre = new javax.swing.JTextField();
        txtRAapellido = new javax.swing.JTextField();
        txtRAfecha = new javax.swing.JTextField();
        cmbRAdoctores = new javax.swing.JComboBox<>();
        btnRAguardar = new javax.swing.JButton();
        txtRAdni = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtPacientes = new javax.swing.JTable();
        cmbRAtipo = new javax.swing.JComboBox<>();
        txtRAcodHistorial = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        pnlRegPacientes = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtRPNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRPapellido = new javax.swing.JTextField();
        txtRPdni = new javax.swing.JTextField();
        txtRPedad = new javax.swing.JTextField();
        cmbRPsexo = new javax.swing.JComboBox<>();
        txtRPdireccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtRPapellidom = new javax.swing.JTextField();
        txtRPcodigoHistoria = new javax.swing.JTextField();
        cmbRPestadoC = new javax.swing.JComboBox<>();
        txtRPocupacion = new javax.swing.JTextField();
        cmbRPnacionalidad = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        taRPalergias = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taRPpatologias = new javax.swing.JTextArea();
        txtRPfecha = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        taRPtiposangre = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        taRPantecedente = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
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
        pnlListaAtencion = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtLApacientes = new javax.swing.JTable();
        txtLCMbuscar = new javax.swing.JTextField();
        cmbLCMcombo = new javax.swing.JComboBox<>();
        pnlListaHistoriaClinica = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jtListaHC = new javax.swing.JTable();
        txtHCbuscarHistorial = new javax.swing.JTextField();
        btnBuscarHistoria = new javax.swing.JLabel();
        cmbLHCfiltro = new javax.swing.JComboBox<>();
        jScrollPane15 = new javax.swing.JScrollPane();
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

        jXTaskPane1.setTitle("Registros");
        jXTaskPaneContainer1.add(jXTaskPane1);

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
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
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
            .addComponent(lblFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        rSPanelsSlider1.add(pnlFondoPrincipal, "card6");

        pnlRegEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegEmpleado.setName("pnlRegEmpleado"); // NOI18N

        btnAgregarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnAgregarRecepcionista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarRecepcionistaMouseClicked(evt);
            }
        });

        jtRecepcionista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtRecepcionista);

        cmbCargo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcionista", "Doctor" }));
        cmbCargo.setEnabled(false);
        cmbCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCargoItemStateChanged(evt);
            }
        });

        txtcontra.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Cargo");

        jtDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDoctorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtDoctor);

        txtrecontra.setEnabled(false);

        txtDni.setEnabled(false);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/id.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nombre.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nombre.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/email.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("REGISTRO");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TABLA DE EMPLEADOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(164, 164, 164))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtnombre.setEnabled(false);

        txtapellido.setEnabled(false);

        txtcorreo.setEnabled(false);

        btnAgregarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnAgregarDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarDoctorMouseClicked(evt);
            }
        });

        btnEliminarrDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menos.png"))); // NOI18N
        btnEliminarrDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarrDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarrDoctorMouseClicked(evt);
            }
        });

        btnEliminarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menos.png"))); // NOI18N
        btnEliminarRecepcionista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarRecepcionistaMouseClicked(evt);
            }
        });

        txtusuario.setEnabled(false);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/guardar.png"))); // NOI18N
        btnGuardar.setText(" GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnEditar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditar2MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setText("Dato Personal");

        javax.swing.GroupLayout pnlRegEmpleadoLayout = new javax.swing.GroupLayout(pnlRegEmpleado);
        pnlRegEmpleado.setLayout(pnlRegEmpleadoLayout);
        pnlRegEmpleadoLayout.setHorizontalGroup(
            pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcontra)
                                    .addComponent(txtrecontra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnGuardar)))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegEmpleadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addGap(78, 78, 78)))
                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarRecepcionista)
                    .addComponent(btnEliminarRecepcionista)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminarrDoctor)
                    .addComponent(btnAgregarDoctor)
                    .addComponent(btnEditar2))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlRegEmpleadoLayout.setVerticalGroup(
            pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel24)
                        .addGap(30, 30, 30)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcontra)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrecontra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCargo)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnAgregarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarrDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlRegEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar2)
                                .addGap(105, 105, 105))
                            .addGroup(pnlRegEmpleadoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        rSPanelsSlider1.add(pnlRegEmpleado, "card2");

        pnlRegAtencion.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegAtencion.setName("pnlRegAtencion"); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("REGISTRAR ATENCION");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtRAbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRAbuscarKeyTyped(evt);
            }
        });

        cmbRAdoctores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Doctores" }));

        btnRAguardar.setBackground(new java.awt.Color(0, 204, 204));
        btnRAguardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRAguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnRAguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/guardar.png"))); // NOI18N
        btnRAguardar.setText("Guardar");
        btnRAguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAguardarActionPerformed(evt);
            }
        });

        jtPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPacientesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtPacientes);

        cmbRAtipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbRAtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Dato", "N° DNI", "Nombre", "Apellido" }));

        javax.swing.GroupLayout pnlRegAtencionLayout = new javax.swing.GroupLayout(pnlRegAtencion);
        pnlRegAtencion.setLayout(pnlRegAtencionLayout);
        pnlRegAtencionLayout.setHorizontalGroup(
            pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegAtencionLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                                .addComponent(btnRAguardar)
                                .addGap(213, 213, 213))
                            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                                .addComponent(txtRAcodHistorial)
                                .addGap(18, 18, 18)
                                .addComponent(txtRAdni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRAnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRAapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRAfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(cmbRAdoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addComponent(cmbRAtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegAtencionLayout.setVerticalGroup(
            pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRAtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRAdoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAdni, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAcodHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRAguardar)
                .addGap(43, 43, 43))
        );

        rSPanelsSlider1.add(pnlRegAtencion, "card4");

        pnlRegPacientes.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegPacientes.setName("pnlRegPacientes"); // NOI18N

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("REGISTRO DE PACIENTES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLabel13)
                .addContainerGap(246, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Datos Personales");

        cmbRPsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "Masculino", "Femenino" }));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtRPcodigoHistoria.setEnabled(false);

        cmbRPestadoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado Civil", "Soltero", "Casado", "Viudo" }));

        cmbRPnacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nacionalidad", "Peruana", "Venezolana", "Colombiana", "Argetina", "Chilena", "Boliviana" }));

        taRPalergias.setColumns(20);
        taRPalergias.setRows(5);
        jScrollPane3.setViewportView(taRPalergias);

        taRPpatologias.setColumns(20);
        taRPpatologias.setRows(5);
        jScrollPane4.setViewportView(taRPpatologias);

        txtRPfecha.setEnabled(false);

        taRPtiposangre.setColumns(20);
        taRPtiposangre.setRows(5);
        jScrollPane13.setViewportView(taRPtiposangre);

        taRPantecedente.setColumns(20);
        taRPantecedente.setRows(5);
        jScrollPane14.setViewportView(taRPantecedente);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setText("Antecedentes");

        javax.swing.GroupLayout pnlRegPacientesLayout = new javax.swing.GroupLayout(pnlRegPacientes);
        pnlRegPacientes.setLayout(pnlRegPacientesLayout);
        pnlRegPacientesLayout.setHorizontalGroup(
            pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel14)
                    .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                                    .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane14)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegPacientesLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addGap(301, 301, 301)))
                            .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbRPestadoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRPdireccion)
                                    .addComponent(txtRPcodigoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRPNombre)
                                    .addComponent(txtRPdni)
                                    .addComponent(cmbRPsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRPedad)
                                    .addComponent(txtRPapellido)
                                    .addComponent(cmbRPnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRPapellidom)
                                    .addComponent(txtRPocupacion)
                                    .addComponent(txtRPfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegPacientesLayout.setVerticalGroup(
            pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegPacientesLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel14)
                .addGap(23, 23, 23)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRPcodigoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRPdni)
                            .addComponent(txtRPdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbRPestadoC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRPsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRPnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRPfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRPapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRPapellidom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRPedad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRPocupacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        rSPanelsSlider1.add(pnlRegPacientes, "card3");

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
                .addGap(0, 80, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlListaAtencion, "card5");

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
        jScrollPane15.setViewportView(taRegistroHC);

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
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarRecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarRecepcionistaMouseClicked
        Agregar();
        cmbCargo.setSelectedIndex(0);
    }//GEN-LAST:event_btnAgregarRecepcionistaMouseClicked

    private void cmbCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCargoItemStateChanged

    }//GEN-LAST:event_cmbCargoItemStateChanged

    private void jtDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDoctorMouseClicked
        consultardatos();
    }//GEN-LAST:event_jtDoctorMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        ModificarTablaMedico();
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnAgregarDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDoctorMouseClicked
        Agregar();
        cmbCargo.setSelectedIndex(1);
    }//GEN-LAST:event_btnAgregarDoctorMouseClicked

    private void btnEliminarrDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarrDoctorMouseClicked
        Eliminar();
    }//GEN-LAST:event_btnEliminarrDoctorMouseClicked

    private void btnEliminarRecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarRecepcionistaMouseClicked
        Eliminar1();
    }//GEN-LAST:event_btnEliminarRecepcionistaMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.Registrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditar2MouseClicked

    private void btnRAguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAguardarActionPerformed
        RegistrarAtenciones();
        limpiarRA();
    }//GEN-LAST:event_btnRAguardarActionPerformed

    private void txtRAbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRAbuscarKeyTyped
        txtRAbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e){
                String cadena=txtRAbuscar.getText();
                txtRAbuscar.setText(cadena);                
                filtro();
            }
        });
        tr=new TableRowSorter(this.jtPacientes.getModel());
        jtPacientes.setRowSorter(tr);    
    }//GEN-LAST:event_txtRAbuscarKeyTyped

    private void jtPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPacientesMouseClicked
        consultarTablaPacientes();
    }//GEN-LAST:event_jtPacientesMouseClicked

    private void imglogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imglogoMouseClicked
        rSPanelsSlider1.setPanelSlider(20, pnlFondoPrincipal,RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_imglogoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.GrabarPaciente();
        LimpiarRegistroPaciente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        BuscarHistorialClinico();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AgregarRegistroHC();
        LimpiarRegistroHC();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEliminarDP_HCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDP_HCMouseClicked
        txtHCcodHistoria.setText("");
        txtHCnombre.setText("");
        txtHCapellido.setText("");
        txtHCedad.setText("");
        txtHCsexo.setText("");
        txtHCdni.setText("");
    }//GEN-LAST:event_btnEliminarDP_HCMouseClicked

    private void jtLApacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLApacientesMouseClicked
        consultarPacientesHC();
    }//GEN-LAST:event_jtLApacientesMouseClicked

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

    private void btnBuscarHistoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarHistoriaMouseClicked
        modelHC.setRowCount(0);
        BuscarHC();
        txtHCbuscarHistorial.setText("");
    }//GEN-LAST:event_btnBuscarHistoriaMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarDoctor;
    private javax.swing.JLabel btnAgregarRecepcionista;
    private javax.swing.JLabel btnBuscarHistoria;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnEditar2;
    private javax.swing.JLabel btnEliminarDP_HC;
    private javax.swing.JLabel btnEliminarRecepcionista;
    private javax.swing.JLabel btnEliminarrDoctor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnLimpiarHC1;
    private javax.swing.JButton btnRAguardar;
    public static javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbLCMcombo;
    private javax.swing.JComboBox<String> cmbLHCfiltro;
    private javax.swing.JComboBox<String> cmbRAdoctores;
    private javax.swing.JComboBox<String> cmbRAtipo;
    private javax.swing.JComboBox<String> cmbRPestadoC;
    private javax.swing.JComboBox<String> cmbRPnacionalidad;
    private javax.swing.JComboBox<String> cmbRPsexo;
    private javax.swing.JLabel imglogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JTable jtDoctor;
    private javax.swing.JTable jtLApacientes;
    private javax.swing.JTable jtListaHC;
    private javax.swing.JTable jtPacientes;
    private javax.swing.JTable jtRecepcionista;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPanel pnlFondoPrincipal;
    private javax.swing.JPanel pnlHistorialClinico;
    private javax.swing.JPanel pnlListaAtencion;
    private javax.swing.JPanel pnlListaHistoriaClinica;
    private javax.swing.JPanel pnlRegAtencion;
    private javax.swing.JPanel pnlRegEmpleado;
    private javax.swing.JPanel pnlRegPacientes;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JTextArea taHCdiagnostico;
    private javax.swing.JTextArea taHCmotivoConsulta;
    private javax.swing.JTextArea taHCreceta;
    private javax.swing.JTextArea taRPalergias;
    private javax.swing.JTextArea taRPantecedente;
    private javax.swing.JTextArea taRPpatologias;
    private javax.swing.JTextArea taRPtiposangre;
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
    private javax.swing.JTextField txtDni;
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
    private javax.swing.JTextField txtRAapellido;
    private javax.swing.JTextField txtRAbuscar;
    private javax.swing.JTextField txtRAcodHistorial;
    private javax.swing.JTextField txtRAdni;
    private javax.swing.JTextField txtRAfecha;
    private javax.swing.JTextField txtRAnombre;
    private javax.swing.JTextField txtRPNombre;
    private javax.swing.JTextField txtRPapellido;
    private javax.swing.JTextField txtRPapellidom;
    private javax.swing.JTextField txtRPcodigoHistoria;
    private javax.swing.JTextField txtRPdireccion;
    private javax.swing.JTextField txtRPdni;
    private javax.swing.JTextField txtRPedad;
    private javax.swing.JTextField txtRPfecha;
    private javax.swing.JTextField txtRPocupacion;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtrecontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

