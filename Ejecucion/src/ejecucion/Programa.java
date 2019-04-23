package ejecucion;

import java.util.LinkedList;

public class Programa{

LinkedList<String> instrucciones = new LinkedList();
LinkedList<String> resultadoConsola = new LinkedList();
LinkedList<String> variables = new LinkedList();

public void main(){
instrucciones.add("main{");int n;instrucciones.add("int n;");n=10;instrucciones.add("n<-10;");variables.add("n<-"+n); for( int i=1 ; i <= n ; i ++){ instrucciones.add("for i<-1 to n:");variables.add("i<-"+i);resultadoConsola.add("análisis");instrucciones.add("escriba('análisis');");
 }instrucciones.add("for i<-1 to n:");instrucciones.add("endfor");instrucciones.add("}");}}