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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin1
 */
public class verCandidatos extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
        private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String conocimientoscan, usuario, conocimientos, carnet,coche, viajar;
    private int experiencia;
    private int[] array_cont;
    private int[] array_cont2;
    private JLabel [] ofertas= new JLabel[20];
    private JButton [] botones= new JButton[20];
    private JButton  atras;
    private JLabel [] ofertas2= new JLabel[20];
    private JPanel panel_botones;
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public verCandidatos(String usuario, String conocimientos,int experiencia, String carnet, String coche, String viajar) {
        this.usuario=usuario;
        this.conocimientos=conocimientos;
        this.experiencia=experiencia;
        this.carnet=carnet;
        this.coche=coche;
        this.viajar=viajar;
        panel_botones=new JPanel();
        add(panel_botones, BorderLayout.CENTER);

        
        try {
            Statement ps=co.createStatement(); 
        
            PreparedStatement ps2 =  co.prepareStatement("SELECT COUNT(*) FROM curriculum_candidatos where años_experiencia>=? AND carnet_conducir LIKE ? AND coche_propio LIKE ? AND viajar LIKE ?"); 
        
            ps2.setInt(1, experiencia);
            ps2.setString(2, carnet);
            ps2.setString(3, coche);
            ps2.setString(4, viajar);
        
        PreparedStatement ps3 =  co.prepareStatement("SELECT * FROM curriculum_candidatos where años_experiencia>=? AND carnet_conducir LIKE ? AND coche_propio LIKE ? AND viajar LIKE ?"); 
        ps3.setInt(1,experiencia);
        ps3.setString(2, carnet);
        ps3.setString(3, coche);
        ps3.setString(4, viajar);
        ResultSet rs=ps3.executeQuery();
        ResultSet rs2=ps2.executeQuery();
        String[] array_conocimientosemp = conocimientos.split("\\s*,\\s*");
        
        int contador=0;
            int i=0;
            while(rs2.next()){
                contador=rs2.getInt(1);
            }
            System.out.println(contador);
            while(rs.next()){
                    conocimientoscan=rs.getString(8);
                    String[] array_conocimientoscan = conocimientoscan.split("\\s*,\\s*");
                int y=0;
                if(rs.getInt(10)>=experiencia){
                    array_cont=new int[array_conocimientosemp.length];
                    array_cont2=new int[array_conocimientosemp.length];
                    for (int j=0;j<array_conocimientosemp.length;j++){
                            if (conocimientoscan.contains(array_conocimientosemp[j])){
                                array_cont[j]++;
                            }
                            
                            System.out.println("cosa numero"+(j+1)+"  "+array_conocimientosemp[j]+"   cont:"+array_cont[y]+"/"+array_conocimientoscan.length);
                            System.out.println(j);
                        }

                    }
                    ofertas[i]=new JLabel();
                    ofertas[i].setText(rs.getString(4));
                    ofertas2[i]=new JLabel();
                    ofertas2[i].setText("%"+(array_cont[y]*100)/array_conocimientoscan.length);
                    i++;
                y++;
                }
            System.out.println("aaaaaaaaaaaa"+contador);
                    
        setSize(500, contador*45+50);
        panel_botones.setLayout(new GridLayout(contador,3));
            for (int j=0;j<contador;j++){
                panel_botones.add(ofertas[j]);
                panel_botones.add(ofertas2[j]);
                botones[j]=new JButton("Perfil de candidato");
                panel_botones.add(botones[j]);
            }
            for (int j=0;j<contador;j++){
            botones[j].addActionListener(this);
        }

        atras=new JButton("Atras");
        atras.setBounds(20, contador*40, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

            
            
        } catch (SQLException ex) {
            Logger.getLogger(verCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         buscarcandidatos p=new buscarcandidatos(usuario);
         p.setVisible(true);
         this.dispose();
         
         }
        else{
        for (int i=0;i<botones.length;i++){
            if (ae.getSource()==botones[i]){
                System.out.println(ofertas[i].getText());
                String nombre=ofertas[i].getText();
                Statement stm;
                try {
                    stm = co.createStatement();
                    
                    ResultSet rs = stm.executeQuery("SELECT nombreusu FROM curriculum_candidatos where nombre='"+nombre+"'");
                    String nombreusu="";
                    while(rs.next()){
                        nombreusu=rs.getString(1);
                    }
                    System.out.println(nombreusu);
                    candidatoperfil v = new candidatoperfil(usuario, conocimientos, experiencia, carnet, coche, viajar);
                    v.setVisible(true);
                    this.dispose();//Cierra la ventana en la que estas actualmente.
                } catch (SQLException ex) {
                    Logger.getLogger(verOfertas.class.getName()).log(Level.SEVERE, null, ex);
                }

        
    }
        }
        }
    }
}
