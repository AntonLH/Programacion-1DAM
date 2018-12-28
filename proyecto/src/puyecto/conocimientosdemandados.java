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
public class conocimientosdemandados extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private int[] array_cont;
    private int cont;
        private JButton aceptar, atras;
        private String usuario="", conocimientosof, conocimientos;
    private int experiencia, experienciausu;
    private JPanel panel_botones;
    private String [] array_conocimientos;
    private        JLabel [] ofertas;
    private        JLabel [] ofertas2= new JLabel[20];
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombre_oferta;
    public static void main(String[] args) {
        verOfertas a= new verOfertas(null, null, null, null, null, 0, 0, null);
        a.pack();
        a.setVisible(true);
    }
    
    public conocimientosdemandados(String usuario){
        this.usuario=usuario;
        setTitle("Conocimientos demandados");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        add(panel_botones, BorderLayout.CENTER);
        Statement stm;
                try {
                    stm = co.createStatement();
                    
                    ResultSet rs2 = stm.executeQuery("SELECT count(*) FROM conocimientos");
                    int i=0;
                    while(rs2.next()){
                        cont=rs2.getInt(1);
                    }
                    array_conocimientos=new String[cont];
                    ResultSet rs = stm.executeQuery("SELECT nombre FROM conocimientos");
                    while(rs.next()){
                        array_conocimientos[i]=rs.getString(1);
                        i++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ofertasAdecuadas.class.getName()).log(Level.SEVERE, null, ex);
                }


        try {
        Statement ps=co.createStatement(); 
        PreparedStatement ps3 =  co.prepareStatement("SELECT * FROM ofertas_empleo"); 
        ResultSet rs=ps3.executeQuery();
                     ofertas = new JLabel[array_conocimientos.length];
                    array_cont=new int[array_conocimientos.length];
       
        int contador=0;
            while(rs.next()){
                    conocimientosof=rs.getString(9);
                    for (int j=0;j<array_conocimientos.length;j++){
                            if (conocimientosof.contains(array_conocimientos[j])){
                                array_cont[j]++;
                        }
                    }
                }
            ordenarArray(array_cont, array_conocimientos);
            for (int y=0;y<array_conocimientos.length;y++){
                System.out.println(array_conocimientos[y]+"    "+array_cont[y]);
                    ofertas[y]=new JLabel();
                    ofertas[y].setText(array_conocimientos[y]);
                    ofertas2[y]=new JLabel();
                    ofertas2[y].setText(""+array_cont[y]);
            }
            setLocationRelativeTo(null);
        setSize(500, array_conocimientos.length*40);
            
        panel_botones.setLayout(new GridLayout(array_conocimientos.length,2));
            for (int j=0;j<array_conocimientos.length;j++){
                panel_botones.add(ofertas[j]);
                panel_botones.add(ofertas2[j]);
            }
        
                } catch (SQLException ex) {
            Logger.getLogger(conocimientosdemandados.class.getName()).log(Level.SEVERE, null, ex);
        }
        atras=new JButton("Atras");
        atras.setBounds(20, 370, 30, 30);
        add(atras, BorderLayout.SOUTH);
        atras.addActionListener(this);

    }
public static int[] ordenarArray(int[] n, String[] m) {
    int aux;
    String aux2;
    for (int i = 0; i < n.length - 1; i++) {
        for (int x = i + 1; x < n.length; x++) {
            if (n[x] > n[i]) {
                aux = n[i];
                aux2 = m[i];
                n[i] = n[x];
                n[x] = aux;
                m[i] = m[x];
                m[x] = aux2;
            }
        }
    }

    return n;
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         candidato p=new candidato(usuario);
         p.setVisible(true);
         this.dispose();
         }
    }
}