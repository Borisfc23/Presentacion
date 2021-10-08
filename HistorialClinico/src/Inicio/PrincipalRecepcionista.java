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
 * @author BORIS
 */
public class PrincipalRecepcionista extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     *
     */
    boolean v = true;
    boolean nuevo;
    long codMedico = 0;    
    DefaultTableModel modelP;
    DefaultTableModel modelLA;
    DefaultTableModel modelHC;
    DefaultTableModel modelLP;
    Medico medico = new Medico();
    Recepcionista recepcionista = new Recepcionista();
    VPregistro vp =  new VPregistro();
    Institucion institucion = new Institucion();
    HistoriaClinica historiaClinica = new HistoriaClinica();
    registroHistoria dap = new registroHistoria();
    private TableRowSorter tr;

    public void Logo() {
        ImageIcon imagenChapa = new ImageIcon("src/Imagenes/logo.png");
        ImageIcon imgFondo = new ImageIcon("src/Imagenes/fondoPrincipal.jpg");
        Icon ico = new ImageIcon(imagenChapa.getImage().getScaledInstance(imglogo.getWidth(), imglogo.getHeight(), Image.SCALE_DEFAULT));
        Icon ico2 = new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
        imglogo.setIcon(ico);
        lblFondo.setIcon(ico2);
    }

    public void Atenciones() {
        Icon icono = new ImageIcon(ClassLoader.getSystemResource("Recursos/boss.png"));
        final JXLabel label = new JXLabel("Nueva Cita Medica", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                rSPanelsSlider1.setPanelSlider(20, pnlRegAtencion, RSPanelsSlider.DIRECT.RIGHT);
            }
        });

        eventosmouse(label);

        jXTaskPane2.add(label);

    }

    public void Pacientes() {
        Icon icono = new ImageIcon(ClassLoader.getSystemResource("Recursos/enfermo.png"));
        JXLabel label = new JXLabel("Pacientes", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                rSPanelsSlider1.setPanelSlider(20, pnlRegPacientes, RSPanelsSlider.DIRECT.RIGHT);
            }
        });

        eventosmouse(label);
        jXTaskPane1.add(label);
        
        Icon icono2 = new ImageIcon(ClassLoader.getSystemResource("Recursos/text-lines.png"));
        JXLabel label2 = new JXLabel("Lista de Pacientes", icono2, JXLabel.LEFT);
        label2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                rSPanelsSlider1.setPanelSlider(20, pnlListaPacientes, RSPanelsSlider.DIRECT.RIGHT);
            }
        });

        eventosmouse(label2);
        jXTaskPane1.add(label2);

    }

    public void HistoriaClinica() {

        Icon icono1 = new ImageIcon(ClassLoader.getSystemResource("Recursos/text-lines.png"));
        final JXLabel label1 = new JXLabel("Listas Historia Clinica", icono1, JXLabel.LEFT);
        label1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                rSPanelsSlider1.setPanelSlider(20, pnlListaHistoriaClinica, RSPanelsSlider.DIRECT.RIGHT);
            }
        });

        eventosmouse(label1);
        jXTaskPane3.add(label1);
    }

    //para que se sombree cunado entre
    public void eventosmouse(final JXLabel label) {
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                //tipo de letra
                Font font = new Font("tahoma", Font.BOLD, 14);
                label.setFont(font);
            }

        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                //tipo de letra
                Font font = new Font("tahoma", Font.PLAIN, 13);
                label.setFont(font);
            }
        });

    }

    public PrincipalRecepcionista() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/heart.png")).getImage());
        Pacientes();
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

    public void PlaceHolder() {

        /*PANEL REGISTRO PACIENTE*/
        TextPrompt rp1 = new TextPrompt("Nombre", txtRPNombre);
        TextPrompt rp = new TextPrompt("Apellido Paterno", txtRPapellido);
        TextPrompt rp3 = new TextPrompt("Direccion", txtRPdireccion);
        TextPrompt rp4 = new TextPrompt("N° DNI", txtRPdni);
        TextPrompt rp5 = new TextPrompt("Edad", txtRPedad);
        TextPrompt rp8 = new TextPrompt("Apellido Materno", txtRPapellidom);
        TextPrompt rp9 = new TextPrompt("Codigo Paciente", txtRPcodigoHistoria);
        TextPrompt rp10 = new TextPrompt("Ocupacion", txtRPocupacion);
        TextPrompt rp11 = new TextPrompt("Habitos Toxicos", taRPantecedente);
        TextPrompt rp12 = new TextPrompt("Patologias", taRPpatologias);
        TextPrompt rp13 = new TextPrompt("Tipo de Sangre", taRPtiposangre);
        TextPrompt rp14 = new TextPrompt("Alergias", taRPalergias);

        /*PANEL REGISTRO ATENCIONES*/
        TextPrompt ra1 = new TextPrompt("Nombre Paciente", txtRAnombre);
        TextPrompt ra3 = new TextPrompt("Apellido Paciente", txtRAapellido);
        TextPrompt ra4 = new TextPrompt("Dia(dd-mm-yy)", txtRAfecha);
        TextPrompt ra5 = new TextPrompt("N° DNI", txtRAdni);
        TextPrompt ra6 = new TextPrompt("Ingresar Dato", txtRAbuscar);
        TextPrompt ra7 = new TextPrompt("Cod Historial", txtRAcodHistorial);

        TextPrompt LHC1 = new TextPrompt("DNI o HC", txtHCbuscarHistorial);        
    }

    public void CargarInterfaz() {

        String camposP[] = {"Cod Historial", "Nombre", "Apellido Paterno", "Apellido Materno", "DNI"};
        String camposLA[] = {"DNI", "Paciente", "Fecha Atencion", "Doctor"};
        String camposHC[] = {"N°Registro", "Fecha"};
        String camposLP[] = {"Cod Historial", "Nombre", "Apellido Paterno", "Apellido Materno", "DNI", "Sexo", "Edad", "Direccion","Nacionalidad"};        
        String dataP[][] = {};
        String dataLA[][] = {};
        String dataHC[][] = {};
        String dataLP[][] = {};
        modelP = new DefaultTableModel(dataP, camposP);
        modelLA = new DefaultTableModel(dataLA, camposLA);
        modelHC = new DefaultTableModel(dataHC, camposHC);
        modelLP = new DefaultTableModel(dataLP,camposLP);
        
        this.jtPacientes.setModel(modelP);        
        this.jtListaHC.setModel(modelHC);
        this.jtListaPacientes.setModel(modelLP);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        /*CENTER HEADER*/
        ((DefaultTableCellRenderer) jtPacientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);        
        ((DefaultTableCellRenderer) jtListaHC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) jtListaPacientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        /*DATA PACIENTE*/
        jtPacientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtPacientes.getColumnModel().getColumn(4).setCellRenderer(tcr);        

        /*DATA LISTA DE HISTORIAS CLINICAS*/
        jtListaHC.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtListaHC.getColumnModel().getColumn(1).setCellRenderer(tcr);        
        /*DATA LISTA PACIENTE*/
        jtListaPacientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(7).setCellRenderer(tcr);
        jtListaPacientes.getColumnModel().getColumn(8).setCellRenderer(tcr);
    }

    public void CargarTabla() { //Tablas
        int tamP = institucion.TamañoPaciente(); 
        int tamLA = institucion.TamañoAtencion();

        if (tamP > 0) {
            for (int i = 0; i < tamP; i++) {
                Paciente pc = institucion.ObtenerPaciente(i);
                Object datosP[] = {pc.getHistoria(), pc.getNombre(), pc.getApellidoP(), pc.getApellidoM(), pc.getDni()};
                modelP.addRow(datosP);
            }
        }
        if (tamLA > 0) {
            for (int i = 0; i < tamLA; i++) {
                Atencion at = institucion.ObtenerAtencion(i);
                Object datosLA[] = {at.getDniPaciente(), at.getPaciente(), at.getFecha(), at.getDoctor()};
                modelLA.addRow(datosLA);
            }
        }
        if (tamP > 0) {
            for (int i = 0; i < tamP; i++) {
                Paciente pc = institucion.ObtenerPaciente(i);
                Object datosP[] = {pc.getHistoria(), pc.getNombre(), pc.getApellidoP(), pc.getApellidoM(), pc.getDni(), pc.getSexo(), pc.getEdad(), pc.getDireccion(),pc.getNacionalidad()};
                modelLP.addRow(datosP);
            }
        }
    }

    /*PANEL DE REGISTRO DE  PACIENTES*/
    public String codigoAleatorio() {/*REGSITRO PACIENTE*/
        txtRPcodigoHistoria.setText(UUID.randomUUID().toString().toUpperCase().substring(0, 10));
        txtRPfecha.setText(Fecha());
        return UUID.randomUUID().toString().toUpperCase().substring(0, 10);
    }

    public String Fecha() {/*REGSITRO PACIENTE*/
        Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);

        String fecha;
        mes = mes + 1;
        fecha = dia + "-" + mes + "-" + anio;
        return fecha;
    }

    public void LimpiarRegistroPaciente() {/*REGISTRO PACIENTE*/
        txtRPNombre.setText("");
        txtRPapellido.setText("");
        txtRPapellidom.setText("");
        txtRPdireccion.setText("");
        txtRPdni.setText("");
        txtRPedad.setText("");
        txtRPocupacion.setText("");
        txtRPfecha.setText(Fecha());
        taRPpatologias.setText("");
        taRPalergias.setText("");
        taRPalergias.setText("");
        taRPtiposangre.setText("");
        taRPantecedente.setText("");
        cmbRPestadoC.setSelectedIndex(0);
        cmbRPnacionalidad.setSelectedIndex(0);
        cmbRPsexo.setSelectedIndex(0);
        txtRPcodigoHistoria.setText(codigoAleatorio());
    }

    public void GrabarPaciente() {/*REGSITRO PACIENTE*/
        ImageIcon iiR = new ImageIcon(getClass().getResource("/Icons/AgregarUsuario.png"));
        try {            
            Object repX[] = {txtRPcodigoHistoria.getText(), txtRPNombre.getText(), txtRPapellido.getText(), txtRPapellidom.getText(), txtRPdni.getText(), cmbRPsexo.getSelectedItem().toString(), txtRPedad.getText(), txtRPdireccion.getText()};
            Object datPac[] = {txtRPcodigoHistoria.getText(), txtRPNombre.getText(), txtRPapellido.getText(), txtRPapellidom.getText(), txtRPdni.getText(), cmbRPsexo.getSelectedItem().toString(), txtRPedad.getText(), txtRPdireccion.getText(),cmbRPnacionalidad.getSelectedItem()};
            Paciente obj1 = recepcionista.BuscarPaciente(Integer.parseInt(txtRPdni.getText()));
            if (obj1 == null) {
                Paciente pac = new Paciente(txtRPcodigoHistoria.getText(), txtRPNombre.getText(), txtRPapellido.getText(),
                        txtRPapellidom.getText(), txtRPdireccion.getText()/*, taRPpatologias.getText(), taRPalergias.getText()*/,
                        cmbRPsexo.getSelectedItem().toString(), txtRPocupacion.getText(), cmbRPnacionalidad.getSelectedItem().toString(),
                        cmbRPestadoC.getSelectedItem().toString(), Integer.parseInt(txtRPedad.getText()), Integer.parseInt(txtRPdni.getText()));
                HistoriaClinica hc = new HistoriaClinica(txtRPcodigoHistoria.getText(),taRPantecedente.getText(),taRPpatologias.getText(),taRPtiposangre.getText(),taRPalergias.getText());
                modelP.addRow(repX);
                modelLP.addRow(datPac);
                recepcionista.AgregarPaciente(pac);
                recepcionista.AgregarHC(hc);
                JOptionPane.showMessageDialog(this, "Registraste Exitosamente a: " + txtRPNombre.getText() + " " + txtRPapellido.getText(), "Mensaje de Registro", JOptionPane.PLAIN_MESSAGE, iiR);
            } else {
                JOptionPane.showMessageDialog(this, "Ya Existe Paciente", "Mensaje de confirmacion", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
        institucion.GrabarPaciente();
        institucion.GrabarHC();
    }
    public void ElminarPaciente(){
        ImageIcon iiE=new ImageIcon(getClass().getResource("/Icons/deleteaccount.png"));
        int filasPaci = this.jtListaPacientes.getSelectedRowCount();        
            if(filasPaci == 0){
                JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar Fila", "Eliminar", JOptionPane.INFORMATION_MESSAGE);            
            }else{                       
                int filaPacie = this.jtListaPacientes.getSelectedRow();
                String dni = this.jtListaPacientes.getValueAt(filaPacie, 4).toString();
                recepcionista.EliminarPaciente(Integer.parseInt(dni));
                modelLP.removeRow(filaPacie);
                institucion.GrabarPaciente();
                JOptionPane.showMessageDialog(rootPane, "Paciente Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE,iiE);
            }       
    }
    /*PANEL DE REGISTRO DE ATENCIONES*/
    public void limpiarRA() {
        txtRAcodHistorial.setText("");
        txtRAapellido.setText("");
        txtRAnombre.setText("");
        txtRAdni.setText("");
        txtRAfecha.setText("");
    }

    public void LlenarComboDoctor() {
        int t = institucion.TamañoMedico();
        for (int i = 0; i < t; i++) {
            Medico md = institucion.ObtenerMedico(i);
            cmbRAdoctores.addItem(md.getNombre() + " " + md.getApellido());
        }
    }

    public void filtro() {
        int campo = 0;
        if (cmbRAtipo.getSelectedIndex() == 1) {
            campo = 4;
        } else if (cmbRAtipo.getSelectedIndex() == 2) {
            campo = 1;
        } else if (cmbRAtipo.getSelectedIndex() == 3) {
            campo = 2;
        }
        tr.setRowFilter(RowFilter.regexFilter(txtRAbuscar.getText(), campo));
    }

    public void consultarTablaPacientes() {
        int fila = this.jtPacientes.getSelectedRow();
        txtRAdni.setText(this.jtPacientes.getValueAt(fila, 4).toString());
        txtRAnombre.setText(this.jtPacientes.getValueAt(fila, 1).toString());
        txtRAapellido.setText(this.jtPacientes.getValueAt(fila, 2).toString());
        txtRAcodHistorial.setText(this.jtPacientes.getValueAt(fila, 0).toString());
    }

    public void RegistrarAtenciones() {
        try {
            Object dat[] = {txtRAdni.getText(), txtRAnombre.getText() + " " + txtRAapellido.getText(), txtRAfecha.getText(), cmbRAdoctores.getSelectedItem()};
            Atencion at = new Atencion(Integer.parseInt(txtRAdni.getText()), txtRAnombre.getText(), txtRAfecha.getText(), cmbRAdoctores.getSelectedItem().toString());
            modelLA.addRow(dat);
            recepcionista.AgregarAtencion(at);
            JOptionPane.showMessageDialog(this, "Registro de Atencion Exitoso: " + txtRAnombre.getText() + " " + txtRAapellido.getText() + " el " + txtRAfecha.getText(), "Mensaje de Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
        }
        institucion.GrabarAtencion();
    }
    
    /*HISTORIAL CLINICO*/  
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
    public void consultarRegistroHC(){         
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
        jScrollPane7 = new javax.swing.JScrollPane();
        taRPtiposangre = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        taRPantecedente = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
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
        pnlListaPacientes = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaPacientes = new javax.swing.JTable();
        btnAgregarPaciente = new javax.swing.JLabel();
        btnEliminarPaciente = new javax.swing.JLabel();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 747, Short.MAX_VALUE)
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

        jXTaskPane1.setTitle("Pacientes");
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
            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        pnlFondoPrincipalLayout.setVerticalGroup(
            pnlFondoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        rSPanelsSlider1.add(pnlFondoPrincipal, "card6");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane7.setViewportView(taRPtiposangre);

        taRPantecedente.setColumns(20);
        taRPantecedente.setRows(5);
        jScrollPane8.setViewportView(taRPantecedente);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Antecedentes");

        javax.swing.GroupLayout pnlRegPacientesLayout = new javax.swing.GroupLayout(pnlRegPacientes);
        pnlRegPacientes.setLayout(pnlRegPacientesLayout);
        pnlRegPacientesLayout.setHorizontalGroup(
            pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlRegPacientesLayout.createSequentialGroup()
                                    .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                                        .addComponent(jScrollPane7))
                                    .addGap(36, 36, 36)
                                    .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane8)
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
                                    .addComponent(cmbRPsexo, 0, 133, Short.MAX_VALUE))
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
                .addContainerGap(164, Short.MAX_VALUE))
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
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRegPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        rSPanelsSlider1.add(pnlRegPacientes, "card3");

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

        txtRAnombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRAnombre.setEnabled(false);

        txtRAapellido.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRAapellido.setEnabled(false);

        cmbRAdoctores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Doctores" }));

        btnRAguardar.setBackground(new java.awt.Color(0, 204, 204));
        btnRAguardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRAguardar.setForeground(new java.awt.Color(0, 0, 0));
        btnRAguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/guardar.png"))); // NOI18N
        btnRAguardar.setText("Guardar");
        btnRAguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAguardarActionPerformed(evt);
            }
        });

        txtRAdni.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRAdni.setEnabled(false);

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

        txtRAcodHistorial.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRAcodHistorial.setEnabled(false);

        javax.swing.GroupLayout pnlRegAtencionLayout = new javax.swing.GroupLayout(pnlRegAtencion);
        pnlRegAtencion.setLayout(pnlRegAtencionLayout);
        pnlRegAtencionLayout.setHorizontalGroup(
            pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegAtencionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbRAtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRAbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(txtRAcodHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAdni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbRAdoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(btnRAguardar)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        pnlRegAtencionLayout.setVerticalGroup(
            pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegAtencionLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRAtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(pnlRegAtencionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRAdoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAdni, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRAcodHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnRAguardar)
                .addGap(32, 32, 32))
        );

        rSPanelsSlider1.add(pnlRegAtencion, "card4");

        pnlListaPacientes.setBackground(new java.awt.Color(255, 255, 255));
        pnlListaPacientes.setName("pnlListaPacientes"); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LISTA DE PACIENTES");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel4)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jtListaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtListaPacientes);

        btnAgregarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnAgregarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarPacienteMouseClicked(evt);
            }
        });

        btnEliminarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menos.png"))); // NOI18N
        btnEliminarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPacienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlListaPacientesLayout = new javax.swing.GroupLayout(pnlListaPacientes);
        pnlListaPacientes.setLayout(pnlListaPacientesLayout);
        pnlListaPacientesLayout.setHorizontalGroup(
            pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaPacientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarPaciente)
                    .addComponent(btnEliminarPaciente))
                .addGap(51, 51, 51))
        );
        pnlListaPacientesLayout.setVerticalGroup(
            pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaPacientesLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaPacientesLayout.createSequentialGroup()
                        .addComponent(btnAgregarPaciente)
                        .addGap(116, 116, 116)
                        .addComponent(btnEliminarPaciente)
                        .addGap(152, 152, 152)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlListaPacientes, "card6");

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
                .addContainerGap(431, Short.MAX_VALUE))
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
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtListaHC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(txtListaNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addContainerGap(647, Short.MAX_VALUE)
                        .addComponent(cmbLHCfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtHCbuscarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarHistoria)
                .addGap(83, 83, 83)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
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
                .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaHistoriaClinicaLayout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarHC1)
                    .addComponent(jButton4))
                .addGap(79, 79, 79))
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
                    .addComponent(txtListaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtListaHC))
                .addGap(18, 18, 18)
                .addGroup(pnlListaHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaHistoriaClinicaLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnLimpiarHC1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
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
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.GrabarPaciente();
        LimpiarRegistroPaciente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRAguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAguardarActionPerformed
        RegistrarAtenciones();
        limpiarRA();
    }//GEN-LAST:event_btnRAguardarActionPerformed

    private void txtRAbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRAbuscarKeyTyped
        txtRAbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = txtRAbuscar.getText();
                txtRAbuscar.setText(cadena);
                filtro();
            }
        });
        tr = new TableRowSorter(this.jtPacientes.getModel());
        jtPacientes.setRowSorter(tr);
    }//GEN-LAST:event_txtRAbuscarKeyTyped

    private void jtPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPacientesMouseClicked
        consultarTablaPacientes();
    }//GEN-LAST:event_jtPacientesMouseClicked

    private void imglogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imglogoMouseClicked
        rSPanelsSlider1.setPanelSlider(20, pnlFondoPrincipal, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_imglogoMouseClicked

    private void btnEliminarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPacienteMouseClicked
        ElminarPaciente();
    }//GEN-LAST:event_btnEliminarPacienteMouseClicked

    private void btnAgregarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPacienteMouseClicked
        rSPanelsSlider1.setPanelSlider(20, pnlRegPacientes, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_btnAgregarPacienteMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalRecepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarPaciente;
    private javax.swing.JLabel btnBuscarHistoria;
    private javax.swing.JLabel btnEliminarPaciente;
    private javax.swing.JLabel btnLimpiarHC1;
    private javax.swing.JButton btnRAguardar;
    private javax.swing.JComboBox<String> cmbLHCfiltro;
    private javax.swing.JComboBox<String> cmbRAdoctores;
    private javax.swing.JComboBox<String> cmbRAtipo;
    private javax.swing.JComboBox<String> cmbRPestadoC;
    private javax.swing.JComboBox<String> cmbRPnacionalidad;
    private javax.swing.JComboBox<String> cmbRPsexo;
    private javax.swing.JLabel imglogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JTable jtListaHC;
    private javax.swing.JTable jtListaPacientes;
    private javax.swing.JTable jtPacientes;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPanel pnlFondoPrincipal;
    private javax.swing.JPanel pnlListaHistoriaClinica;
    private javax.swing.JPanel pnlListaPacientes;
    private javax.swing.JPanel pnlRegAtencion;
    private javax.swing.JPanel pnlRegPacientes;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
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
    private javax.swing.JTextField txtHCbuscarHistorial;
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
    // End of variables declaration//GEN-END:variables
}
