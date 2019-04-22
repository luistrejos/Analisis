/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.JFileChooser;
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
        this.setLocationRelativeTo(null);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setText("Editor de código");

        btnGuardar.setText("Guardar código");
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

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupapeque.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lopopeque.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnAnalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnGuardar)
                        .addGap(17, 17, 17)
                        .addComponent(btnAnalizar)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        try {
            bw = new BufferedWriter(new FileWriter(archivoPrograma));
            bw.write(txtCodigo.getText());
            bw.close();
            archivoPrograma = new File("/home/jitzo/Documentos/GitHub/Analisis/Ejecucion/src/ejecucion/algoritmo.txt");
            bw = new BufferedWriter(new FileWriter(archivoPrograma));
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
        
        if (txtCodigo.getText().contains("endfunction")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("endfunction"), 11, Color.black);
        }

        if (txtCodigo.getText().contains("procedure")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("procedure"), 9, Color.black);
        }
        
        if (txtCodigo.getText().contains("endprocedure")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("endprocedure"), 12, Color.black);
        }

        if (txtCodigo.getText().contains("main")) {
            PonerNegrita(txtCodigo.getText().lastIndexOf("main"), 4, Color.black);
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }

    }//GEN-LAST:event_txtCodigoKeyReleased

    private void PonerNegrita(int pos, int length, Color color) {
        SimpleAttributeSet atributo = new SimpleAttributeSet();
        StyleConstants.setBold(atributo, true);
        StyleConstants.setForeground(atributo, color);
        txtCodigo.getStyledDocument().setCharacterAttributes(pos, length, atributo, true);
    }

    private void AnalizarCodigo(String archivo) throws FileNotFoundException, IOException {
        if (archivo.isEmpty()) {
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            selectorArchivos.showOpenDialog(this);
            File file = selectorArchivos.getSelectedFile();
            archivo = file.getName().substring(0, file.getName().length()-4);
        }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane txtCodigo;
    // End of variables declaration//GEN-END:variables
}
