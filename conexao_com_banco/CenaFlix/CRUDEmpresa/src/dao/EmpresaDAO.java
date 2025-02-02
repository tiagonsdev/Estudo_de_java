package dao;

import beans.Empresa;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpresaDAO {

    private Conexao conexao;
    private Connection conn;

    public EmpresaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Empresa empresa) {
        String sql = "INSERT INTO empresa(nomeempresa, areaatuacao) VALUES "
                + "(?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, empresa.getNomeempresa());
            stmt.setString(2, empresa.getAreaatuacao());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
        }
    }

    public Empresa getEmpresa(int id) {
        String sql = "SELECT * FROM empresa WHERE id = ?";
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Empresa empresa = new Empresa();

            rs.next();
            empresa.setId(id);
            empresa.setNomeempresa(rs.getString("nomeempresa"));
            empresa.setAreaatuacao(rs.getString("areaatuacao"));

            return empresa;

            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

}
