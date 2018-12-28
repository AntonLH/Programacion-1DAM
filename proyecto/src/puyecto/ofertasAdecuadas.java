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
public class ofertasAdecuadas extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private int[] array_cont;
    private int[] array_cont2;
        private JButton aceptar, atras;
        private String usuario="", conocimientosof, conocimientosusu;
    private int experiencia, experienciausu;
    private JPanel panel_botones;
    private String [] arcono=new String[5];
    private        JLabel [] ofertas= new JLabel[20];
    private        JLabel [] ofertas2= new JLabel[20];
    private        JButton [] botones= new JButton[20];
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String nombre_oferta;
    public static void main(String[] args) {
        verOfertas a= new verOfertas(null, null, null, null, null, 0, 0, null);
        a.pack();
        a.setVisible(true);
    }
    
    public ofertasAdecuadas(String usuario){
        this.usuario=usuario;
        setTitle("Ofertas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_botones=new JPanel();
        add(panel_botones, BorderLayout.CENTER);
        Statement stm;
                try {
                    stm = co.createStatement();
                    
                    ResultSet rs = stm.executeQuery("SELECT años_experiencia, conocimientos FROM curriculum_candidatos WHERE nombreusu='"+usuario+"'");
                    experienciausu=0;
                    while(rs.next()){
                        experienciausu=rs.getInt(1);
                        conocimientosusu=rs.getString(2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ofertasAdecuadas.class.getName()).log(Level.SEVERE, null, ex);
                }


        try {

        Statement ps=co.createStatement(); 
        PreparedStatement ps2 =  co.prepareStatement("SELECT COUNT(*) FROM ofertas_empleo where experiencia_requerida<=?"); 
        ps2.setInt(1, experienciausu);
        PreparedStatement ps3 =  co.prepareStatement("SELECT * FROM ofertas_empleo where experiencia_requerida<=?"); 
        ps3.setInt(1, experienciausu);
        ResultSet rs=ps3.executeQuery();
        ResultSet rs2=ps2.executeQuery();
                    String[] array_conocimientosusu = conocimientosusu.split("\\s*,\\s*");
        
        int contador=0;
            int i=0;
            while(rs2.next()){
                contador=rs2.getInt(1);
            }
            System.out.println(contador);
            while(rs.next()){
                    conocimientosof=rs.getString(9);
                    String[] array_conocimientosof = conocimientosof.split("\\s*,\\s*");
                int y=0;
                if(rs.getInt(8)<=experienciausu){
                    array_cont=new int[array_conocimientosusu.length];
                    array_cont2=new int[array_conocimientosusu.length];
                    for (int j=0;j<array_conocimientosusu.length;j++){
                            if (conocimientosof.contains(array_conocimientosusu[j])){
                                array_cont[j]++;
                            }
                            
                            System.out.println("cosa numero"+(j+1)+"  "+array_conocimientosusu[j]+"   cont:"+array_cont[y]+"/"+array_conocimientosof.length);
                            System.out.println(j);
                        }

                    }
                    ofertas[i]=new JLabel();
                    ofertas[i].setText(rs.getString(2));
                    ofertas2[i]=new JLabel();
                    ofertas2[i].setText("%"+(array_cont[y]*100)/array_conocimientosof.length);
                    i++;
                y++;
                }
            setLocationRelativeTo(null);
        setSize(500, contador*40+30);
            
        panel_botones.setLayout(new GridLayout(contador,3));
            for (int j=0;j<contador;j++){
                panel_botones.add(ofertas[j]);
                panel_botones.add(ofertas2[j]);
                botones[j]=new JButton("Mirar oferta");
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
            Logger.getLogger(verOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==atras){
         candidato p=new candidato(usuario);
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
                    System.out.println(id);
                    System.out.println(usuario);
                    //Abre la ventana para ver la oferta mas detallada.
                    veroferta2 v = new veroferta2(id,usuario);
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


