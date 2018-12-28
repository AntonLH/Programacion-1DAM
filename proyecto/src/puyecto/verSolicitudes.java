/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author admin1
 */
public class verSolicitudes extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private JButton atras;
    private JPanel grid;
        private conexion mysql=new conexion();
    private Connection co=mysql.conectar();
    private int contador, numcandidatos;
    private String nombre, email, telefono;
    private Statement stm;
    private JLabel[] candidatos;
    private JLabel[] candidatostel;
    private JLabel[] candidatosemail;
    private JButton[] botones;
    private JPanel datos_candidato;
    private int id;
    private String CIF, nombreusu;
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public verSolicitudes(int id, String CIF, String nombreusu) {
        this.id=id;
        this.CIF=CIF;
        this.nombreusu=nombreusu;
        //setResizable(false);
        setBounds(50, 100, 450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        grid=new JPanel();
        add(grid, BorderLayout.CENTER);
        /*JScrollPane scroll = new JScrollPane(grid);
        add(scroll);
        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);*/
        try {
                stm = co.createStatement();
                ResultSet rs2 = stm.executeQuery("SELECT count(distinct email) FROM solicitar where codoferta='"+id+"'");
                while(rs2.next()){
                    numcandidatos=rs2.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(verSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }
        grid.setLayout(new GridLayout(numcandidatos,1));
        candidatos=new JLabel[numcandidatos];
        candidatosemail=new JLabel[numcandidatos];
        candidatostel=new JLabel[numcandidatos];
        botones=new JButton[numcandidatos];
        int i=0,j=0;
        try{
                Statement stm2 = co.createStatement();

                ResultSet rs = stm.executeQuery("SELECT distinct email, telefono FROM solicitar where codoferta='"+id+"'");
                while (rs.next()){
                    email=rs.getString(1);
                    candidatosemail[i]=new JLabel("Email:  "+rs.getString(1));
                    candidatostel[i]=new JLabel("Telefono:  "+rs.getString(2));
                    ResultSet rs2 = stm2.executeQuery("SELECT nombre FROM curriculum_candidatos where email='"+email+"'");
                    while (rs2.next()){
                        nombre=rs2.getString(1);
                        candidatos[j]=new JLabel();
                        candidatos[j].setText(nombre);
                        j++;
                    }
                    i++;
                }
            }catch (SQLException ex) {
            Logger.getLogger(analizarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        for (int x=0;x<numcandidatos;x++){
            datos_candidato=new JPanel();
            datos_candidato.setLayout(null);
            
            datos_candidato.add(candidatos[x]);
            candidatos[x].setBounds(20, 20, 200, 50);
            datos_candidato.add(candidatosemail[x]);
            candidatosemail[x].setBounds(20, 70, 200, 50);
            datos_candidato.add(candidatostel[x]);
            candidatostel[x].setBounds(20, 120, 200, 50);
            botones[x]=new JButton("Ver perfil completo");

            datos_candidato.add(botones[x]);
            botones[x].setBounds(220, 60, 200, 50);
            grid.add(datos_candidato);
            botones[x].addActionListener(this);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario;
        if (ae.getSource()==atras){
         analizarSolicitudes p=new analizarSolicitudes(CIF, nombreusu);
         p.setVisible(true);
         this.dispose();
         
         }
        else{
         for (int i=0;i<botones.length;i++){
            if (ae.getSource()==botones[i]){
                usuario=candidatos[i].getText();
                    //Abre la ventana para ver la oferta mas detallada.
                        perfilCandidato v = new perfilCandidato(usuario, id, CIF);
                    v.setVisible(true);
                    this.dispose();//Cierra la ventana en la que estas actualmente.

            }
        }
        }
    
}
}
