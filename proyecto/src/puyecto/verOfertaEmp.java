/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;

import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author admin1
 */
public class verOfertaEmp extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombreusu, titulo, descripcion, lugar, tipo, experiencia,  conocimientos, aspectos_valorar, aspectos_imprescindibles, nombre, cif, email;
    private int sueldo_min,sueldo_max, telefono;
    
    JLabel titulolabel, descripcionlabel, lugarlabel, 
           tipolabel, experiencialabel,  conocimientoslabel, 
           aspectos_valorarlabel, aspectos_imprescindibleslabel, 
           nombrelabel, ciflabel, emaillabel, sueldominlabel, sueldomaxlabel,  telefonolabel;
    
    JLabel titulolabel1, lugarlabel1, 
           tipolabel1, experiencialabel1,  conocimientoslabel1, 
           aspectos_valorarlabel1, aspectos_imprescindibleslabel1, 
           nombrelabel1, ciflabel1, emaillabel1, sueldominlabel1, sueldomaxlabel1;
    
    JTextArea descripciontext, conocimientostext, taspectos_valorartext, aspectos_imprescindiblestext; 
    
    JButton atras, inscribirse;
    
    public verOfertaEmp(int id, String nombreusu) {
        this.nombreusu=nombreusu;
        System.out.println(id);
        setTitle("Oferta de empleo");
        setLayout(null);
        setBounds(50, 100, 500, 500);
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
            Logger.getLogger(IniciarSesionCan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         titulolabel = new JLabel();
        titulolabel.setText("Nombre:");
        titulolabel.setBounds(30,30,120,20);
        add(titulolabel);
        
        titulolabel1 = new JLabel();
        titulolabel1.setText(titulo);
        titulolabel1.setBounds(190,30,120,20);
        add(titulolabel1);
        
        descripcionlabel = new JLabel();
        descripcionlabel.setText("Descripcion:");
        descripcionlabel.setBounds(30,70,120,20);
        add(descripcionlabel);
        
        descripciontext = new JTextArea();
        descripciontext.setText(descripcion);
        descripciontext.setBounds(190,70,300,60);
        descripciontext.setEditable(false);
        add(descripciontext);
        
        lugarlabel = new JLabel();
        lugarlabel.setText("Lugar:");
        lugarlabel.setBounds(30,150,120,20);
        add(lugarlabel);
        
        lugarlabel1 = new JLabel();
        lugarlabel1.setText(lugar);
        lugarlabel1.setBounds(190,150,120,20);
        add(lugarlabel1);
        
        tipolabel = new JLabel();
        tipolabel .setText("Tipo de Contrato:");
        tipolabel .setBounds(30,190,120,20);
        add(tipolabel );
        
        tipolabel1  = new JLabel();
        tipolabel1.setText(tipo);
        tipolabel1.setBounds(190,190,120,20);
        add(tipolabel1);
        
        experiencialabel = new JLabel();
        experiencialabel .setText("Experiencia:");
        experiencialabel .setBounds(30,230,120,20);
        add(experiencialabel );
        
        experiencialabel1  = new JLabel();
        experiencialabel1.setText(experiencia);
        experiencialabel1.setBounds(190,230,120,20);
        add(experiencialabel1);
        
        conocimientoslabel = new JLabel();
        conocimientoslabel .setText("Conocimientos:");
        conocimientoslabel .setBounds(30,270,120,20);
        add(conocimientoslabel );
        
        conocimientostext  = new JTextArea();
        conocimientostext.setText(conocimientos);
        conocimientostext.setBounds(190,270,200,40);
        conocimientostext.setEditable(false);
        add(conocimientostext);
        
        aspectos_valorarlabel = new JLabel();
        aspectos_valorarlabel .setText("Aspectos a valorar:");
        aspectos_valorarlabel .setBounds(30,330,120,20);
        add(aspectos_valorarlabel );
        
        taspectos_valorartext  = new JTextArea();
        taspectos_valorartext.setText(aspectos_valorar);
        taspectos_valorartext.setBounds(190,330,200,40);
        taspectos_valorartext.setEditable(false);
        add(taspectos_valorartext);
        
        
        aspectos_imprescindibleslabel = new JLabel();
        aspectos_imprescindibleslabel .setText("Aspectos imprescindibles:");
        aspectos_imprescindibleslabel .setBounds(30,390,155,20);
        add(aspectos_imprescindibleslabel );
        
        aspectos_imprescindiblestext  = new JTextArea();
        aspectos_imprescindiblestext.setText(aspectos_imprescindibles);
        aspectos_imprescindiblestext.setBounds(190,390,200,40);
        aspectos_imprescindiblestext.setEditable(false);
        add(aspectos_imprescindiblestext);        
        
        sueldominlabel = new JLabel();
        sueldominlabel .setText("Sueldo minimo:");
        sueldominlabel .setBounds(30,450,120,20);
        add(sueldominlabel );
        
        sueldominlabel1  = new JLabel();
        sueldominlabel1.setText(""+sueldo_min+"€");
        sueldominlabel1.setBounds(190,450,120,20);
        add(sueldominlabel1);
        
        sueldomaxlabel = new JLabel();
        sueldomaxlabel .setText("Sueldo maximo:");
        sueldomaxlabel .setBounds(270,450,120,20);
        add(sueldomaxlabel );
        
        sueldomaxlabel1  = new JLabel();
        sueldomaxlabel1.setText(""+sueldo_max+"€");
        sueldomaxlabel1.setBounds(410,450,120,20);
        add(sueldomaxlabel1);
        
        nombrelabel = new JLabel();
        nombrelabel .setText("Empresa:");
        nombrelabel .setBounds(30,490,120,20);
        add(nombrelabel );
        
        nombrelabel1  = new JLabel();
        nombrelabel1.setText(nombre);
        nombrelabel1.setBounds(190,490,120,20);
        add(nombrelabel1);
        
        ciflabel = new JLabel();
        ciflabel .setText("CIF:");
        ciflabel .setBounds(30,530,120,20);
        add(ciflabel );
        
        ciflabel1  = new JLabel();
        ciflabel1.setText(cif);
        ciflabel1.setBounds(190,530,120,20);
        add(ciflabel1);
        
        emaillabel = new JLabel();
        emaillabel .setText("Email:");
        emaillabel .setBounds(30,570,120,20);
        add(emaillabel );
        
        emaillabel1  = new JLabel();
        emaillabel1.setText(email);
        emaillabel1.setBounds(190,570,120,20);
        add(emaillabel1);
        
        telefonolabel = new JLabel();
        telefonolabel .setText("Telefono:");
        telefonolabel .setBounds(30,610,120,20);
        add(telefonolabel );
        
        telefonolabel  = new JLabel();
        telefonolabel.setText(""+telefono);
        telefonolabel.setBounds(190,610,120,20);
        add(telefonolabel);
        
        atras  = new JButton();
        atras.setText("Atras");
        atras.setBounds(220,650,90,40);
        add(atras);
        atras.addActionListener(this);
        
        inscribirse  = new JButton();
        inscribirse.setText("Retirada");
        inscribirse.setBounds(340,650,90,40);
        add(inscribirse);
        inscribirse.addActionListener(this);
    }
    
    
    
    
    
    public static void main(String[] args) {
        verOfertaEmp a= new verOfertaEmp(0,"");
        a.setLayout(null);
        a.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == atras){
            System.out.println("aaaa");
            con_oferta v = new con_oferta(cif, nombreusu);
            v.setVisible(true);
            this.dispose();
        }
        else if(ae.getSource() == inscribirse){
            System.out.println("hothiortjhiortjh");
        }
    }
    

    }
    

