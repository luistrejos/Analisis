package ejecucion;

import java.util.LinkedList;

public class Programa{

LinkedList<String> instrucciones = new LinkedList();
LinkedList<String> resultadoConsola = new LinkedList();

public void imprimir( ){
resultadoConsola.add("hey");instrucciones.add("escriba('hey');");
 }public void main(){
int n;instrucciones.add("int n;"); int i;instrucciones.add("int i;"); int[] f = new int[6];instrucciones.add("int[6] f;");n=5;instrucciones.add("n<-5"); instrucciones.add("for i<-0 to n:");for( i=0 ; i <= n ; i ++){ instrucciones.add("for i<-0 to n:");resultadoConsola.add("hola"+i);instrucciones.add("escriba('hola',i);");
 }}}