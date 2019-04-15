/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;

/**
 *
 * @author jitzo
 */
public class Principal {

    boolean e;
    public Principal(boolean e) {
        this.e = e;
    }
    
    public void m(){
        String[] args = {};
        if(e){
            try {
            
          Runtime.getRuntime().exec("javac /home/jitzo/NetBeansProjects/Compilador/src/compilador/Programa.java");
          Runtime.getRuntime().exec("java /home/jitzo/NetBeansProjects/Compilador/src/compilador/Programa");
        
      } catch (IOException ex) {
      
          System.out.println(ex);
        }
    }
    
}
}
