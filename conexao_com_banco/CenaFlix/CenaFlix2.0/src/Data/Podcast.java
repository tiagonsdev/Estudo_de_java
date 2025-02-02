/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author tiago
 */
public class Podcast {
    
    private String produtor;
    private String nomeEpisodio;
    private String numeroEpisodio;
    private String duracao;
    private String url;
    
    public Podcast(){}

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public String getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getUrl() {
        return url;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public void setNumeroEpisodio(String numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
    
    
}
