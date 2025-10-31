package view.frmproduto;

/**
 * Janela gráfica responsável por criar e cadastrar um novo produto no sistema.
 *
 * Esta classe utiliza {@link ProdutoDAO} para persistência e {@link CategoriaDAO}
 * para carregar categorias existentes. A interface gráfica permite ao usuário
 * informar nome, preço, unidade, quantidades (estoque, mínima, máxima) e
 * selecionar a categoria correspondente.
 *
 * @author Machadox18
 */
public class FrmCriarProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName());

    /**
     * Creates new form FrmGerenciarProdutos
     */
    public FrmCriarProduto() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFpreco = new javax.swing.JTextField();
        JTFatual = new javax.swing.JTextField();
        JTFmaxima = new javax.swing.JTextField();
        JTFminima = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        JBcriar = new javax.swing.JToggleButton();
        JCBUnidade = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        JCBCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton2.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jToggleButton2.setText("Sair");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastramento de Produtos");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel5.setText("Categoria:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel9.setText("Quantidade atual em estoque:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel10.setText("Preço por unidade:");

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel11.setText("Quantidade mínima em estoque:");

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel12.setText("Quantidade máxima em estoque:");

        JTFNome.setBackground(new java.awt.Color(255, 255, 255));
        JTFNome.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFNome.setForeground(new java.awt.Color(0, 0, 0));
        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
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

        JTFminima.setBackground(new java.awt.Color(255, 255, 255));
        JTFminima.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JTFminima.setForeground(new java.awt.Color(0, 0, 0));
        JTFminima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFminimaActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(0, 0, 51));
        jToggleButton3.setText("Voltar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        JBcriar.setBackground(new java.awt.Color(255, 255, 255));
        JBcriar.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        JBcriar.setForeground(new java.awt.Color(0, 0, 51));
        JBcriar.setText("Cadastrar");
        JBcriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBcriarMouseClicked(evt);
            }
        });
        JBcriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcriarActionPerformed(evt);
            }
        });

        JCBUnidade.setBackground(new java.awt.Color(255, 255, 255));
        JCBUnidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        JCBUnidade.setForeground(new java.awt.Color(0, 0, 0));
        JCBUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UN", "KG", "G", "L", "ML" }));
        JCBUnidade.setToolTipText("Kg");
        JCBUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBUnidadeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel13.setText("Tipo da unidade:");

        JCBCategoria.setBackground(new java.awt.Color(255, 255, 255));
        JCBCategoria.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        JCBCategoria.setForeground(new java.awt.Color(0, 0, 0));
        JCBCategoria.setToolTipText("Kg");
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel1.setText("Cadastre Um Novo Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBcriar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTFNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFatual, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JCBCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JTFpreco, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFmaxima, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFminima, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCBUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFatual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFminima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFmaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(JBcriar)
                .addGap(27, 27, 27)
                .addComponent(jToggleButton3)
                .addGap(61, 61, 61))
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

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_JTFNomeActionPerformed

    private void JTFprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFprecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFprecoActionPerformed

    private void JTFatualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFatualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFatualActionPerformed

    private void JTFmaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFmaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFmaximaActionPerformed

    private void JTFminimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFminimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFminimaActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * Evento de clique no botão de cancelar/fechar.
     * Fecha a janela atual.
     *
     * @param evt o evento de clique no botão
     */
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    /**
     * Evento de clique no botão "Criar".
     * Lê os dados informados nos campos, valida as entradas e cria um novo produto.
     * Em caso de sucesso, exibe mensagem de confirmação e limpa os campos.
     *
     * @param evt o evento de clique no botão
     */
    private void JBcriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcriarActionPerformed

    }//GEN-LAST:event_JBcriarActionPerformed

    private void JCBUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBUnidadeActionPerformed

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBCategoriaActionPerformed

    private void JBcriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBcriarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JBcriarMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCriarProduto().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JBcriar;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JComboBox<String> JCBUnidade;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFatual;
    private javax.swing.JTextField JTFmaxima;
    private javax.swing.JTextField JTFminima;
    private javax.swing.JTextField JTFpreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}