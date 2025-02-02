/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade_2.pkg3;

import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Consultas> consultas;
    
    public static void main(String[] args) {
        
        consultas = new ArrayList<>();
        
        CadastrarConsulta cadastro = new CadastrarConsulta();
        
        cadastro.setVisible(true);
        
    }
    
}
