package view.frmrelatorio;

import client.Cliente;
import model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorio extends javax.swing.JFrame {

    public FrmRelatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaRelatorio = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        JLValorTotalEstoque = new javax.swing.JLabel();
        comboTipoRelatorio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorio do Estoque");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Relatórios de Estoque");

        btnGerar.setBackground(new java.awt.Color(255, 255, 255));
        btnGerar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btnGerar.setForeground(new java.awt.Color(0, 0, 51));
        btnGerar.setText("Gerar Relatório");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        TabelaRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        TabelaRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        TabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gere um relatório para visualizá-lo"
            }
        ));
        jScrollPane1.setViewportView(TabelaRelatorio);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JLValorTotalEstoque.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N

        comboTipoRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        comboTipoRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        comboTipoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Preços", "Balanço Físico/Financeiro", "Produtos abaixo da quantidade mínima", "Quantidade de produtos por categoria", "Produto com maior entrada e saída" }));
        comboTipoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecione um relatório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboTipoRelatorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(JLValorTotalEstoque)
                    .addContainerGap(1102, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(732, 732, 732)
                    .addComponent(JLValorTotalEstoque)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        // TODO add your handling code here:
        // lê a opção selecionada no combo
        String tipo = (String) comboTipoRelatorio.getSelectedItem();

        if (tipo == null || tipo.equals("Selecione um relatório")) {
            JOptionPane.showMessageDialog(this, "Selecione um tipo de relatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // cria cliente (responsável só pela comunicação)
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 1234);

            // Dispara o método apropriado da UI (métodos locais que recebem o cliente)
            switch (tipo) {
                case "Lista de Preços" ->
                    gerarListaPrecos(cliente);
                case "Balanço Físico/Financeiro" ->
                    gerarBalanco(cliente);
                case "Produtos abaixo da quantidade mínima" ->
                    gerarAbaixoMinimo(cliente);
                case "Quantidade de produtos por categoria" ->
                    gerarQtdPorCategoria(cliente);
                case "Produto com maior entrada e saída" ->
                    gerarMaisMovimentado(cliente);

                default ->
                    JOptionPane.showMessageDialog(this, "Tipo de relatório inválido!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao servidor: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // sempre feche o cliente
            cliente.close();
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    private void comboTipoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoRelatorioActionPerformed

    // ======================= RELATÓRIOS ==========================
    private void gerarListaPrecos(Cliente cliente) {
        try {
            cliente.enviarComando("RELATORIO_LISTA_PREC");
            Object resposta = cliente.receberObjeto();

            if (resposta instanceof List<?>) {
                List<?> lista = (List<?>) resposta;
                DefaultTableModel model = (DefaultTableModel) TabelaRelatorio.getModel();
                model.setRowCount(0);

                model.setColumnIdentifiers(new String[]{"Produto", "Categoria", "Preço (R$)"});

                for (Object obj : lista) {
                    if (obj instanceof Map<?, ?> map) {
                        String produto = String.valueOf(map.get("produto"));
                        String categoria = String.valueOf(map.get("categoria"));
                        String preco = String.valueOf(map.get("preco"));
                        model.addRow(new Object[]{produto, categoria, preco});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado retornado do servidor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar lista de preços: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gerarBalanco(Cliente cliente) {
        try {
            cliente.enviarComando("RELATORIO_BALANCO");
            Object resposta = cliente.receberObjeto();

            if (resposta instanceof List<?>) {
                List<?> lista = (List<?>) resposta;
                DefaultTableModel model = (DefaultTableModel) TabelaRelatorio.getModel();
                model.setRowCount(0);

                model.setColumnIdentifiers(new String[]{
                    "Produto", "Categoria", "Quantidade Atual", "Valor Unitário", "Valor Total"
                });

                for (Object obj : lista) {
                    if (obj instanceof Map<?, ?> map) {
                        String produto = String.valueOf(map.get("produto"));
                        String categoria = String.valueOf(map.get("categoria"));
                        int qtd = Integer.parseInt(String.valueOf(map.get("quantidade")));
                        double preco = Double.parseDouble(String.valueOf(map.get("preco")));
                        double total = qtd * preco;
                        model.addRow(new Object[]{produto, categoria, qtd, preco, total});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado retornado do servidor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar balanço: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gerarAbaixoMinimo(Cliente cliente) {
        try {
            cliente.enviarComando("RELATORIO_ABAIXO_MIN");
            Object resposta = cliente.receberObjeto();

            if (resposta instanceof List<?>) {
                List<?> lista = (List<?>) resposta;
                DefaultTableModel model = (DefaultTableModel) TabelaRelatorio.getModel();
                model.setRowCount(0);

                model.setColumnIdentifiers(new String[]{
                    "Produto", "Categoria", "Qtd Atual", "Qtd Mínima"
                });

                for (Object obj : lista) {
                    if (obj instanceof Map<?, ?> map) {
                        String produto = String.valueOf(map.get("produto"));
                        String categoria = String.valueOf(map.get("categoria"));
                        int qtdAtual = Integer.parseInt(String.valueOf(map.get("quantidade_atual")));
                        int qtdMin = Integer.parseInt(String.valueOf(map.get("quantidade_minima")));
                        model.addRow(new Object[]{produto, categoria, qtdAtual, qtdMin});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado retornado do servidor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório de produtos abaixo do mínimo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gerarQtdPorCategoria(Cliente cliente) {
        try {
            cliente.enviarComando("RELATORIO_QTD_CAT");
            Object resposta = cliente.receberObjeto();

            if (resposta instanceof List<?>) {
                List<?> lista = (List<?>) resposta;
                DefaultTableModel model = (DefaultTableModel) TabelaRelatorio.getModel();
                model.setRowCount(0);

                model.setColumnIdentifiers(new String[]{"Categoria", "Qtd de Produtos"});

                for (Object obj : lista) {
                    if (obj instanceof Map<?, ?> map) {
                        String categoria = String.valueOf(map.get("categoria"));
                        int qtd = Integer.parseInt(String.valueOf(map.get("quantidade")));
                        model.addRow(new Object[]{categoria, qtd});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado retornado do servidor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório por categoria: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gerarMaisMovimentado(Cliente cliente) {
        try {
            cliente.enviarComando("RELATORIO_MAIS_MOV");
            Object resposta = cliente.receberObjeto();

            if (resposta instanceof List<?>) {
                List<?> lista = (List<?>) resposta;
                DefaultTableModel model = (DefaultTableModel) TabelaRelatorio.getModel();
                model.setRowCount(0);

                model.setColumnIdentifiers(new String[]{
                    "Produto", "Categoria", "Entradas", "Saídas", "Total Movimentado"
                });

                for (Object obj : lista) {
                    if (obj instanceof Map<?, ?> map) {
                        String produto = String.valueOf(map.get("produto"));
                        String categoria = String.valueOf(map.get("categoria"));
                        int entradas = Integer.parseInt(String.valueOf(map.get("entradas")));
                        int saidas = Integer.parseInt(String.valueOf(map.get("saidas")));
                        int total = entradas + saidas;
                        model.addRow(new Object[]{produto, categoria, entradas, saidas, total});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado retornado do servidor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório de movimentações: " + e.getMessage());
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmRelatorio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLValorTotalEstoque;
    private javax.swing.JTable TabelaRelatorio;
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> comboTipoRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
