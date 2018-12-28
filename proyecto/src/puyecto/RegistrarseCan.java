/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puyecto;

import java.awt.GridLayout;
import java.sql.Connection;
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
public class RegistrarseCan extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarseCan
     */
        private JCheckBox [] conocimientos_check;

    public RegistrarseCan() {
        initComponents();
                       conexion mysql=new conexion();
        Connection co=mysql.conectar();

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
                Logger.getLogger(RegistrarseCan.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(RegistrarseCan.class.getName()).log(Level.SEVERE, null, ex);
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

        RegisCandidato = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Fecha_nacimiento = new javax.swing.JLabel();
        NombreText = new javax.swing.JTextField();
        ApellidoText = new javax.swing.JTextField();
        DireccionText = new javax.swing.JTextField();
        TelefonoText = new javax.swing.JTextField();
        EmailText = new javax.swing.JTextField();
        Fecha_NacimientoText = new javax.swing.JTextField();
        CarnetConducir = new javax.swing.JRadioButton();
        CochePropio = new javax.swing.JRadioButton();
        DisponViajar = new javax.swing.JRadioButton();
        Estudios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        OtrosConocimientos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        AniosExperiencia = new javax.swing.JLabel();
        AniosExperienciaText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        Atras = new javax.swing.JButton();
        Siguiente = new javax.swing.JButton();
        NuevoUsuario = new javax.swing.JLabel();
        NuevoUsuarioText = new javax.swing.JTextField();
        Contrasena = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegisCandidato.setText("REGISTRO DE CANDIDATO");

        Nombre.setText("Nombre: ");

        Apellido.setText("Apellido: ");

        Direccion.setText("Direccion: ");

        Telefono.setText("Telefono: ");

        Email.setText("E-mail: ");

        Fecha_nacimiento.setText("Fecha nacimiento:");

        Fecha_NacimientoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fecha_NacimientoTextActionPerformed(evt);
            }
        });

        CarnetConducir.setText("Carnet de conducir");
        CarnetConducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarnetConducirActionPerformed(evt);
            }
        });

        CochePropio.setText("Coche propio");

        DisponViajar.setText("Disponibilidad para Viajar");
        DisponViajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisponViajarActionPerformed(evt);
            }
        });

        Estudios.setText("Estudios:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        OtrosConocimientos.setText("Otros conocimientos:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        AniosExperiencia.setText("Años de experiencia: ");

        AniosExperienciaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AniosExperienciaTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Vida laboral: ");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        Siguiente.setText("Registrarse");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        NuevoUsuario.setText("Nuevo Usuario:");

        NuevoUsuarioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoUsuarioTextActionPerformed(evt);
            }
        });

        Contrasena.setText("Contraseña:");

        jLabel2.setText("DNI:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel3.setText("Conocimientos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(RegisCandidato))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Apellido))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Direccion)
                                            .addComponent(Email))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(EmailText)
                                            .addComponent(DireccionText)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(Fecha_nacimiento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fecha_NacimientoText)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ApellidoText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Telefono)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TelefonoText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(jTextField1)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Estudios)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(CarnetConducir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CochePropio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DisponViajar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(Contrasena)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPasswordField1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(NuevoUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NuevoUsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(AniosExperiencia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AniosExperienciaText, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OtrosConocimientos)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2))))))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Atras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Siguiente)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegisCandidato)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(Apellido)
                    .addComponent(NombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(DireccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Telefono)
                    .addComponent(TelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email)
                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha_nacimiento)
                    .addComponent(Fecha_NacimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarnetConducir)
                    .addComponent(CochePropio)
                    .addComponent(DisponViajar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estudios)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OtrosConocimientos)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AniosExperiencia)
                            .addComponent(AniosExperienciaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NuevoUsuario)
                            .addComponent(NuevoUsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Contrasena)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Siguiente)
                            .addComponent(Atras)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        BienvenidoCan p=new BienvenidoCan();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_AtrasActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
               conexion mysql=new conexion();
        Connection co=mysql.conectar();

        String dni, email,nombre, apellidos,fecha_nacimiento, direccion, estudios, conocimientos="", otros_conocimientos, vida_laboral, nombreusu, contraseña, repcontraseña;
       int telefono, años_experiencia;
       try{
       email=EmailText.getText();
       
       nombre=NombreText.getText();
       apellidos=ApellidoText.getText();
       direccion=DireccionText.getText();
       estudios=jTextArea1.getText();
       otros_conocimientos=jTextArea2.getText();
        for (int i=0;i<conocimientos_check.length;i++){
            if (conocimientos_check[i].isSelected()){
                conocimientos+=conocimientos_check[i].getText()+",";
            }
        }
       años_experiencia=Integer.parseInt(AniosExperienciaText.getText());
       telefono=Integer.parseInt(TelefonoText.getText());
       dni=jTextField1.getText();
       vida_laboral=jTextArea3.getText();
       nombreusu=NuevoUsuarioText.getText();
       if (CarnetConducir.isSelected()) carnet="S";
       else carnet="N";
       if (CochePropio.isSelected()) coche="S";
       else coche="N";
       if (DisponViajar.isSelected()) viajar="S";
       else viajar="N";
       fecha_nacimiento=Fecha_NacimientoText.getText();
       contraseña=jPasswordField1.getText();

       String tipo="candidato";
               String sentenciaSQL;
        sentenciaSQL="INSERT INTO curriculum_candidatos (DNI, telefono, email, nombre, apellidos,"
                + " direccion, estudios, conocimientos, otros_conocimientos, años_experiencia, vida_laboral,"
                + " carnet_conducir, coche_propio, viajar,nombreusu)"+
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               String sentenciaSQL2;
        sentenciaSQL2="INSERT INTO usuarios (nombreusu, clave, tipo)"+
                "VALUES(?,?,?)";
        
        try {
            PreparedStatement psp2 =co.prepareStatement(sentenciaSQL2);
            psp2.setString(1, nombreusu);
            psp2.setString(2, contraseña);
            psp2.setString(3, tipo);
            int m=0,n=0;
            try{
            m=psp2.executeUpdate();

            PreparedStatement psp =co.prepareStatement(sentenciaSQL);
            psp.setString(1, dni);
            psp.setInt(2, telefono);
            psp.setString(3, email);
            psp.setString(4, nombre);
            psp.setString(5, apellidos);
            psp.setString(6, direccion);
            psp.setString(7, estudios);
            psp.setString(8, conocimientos);
            psp.setString(9, otros_conocimientos);
            psp.setInt(10, años_experiencia);
            psp.setString(11, vida_laboral);
            psp.setString(12, carnet);
            psp.setString(13, coche);
            psp.setString(14, viajar);
            psp.setString(15, nombreusu);
            
            n=psp.executeUpdate();
            }catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ea){
                JOptionPane.showMessageDialog(null, "Ya existe ese usuario");
            }
            if (n>0&&m>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                IniciarSesionCan p=new IniciarSesionCan();
                p.setVisible(true);
                this.dispose();

            }
            else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarseCan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }catch(java.lang.NumberFormatException ea){
            JOptionPane.showMessageDialog(null, "Telefono o Años experiencia introducido incorrectamente");
                  
        }


    }//GEN-LAST:event_SiguienteActionPerformed

    private void NuevoUsuarioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoUsuarioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoUsuarioTextActionPerformed

    private void AniosExperienciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AniosExperienciaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AniosExperienciaTextActionPerformed

    private void CarnetConducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarnetConducirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CarnetConducirActionPerformed

    private void DisponViajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisponViajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisponViajarActionPerformed

    private void Fecha_NacimientoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fecha_NacimientoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha_NacimientoTextActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarseCan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarseCan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarseCan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarseCan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarseCan().setVisible(true);
            }
        });
    }
    private String carnet, coche, viajar;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AniosExperiencia;
    private javax.swing.JTextField AniosExperienciaText;
    private javax.swing.JLabel Apellido;
    private javax.swing.JTextField ApellidoText;
    private javax.swing.JButton Atras;
    private javax.swing.JRadioButton CarnetConducir;
    private javax.swing.JRadioButton CochePropio;
    private javax.swing.JLabel Contrasena;
    private javax.swing.JLabel Direccion;
    private javax.swing.JTextField DireccionText;
    private javax.swing.JRadioButton DisponViajar;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel Estudios;
    private javax.swing.JTextField Fecha_NacimientoText;
    private javax.swing.JLabel Fecha_nacimiento;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField NombreText;
    private javax.swing.JLabel NuevoUsuario;
    private javax.swing.JTextField NuevoUsuarioText;
    private javax.swing.JLabel OtrosConocimientos;
    private javax.swing.JLabel RegisCandidato;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel Telefono;
    private javax.swing.JTextField TelefonoText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}