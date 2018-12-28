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
public class analizarSolicitudes extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private JButton aceptar, atras;
    private JPanel panel_botones;
    private JLabel [] ofertas= new JLabel[20];
    private JLabel [] contadores= new JLabel[20];
    private JButton [] botones= new JButton[20];
    private conexion mysql=new conexion();
    private Connection co=mysql.conectar();
    private String nombre_oferta, CIF, usuario;
    private int contador;
    public static void main(String[] args) {
    }

    public analizarSolicitudes(String CIF, String usuario) {
        this.CIF=CIF;
        this.usuario=usuario;
        setTitle("Ofertas");
        pack();
        setResizable(false);
        setBounds(50, 100, 750, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        panel_botones.setLayout(new GridLayout(4,3));
        add(panel_botones);


        String SSQL="SELECT * FROM ofertas_empleo where CIF='"+CIF+"'";
        try {
            Statement stm;
            stm = co.createStatement();
            ResultSet rs = stm.executeQuery(SSQL);
            int i=0;
            while(rs.next()){
                ofertas[i]=new JLabel();
                ofertas[i].setText(rs.getString(2));
                i++;
            }
            for (int j=0;j<3;j++){
                panel_botones.add(ofertas[j]);
                stm = co.createStatement();
                         nombre_oferta=ofertas[j].getText();
           
                ResultSet rs1 = stm.executeQuery("SELECT codigo_oferta FROM ofertas_empleo WHERE titulo_oferta='"+nombre_oferta+"'");
                    int id=0;
                    while(rs1.next()){
                        id=rs1.getInt(1);
                    }
                String SSQL3="SELECT COUNT(DISTINCT DNI) FROM solicitar where codoferta='"+id+"'";
            try{
                stm = co.createStatement();
                ResultSet rs3 = stm.executeQuery(SSQL3);
                while (rs3.next()){
                    contador=rs3.getInt(1);
                }
                contadores[j]=new JLabel();
                contadores[j].setText("Número de solicitudes recibidas:"+contador);
                panel_botones.add(contadores[j]);
            }catch (SQLException ex) {
            Logger.getLogger(analizarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
                botones[j]=new JButton("Mirar solicitudes");
                panel_botones.add(botones[j]);
                
            }
            for (int j=0;j<1;j++){
            botones[j].addActionListener(this);
        }

                } catch (SQLException ex) {
            Logger.getLogger(analizarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         empresa p=new empresa(usuario);
         p.setVisible(true);
         this.dispose();
         
         }
        else{

        for (int i=0;i<botones.length;i++){
            if (ae.getSource()==botones[i]){
                nombre_oferta=ofertas[i].getText();
                            Statement stm;
                try {
                    stm = co.createStatement();
                    
                    ResultSet rs = stm.executeQuery("SELECT codigo_oferta FROM ofertas_empleo WHERE titulo_oferta='"+nombre_oferta+"'");
                    int id=0;
                    while(rs.next()){
                        id=rs.getInt(1);
                    }
                    
                    //Abre la ventana para ver la oferta mas detallada.
                    verSolicitudes v = new verSolicitudes(id, CIF, usuario);
                    v.setVisible(true);
                    this.dispose();//Cierra la ventana en la que estas actualmente.
                } catch (SQLException ex) {
                    Logger.getLogger(analizarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
    }
    
    }
}
}
