/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudinterativo;

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

public class CRUDInterativo {

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

        
        //UPDATE
        
        int idBusca,idadeNova;
        
        Scanner idFunc = new Scanner(System.in);
        
        System.out.println("Informe o id que será atualizado: ");
        idBusca = idFunc.nextInt();
        
        System.out.println("Informe a nova idade");
        idadeNova = idFunc.nextInt();
        
        try{
        
            String sql = null;
            sql = "update alunos set idade = "+ idadeNova +" where id ="+ idBusca;
            stmt.executeUpdate(sql);
            System.out.println("Dados atualizados.");
        }catch(SQLException sqle){
        
            System.out.println("Erro atualizacao : " + sqle.getMessage());
        }
        
        //DELETE
        
        System.out.println("Informe o id da linha a ser excluida");
        idBusca = idFunc.nextInt();
        
        try{
        
            String sql = null;
            sql = "delete from alunos where id =" + idBusca;
            stmt.executeUpdate(sql);
            System.out.println("Dados removidos");
        }catch(SQLException sqle){
        
            System.out.println("Erro remocao : " + sqle.getMessage());
        }
       
        
    }
    
}
