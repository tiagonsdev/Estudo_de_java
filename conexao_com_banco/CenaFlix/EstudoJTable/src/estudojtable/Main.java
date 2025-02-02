/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudojtable;

import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Persona> personas;
    
    public static void main(String[] args) {
        
        personas = new ArrayList<>();
        
        IngressoPersona ventana = new IngressoPersona();
        ventana.setVisible(true);
        
    }
    
}
