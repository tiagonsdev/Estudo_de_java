/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author tiago
 */

import model.DadosPessoa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaoSelect {
 
    private Conexao conexao;
    private Statement stm;
    private Connection con;
    private ResultSet rs;
    
    public void conect() {
        try {
            conexao = new Conexao();
            con = conexao.getConection();
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void desconect() {
        try {
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ResultSet selectPessoa() {
        try {
            return stm.executeQuery("SELECT * FROM PESSOA");
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public void insertPessoa(DadosPessoa d){
        try {
            stm.execute("INSERT INTO PESSOA (NOME, TELEFONE, IDADE, PESO, CPF) VALUES ('"+d.getNome()+"', '"+d.getTelefone()+"', "+d.getIdade()+", "+d.getPeso()+", '"+d.getCpf()+"');");
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }}
    
    
}
