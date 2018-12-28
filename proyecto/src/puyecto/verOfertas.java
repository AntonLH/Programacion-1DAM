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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin1
 */
public class verOfertas extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
        private JButton aceptar, atras;
        private String usuario="", titulo, lugar, tipo, empresa, conocimiento;
    private int sueldo, experiencia;
    private JPanel panel_botones;
    private        JLabel [] ofertas= new JLabel[20];
    private        JButton [] botones= new JButton[20];
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombre_oferta;
    public static void main(String[] args) {
        verOfertas a= new verOfertas(null, null, null, null, null, 0, 0, null);
        a.pack();
        a.setVisible(true);
    }
    public verOfertas(String usuario, String titulo, String lugar, String tipo, String empresa, int sueldo, int experiencia, String conocimientos){
        this.titulo=titulo;
        this.lugar=lugar;
        this.tipo=tipo;
        this.empresa=empresa;
        this.sueldo=sueldo;
        this.experiencia=experiencia;
        this.conocimiento=conocimientos;
        this.usuario=usuario;
        setTitle("Ofertas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        add(panel_botones, BorderLayout.CENTER);


        try {
            titulo=titulo.replace("%", "!%");
            lugar=lugar.replace("%", "!%");
            tipo=tipo.replace("%", "!%");
            empresa=empresa.replace("%", "!%");
            conocimientos=conocimientos.replace("%", "!%");

        Statement ps=co.createStatement(); 
        PreparedStatement ps2 =  co.prepareStatement("SELECT COUNT(*) FROM ofertas_empleo where titulo_oferta LIKE ? AND lugar_trabajo LIKE ? AND tipo_contrato LIKE ? AND nombre LIKE ? AND sueldo_maximo>? AND experiencia_requerida<=? AND conocimientos LIKE ?"); 
        ps2.setString(1, "%" + titulo + "%");
        ps2.setString(2, "%" + lugar + "%");
        ps2.setString(3, "%" + tipo + "%");
            System.out.println(tipo);
        ps2.setString(4, "%" + empresa + "%");
        ps2.setInt(5, sueldo);
        ps2.setInt(6, experiencia);
        ps2.setString(7, "%" + conocimiento + "%");
            System.out.println(conocimiento);
        PreparedStatement ps3 =  co.prepareStatement("SELECT * FROM ofertas_empleo where titulo_oferta LIKE ? AND lugar_trabajo LIKE ? AND tipo_contrato LIKE ? AND nombre LIKE ? AND sueldo_maximo>? AND experiencia_requerida<=? AND conocimientos LIKE ?"); 
        ps3.setString(1, "%" + titulo + "%");
        ps3.setString(2, "%" + lugar + "%");
        ps3.setString(3, "%" + tipo + "%");
        ps3.setString(4, "%" + empresa + "%");
        ps3.setInt(5, sueldo);
        ps3.setInt(6, experiencia);
        ps3.setString(7, "%" + conocimientos + "%");
        ResultSet rs=ps3.executeQuery();
        ResultSet rs2=ps2.executeQuery();
        
        int contador=0;
            int i=0;
            while(rs2.next()){
                contador=rs2.getInt(1);
            }
            System.out.println(contador);
            while(rs.next()){
                ofertas[i]=new JLabel();
                ofertas[i].setText(rs.getString(2));
                i++;
            }
            setSize(500, contador*40+30);
            setLocationRelativeTo(null);
        

        panel_botones.setLayout(new GridLayout(contador,2));
            for (int j=0;j<contador;j++){
                panel_botones.add(ofertas[j]);
                botones[j]=new JButton("Mirar oferta");
                panel_botones.add(botones[j]);
                
            }
            for (int j=0;j<contador;j++){
            botones[j].addActionListener(this);
        }

                } catch (SQLException ex) {
            Logger.getLogger(verOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         buscarOferta p=new buscarOferta(usuario);
         p.setVisible(true);
         this.dispose();
         
         }
        else{
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
                    VerOferta v = new VerOferta(id, usuario, titulo, lugar, tipo, empresa, sueldo, experiencia, conocimiento);
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

