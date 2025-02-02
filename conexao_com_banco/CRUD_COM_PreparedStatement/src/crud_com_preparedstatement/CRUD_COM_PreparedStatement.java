/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud_com_preparedstatement;

/**
 *
 * @author tiago
 */

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class CRUD_COM_PreparedStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Criando conexão com o banco
        
        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root";
        String password = "tiago";
        
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC carregado");
        }catch(ClassNotFoundException cnfe){
        
            System.out.println("Driver JDBC não encontrado : " + cnfe.getMessage());
        }
        
        Connection con = null;
        try{
        
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão com o banco estabelecida");
        }catch(SQLException sqle){
        
            System.out.println("Erro na conexão com o banco : " + sqle.getMessage());
        }
        
        Statement stmt = null;
        try{
        
            stmt = con.createStatement();
            System.out.println("Pronto para execucao de comando sql");
        }catch(SQLException sqle){
        
            System.out.println("Erro no acesso ao banco de dados : " + sqle.getMessage());
        }
        
        //INSERT PreparedStatement mode
        
        //Objeto para executar comandos sql
        PreparedStatement ps = null;
        String sql = "insert into alunos values (?,?,?,?)";
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2, "Érico");
            ps.setInt(3,30);
            ps.setString(4, "Rua das araucárias 20");
            
            ps.executeUpdate();

            System.out.println("Dados Inseridos Com Exito");
        }catch(SQLException sqle){
        
            System.out.println("Erro no acesso ao Banco" + sqle.getMessage());
        }
        
        
        //DELETE
        
        String sql2 = "delete from alunos where id=?";
        
        try{
        
            ps = con.prepareStatement(sql2);
            ps.setInt(1, 8);
            ps.executeUpdate();
            
            System.out.println("Dados excluidos com exito.");
        }catch(SQLException sqle){
        
            System.out.println("Erro no acesso ao Banco de Dados : "+ sqle.getMessage());
        }
        
         
        
        String sql3 = "update alunos set nome = ? where id =1";
        
        try {
            ps = con.prepareStatement(sql3);
            ps.setString(1,"Frederico");
            ps.executeUpdate();
            
            System.out.println( "Dados atualizados com sucesso." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro no acesso ao Bando de Dados : "+ sqle.getMessage());
        }
        
        //Fechando conexão
        
        try{
        
            con.close();
        }catch(SQLException sqle){
        
            System.out.println("Erro no fechamento da conexão");
        }
    }
    
    
    
}
