package TPIFormulario;

import TPIsql.ConexionBD;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class JFUsuario extends javax.swing.JFrame {
    Icon ok;
    
    public JFUsuario() {
        this.setUndecorated(true);
        initComponents();
        ok = new ImageIcon(getClass().getResource("/imagenes/accept_ok_male_man.png"));
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        BtnRegistrarse = new javax.swing.JButton();
        BtnIngresar = new javax.swing.JButton();
        txtPass = new javax.swing.JTextField();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-2384333_960_720.png"))); // NOI18N

        jToolBar1.setRollover(true);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-2384333_960_720.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-2384333_960_720.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 120, 120));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 30));

        BtnRegistrarse.setBackground(new java.awt.Color(0, 0, 0));
        BtnRegistrarse.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrarse.setText("Registrarse");
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, -1));

        BtnIngresar.setBackground(new java.awt.Color(0, 0, 0));
        BtnIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, -1));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        
            JFRegistro registro = new JFRegistro();
            registro.setVisible(true);
            this.dispose();
       
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        String Usuario = txtUsuario.getText();
        String Pass = txtPass.getText();

        ConexionBD conexion = new ConexionBD();
        conexion.conectar();
        Boolean UsyPa = conexion.Login(Usuario, Pass);
                                                
        if (!Usuario.equals("") && !Pass.equals("")) {              //Validacion si los campos estan vacios
            if (UsyPa==true) {                                                      //Validacion si es true la conexion al login me trae el formulario de empleados
            Formulario Form = new Formulario();                     //Hace visible mi formulario de Empleado
            Form.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(rootPane, "Usuario No Registrado!!\n Por Favor Registrese.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuario No Registrado!!\n Por Favor Registrese.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        txtUsuario.setText("");                                                  //estos setText dejan en blanco mis casillas   
        txtPass.setText("");                                                        //para poder volver a escribir en caso de error
    }//GEN-LAST:event_BtnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new JFUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
