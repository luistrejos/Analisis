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
    boolean ejecutar = true;

    public HiloAutomatico(JTextArea area, JTextArea txtValores, DefaultTableModel modelo,
            LinkedList<String[]> instrucciones, Programa p,
            LinkedList<Integer> cantidadEjecucion,
            LinkedList<Integer> indiceInicioLinea) {
        this.txtAlgoritmo = area;
        this.txtValores = txtValores;
        this.modelo = modelo;
        this.instrucciones = instrucciones;
        this.p = p;
        this.cantidadEjecucion = cantidadEjecucion;
        this.indiceInicioLinea = indiceInicioLinea;
    }

    @Override
    public void run() {
        while (true) {
            if (ejecutar) {
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
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    private void compararCalculoEstudiante() {
        String[] valores = this.txtValores.getText().split("\n");
        for (int i = 0; i < valores.length; i++) {
            int letraCadena = Integer.valueOf(valores[i]);
            if (letraCadena != cantidadEjecucion.get(i)) {
                SubRayar2(indiceInicioLinea.get(i), valores[i].length());
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

    private void InsertarTabla(String s) {
        String[] aux = s.split("<-");
        String[] row = {aux[0], aux[1]};
        this.modelo.addRow(row);
    }

}
