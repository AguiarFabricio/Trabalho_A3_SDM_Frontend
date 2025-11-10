package view.frmmovimentacao;

// === Imports adicionais necessários ===
import model.Produto;
import model.Movimentacao;
import client.Cliente;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Janela para gerenciar movimentações de estoque.
 *
 * <p>
 * Permite visualizar o histórico de movimentações, selecionar um produto,
 * escolher o tipo de movimentação (entrada ou saída), informar a quantidade e
 * registrar essa movimentação no banco de dados.</p>
 *
 * @author EvelynYs2
 * @version 1.0
 */
public class FrmMovimentarEstoque extends javax.swing.JFrame {

    public FrmMovimentarEstoque() {
        initComponents();
        carregarHistorico();
        carregarProdutos();
    }

    /**
     * Carrega o histórico de movimentações do servidor e exibe na tabela
     * JTableHistoricoMovimentacoes.
     */
    private void carregarHistorico() {
        try {
            // Abre conexão com o servidor
            Cliente cliente = new Cliente();
            cliente.conectar("localhost", 1234);

            // Pede ao servidor a lista de movimentações
            @SuppressWarnings("unchecked")
            List<Movimentacao> lista = (List<Movimentacao>) cliente.enviarComandoReceberObjeto("LISTAR_MOVIMENTACOES");

            // Fecha a conexão imediatamente após receber a lista
            cliente.close();

            // Obtém o modelo atual da tabela e limpa todas as linhas
            DefaultTableModel model = (DefaultTableModel) JTableHistoricoMovimentacoes.getModel();
            model.setRowCount(0); // limpa a tabela antes de popular

            // Formato de data/hora para exibir no fim da linha
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm a");

            // Percorre as movimentações recebidas e adiciona no modelo da tabela
            for (Movimentacao m : lista) {
                // Proteção contra nulls para evitar NullPointerException ao montar a linha
                String nomeProduto = (m.getProduto() != null && m.getProduto().getNome() != null)
                        ? m.getProduto().getNome()
                        : "N/A";

                String tipo = (m.getTipo() != null) ? m.getTipo() : "N/A";
                int quantidade = m.getQuantidade();
                String data = (m.getDataMovimentacao() != null) ? sdf.format(m.getDataMovimentacao()) : "Sem data";

                /*
             * Ordem pedida:
             * 0 -> ID movimentação
             * 1 -> Nome produto
             * 2 -> Tipo movimentação (ENTRADA / SAIDA)
             * 3 -> Quantidade movimentada
             * 4 -> Data (formato dd/MM/yyyy HH:mm:ss)
                 */
                model.addRow(new Object[]{
                    m.getId(),
                    nomeProduto,
                    tipo,
                    quantidade,
                    data
                });
            }

            System.out.println("✅ Movimentações carregadas: " + lista.size());

        } catch (Exception e) {
            // Mensagem amigável para o usuário e log para o desenvolvedor
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar movimentações: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Carrega a lista de produtos do servidor e preenche o JComboBox
     * "comboProdutos" com os nomes.
     */
// ====================
// NOVO carregarProdutos()
// ====================
    private void carregarProdutos() {
        try {
            Cliente cliente = new Cliente();
            cliente.conectar("localhost", 1234);

            cliente.enviarComando("LISTAR_PRODUTOS");
            Object resposta = cliente.receberObjeto();
            cliente.close();

            comboProdutos.removeAllItems();

            if (resposta instanceof ArrayList<?>) {
                ArrayList<?> lista = (ArrayList<?>) resposta;
                for (Object obj : lista) {
                    if (obj instanceof Produto produto) {
                        comboProdutos.addItem(produto); // agora guarda o objeto inteiro
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar produtos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboProdutos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JEntrada = new javax.swing.JRadioButton();
        JSaida = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        JTextQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JBConfirmar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableHistoricoMovimentacoes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Movimentações do Estoque");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecionar Produto:");

        comboProdutos.setBackground(new java.awt.Color(255, 255, 255));
        comboProdutos.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        comboProdutos.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de Movimentação:");

        JEntrada.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JEntrada);
        JEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JEntrada.setForeground(new java.awt.Color(0, 0, 51));
        JEntrada.setSelected(true);
        JEntrada.setText("Entrada");
        JEntrada.setBorder(null);

        JSaida.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JSaida);
        JSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JSaida.setForeground(new java.awt.Color(0, 0, 51));
        JSaida.setText("Saida");
        JSaida.setBorder(null);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade a movimentar:");

        JTextQtd.setBackground(new java.awt.Color(255, 255, 255));
        JTextQtd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        JTextQtd.setForeground(new java.awt.Color(0, 0, 0));
        JTextQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextQtdActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Movimentar estoque:");

        JBConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        JBConfirmar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBConfirmar.setForeground(new java.awt.Color(0, 0, 51));
        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        JBCancelar.setBackground(new java.awt.Color(255, 255, 255));
        JBCancelar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBCancelar.setForeground(new java.awt.Color(0, 0, 51));
        JBCancelar.setText("Voltar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gerenciamento de movimentações");

        JTableHistoricoMovimentacoes.setBackground(new java.awt.Color(255, 255, 255));
        JTableHistoricoMovimentacoes.setForeground(new java.awt.Color(0, 0, 0));
        JTableHistoricoMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID movimentação", "Nome produto", "Tipo movimentacao", "Quantidade movimentada", "Data"
            }
        ));
        jScrollPane2.setViewportView(JTableHistoricoMovimentacoes);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Historico de movimentações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JEntrada)
                                .addGap(18, 18, 18)
                                .addComponent(JSaida))
                            .addComponent(jLabel5))))
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addContainerGap(15, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JSaida)
                            .addComponent(JEntrada))
                        .addGap(19, 19, 19)
                        .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBConfirmar)
                        .addGap(26, 26, 26)
                        .addComponent(JBCancelar)))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(52, 52, 52)
                    .addComponent(jLabel3)
                    .addGap(66, 66, 66)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        //fecha a janela
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            // 🔹 1. Captura o produto selecionado (agora é o objeto completo)
            Produto produto = (Produto) comboProdutos.getSelectedItem();
            if (produto == null) {
                JOptionPane.showMessageDialog(this,
                        "Selecione um produto.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 🔹 2. Tipo de movimentação
            String tipoMov = JEntrada.isSelected() ? "ENTRADA" : (JSaida.isSelected() ? "SAIDA" : null);
            if (tipoMov == null) {
                JOptionPane.showMessageDialog(this,
                        "Selecione o tipo de movimentação.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 🔹 3. Quantidade
            int quantidade = Integer.parseInt(JTextQtd.getText());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this,
                        "A quantidade deve ser maior que zero.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 🔹 4. Cria o objeto movimentação
            Movimentacao mov = new Movimentacao(produto, tipoMov, quantidade, new java.util.Date());

            // 🔹 5. Envia pro servidor
            Cliente cliente = new Cliente();
            cliente.conectar("localhost", 1234);
            cliente.enviarComando("INSERIR_MOVIMENTACAO");
            cliente.enviarObjeto(mov);

            String resposta = cliente.receberMensagem();
            cliente.close();

            JOptionPane.showMessageDialog(this,
                    (resposta != null ? resposta : "Movimentação registrada com sucesso!"),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            carregarHistorico();
            JTextQtd.setText("");
            buttonGroup1.clearSelection();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Quantidade inválida. Digite apenas números.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao registrar movimentação: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBConfirmarActionPerformed

    private void JTextQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextQtdActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentarEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBConfirmar;
    private javax.swing.JRadioButton JEntrada;
    private javax.swing.JRadioButton JSaida;
    private javax.swing.JTable JTableHistoricoMovimentacoes;
    private javax.swing.JTextField JTextQtd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Produto> comboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
