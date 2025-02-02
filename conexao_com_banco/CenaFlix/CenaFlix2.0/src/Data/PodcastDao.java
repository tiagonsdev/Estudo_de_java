/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tiago
 */
public class PodcastDao {

    private Connection conn;
    private PreparedStatement st;
    private ResultSet rs;

    /**
     * Conecta ao banco de dados.
     *
     * @return {@code true} se a conexão for bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix2", "root", "tiago");
            System.out.println("Conexão com o banco efetuada com sucesso!");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public int salvar(Podcast podcast) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO podcast (produtor, nomeEpisodio, numeroEpisodio,duracao,url  ) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, podcast.getProdutor());
            st.setString(2, podcast.getNomeEpisodio());
            st.setString(3, podcast.getNumeroEpisodio());
            st.setString(4, podcast.getDuracao());
            st.setString(5, podcast.getUrl());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar filme: " + ex.getMessage());
            return ex.getErrorCode();
        } catch (Exception ex) {
            System.out.println("Erro ao formatar data: " + ex.getMessage());
            return -1;
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            // Ignorar erros de fechamento para evitar mensagens desnecessárias
        }
    }

    /**
     * Lista todos os filmes presentes no banco de dados.
     *
     * @return uma lista de objetos {@link Filme} contendo os dados dos filmes
     */
    public List<Podcast> ListarPodcasts() {
        List<Podcast> podcasts = new ArrayList<>();
        try {
            st = conn.prepareStatement("SELECT produtor, nomeEpisodio, numeroEpisodio,duracao,url FROM podcast");
            rs = st.executeQuery();

            while (rs.next()) {
                Podcast podcast = new Podcast();
                podcast.setProdutor(rs.getString("produtor"));
                podcast.setNomeEpisodio(rs.getString("nomeEpisodio"));
                podcast.setNumeroEpisodio(rs.getString("numeroEpisodio"));
                podcast.setDuracao(rs.getString("duracao"));
                podcast.setUrl(rs.getString("url"));
                podcasts.add(podcast);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar filmes: " + ex.getMessage());
        }
        return podcasts;
    }

    public int excluirPodcast(String nomeEpisodio) {
        int status;
        try {
            // SQL para excluir o podcast com base no nome do episódio
            st = conn.prepareStatement("DELETE FROM podcast WHERE nomeEpisodio = ?");
            st.setString(1, nomeEpisodio);  // Define o parâmetro para o nome do episódio
            status = st.executeUpdate();  // Executa a atualização (exclusão)

            // Retorna o número de linhas afetadas, se for maior que 0, significa que a exclusão foi bem-sucedida
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir podcast: " + ex.getMessage());
            return -1;  // Retorna -1 se ocorrer um erro
        }
    }
    
    public List<Podcast> ListarPodcastsPorProdutor(String produtor) {
    List<Podcast> podcasts = new ArrayList<>();
    try {
        // Consulta SQL para buscar podcasts filtrados pelo produtor
        st = conn.prepareStatement("SELECT produtor, nomeEpisodio, numeroEpisodio, duracao, url FROM podcast WHERE produtor LIKE ?");
        st.setString(1, "%" + produtor + "%");  // Utiliza LIKE para buscar por parte do nome do produtor
        rs = st.executeQuery();

        // Adiciona os podcasts encontrados à lista
        while (rs.next()) {
            Podcast podcast = new Podcast();
            podcast.setProdutor(rs.getString("produtor"));
            podcast.setNomeEpisodio(rs.getString("nomeEpisodio"));
            podcast.setNumeroEpisodio(rs.getString("numeroEpisodio"));
            podcast.setDuracao(rs.getString("duracao"));
            podcast.setUrl(rs.getString("url"));
            podcasts.add(podcast);
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao listar podcasts: " + ex.getMessage());
    }
    return podcasts;
}

}




