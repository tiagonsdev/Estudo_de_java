/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacaoacessobd;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tiago
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
        
            Connection conn; //Criando um objeto do tipo connection chamado conn
            Statement st; //Criandp um objeto do tipo Statemaent chamado st para execução de comando SQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo_senac","root","tiago");
            st = conn.createStatement();
        }catch(ClassNotFoundException ex){
        
            System.out.println("driver não esta disponicel para acesso ou não existe");
        }catch(SQLException ex){
            System.out.println("");
        }
        
    }
    
}
