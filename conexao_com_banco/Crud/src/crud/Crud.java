/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

/**
 *
 * @author tiago
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Crud {

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
        
        //CREATE
        
        try{
        
            String sql = null;
            
            String nome = "Ana";
            
            sql = "insert into alunos (nome,idade, endereco) values ('Ana','23', 'Rua 7 de setembro 826')";
            stmt.executeUpdate(sql);
            System.out.println("Dados inseridos com exito!");
        }catch(SQLException sqle){
        
            System.out.println("Erro inserindo : " + sqle.getMessage());
        }
        
        //DELETE
        try{
            String sql = null;
            sql = "delete from alunos where id = 1";
            stmt.executeUpdate(sql);
            System.out.println("Dados removidos.");
        }catch(SQLException sqle){
        
            System.out.println("Erro remocao" + sqle.getMessage());
        }
        
        //UPDATE
        
        try{
        
            String sql = null;
            sql = "update alunos set idade = '58' where id =2";
            stmt.executeUpdate(sql);
            System.out.println("Dados atualizados com exito");
        }catch(SQLException sqle){
        
            System.out.println("Erro atualizacao" + sqle.getMessage());
        }
        
        //READ
        
        try{
        
            String sql = "select id,nome,idade,endereco from alunos" ;
            
            //Execultando o comando select
            ResultSet rs = stmt.executeQuery(sql);
            
            //Exibindo os resultados
            while(rs.next()){
            
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                
                System.out.println("dados da tabela autor do banco de dados");
                System.out.println("------------------");
                System.out.println("ID: "+id+"- NOME: "+nome+"- IDADE: "+idade+"- ENDERECO: "+endereco);
            }
        }catch(SQLException sqle){
        
            System.out.println("Erro efetuando consulta" + sqle.getMessage());
        }
        
        //Fechando a conexão com o banco
        try{
        
            con.close();
            System.out.println("Conexão com o banco  fechada com exito");
        }catch(SQLException sqle){
        
            System.out.println("Erro no fechamento da conexão" + sqle.getMessage());
        }
    }
    
}
