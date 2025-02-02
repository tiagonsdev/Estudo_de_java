/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author tiago
 */
public class Usuario {
    
    private int id;
    private String login;
    private String Senha;
    private String tipo;

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return Senha;
    }

    public String getTipo() {
        return tipo;
    }
    
    public class UsuarioLogado {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuarioLogado) {
        usuario = usuarioLogado;
    }
}
    
    
}
