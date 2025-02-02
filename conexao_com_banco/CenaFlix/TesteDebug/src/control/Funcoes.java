/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author tiago
 */

import banco.DaoSelect;
import model.DadosPessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Funcoes {
    
    public void buscaPessoa(){
        DaoSelect daoSelect = new DaoSelect();
        daoSelect.conect();
        ResultSet rs = daoSelect.selectPessoa();
        
        List<DadosPessoa> listPessoa = new ArrayList<>();
        
        try {
            while(rs.next()){
                DadosPessoa dadosPessoa = new DadosPessoa();
                dadosPessoa.setCpf(rs.getString("CPF"));
                dadosPessoa.setId(rs.getInt("ID_PESSOA"));
                dadosPessoa.setIdade(rs.getInt("IDADE"));
                dadosPessoa.setNome(rs.getString("NOME"));
                dadosPessoa.setPeso(rs.getDouble("PESO"));
                dadosPessoa.setTelefone(rs.getString("TELEFONE"));
                listPessoa.add(dadosPessoa);
                
                JOptionPane.showMessageDialog(null, "o nome é : " + dadosPessoa.getNome());
                JOptionPane.showMessageDialog(null, "a idade é : " + dadosPessoa.getIdade());
                JOptionPane.showMessageDialog(null, "o cpf é : " + dadosPessoa.getCpf());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        daoSelect.desconect();
        
        System.out.println(listPessoa.size());
    }
    
    public void inserePessoa(){
        DaoSelect daoSelect = new DaoSelect();
        daoSelect.conect();       
        
        DadosPessoa dadosPessoa = new DadosPessoa();
        dadosPessoa.setCpf("12345678911");
        dadosPessoa.setIdade(11);
        dadosPessoa.setNome("teste");
        dadosPessoa.setPeso(10.0);
        dadosPessoa.setTelefone("15");
        
        daoSelect.insertPessoa(dadosPessoa);
                    
        daoSelect.desconect();
    }
    
}
