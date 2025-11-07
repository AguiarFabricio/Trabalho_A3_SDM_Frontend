package view.frmproduto;

import client.Cliente;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;
import view.frmprincipal.FrmPrincipal;

/**
 * Janela gráfica responsável por criar e cadastrar um novo produto no sistema.
 *
 * Esta classe utiliza {@link ProdutoDAO} para persistência e
 * {@link CategoriaDAO} para carregar categorias existentes. A interface gráfica
 * permite ao usuário informar nome, preço, unidade, quantidades (estoque,
 * mínima, máxima) e selecionar a categoria correspondente.
 *
 * @author Machadox18
 */
public class FrmCriarProduto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCriarProduto.class.getName());
    private java.util.List<model.Categoria> listaDeCategorias = new java.util.ArrayList<>();

    private void carregarCategorias() {
        try {
            // Conecta ao servidor e pede a lista de categorias
            client.Cliente cliente = new client.Cliente();
            cliente.conectar("localhost", 1234);
            cliente.enviarComando("LISTAR_CATEGORIAS");

            Object resposta = cliente.receberObjeto();
            cliente.close();

            // Debug: imprime resposta no console
            System.out.println("carregarCategorias() resposta = " + (resposta == null ? "null" : resposta.getClass().getName()));

            if (resposta instanceof java.util.List<?>) {
                java.util.List<?> lista = (java.util.List<?>) resposta;

                listaDeCategorias.clear();
                comboCategoria.removeAllItems(); // combo é JComboBox<String> gerado pelo NetBeans

                for (Object obj : lista) {
                    if (obj instanceof model.Categoria) {
                        model.Categoria categoria = (model.Categoria) obj;
                        listaDeCategorias.add(categoria);           // guarda o objeto na lista paralela
                        comboCategoria.addItem(categoria.getNome()); // adiciona SOMENTE o nome (String) ao combo
                        System.out.println("carregarCategorias(): adicionada -> " + categoria.getNome());
                    }
                }

                // se não veio nada, mantém um item informativo
                if (comboCategoria.getItemCount() == 0) {
                    comboCategoria.addItem("Nenhuma categoria disponível");
                }
            } else {
                // caso a resposta não seja lista (debug)
                System.out.println("carregarCategorias: resposta não é List: " + resposta);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Erro ao carregar categorias: " + e.getMessage(),
                    "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public FrmCriarProduto() {
        initComponents();
        carregarCategorias(); // ✅ carrega as categorias no combo ao abrir

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
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQtdAtual = new javax.swing.JTextField();
        txtQtdMax = new javax.swing.JTextField();
        txtQtdMin = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        JBcriar = new javax.swing.JToggleButton();
        comboTipoUnidade = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();

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
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantidade atual em estoque:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Preço por unidade:");

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantidade mínima em estoque:");

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantidade máxima em estoque:");

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtPreco.setBackground(new java.awt.Color(255, 255, 255));
        txtPreco.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        txtPreco.setForeground(new java.awt.Color(0, 0, 0));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        txtQtdAtual.setBackground(new java.awt.Color(255, 255, 255));
        txtQtdAtual.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        txtQtdAtual.setForeground(new java.awt.Color(0, 0, 0));
        txtQtdAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdAtualActionPerformed(evt);
            }
        });

        txtQtdMax.setBackground(new java.awt.Color(255, 255, 255));
        txtQtdMax.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        txtQtdMax.setForeground(new java.awt.Color(0, 0, 0));
        txtQtdMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdMaxActionPerformed(evt);
            }
        });

        txtQtdMin.setBackground(new java.awt.Color(255, 255, 255));
        txtQtdMin.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        txtQtdMin.setForeground(new java.awt.Color(0, 0, 0));
        txtQtdMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdMinActionPerformed(evt);
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

        comboTipoUnidade.setBackground(new java.awt.Color(255, 255, 255));
        comboTipoUnidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        comboTipoUnidade.setForeground(new java.awt.Color(0, 0, 0));
        comboTipoUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UN", "KG", "G", "L", "ML" }));
        comboTipoUnidade.setToolTipText("Kg");
        comboTipoUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUnidadeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo da unidade:");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastre Um Novo Produto");

        comboCategoria.setBackground(new java.awt.Color(255, 255, 255));
        comboCategoria.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        comboCategoria.setForeground(new java.awt.Color(0, 0, 0));
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papelao", "Vidro", "Lata" }));
        comboCategoria.setToolTipText("");
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

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
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQtdAtual, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQtdMax, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQtdMin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboTipoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTipoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void txtQtdAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdAtualActionPerformed

    private void txtQtdMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdMaxActionPerformed

    private void txtQtdMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdMinActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * Evento de clique no botão de cancelar/fechar. Fecha a janela atual.
     *
     * @param evt o evento de clique no botão
     */
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    /**
     * Evento de clique no botão "Criar". Lê os dados informados nos campos,
     * valida as entradas e cria um novo produto. Em caso de sucesso, exibe
     * mensagem de confirmação e limpa os campos.
     *
     * @param evt o evento de clique no botão
     */
    private void JBcriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcriarActionPerformed
        try {
            // Verifica índice selecionado no combo (que contém nomes)
            int idx = comboCategoria.getSelectedIndex();
            model.Categoria categoriaSelecionada = null;

            if (listaDeCategorias != null && idx >= 0 && idx < listaDeCategorias.size()) {
                categoriaSelecionada = listaDeCategorias.get(idx);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Selecione uma categoria válida.",
                        "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Cria e popula o produto usando os nomes de variáveis que você pediu
            model.Produto produto = new model.Produto();
            produto.setNome(txtNome.getText());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            produto.setTipoUnidade(comboTipoUnidade.getSelectedItem().toString());
            produto.setQuantidadeAtual(Integer.parseInt(txtQtdAtual.getText()));
            produto.setQuantidadeMinima(Integer.parseInt(txtQtdMin.getText()));
            produto.setQuantidadeMaxima(Integer.parseInt(txtQtdMax.getText()));
            produto.setCategoria(categoriaSelecionada);

            // Envia ao servidor
            client.Cliente cliente = new client.Cliente();
            cliente.conectar("localhost", 1234);

            cliente.enviarComando("INSERIR_PRODUTO");
            cliente.enviarObjeto(produto);

            String resposta = cliente.receberMensagem();
            cliente.close();

            javax.swing.JOptionPane.showMessageDialog(this,
                    (resposta != null ? resposta : "Produto cadastrado com sucesso!"),
                    "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // ✅ LIMPA OS CAMPOS APÓS O CADASTRO
            txtNome.setText("");
            txtPreco.setText("");
            txtQtdAtual.setText("");
            txtQtdMin.setText("");
            txtQtdMax.setText("");
            comboTipoUnidade.setSelectedIndex(0);
            comboCategoria.setSelectedIndex(0);
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Verifique os campos numéricos (preço, quantidades).",
                    "Erro de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar o produto:\n" + e.getMessage(),
                    "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBcriarActionPerformed

    private void comboTipoUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoUnidadeActionPerformed

    private void JBcriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBcriarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JBcriarMouseClicked

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

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
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboTipoUnidade;
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
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdAtual;
    private javax.swing.JTextField txtQtdMax;
    private javax.swing.JTextField txtQtdMin;
    // End of variables declaration//GEN-END:variables
}
