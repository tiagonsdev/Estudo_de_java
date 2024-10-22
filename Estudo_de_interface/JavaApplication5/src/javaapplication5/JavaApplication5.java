/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;

/**
 *
 * @author tiago
 */
import javax.swing.JOptionPane;
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String vendastr = JOptionPane.showInputDialog("Insira o valor da venda");
       
        double venda = Double.parseDouble(vendastr);
        
        if(venda >=500){
        
            String percentualstr = JOptionPane.showInputDialog("Insira o valor do Percentual de desconto");
            
            double percentual = Double.parseDouble(percentualstr);
            
            if(percentual >=1){
            
                double Resultado = (percentual * venda) / 100;
            
                JOptionPane.showMessageDialog(null, Resultado);}
            else{
            
                JOptionPane.showMessageDialog(null, venda);
            }
        
        }
        
        else{
        
            JOptionPane.showMessageDialog(null, venda);
        }
        
        
    }
    
}
