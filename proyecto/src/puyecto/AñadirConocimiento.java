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
import javax.swing.JTextField;

/**
 *
 * @author admin1
 */
public class AñadirConocimiento extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private String usuario, cif;
    private JButton atras, añadir;
    private JTextField nombretext;
    private JLabel nombre;
    private conexion mysql=new conexion();
    private Connection co=mysql.conectar();

    public static void main(String[] args) {
        // TODO code application logic here
        
    }

    public AñadirConocimiento(String cif, String usuario) {
        this.usuario=usuario;
        this.cif=cif;
          setLayout(null);
      setTitle("Añadir conocimiento");
        setBounds(50, 100, 230, 190);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        nombre= new JLabel("Nombre:");
        nombretext= new JTextField();
        atras=new JButton("Atrás");
        añadir=new JButton("Añadir");
        nombre.setBounds(20, 20, 50, 30);
        nombretext.setBounds(100, 20, 100, 30);
        añadir.setBounds(120, 100, 80, 30);
        atras.setBounds(20, 100, 80, 30);
        add(nombre);
        add(nombretext);
        add(añadir);
        add(atras);
        atras.addActionListener(this);
        añadir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
            this.dispose();
        }
        else if (ae.getSource()==añadir){
            String nombre=nombretext.getText();
            int m=0;
                try {
                    String sql="INSERT INTO conocimientos (nombre)"+
                "VALUES(?)";
                PreparedStatement psp2 =co.prepareStatement(sql);
                psp2.setString(1, nombre);
                m=psp2.executeUpdate();
                if (m>0){
                    System.out.println("aaaaaaaa");
                }
                    System.out.println(nombre);
                    this.dispose();

                    //Abre la ventana para ver la oferta mas detallada.
                } catch (SQLException ex) {
                    Logger.getLogger(SolicitudesEmitidas.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }
    
}
