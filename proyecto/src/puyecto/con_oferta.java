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
public class con_oferta extends JFrame implements ActionListener {
    
    private JButton aceptar, atras;
    private JPanel panel_botones;
    private        JLabel [] ofertas= new JLabel[20];
    private        JButton [] botones= new JButton[20];
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombre_oferta, nombreusu;
    public static void main(String[] args) {
        con_oferta a= new con_oferta("","");
        a.setLayout(null);
        a.setVisible(true);
    }
    
    public con_oferta(String CIF, String nombreusu){
        this.nombreusu=nombreusu;
    
        setTitle("Ofertas");
        //setLayout(null);
        setBounds(50, 100, 200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        panel_botones.setLayout(new GridLayout(5,3));
        add(panel_botones);


        String SSQL="SELECT * FROM ofertas_empleo where CIF='"+CIF+"'";
        int cont=0;
        
        //cuenta el numero de ofertas que existen con el codigo CIF de la empresa registrada
        try {
                Statement stm1 = co.createStatement();
                ResultSet rs = stm1.executeQuery("SELECT COUNT(codigo_oferta) FROM ofertas_empleo WHERE CIF='"+CIF+"'");
                while(rs.next()){
                    if(rs.getInt(1)!=0){
                        cont = rs.getInt(1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
            for (int j=0;j<cont;j++){
                panel_botones.add(ofertas[j]);
                botones[j]=new JButton("Mirar oferta");
                panel_botones.add(botones[j]);
                
            }
            for (int j=0;j<cont;j++){
            botones[j].addActionListener(this);
        }

                } catch (SQLException ex) {
            Logger.getLogger(con_oferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         empresa p=new empresa(nombreusu);
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
                    verOfertaEmp v = new verOfertaEmp(id, nombreusu);
                    v.setVisible(true);
                    this.dispose();//Cierra la ventana en la que estas actualmente.
                } catch (SQLException ex) {
                    Logger.getLogger(con_oferta.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
}

