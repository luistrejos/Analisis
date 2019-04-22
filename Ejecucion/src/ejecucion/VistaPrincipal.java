/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author jitzo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    Object[][] data;
    String[] columnNames = {"Variable", "Valor"};
    DefaultTableModel modelo = new DefaultTableModel(data, columnNames);
    Object[][] data2;
    LinkedList<String[]> instrucciones = new LinkedList<>();
    Programa p = new Programa();
    String[] varTable = new String[2];
    LinkedList<Integer> cantidadEjecucion = new LinkedList<>();
    LinkedList<Integer> indiceInicioLinea = new LinkedList<>();
    HiloAutomatico h;

    /**
     * Creates new form VistaPrincipal
     *
     * @throws java.io.FileNotFoundException
     */
    public VistaPrincipal() throws FileNotFoundException, IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        LeerAlgoritmo();
        p.main();
        this.btnAutomatico.setEnabled(false);
        this.btnPaso.setEnabled(false);
        this.btnPrueba.setEnabled(false);
        this.txtAlgoritmo.setEditable(false);
        this.txtConsola.setEditable(false);
        this.tblSeguimiento.setModel(modelo);
        this.txtConsola.setText("");
        for (String string : p.resultadoConsola) {
            this.txtConsola.append(string + "\n");
        }
        for (String variable : p.variables) {
            String[] var = variable.split("<-");
        }

        int contAux = 0;
        for (int i = 0; i < instrucciones.size(); i++) {
            for (int j = 0; j < p.instrucciones.size(); j++) {
                if (instrucciones.get(i)[0].trim().equals(p.instrucciones.get(j))) {
                    contAux++;
                }
            }
            cantidadEjecucion.add(contAux);
            contAux = 0;
        }
        System.out.println("Variables:\n" + p.variables);
        btnPrueba.setName("pruebaaaa");
    }

    private void LeerAlgoritmo() throws FileNotFoundException, IOException {
        File archivo = new File("src/ejecucion/algoritmo.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        // Lectura del fichero
        String linea;
        String[] instruccion;
        int pos = 0;
        while ((linea = br.readLine()) != null) {
            instruccion = new String[3];
            instruccion[0] = linea;
            instruccion[1] = String.valueOf(pos);
            instruccion[2] = "0";
            instrucciones.add(instruccion);
            pos += linea.length() + 1;
            this.txtAlgoritmo.append(linea + "\n");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeguimiento = new javax.swing.JTable();
        btnAutomatico = new javax.swing.JButton();
        btnPaso = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlgoritmo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtValores = new javax.swing.JTextArea();
        btnDebug = new javax.swing.JButton();
        btnPrueba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtConsola.setColumns(20);
        txtConsola.setRows(5);
        jScrollPane1.setViewportView(txtConsola);

        jLabel1.setText("Estado variables");

        jLabel2.setText("Entorno de ejecución");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("Algoritmo del CareStudent");

        tblSeguimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblSeguimiento);

        btnAutomatico.setText("Automático");
        btnAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomaticoActionPerformed(evt);
            }
        });

        btnPaso.setText("Paso a paso");
        btnPaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasoActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtAlgoritmo.setColumns(20);
        txtAlgoritmo.setRows(5);
        jScrollPane3.setViewportView(txtAlgoritmo);

        jLabel4.setText("Consola");

        txtValores.setColumns(20);
        txtValores.setRows(5);
        txtValores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValoresKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtValores);

        btnDebug.setText("Reiniciar paso a paso");
        btnDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebugActionPerformed(evt);
            }
        });

        btnPrueba.setText("jButton1");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnAutomatico)
                                .addGap(32, 32, 32)
                                .addComponent(btnPaso))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnDebug)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrueba)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPaso)
                                    .addComponent(btnAutomatico))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDebug)
                                    .addComponent(btnPrueba)))
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    Timer timer;
    boolean ejecutando = false;
    private void btnAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomaticoActionPerformed
        // TODO add your handling code here:
        this.btnPrueba.setEnabled(true);
        this.btnPrueba.setText("Pausar");
        ejecutando = true;
        modelo.setRowCount(0);
        h = new HiloAutomatico(txtAlgoritmo, txtValores, modelo, instrucciones, p, cantidadEjecucion, indiceInicioLinea);
        h.start();
        /*timer = new Timer(500, new ActionListener() {
            int cont2 = 0, contV = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String i;
                if (cont2 < p.instrucciones.size() && (i = p.instrucciones.get(cont2)) != null) {
                    for (String[] aux : instrucciones) {
                        if (aux[0].trim().equals(i)) {
                            SubRayar(Integer.valueOf(aux[1]), aux[0].length());
                            if (aux[0].contains("<-") && contV < p.variables.size()) {
                                InsertarTabla(p.variables.get(contV));
                                contV++;
                            }
                        }
                    }
                    cont2++;
                }
                if (cont2 >= p.instrucciones.size()) {
                    ResaltarMalCalculo();
                    compararCalculoEstudiante();
                }
            }
        });
        timer.start();*/


    }//GEN-LAST:event_btnAutomaticoActionPerformed

    int cont = 0, contV2 = 0;
    private void btnPasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasoActionPerformed
        // TODO add your handling code here
        String i;
        if (cont < p.instrucciones.size() && (i = p.instrucciones.get(cont)) != null) {
            for (String[] aux : instrucciones) {
                if (aux[0].trim().equals(i)) {
                    SubRayar(Integer.valueOf(aux[1]), aux[0].length());
                    if (aux[0].trim().equals(i)) {
                        SubRayar(Integer.valueOf(aux[1]), aux[0].length());
                        if (aux[0].contains("<-") && contV2 < p.variables.size()) {
                            InsertarTabla(p.variables.get(contV2));
                            contV2++;
                        }
                    }
                }
            }
            cont++;
        }

        // Se termina de leer las lines del programa
        // es decir ya no hay más lineas por ejecutar
        if (cont >= p.instrucciones.size()) {
            ResaltarMalCalculo();
            compararCalculoEstudiante();
            this.btnPaso.setEnabled(false);
        }
    }//GEN-LAST:event_btnPasoActionPerformed

    private void btnDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebugActionPerformed
        // TODO add your handling code here:
        cont = 0;
        modelo.setRowCount(0);
        contV2 = 0;
        this.btnPaso.setEnabled(true);
        this.btnAutomatico.setEnabled(true);
        this.txtAlgoritmo.getHighlighter().removeAllHighlights();
        this.txtValores.getHighlighter().removeAllHighlights();
    }//GEN-LAST:event_btnDebugActionPerformed

    private void txtValoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValoresKeyReleased
        // TODO add your handling code here:
        if (instrucciones.size() == txtValores.getText().split("\n").length) {
            this.btnAutomatico.setEnabled(true);
            this.btnPaso.setEnabled(true);
        } else {
            this.btnAutomatico.setEnabled(false);
            this.btnPaso.setEnabled(false);
        }
    }//GEN-LAST:event_txtValoresKeyReleased

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        if (ejecutando) {
            h.ejecutar = false;
            ejecutando = false;
            this.btnPrueba.setText("Reanudar");
        }else{
            h.ejecutar = true;
            ejecutando = true;
            this.btnPrueba.setText("Pausar");
        }
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void InsertarTabla(String s) {
        String[] aux = s.split("<-");
        String[] row = {aux[0], aux[1]};
        modelo.addRow(row);
    }

    private void ResaltarMalCalculo() {
        String split[] = this.txtValores.getText().split("\n");
        String area = this.txtValores.getText();
        indiceInicioLinea.add(1);
        for (int i = 1; i < area.length(); i++) {
            if (area.charAt(i) == '\n') {
                indiceInicioLinea.add(i + 1);
            }
        }
    }

    private void SubRayar(int pos, int fin) {
        Highlighter h = this.txtAlgoritmo.getHighlighter();
        h.removeAllHighlights();
        try {
            h.addHighlight(pos, pos + fin, new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN));
        } catch (BadLocationException e) {
        }
    }

    private void SubRayar2(int pos, int fin) {
        Highlighter h = this.txtValores.getHighlighter();
        try {
            h.addHighlight(pos, pos + fin, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
        } catch (BadLocationException e) {
        }
    }

    private void compararCalculoEstudiante() {
        String[] valores = this.txtValores.getText().split("\n");
        for (int i = 0; i < valores.length; i++) {
            int letraCadena = Integer.valueOf(valores[i]);
            if (letraCadena != cantidadEjecucion.get(i)) {
                SubRayar2(indiceInicioLinea.get(i), valores[i].length());
            }
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
                try {
                    new VistaPrincipal().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutomatico;
    private javax.swing.JButton btnDebug;
    private javax.swing.JButton btnPaso;
    private javax.swing.JButton btnPrueba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblSeguimiento;
    private javax.swing.JTextArea txtAlgoritmo;
    private javax.swing.JTextArea txtConsola;
    private javax.swing.JTextArea txtValores;
    // End of variables declaration//GEN-END:variables
}
