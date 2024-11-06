/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalaluno.model;

/**
 *
 * @author tiago
 */
public class Aluno {
    
    //Declaração de variaveis
    private String nome;
    private String email;
    private String curso;
    
     //Metodos para acessar e atualizar dados das variaveis
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
   
    
