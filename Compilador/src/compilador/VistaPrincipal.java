/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author jitzo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private String archivo = "";

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Editor de código");

        btnGuardar.setText("Guardar Código");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAnalizar.setText("Analizar código");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtCodigo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar)
                        .addComponent(btnAnalizar)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        File archivoPrograma;
        BufferedWriter bw;

        archivo = JOptionPane.showInputDialog("Ingrese el nombre del programa");

        String file = "src/algoritmos/" + archivo + ".txt";
        archivoPrograma = new File(file);
        System.out.println("Guardando en: "+archivo);

        try {
            bw = new BufferedWriter(new FileWriter(archivoPrograma));
            System.out.println("Codigo: "+txtCodigo.getText());
            bw.write(txtCodigo.getText());
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            // TODO add your handling code here:
            AnalizarCodigo(archivo);
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
        if (txtCodigo.getText().contains("int")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("int"), 3, Color.blue);
        }
        
        if (txtCodigo.getText().contains("double")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("double"), 6, Color.blue);
        }
        
        if (txtCodigo.getText().contains("boolean")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("boolean"), 7, Color.blue);
        }
        
        if (txtCodigo.getText().contains("String")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("String"), 7, Color.blue);
        }
        
        if (txtCodigo.getText().contains("if")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("if"), 2, Color.blue);
        }
        
        if (txtCodigo.getText().contains("for")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("for"), 3, Color.blue);
        }
        
        if (txtCodigo.getText().contains("while")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("while"), 5, Color.blue);
        }
        
        if (txtCodigo.getText().contains("repeat")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("repeat"), 6, Color.blue);
        }
        
        if (txtCodigo.getText().contains("endif")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("endif"), 5, Color.blue);
        }
        
        if (txtCodigo.getText().contains("endfor")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("endfor"), 6, Color.blue);
        }
        
        if (txtCodigo.getText().contains("endwhile")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("endwhile"), 8, Color.blue);
        }
        
        if (txtCodigo.getText().contains("function")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("function"), 8, Color.black);
        }
        
        if (txtCodigo.getText().contains("procedure")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("procedure"), 9, Color.black);
        }
        
        if (txtCodigo.getText().contains("main")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("main"), 4, Color.black);
        }

    }//GEN-LAST:event_txtCodigoKeyReleased

    private void PonerNegrita(int pos, int length, Color color) {
        SimpleAttributeSet atributo = new SimpleAttributeSet();
        StyleConstants.setBold(atributo, true);
        StyleConstants.setForeground(atributo, color);
        txtCodigo.getStyledDocument().setCharacterAttributes(pos, length, atributo, true);
    }

    private void AnalizarCodigo(String archivo) throws FileNotFoundException, IOException {
        Reader reader = new BufferedReader(new FileReader("src/algoritmos/" + archivo + ".txt"));
        Lexer lexer = new Lexer(reader);
        parser miParser = new parser(lexer, "Programa");
        try {
            miParser.parse();
        } catch (Exception ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtCodigo;
    // End of variables declaration//GEN-END:variables
}
