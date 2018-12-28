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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin1
 */
public class SolicitudesEmitidas extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
        private JButton aceptar, atras;
        private String usuario="";
    private JPanel panel_botones;
    private        JLabel [] ofertas= new JLabel[20];
    private        JButton [] botones= new JButton[20];
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombre_oferta;
    public static void main(String[] args) {
        SolicitudesEmitidas a= new SolicitudesEmitidas("");
        a.pack();
        a.setVisible(true);
    }
    
    public SolicitudesEmitidas(String usuario){
        this.usuario=usuario;
        setTitle("Ofertas");
        setBounds(50, 100, 200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        panel_botones.setLayout(new GridLayout(5,3));
        add(panel_botones);
        String SSQL="SELECT * FROM curriculum_candidatos WHERE nombreusu='"+usuario+"'";
            String dni="";
        try {
            
            Statement stm;
            stm = co.createStatement();
            ResultSet rs = stm.executeQuery(SSQL);
            while(rs.next()){
                dni=rs.getString(1);
            }
            }catch (SQLException ex) {
            Logger.getLogger(IniciarSesionCan.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String SSQL2="SELECT * FROM ofertas_empleo where codigo_oferta LIKE(select distinct codoferta from solicitar WHERE dni='"+dni+"')";
            Statement stm;
            stm = co.createStatement();
            ResultSet rs = stm.executeQuery(SSQL2);
            int i=0;
            while(rs.next()){
                ofertas[i]=new JLabel();
                ofertas[i].setText(rs.getString(2));
                i++;
            }
            for (int j=0;j<1;j++){
                panel_botones.add(ofertas[j]);
                botones[j]=new JButton("Mirar oferta");
                panel_botones.add(botones[j]);
                
            }
            for (int j=0;j<1;j++){
            botones[j].addActionListener(this);
        }

                } catch (SQLException ex) {
            Logger.getLogger(IniciarSesionCan.class.getName()).log(Level.SEVERE, null, ex);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         candidato p=new candidato(usuario);
         p.setVisible(true);
         this.dispose();
         
         }

        for (int i=0;i<botones.length;i++){
            if (ae.getSource()==botones[i]){
                System.out.println(ofertas[i].getText());
                nombre_oferta=ofertas[i].getText();
                            Statement stm;
                try {
                    stm = co.createStatement();
                    
                    ResultSet rs = stm.executeQuery("SELECT codigo_oferta FROM ofertas_empleo where titulo_oferta='"+nombre_oferta+"'");
                    int id=0;
                    while(rs.next()){
                        id=rs.getInt(1);
                    }
                    
                    //Abre la ventana para ver la oferta mas detallada.
                    VerOferta v = new VerOferta(id, usuario, null, null, null, null, 0, 0, null);
                    v.setVisible(true);
                    this.dispose();//Cierra la ventana en la que estas actualmente.
                } catch (SQLException ex) {
                    Logger.getLogger(SolicitudesEmitidas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}