/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;

import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author admin1
 */
public class VerOferta extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private int id;
    private String nombreusu;
        private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String titulo, descripcion, lugar, tipo, experiencia,  conocimientos, aspectos_valorar, aspectos_imprescindibles, nombre, cif, email;
    private int sueldo_min,sueldo_max, telefono;
    
    JLabel titulolabel, descripcionlabel, lugarlabel, 
           tipolabel, experiencialabel,  conocimientoslabel, 
           aspectos_valorarlabel, aspectos_imprescindibleslabel, 
           nombrelabel, ciflabel, emaillabel, sueldominlabel, sueldomaxlabel, telefonolabel;
    
    JLabel titulolabel1, lugarlabel1, 
           tipolabel1, experiencialabel1,   
           nombrelabel1, ciflabel1, emaillabel1, sueldominlabel1, sueldomaxlabel1, telefonolabel1;
    
    JTextArea descripciontext, conocimientostext, taspectos_valorartext, aspectos_imprescindiblestext; 
    
    JButton atras, inscribirse;
    
    private String titulo2, lugar2, tipo2, empresa2,  conocimientos2;
    private int sueldo2, experiencia2;

    
    
    
    
    
    public static void main(String[] args) {
        VerOferta a= new VerOferta(0, null, null, null, null, null, 0, 0, null);
        a.setLayout(null);
        a.setVisible(true);
    }
    public VerOferta(int id, String usuario, String titulo2, String lugar2, String tipo2, String empresa2, int sueldo2, int experiencia2, String conocimientos2){
        this.id=id;
        this.nombreusu=usuario;
        this.titulo2=titulo2;
        this.lugar2=lugar2;
        this.tipo2=tipo2;
        this.empresa2=empresa2;
        this.sueldo2=sueldo2;
        this.experiencia2=experiencia2;
        this.conocimientos2=conocimientos2;

        setTitle("Oferta de empleo");
        setLayout(null);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String SSQL="SELECT * FROM ofertas_empleo where codigo_oferta='"+id+"'";

        try {
            Statement stm;
            stm = co.createStatement();
            ResultSet rs = stm.executeQuery(SSQL);
            int i=0;
            while(rs.next()){
                titulo=rs.getString(2);
                descripcion=rs.getString(3);
                lugar=rs.getString(4);
                tipo=rs.getString(5);
                sueldo_max=rs.getInt(6);
                sueldo_min=rs.getInt(7);
                experiencia=rs.getString(8);
                conocimientos=rs.getString(9);
                aspectos_valorar=rs.getString(10);
                aspectos_imprescindibles=rs.getString(11);
                nombre=rs.getString(13);
                cif=rs.getString(14);
                telefono=rs.getInt(15);
                email=rs.getString(16);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VerOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        titulolabel = new JLabel();
        titulolabel.setText("Nombre:");
        titulolabel.setBounds(30,25,120,20);
        add(titulolabel);
        
        titulolabel1 = new JLabel();
        titulolabel1.setText(titulo);
        titulolabel1.setBounds(190,25,120,20);
        add(titulolabel1);
        
        descripcionlabel = new JLabel();
        descripcionlabel.setText("Descripcion:");
        descripcionlabel.setBounds(30,65,120,20);
        add(descripcionlabel);
        
        descripciontext = new JTextArea();
        descripciontext.setText(descripcion);
        descripciontext.setBounds(190,65,300,60);
        descripciontext.setEditable(false);
        add(descripciontext);
        
        lugarlabel = new JLabel();
        lugarlabel.setText("Lugar:");
        lugarlabel.setBounds(30,145,120,20);
        add(lugarlabel);
        
        lugarlabel1 = new JLabel();
        lugarlabel1.setText(lugar);
        lugarlabel1.setBounds(190,145,120,20);
        add(lugarlabel1);
        
        tipolabel = new JLabel();
        tipolabel .setText("Tipo de Contrato:");
        tipolabel .setBounds(30,185,120,20);
        add(tipolabel );
        
        tipolabel1  = new JLabel();
        tipolabel1.setText(tipo);
        tipolabel1.setBounds(190,185,320,20);
        add(tipolabel1);
        
        experiencialabel = new JLabel();
        experiencialabel .setText("Experiencia:");
        experiencialabel .setBounds(30,225,120,20);
        add(experiencialabel );
        
        experiencialabel1  = new JLabel();
        experiencialabel1.setText(experiencia);
        experiencialabel1.setBounds(190,225,120,20);
        add(experiencialabel1);
        
        conocimientoslabel = new JLabel();
        conocimientoslabel .setText("Conocimientos:");
        conocimientoslabel .setBounds(30,265,120,20);
        add(conocimientoslabel );
        
        conocimientostext  = new JTextArea();
        conocimientostext.setText(conocimientos);
        conocimientostext.setBounds(190,265,200,40);
        conocimientostext.setEditable(false);
        add(conocimientostext);
        
        aspectos_valorarlabel = new JLabel();
        aspectos_valorarlabel .setText("Aspectos a valorar:");
        aspectos_valorarlabel .setBounds(30,325,120,20);
        add(aspectos_valorarlabel );
        
        taspectos_valorartext  = new JTextArea();
        taspectos_valorartext.setText(aspectos_valorar);
        taspectos_valorartext.setBounds(190,325,200,40);
        taspectos_valorartext.setEditable(false);
        add(taspectos_valorartext);
        
        
        aspectos_imprescindibleslabel = new JLabel();
        aspectos_imprescindibleslabel .setText("Aspectos imprescindibles:");
        aspectos_imprescindibleslabel .setBounds(30,385,155,20);
        add(aspectos_imprescindibleslabel );
        
        aspectos_imprescindiblestext  = new JTextArea();
        aspectos_imprescindiblestext.setText(aspectos_imprescindibles);
        aspectos_imprescindiblestext.setEditable(false);
        aspectos_imprescindiblestext.setBounds(190,385,200,40);
        add(aspectos_imprescindiblestext);        
        
        sueldominlabel = new JLabel();
        sueldominlabel .setText("Sueldo minimo:");
        sueldominlabel .setBounds(30,445,120,20);
        add(sueldominlabel );
        
        sueldominlabel1  = new JLabel();
        sueldominlabel1.setText(""+sueldo_min+"€");
        sueldominlabel1.setBounds(190,445,120,20);
        add(sueldominlabel1);
        
        sueldomaxlabel = new JLabel();
        sueldomaxlabel .setText("Sueldo maximo:");
        sueldomaxlabel .setBounds(270,445,120,20);
        add(sueldomaxlabel );
        
        sueldomaxlabel1  = new JLabel();
        sueldomaxlabel1.setText(""+sueldo_max+"€");
        sueldomaxlabel1.setBounds(410,445,120,20);
        add(sueldomaxlabel1);
        
        nombrelabel = new JLabel();
        nombrelabel .setText("Empresa:");
        nombrelabel .setBounds(30,485,120,20);
        add(nombrelabel );
        
        nombrelabel1  = new JLabel();
        nombrelabel1.setText(nombre);
        nombrelabel1.setBounds(190,485,120,20);
        add(nombrelabel1);
        
        ciflabel = new JLabel();
        ciflabel .setText("CIF:");
        ciflabel .setBounds(30,525,120,20);
        add(ciflabel );
        
        ciflabel1  = new JLabel();
        ciflabel1.setText(cif);
        ciflabel1.setBounds(190,525,120,20);
        add(ciflabel1);
        
        emaillabel = new JLabel();
        emaillabel .setText("Email:");
        emaillabel .setBounds(30,565,120,20);
        add(emaillabel );
        
        emaillabel1  = new JLabel();
        emaillabel1.setText(email);
        emaillabel1.setBounds(190,565,120,20);
        add(emaillabel1);
        
        telefonolabel = new JLabel();
        telefonolabel .setText("Telefono:");
        telefonolabel .setBounds(30,605,120,20);
        add(telefonolabel );
        
        telefonolabel  = new JLabel();
        telefonolabel.setText(""+telefono);
        telefonolabel.setBounds(190,605,120,20);
        add(telefonolabel);
        
        atras  = new JButton();
        atras.setText("Atras");
        atras.setBounds(220,640,90,40);
        add(atras);
        atras.addActionListener(this);
        
        inscribirse  = new JButton();
        inscribirse.setText("Inscribirse");
        inscribirse.setBounds(340,640,120,40);
        add(inscribirse);
        inscribirse.addActionListener(this);
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==inscribirse){
        String dni="", email2="";
        int telefono2=0;
         mysql=new conexion();
        co=mysql.conectar();
        String sentencia="SELECT * FROM curriculum_candidatos WHERE nombreusu='"+nombreusu+"'";
        try {
            Statement stm;
            stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            int i=0;
            while(rs.next()){
               dni=rs.getString(1);
               telefono2=rs.getInt(2);
               email2=rs.getString(3);
            }
        } catch (SQLException ex) {
        }
        
        
        
        
               String sentenciaSQL2;
        sentenciaSQL2="INSERT INTO solicitar (codsolicitud, codoferta,DNI,telefono,email)"+
                "VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement psp2 =co.prepareStatement(sentenciaSQL2);
            psp2.setString(1, null);
            psp2.setInt(2, id);
            psp2.setString(3, dni);
            psp2.setInt(4, telefono2);
            psp2.setString(5, email2);
            psp2.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarseCan.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            JOptionPane.showMessageDialog(null, "Inscrito correctamente");

        }
        else if (ae.getSource()==atras){
                verOfertas f = new verOfertas(nombreusu, titulo2, lugar2, tipo2, empresa2, sueldo2, experiencia2, conocimientos2);
                f.setVisible(true);
                this.dispose();

        }
    }



}

