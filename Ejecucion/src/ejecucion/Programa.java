package ejecucion;

import java.util.LinkedList;

public class Programa{

LinkedList<String> instrucciones = new LinkedList();
LinkedList<String> resultadoConsola = new LinkedList();

public void imprimir(int p, boolean b, boolean s){instrucciones.add("procedure imprimir(in int p, out boolean b, in boolean s):");int h;instrucciones.add("int h;"); float j;instrucciones.add("float j;"); boolean o;instrucciones.add("boolean o;"); String e;instrucciones.add("String e;"); resultadoConsola.add("hey");instrucciones.add("escriba('hey');");
 instrucciones.add("llame(imprimir2(3, 4));");imprimir2 (3, 4 ); instrucciones.add("endprocedure");} public int imprimir2(int y, float d){
resultadoConsola.add("heyii");instrucciones.add("escriba('heyii');");
instrucciones.add("return 9;");instrucciones.add("endfunction");return 9;}

public void main(){
instrucciones.add("main{");int n;instrucciones.add("int n;"); int i;instrucciones.add("int i;"); int[] f = new int[6];instrucciones.add("int[6] f;");n=2;instrucciones.add("n<-2;"); for( i=0 ; i <= n ; i ++){ instrucciones.add("for i<-0 to n:");resultadoConsola.add("hola"+i);instrucciones.add("escriba('hola',i);");
 }instrucciones.add("for i<-0 to n:");instrucciones.add("endfor"); resultadoConsola.add("Fin algoritmo");instrucciones.add("escriba('Fin algoritmo');");
 instrucciones.add("llame(imprimir(8, true, false));");imprimir (8, true, false );instrucciones.add("}");}}