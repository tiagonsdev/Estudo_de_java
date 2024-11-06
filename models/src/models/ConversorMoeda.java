/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tiago
 */
public class ConversorMoeda {
    
    public double converter(double valor, String tipoConversor){
        double resultado = 0.0;
        
        switch(tipoConversor){
            case "RealParaDolar":
                resultado = valor/5.0;
                break;
            
            case "DolarParaReal":
                resultado = valor *5.0;
                break;
            
            case "RealParaEuro":
                resultado = valor /6.0;
                break;
                
            case "EuroParaReal":
                resultado = valor *6.0;
                break;
        
        
        }
        return resultado;
    }
    
}
