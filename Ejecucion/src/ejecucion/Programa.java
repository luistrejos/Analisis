package ejecucion;

import java.util.LinkedList;

public class Programa{

LinkedList<String> instrucciones = new LinkedList();
LinkedList<String> resultadoConsola = new LinkedList();

public void imprimir(int p, boolean b, String s){instrucciones.add("procedure imprimir(in int p, out boolean b, in String s):");int h;instrucciones.add("int h;"); float j;instrucciones.add("float j;"); boolean o;instrucciones.add("boolean o;"); String e;instrucciones.add("String e;"); resultadoConsola.add("hey");instrucciones.add("escriba('hey');");
 instrucciones.add("endprocedure");}public void main(){
instrucciones.add("main{");int n;instrucciones.add("int n;"); int i;instrucciones.add("int i;"); int[] f = new int[6];instrucciones.add("int[6] f;");n=2;instrucciones.add("n<-2;"); for( i=0 ; i <= n ; i ++){ instrucciones.add("for i<-0 to n:");resultadoConsola.add("hola"+i);instrucciones.add("escriba('hola',i);");
 }instrucciones.add("for i<-0 to n:");instrucciones.add("endfor"); resultadoConsola.add("Fin algoritmo");instrucciones.add("escriba('Fin algoritmo');");
 instrucciones.add("llame(imprimir(8, true, 'false'));");imprimir (8, true, "false" );instrucciones.add("}");}}