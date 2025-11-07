package view.frmproduto;

import client.Cliente;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;

public class FrmEditarProdutos extends javax.swing.JFrame {

    public FrmEditarProdutos() {
        initComponents();
        carregarTabelaProdutos();
    }

    private void carregarTabelaProdutos() {
        try {
            client.Cliente cliente = new client.Cliente();
            cliente.conectar("localhost", 1234);

            cliente.enviarComando("LISTAR_PRODUTOS");
            Object resposta = cliente.receberObjeto();
            cliente.close();

            if (resposta instanceof java.util.List<?>) {
                java.util.List<model.Produto> produtos = (java.util.List<model.Produto>) resposta;

                // Pega o modelo da tabela
                javax.swing.table.DefaultTableModel model
                        = (javax.swing.table.DefaultTableModel) TabelaProdutos.getModel();

                // Limpa tabela antes de preencher
                model.setRowCount(0);

                // Adiciona os produtos na tabela
                for (model.Produto p : produtos) {
                    model.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getTipoUnidade(),
                        p.getPreco(),
                        p.getQuantidadeAtual(),
                        p.getQuantidadeMinima(),
                        p.getQuantidadeMaxima(),
                        (p.getCategoria() != null ? p.getCategoria().getNome() : "")
                    });
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Nenhum produto encontrado.",
                        "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Erro ao carregar produtos:\n" + e.getMessage(),
                    "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFId = new javax.swing.JTextField();
        JTFatual = new javax.swing.JTextField();
        JTFmaxima = new javax.swing.JTextField();
        JTFpreco = new javax.swing.JTextField();
        JTFminima = new javax.swing.JTextField();
        JBAlterar = new javax.swing.JToggleButton();
        JBApagar = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        JCBUnidade = new javax.swing.JComboBox<>();
        JBReajustarPrecos = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Produtos");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        TabelaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        TabelaProdutos.setForeground(new java.awt.Color(0, 0, 0));
        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tipo da unidade", "Preço por unidade ", "Quantidade atual", "Quantidade mínima", "Quantidade máxima", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(TabelaProdutos);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Preço por unidade:");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo da unidade:");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantidade atual em estoque:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantidade mínima em estoque:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantidade máxima em estoque:");

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Categoria:");

        JTFNome.setBackground(new java.awt.Color(255, 255, 255));
        JTFNome.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFNome.setForeground(new java.awt.Color(0, 0, 0));
        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        JTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFIdActionPerformed(evt);
            }
        });

        JTFatual.setBackground(new java.awt.Color(255, 255, 255));
        JTFatual.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFatual.setForeground(new java.awt.Color(0, 0, 0));
        JTFatual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFatualActionPerformed(evt);
            }
        });

        JTFmaxima.setBackground(new java.awt.Color(255, 255, 255));
        JTFmaxima.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFmaxima.setForeground(new java.awt.Color(0, 0, 0));
        JTFmaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFmaximaActionPerformed(evt);
            }
        });

        JTFpreco.setBackground(new java.awt.Color(255, 255, 255));
        JTFpreco.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFpreco.setForeground(new java.awt.Color(0, 0, 0));
        JTFpreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFprecoActionPerformed(evt);
            }
        });

        JTFminima.setBackground(new java.awt.Color(255, 255, 255));
        JTFminima.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFminima.setForeground(new java.awt.Color(0, 0, 0));
        JTFminima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFminimaActionPerformed(evt);
            }
        });

        JBAlterar.setBackground(new java.awt.Color(255, 255, 255));
        JBAlterar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBAlterar.setForeground(new java.awt.Color(0, 0, 51));
        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setBackground(new java.awt.Color(255, 255, 255));
        JBApagar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBApagar.setForeground(new java.awt.Color(0, 0, 51));
        JBApagar.setText("Apagar");

        jToggleButton6.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(0, 0, 51));
        jToggleButton6.setText("Voltar");
        jToggleButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton6MouseClicked(evt);
            }
        });

        JCBUnidade.setBackground(new java.awt.Color(255, 255, 255));
        JCBUnidade.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JCBUnidade.setForeground(new java.awt.Color(0, 0, 0));
        JCBUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UN", "KG", "G", "L", "ML" }));

        JBReajustarPrecos.setBackground(new java.awt.Color(255, 255, 255));
        JBReajustarPrecos.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBReajustarPrecos.setForeground(new java.awt.Color(0, 0, 51));
        JBReajustarPrecos.setText("<html>Alterar o valor de  <br> todos os produtos</html>");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciamento de Produtos existentes");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFminima, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(JTFmaxima, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(JTFatual, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(361, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(JTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(473, 473, 473)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JBApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JBReajustarPrecos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jToggleButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(21, 21, 21)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFminima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFmaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFatual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(JTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(30, 30, 30)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JBAlterar)
                            .addGap(18, 18, 18)
                            .addComponent(JBApagar)
                            .addGap(18, 18, 18)
                            .addComponent(JBReajustarPrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jToggleButton6)))
                    .addContainerGap(223, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTFminimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFminimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFminimaActionPerformed

    private void JTFprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFprecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFprecoActionPerformed

    private void JTFmaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFmaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFmaximaActionPerformed

    private void JTFatualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFatualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFatualActionPerformed

    private void JTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFIdActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeActionPerformed

    private void jToggleButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jToggleButton6MouseClicked

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        // TODO add your handling code here
       try {
        int selectedRow = TabelaProdutos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para alterar.");
            return;
        }

        Produto produto = new Produto();
        produto.setId(Integer.parseInt(TabelaProdutos.getValueAt(selectedRow, 0).toString()));
        produto.setNome(JTFNome.getText());
        produto.setPreco(Double.parseDouble(JTFpreco.getText()));
        produto.setTipoUnidade(JCBUnidade.getSelectedItem().toString());
        produto.setQuantidadeAtual(Integer.parseInt(JTFatual.getText()));
        produto.setQuantidadeMinima(Integer.parseInt(JTFminima.getText()));
        produto.setQuantidadeMaxima(Integer.parseInt(JTFmaxima.getText()));
        produto.setCategoria((Categoria) jComboBox1.getSelectedItem());

        Cliente cliente = new Cliente();
        cliente.enviar("ALTERAR_PRODUTO", produto);

        JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
        carregarTabelaProdutos();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao alterar produto: " + e.getMessage());
    }  
    }//GEN-LAST:event_JBAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmEditarProdutos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JBAlterar;
    private javax.swing.JToggleButton JBApagar;
    private javax.swing.JToggleButton JBReajustarPrecos;
    private javax.swing.JComboBox<String> JCBUnidade;
    private javax.swing.JTextField JTFId;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFatual;
    private javax.swing.JTextField JTFmaxima;
    private javax.swing.JTextField JTFminima;
    private javax.swing.JTextField JTFpreco;
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}
