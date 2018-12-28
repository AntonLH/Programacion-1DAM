/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;

import com.mysql.jdbc.Connection;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author admin1
 */
public class publicar_oferta extends javax.swing.JFrame {

    /**
     * Creates new form publicar_oferta
     */
    private    conexion mysql=new conexion();
    private    Connection co=mysql.conectar();
    private String cif, nombreusuario;
    private JCheckBox [] conocimientos_check;
    public publicar_oferta(String CIF, String nombreusu) {
        initComponents();
        this.cif=CIF;
        this.nombreusuario=nombreusu;
        int contador=0;
                            Statement stm;
                try {
                stm = co.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(nombre) FROM conocimientos");
                while(rs.next()){
                    contador=rs.getInt(1);
                    System.out.println(contador);
                    jPanel1.setLayout(new GridLayout(2, contador/2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);
            }
                conocimientos_check=new JCheckBox[contador];
            try {
                stm = co.createStatement();
                ResultSet rs = stm.executeQuery("SELECT nombre FROM conocimientos");
                int i=0;
                while(rs.next()){
                    System.out.println(rs.getString(1));
                    conocimientos_check[i]=new JCheckBox(rs.getString(1));
                    jPanel1.add(conocimientos_check[i]);
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        nom_oferta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lugar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        sueldo_min = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sueldo_max = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        experiencia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        aspectos_i = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        aspectos_v = new javax.swing.JTextArea();
        atras = new javax.swing.JButton();
        publicar = new javax.swing.JButton();
        tipo_cont = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jCheckBox6.setText("jCheckBox6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre de la oferta: ");

        nom_oferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_ofertaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de contrato:");

        jLabel3.setText("Lugar de Trabajo:");

        jLabel5.setText("Descripcion: ");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jLabel6.setText("Sueldo minimo: ");

        jLabel7.setText("Sueldo maximo:");

        jLabel8.setText("Conocimientos:");

        jLabel10.setText("Experiencia requerida: ");

        jLabel11.setText("Aspectos a valorar:");

        experiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experienciaActionPerformed(evt);
            }
        });

        aspectos_i.setColumns(20);
        aspectos_i.setRows(5);
        jScrollPane2.setViewportView(aspectos_i);

        jLabel12.setText("Aspectos imprescindibles:");

        aspectos_v.setColumns(20);
        aspectos_v.setRows(5);
        jScrollPane3.setViewportView(aspectos_v);

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        publicar.setText("Publicar");
        publicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarActionPerformed(evt);
            }
        });

        tipo_cont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Indefinido-tiempo completo", "indefinido-tiempo parcial", "temporal-tiempo completo", "temporal-tiempo parcial" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        jButton1.setText("Añadir conocimiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(atras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publicar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(sueldo_min, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(sueldo_max, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)))
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nom_oferta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(lugar))
                                .addComponent(tipo_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(221, 221, 221)
                            .addComponent(jLabel9))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipo_cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sueldo_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(sueldo_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(publicar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void nom_ofertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_ofertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_ofertaActionPerformed

    private void experienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experienciaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_experienciaActionPerformed

    private void publicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarActionPerformed
        String nombre, contrato, lug, description, experience, valorar, imprescindible, min, max, conocimientos="", nombre_empresa, telefono, email, retirada;
        int cod=1;
        retirada = "N";
        nombre_empresa = "";
        telefono = "";
        email = "";
         Statement stm;
       
        nombre=nom_oferta.getText();
        contrato=(String) tipo_cont.getSelectedItem();
        lug=lugar.getText();
        description=descripcion.getText();
        min=sueldo_min.getText();
        max=sueldo_max.getText();
        experience=experiencia.getText();
        valorar=aspectos_v.getText();
        imprescindible=aspectos_i.getText();
        for (int i=0;i<conocimientos_check.length;i++){
            if (conocimientos_check[i].isSelected()){
                conocimientos+=conocimientos_check[i].getText()+",";
            }
        }
        

            try {
                stm = co.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(codigo_oferta) FROM ofertas_empleo");
                while(rs.next()){
                    if(rs.getInt(1)!=0){
                        cod = rs.getInt(1)+1;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Statement stm2;
            try {
                stm2 = co.createStatement();
                ResultSet rs2 = stm2.executeQuery("SELECT nombre, telefono, email FROM datos_empresa WHERE CIF = '"+cif+"'");
                while(rs2.next()){
                    nombre_empresa = rs2.getString(1);
                    telefono = rs2.getString(2);
                    email = rs2.getString(3);
                }
            } catch (SQLException ex) {
                Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);
            }

        String sentenciaSQL;
        sentenciaSQL="INSERT INTO ofertas_empleo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
        PreparedStatement psp =co.prepareStatement(sentenciaSQL);
            psp.setInt(1, cod);
            psp.setString(2, nombre);
            psp.setString(3, description);
            psp.setString(4, lug);
            psp.setString(5, contrato);
            psp.setString(6, max);
            psp.setString(7, min);
            psp.setString(8, experience);
            psp.setString(9, conocimientos);
            psp.setString(10, valorar);
            psp.setString(11, imprescindible);
            psp.setString(12, retirada);
            psp.setString(13, nombre_empresa);
            psp.setString(14, cif);
            psp.setString(15, telefono);
            psp.setString(16, email);
            
            int n=0;
            n=psp.executeUpdate();
            
            if (n==1){
                JOptionPane.showMessageDialog(null, "Oferta publicada correctamente.");
                empresa v = new empresa(nombreusuario);
                v.setVisible(true);
                this.dispose();
            }
            
            }catch (SQLException ex) {
                                    Logger.getLogger(publicar_oferta.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(null, "Oferta no publicada.");  
            }
            
           
    }//GEN-LAST:event_publicarActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
      
        empresa v = new empresa(nombreusuario);
            v.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AñadirConocimiento v= new AñadirConocimiento(cif, nombreusuario);
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(publicar_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(publicar_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(publicar_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(publicar_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new publicar_oferta("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aspectos_i;
    private javax.swing.JTextArea aspectos_v;
    private javax.swing.JButton atras;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField experiencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lugar;
    private javax.swing.JTextField nom_oferta;
    private javax.swing.JButton publicar;
    private javax.swing.JTextField sueldo_max;
    private javax.swing.JTextField sueldo_min;
    private javax.swing.JComboBox tipo_cont;
    // End of variables declaration//GEN-END:variables
}
