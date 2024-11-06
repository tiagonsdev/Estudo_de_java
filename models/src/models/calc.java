/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package models;

/**
 *
 * @author tiago
 */
public class calc {

    /**
     * @param args the command line arguments
     */
    public double Calcular(double valor1,double valor2 , String operacao){
        double resultado = 0.0;
        
        switch(operacao){
            case "Soma":
                resultado = valor1 + valor2;
                break;
            
            case "Subtracao":
                resultado = valor1 - valor2;
                break;
            
            case "Multiplicacao":
                resultado = valor1 * valor2;
                break;
                
            case "Divisao":
                if(valor2 != 0){
                    resultado = valor1/valor2;
                }else{
                    throw new ArithmeticException("Divisão por 0 não é permitida!!!");
                }
                
                break;
        
        
        }
        return resultado;    
    }
    
}
