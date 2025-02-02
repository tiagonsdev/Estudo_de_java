/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author tiago
 */



public class Filme {
    
    private String nome;
    private String data;
    private String categoria;

    /**
     * Construtor padrão da classe Filme.
     */
    public Filme() {}

    /**
     * Obtém o nome do filme.
     * 
     * @return o nome do filme
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do filme.
     * 
     * @param nome o nome do filme
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data do filme.
     * 
     * @return a data do filme no formato {@code String}
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data do filme.
     * 
     * @param data a data do filme no formato {@code String}
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obtém a categoria do filme.
     * 
     * @return a categoria do filme
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do filme.
     * 
     * @param categoria a categoria do filme
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
