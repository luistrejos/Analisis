package ejecucion;

import java.util.LinkedList;

public class Programa {

    LinkedList<String> instrucciones = new LinkedList();
    LinkedList<String> resultadoConsola = new LinkedList();

    public void main() {
        instrucciones.add("main{");
        int n;
        instrucciones.add("int n;");
        n = 2;
        instrucciones.add("n<-2;");
        for (int i = 0; i <= n; i++) {
            instrucciones.add("for i<-0 to n:");
            resultadoConsola.add("hola " + i);
            instrucciones.add("escriba('hola',i);");
        }
        instrucciones.add("for i<-0 to n:");
        instrucciones.add("endfor");
        resultadoConsola.add("Fin algoritmo");
        instrucciones.add("escriba('Fin algoritmo');");
        instrucciones.add("}");
    }
}
