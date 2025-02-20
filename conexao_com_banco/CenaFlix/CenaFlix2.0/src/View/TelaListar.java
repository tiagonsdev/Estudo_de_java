/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Data.Podcast;
import Data.PodcastDao;
import Data.Usuario;
import Data.Usuario.UsuarioLogado;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiago
 */
public class TelaListar extends javax.swing.JFrame {

    /**
     * Creates new form TelaListar
     */
    
    Usuario usuario = new Usuario();
    
    public TelaListar() {
        initComponents();
        carregarTabela();
        ajustarVisibilidadeBotoes();
        
    
    }
    
    private void carregarTabela() {
        PodcastDao dao = new PodcastDao();
        if (dao.conectar()) {
            List<Podcast> podcasts = dao.ListarPodcasts();
            dao.desconectar();

            // Configurar o modelo da tabela
            DefaultTableModel model = (DefaultTableModel) tblCatalogo.getModel();
            model.setRowCount(0); // Limpar a tabela antes de adicionar os dados

            for (Podcast podcast : podcasts) {
                model.addRow(new Object[]{podcast.getProdutor(), podcast.getNomeEpisodio(), podcast.getNumeroEpisodio(),podcast.getDuracao(),podcast.getUrl()});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }
    
    
   private void ajustarVisibilidadeBotoes() {
        // Acessa o usuário logado
        Usuario usuarioLogado = UsuarioLogado.getUsuario();

        if (usuarioLogado != null) {
            String tipoUsuario = usuarioLogado.getTipo();

            // Ajusta a visibilidade dos botões com base no tipo de usuário
            if ("operador".equalsIgnoreCase(tipoUsuario)) {
                btnExcluir.setVisible(false); // Esconde o botão Excluir
            } else if ("usuario".equalsIgnoreCase(tipoUsuario)) {
                btnExcluir.setVisible(false); // Esconde o botão Excluir
                btnCadastrar.setVisible(false); // Esconde o botão Cadastrar
            } else {
                btnExcluir.setVisible(true); // Exibe o botão Excluir
                btnCadastrar.setVisible(true); // Exibe o botão Cadastrar
            }
    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatalogo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProdutor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtor", "Nome do Episodio", "N° Episodio", "Duração", "URL do Repo"
            }
        ));
        jScrollPane1.setViewportView(tblCatalogo);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("CenaFlix");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Listagem");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pesquisar podcast por produtor");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(213, 213, 213))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProdutor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProdutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnExcluir))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastro cadastrar = new TelaCadastro();
        cadastrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblCatalogo.getSelectedRow(); // Pega a linha selecionada

    if (selectedRow != -1) { // Verifica se uma linha foi selecionada
        // Pega o ID do podcast selecionado (assumindo que a primeira coluna seja o ID ou algum identificador único)
        String nomeEpisodio = tblCatalogo.getValueAt(selectedRow, 1).toString(); // Exemplo, pegando o nome do episódio

        PodcastDao dao = new PodcastDao();
        if (dao.conectar()) {
            int status = dao.excluirPodcast(nomeEpisodio); // Chama o método de exclusão passando o identificador
            dao.desconectar();

            if (status > 0) {
                // Se a exclusão for bem-sucedida, remove a linha da tabela
                DefaultTableModel model = (DefaultTableModel) tblCatalogo.getModel();
                model.removeRow(selectedRow); // Remove a linha da tabela
                JOptionPane.showMessageDialog(this, "Podcast excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir podcast.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um podcast para excluir.");
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

     // Obtendo o valor do campo txtProdutor
    String produtor = txtProdutor.getText().trim(); // .trim() para remover espaços extras

    // Verificando se o campo txtProdutor não está vazio
    if (!produtor.isEmpty()) {
        // Cria um objeto PodcastDao para acessar o banco de dados
        PodcastDao podcastDao = new PodcastDao();
        podcastDao.conectar();  // Conecta ao banco de dados

        // Busca os podcasts filtrados por produtor
        List<Podcast> podcasts = podcastDao.ListarPodcastsPorProdutor(produtor);

        // Limpar os resultados anteriores (se houver uma tabela de resultados)
        DefaultTableModel modelo = (DefaultTableModel) tblCatalogo.getModel();
        modelo.setRowCount(0);  // Limpa a tabela antes de adicionar os novos resultados

        // Adiciona os resultados na tabela
        for (Podcast podcast : podcasts) {
            modelo.addRow(new Object[] {
                podcast.getProdutor(),
                podcast.getNomeEpisodio(),
                podcast.getNumeroEpisodio(),
                podcast.getDuracao(),
                podcast.getUrl()
            });
        }

        // Fecha a conexão com o banco de dados
        podcastDao.desconectar();
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, insira um nome de produtor.");
    }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCatalogo;
    private javax.swing.JTextField txtProdutor;
    // End of variables declaration//GEN-END:variables
}
