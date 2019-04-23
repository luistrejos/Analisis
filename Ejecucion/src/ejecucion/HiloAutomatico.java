/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

import java.awt.Color;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author jitzo
 */
public class HiloAutomatico extends Thread {

    JTextArea txtAlgoritmo;
    JTextArea txtValores;
    DefaultTableModel modelo;
    int cont2 = 0, contV = 0;
    LinkedList<String[]> instrucciones;
    Programa p;
    LinkedList<Integer> cantidadEjecucion;
    LinkedList<Integer> indiceInicioLinea;
    LinkedList<Integer> breakpoints;
    boolean ejecutar = true;
    JButton btn;
    int velocidad;

    public HiloAutomatico(JTextArea area, JTextArea txtValores, DefaultTableModel modelo,
            LinkedList<String[]> instrucciones, Programa p,
            LinkedList<Integer> cantidadEjecucion,
            LinkedList<Integer> indiceInicioLinea, LinkedList<Integer> breakpoints,
            JButton btn) {
        this.txtAlgoritmo = area;
        this.txtValores = txtValores;
        this.modelo = modelo;
        this.instrucciones = instrucciones;
        this.p = p;
        this.cantidadEjecucion = cantidadEjecucion;
        this.indiceInicioLinea = indiceInicioLinea;
        this.breakpoints = breakpoints;
        this.btn = btn;
        this.velocidad = 500;
    }

    /**
     * Hilo que realiza la ejecución automática del debug
     */
    @Override
    public void run() {
        while (true) {
            if (ejecutar) {
                String i;
                if (cont2 < p.instrucciones.size() && (i = p.instrucciones.get(cont2)) != null) {
                    for (String[] aux : instrucciones) {
                        if (aux[0].trim().equals(i)) {
                            for (Integer breakpoint : breakpoints) {
                                if (breakpoint == instrucciones.indexOf(aux)) {
                                    System.out.println("Linea: "+aux[0].trim() + " : "+breakpoint);
                                    ejecutar = false;
                                    btn.setText("Reanudar");
                                }
                            }
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
            try {
                if (velocidad>0) {
                    Thread.sleep(velocidad);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método que detecta los valores de ejecución ingresados por el usuario,
     * que no concuerdan con los valores reales calculados por la aplicación
     */
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

    /**
     * Método que compara los valores de ejecución ingresados por el usuario,
     * con los valores reales calculados por la aplicación
     */
    private void compararCalculoEstudiante() {
        String[] valores = this.txtValores.getText().split("\n");
        int sumaV=0;
        for (int i = 0; i < valores.length; i++) {
            int valor = Integer.valueOf(valores[i]);
            if (valor != cantidadEjecucion.get(i)) {
                SubRayar2(indiceInicioLinea.get(i), valores[i].length());
            }else{
                  sumaV += valor;
            }
        }
        int sumaC = 0;
        for (Integer integer : cantidadEjecucion) {
            sumaC += integer;
        }
        int x = (sumaV*100)/sumaC;
        JOptionPane.showMessageDialog(null, "Cantidad  real de ejecución: "+sumaC+"\nCantidad de ejecución ingresada: "+sumaV+"\nAcertó en un "+x+"%");
        ejecutar = false;
    }

    /**
     * Método que resalta la linea que se está ejecutando actualmente
     * @param pos
     * @param fin 
     */
    private void SubRayar(int pos, int fin) {
        Highlighter h = this.txtAlgoritmo.getHighlighter();
        h.removeAllHighlights();
        try {
            h.addHighlight(pos, pos + fin, new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN));
        } catch (BadLocationException e) {
        }
    }

    /**
     * Método que resalta los valores de ejecución ingresados por el usuario,
     * que no concuerdan con los valores reales calculados por la aplicación
     * @param pos
     * @param fin 
     */
    private void SubRayar2(int pos, int fin) {
        Highlighter h = this.txtValores.getHighlighter();
        try {
            h.addHighlight(pos, pos + fin, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
        } catch (BadLocationException e) {
        }
    }

    /**
     * Método que muestra el estado de las variables en la tabla de seguimiento
     * @param s 
     */
    private void InsertarTabla(String s) {
        String[] aux = s.split("<-");
        String[] row = {aux[0], aux[1]};
        boolean b = false;
        int rows = modelo.getRowCount();
        for (int i = 0; i < rows; i++) {
            String var = String.valueOf(modelo.getValueAt(i, 0));
            if (var.equals(aux[0])) {
                modelo.setValueAt(aux[1], i, 1);
                b = true;
                break;
            }
        }
        if (!b) {
            this.modelo.addRow(row);
        }
    }
}
