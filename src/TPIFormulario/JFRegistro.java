package TPIFormulario;
import TPIsql.ConexionBD;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class JFRegistro extends javax.swing.JFrame {
    
    public JFRegistro() {
       this.setUndecorated(true);       
        initComponents();         
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        txtusuarioreg = new javax.swing.JTextField();
        txtpassreg1 = new javax.swing.JTextField();
        txtpassreg2 = new javax.swing.JTextField();
        BtnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField1.setText("Usuario : ");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 34, -1, -1));

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField2.setText("Ingrese Contraseña :");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 79, 160, -1));

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField3.setText("Ingrese Nuevamente Contraseña :");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 124, -1, -1));
        jPanel1.add(txtusuarioreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 36, 220, -1));
        jPanel1.add(txtpassreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 81, 220, -1));
        jPanel1.add(txtpassreg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 126, 220, -1));

        BtnRegistrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnRegistrar.setText("Registro");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 185, 137, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-2384333_960_720.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        Icon ok = new ImageIcon(getClass().getResource("/imagenes/accept_ok_male_man.png")); //Imagen de JOptionPane
        //variables 
        String Usuario = txtusuarioreg.getText();
        String Pass1 = txtpassreg1.getText();
        String Pass2 = txtpassreg2.getText();
        //conexion a la base de datos ConexionBD
        ConexionBD conexion= new ConexionBD ();
         conexion.conectar();
        //Validacion de pass y campos  
        if (!Pass1.equals("") && !Pass2.equals("")) {
            if (Pass1.equals(Pass2)) {
                conexion.RegistrarUsuario(Usuario, Pass1);
                JOptionPane.showMessageDialog(rootPane, "El Registro fue exitoso!!", "Gracias", JOptionPane.PLAIN_MESSAGE, ok);
                this.dispose(); //cierre de ventana 
            }else{
               JOptionPane.showMessageDialog(rootPane, "Las contraseñas son distintas!!", "Error", JOptionPane.ERROR_MESSAGE); 
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los Campos estan vacios!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    
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
            java.util.logging.Logger.getLogger(JFRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtpassreg1;
    private javax.swing.JTextField txtpassreg2;
    private javax.swing.JTextField txtusuarioreg;
    // End of variables declaration//GEN-END:variables

  
}
