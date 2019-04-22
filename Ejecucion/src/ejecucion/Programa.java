package ejecucion;

import java.util.LinkedList;

public class Programa {

    LinkedList<String> instrucciones = new LinkedList();
    LinkedList<String> resultadoConsola = new LinkedList();
    LinkedList<String> variables = new LinkedList();

    public void main() {
        instrucciones.add("main{");
        int n;
        instrucciones.add("int n;");
        n = 2;
        instrucciones.add("n<-2;");
        variables.add("n<-" + n);
        for (int i = 0; i <= n; i++) {
            instrucciones.add("for i<-0 to n:");
            variables.add("i<-" + i);
            resultadoConsola.add("hola " + i);
            instrucciones.add("escriba('hola',i);");
        }
        instrucciones.add("for i<-0 to n:");
        instrucciones.add("endfor");
        instrucciones.add("if(n<1):");
        if (n < 1) {
            n = 8;
            instrucciones.add("n<-8;");
            variables.add("n<-" + n);
        } else {
            instrucciones.add("else");
            n = 3;
            instrucciones.add("n<-3;");
            variables.add("n<-" + n);
        }
        instrucciones.add("endif");
        do {
            instrucciones.add("repeat:");
            resultadoConsola.add("repeattt");
            instrucciones.add("escriba('repeattt');");
            n = (n - 1);
            instrucciones.add("n<-(n-1);");
            variables.add("n<-" + n);
            instrucciones.add("while(n>0);");
        } while (n > 0);
        resultadoConsola.add("Fin algoritmo");
        instrucciones.add("escriba('Fin algoritmo');");
        instrucciones.add("}");
    }
}
