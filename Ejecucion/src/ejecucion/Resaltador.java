/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

/**
 *
 * @author David
 */
/**
 * @param fila the fila to set
 */
import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Resaltador extends DefaultTableCellRenderer {

    /**
     * @return the filas
     */
    public LinkedList<Integer> getFilas() {
        return filas;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(LinkedList<Integer> filas) {
        this.filas = filas;
    }

    private Integer fila;
    private LinkedList<Integer> filas = new LinkedList<>();
    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    /**
     * Creamos el resaltador indicando que fila se coloreara por defecto
     *
     * @param row
     */
    public Resaltador(Integer row) {
        fila = row;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);
        table.setForeground(Color.black);
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        for (Integer fila1 : filas) {
            if (table.getValueAt(fila1, 0).equals("A")) {
                this.setForeground(Color.RED);
            } else if (table.getValueAt(fila1, 0).equals("B")) {
                this.setForeground(Color.BLUE);
            } else if (table.getValueAt(fila1, 0).equals("C")) {
                this.setForeground(Color.GREEN);
            } else {
                this.setForeground(Color.BLACK);
            }
        }

        return this;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }
}
