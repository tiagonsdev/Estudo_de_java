/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacaoacessobd2;

/**
 *
 * @author tiago
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Conexao {
    
    Connection conn; //criando um objeto do tipo connection chamado conn
    
    public String url = "jdbc:mysql://localhost:3306//exemplo_senac"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "tiago"; //senha do MySQL
    
    public boolean conectar(){
        
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão realizado comn Exito");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
        
            System.out.println("Falha na conexão com o banco" + ex.getMessage());
            return false;
        }
    }
    
    public void desconectar(){
    
        try{
        
            conn.close();
        }catch(SQLException ex){
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}
