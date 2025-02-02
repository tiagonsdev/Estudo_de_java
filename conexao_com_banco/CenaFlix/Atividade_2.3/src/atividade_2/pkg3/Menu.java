/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atividade_2.pkg3;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tiago
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public JTable getTblConsultas() {
        return tblConsultas;
    }

    public Menu() {
        initComponents();
        chamarTabela();
        configurarBotaoFinalizar();
    }
    
    private void configurarBotaoFinalizar() {
    btnFinalizar.setVisible(false); // Inicialmente invisível

    // Adiciona um ListSelectionListener para monitorar mudanças de seleção
    tblConsultas.getSelectionModel().addListSelectionListener(e -> {
        boolean isRowSelected = tblConsultas.getSelectedRow() != -1; // Verifica se há linha selecionada
        btnFinalizar.setVisible(isRowSelected); // Alterna visibilidade com base na seleção
    });
    }

    public void chamarTabela() {

        // A primeira vez que for chamado, cria o modelo com as colunas e sem linhas
        if (tblConsultas.getModel().getRowCount() == 0) {
            DefaultTableModel modeloDefault = new DefaultTableModel(
                    new String[]{"Paciente", "CPF", "Telefone", "Data", "jaPAciente", "ConsultaRealizada"}, 0);
            tblConsultas.setModel(modeloDefault);
        }

        // Limpa todas as linhas
        DefaultTableModel modeloDefault = (DefaultTableModel) tblConsultas.getModel();
        modeloDefault.setRowCount(0);

        // Preenche as linhas com os dados da lista de consultas
        for (int i = 0; i < Main.consultas.size(); i++) {
            Consultas consulta = Main.consultas.get(i);
            if (consulta == null) {
                continue;  // Ignora consultas nulas
            }

            Object[] linha = {
                consulta.getPaciente(),
                consulta.getCpf(),
                consulta.getTelefone(),
                consulta.getData(),
                consulta.getJaPaciente(),
                consulta.getConsultaRealizada()
            };

            modeloDefault.addRow(linha); // Adiciona a linha ao modelo da tabela
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "CPF", "Telefone", "Data", "JaPaciente", "ConsultaRealizada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblConsultas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Boas Vindas ao Sistema de Agendamento");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Nova Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizar.setText("Finalizar Consulta");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir Consulta");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(109, 109, 109)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnFinalizar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastrarConsulta cadastro = new CadastrarConsulta();
        cadastro.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int excluir = tblConsultas.getSelectedRow();

        if (excluir >= 0) {

            Main.consultas.remove(excluir);
            chamarTabela();

        } else {

            JOptionPane.showMessageDialog(null, "Favor Selecionar uma consulta");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed

        int id = tblConsultas.getSelectedRow();

        if (id != -1) { // Verifica se alguma linha foi selecionada
            System.out.println("A posição no vetor da linha selecionada é: " + id);

            // Obtém os dados da linha selecionada
            Consultas consultaSelecionada = Main.consultas.get(id);

            // Cria um novo objeto Consultas com os dados da linha selecionada
            Consultas consultas = new Consultas();
            consultas.setId(consultaSelecionada.getId());
            consultas.setPaciente(consultaSelecionada.getPaciente());
            consultas.setCpf(consultaSelecionada.getCpf());
            consultas.setTelefone(consultaSelecionada.getTelefone());
            consultas.setData(consultaSelecionada.getData());
            consultas.setJaPaciente(consultaSelecionada.getJaPaciente());
            consultas.setConsultaRealizada("Sim"); // Ou outro valor que você deseja definir

            // Verifica se a consulta já existe na lista antes de adicionar
            boolean consultaExiste = false;
            for (Consultas c : Main.consultas) {
                if (c.getId() == consultas.getId()) {
                    consultaExiste = true;
                    break;
                }
            }

            if (!consultaExiste) {
                // Adiciona o objeto Consultas preenchido à lista
                Main.consultas.add(consultas);
            } else {
                System.out.println("Consulta já existente na lista.");
            }

            // Abre o formulário Finalizar
            Finalizar finalizar = new Finalizar(this);
            finalizar.setVisible(true);

        } else {
            System.out.println("Nenhuma linha foi selecionada.");
        }


    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
