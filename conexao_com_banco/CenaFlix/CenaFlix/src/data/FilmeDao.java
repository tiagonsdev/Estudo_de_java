/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author tiago
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Classe responsável por realizar operações no banco de dados relacionadas aos filmes.
 * Inclui métodos para conexão, formatação de dados, inserção e listagem.
 * 
 * @author Tiago
 */
public class FilmeDao {
    
    private Connection conn;
    private PreparedStatement st;
    private ResultSet rs;

    /**
     * Conecta ao banco de dados.
     * 
     * @return {@code true} se a conexão for bem-sucedida, {@code false} caso contrário
     */
    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix", "root", "tiago");
            System.out.println("Conexão com o banco efetuada com sucesso!");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Formata uma data no formato {@code dd/MM/yyyy} para o formato {@code yyyy-MM-dd}.
     * 
     * @param data a data no formato {@code dd/MM/yyyy}
     * @return a data formatada no formato {@code yyyy-MM-dd}
     * @throws Exception se ocorrer um erro durante a formatação
     */
    public String formatarData(String data) throws Exception {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = formatoEntrada.parse(data);
        return formatoSaida.format(dataFormatada);
    }

    /**
     * Insere um filme no banco de dados.
     * 
     * @param filme o objeto {@link Filme} contendo os dados a serem inseridos
     * @return {@code 1} se a operação for bem-sucedida, {@code -1} se houver erro na formatação da data,
     *         ou o código de erro SQL em caso de falha
     */
    public int salvar(Filme filme) {
        int status;
        try {
            String dataFormatada = formatarData(filme.getData());
            st = conn.prepareStatement("INSERT INTO filmes (nome, datalancamento, categoria) VALUES (?, ?, ?)");
            st.setString(1, filme.getNome());
            st.setString(2, dataFormatada);
            st.setString(3, filme.getCategoria());
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
    public List<Filme> listarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        try {
            st = conn.prepareStatement("SELECT nome, datalancamento, categoria FROM filmes");
            rs = st.executeQuery();
            
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setNome(rs.getString("nome"));
                filme.setData(rs.getString("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));
                filmes.add(filme);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar filmes: " + ex.getMessage());
        }
        return filmes;
    }
   
    
}
