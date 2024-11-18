/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ItemCarrinhoDAO;
import controller.ItemHistoricoDAO;
import controller.ProdutoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.ItemCarrinho;
import model.ItemHistorico;
import model.Produto;
import model.Usuario;

public class FormVendas extends javax.swing.JFrame {

    private Usuario usuario;

    public FormVendas(Usuario us) {
        initComponents();
        this.usuario = us;
        this.setLocationRelativeTo(null);
        this.setTitle("Vendas");
        popularCombo();
        popularLista();

    }

    public void popularCombo() {
        DefaultComboBoxModel limpar = new DefaultComboBoxModel<>();
        removerCombo.setModel(limpar);
        adicionarCombo.setModel(limpar);
        List<Produto> lista = new ProdutoDAO().listarProdutos();
        DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
        for (Produto p : lista) {
            combo.addElement(p);
        }
        DefaultComboBoxModel combo2 = new DefaultComboBoxModel<>();
        List<ItemCarrinho> lista2 = new ItemCarrinhoDAO().listarItens(usuario.getId());
        for (ItemCarrinho it : lista2) {
            combo2.addElement(it);

        }
        adicionarCombo.setModel(combo);
        removerCombo.setModel(combo2);
        novaQuantidadeCombo.setModel(combo2);

    }

    public void popularLista() {
        DefaultListModel<String> Limpar = new DefaultListModel<>();
        listaCarrinho.setModel(Limpar);
        List<ItemCarrinho> lista = new ItemCarrinhoDAO().listarItens(usuario.getId());
        DefaultListModel<String> listaModel = new DefaultListModel<>();
        ItemCarrinhoDAO itemDAO = new ItemCarrinhoDAO();
        double total = itemDAO.calcularTotalUsuario(usuario.getId());

        for (ItemCarrinho it : lista) {
            String item = " Nome: " + it.getNomeProduto() + " - " + " Preço: " + it.getPreco() + " - " + " Quantidade: " + it.getQuantidade() + " - " + " SubTotal: " + it.getTotal();
            listaModel.addElement(item);
        }
        listaCarrinho.setModel(listaModel);
        campoTotal.setText(String.valueOf(total));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoVoltar = new javax.swing.JButton();
        adicionarCombo = new javax.swing.JComboBox<>();
        campoQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();
        removerCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCarrinho = new javax.swing.JList<>();
        botaoRemover = new javax.swing.JButton();
        botaoComprar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        novaQuantidadeCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoTotal = new javax.swing.JTextPane();
        campoNovaQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoAtualizar = new javax.swing.JButton();
        botaoBuscarC = new javax.swing.JButton();
        botaoBuscarU1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        adicionarCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adicionarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarComboActionPerformed(evt);
            }
        });
        getContentPane().add(adicionarCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 77, 130, -1));
        getContentPane().add(campoQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 77, 73, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantidade");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 55, -1, -1));

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        removerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(removerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 307, -1));

        jScrollPane1.setViewportView(listaCarrinho);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 442, -1));

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        botaoComprar.setText("Comprar");
        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 132, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Carrinho");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Remover Produtos Do Carrinho");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Adicionar Produtos No Carrinho");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, -1, -1));

        novaQuantidadeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(novaQuantidadeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, -1));

        campoTotal.setEditable(false);
        jScrollPane2.setViewportView(campoTotal);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, -1, -1));
        getContentPane().add(campoNovaQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 100, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        botaoBuscarC.setText("Buscar Carrinho");
        botaoBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarCActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 128, -1));

        botaoBuscarU1.setText("Detalhe Compra");
        botaoBuscarU1.setPreferredSize(new java.awt.Dimension(135, 23));
        botaoBuscarU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarU1ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBuscarU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 160, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nova Quantidade");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Atualizar Quantidade");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradient.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 570, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        FormPrincipal TelaPrincipal = new FormPrincipal(usuario);
        TelaPrincipal.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        if (!campoQuantidade.getText().isBlank()) {
            try {
                Produto produtoSelecionado = (Produto) adicionarCombo.getSelectedItem();
                int quantidade = Integer.parseInt(campoQuantidade.getText());

                if (quantidade < 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade não pode ser negativa", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    ItemCarrinho item = new ItemCarrinho(usuario.getId(), produtoSelecionado.getId(), produtoSelecionado.getNome(), produtoSelecionado.getPreco(), quantidade);
                    ItemCarrinhoDAO itemDAO = new ItemCarrinhoDAO();
                    if (itemDAO.adicionarItem(item)) {
                        campoQuantidade.setText("");
                        popularCombo();
                        popularLista();
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed

        ItemCarrinho item = (ItemCarrinho) removerCombo.getSelectedItem();
        if (item != null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o produto selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                ItemCarrinhoDAO itemDAO = new ItemCarrinhoDAO();
                if (itemDAO.removerItem(item)) {
                    popularLista();
                    popularCombo();
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao remover o produto!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void adicionarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adicionarComboActionPerformed

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarActionPerformed
        if (listaCarrinho.getModel().getSize() != 0) {
            try {
                double totalCompra = Double.parseDouble(campoTotal.getText());
                new ItemCarrinhoDAO().limparCarrinho(usuario.getId());
                if (new ItemHistoricoDAO().adicionarItemHistorico(new ItemHistorico(usuario.getId(), totalCompra))) {
                    popularCombo();
                    popularLista();
                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar o histórico de compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor total inválido. Verifique o campo de valor total.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O carrinho de compras está vazio. Adicione itens para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botaoComprarActionPerformed

    private void botaoBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarCActionPerformed
        this.dispose();
        FormBuscarCarrinho TelaCarrinho = new FormBuscarCarrinho(usuario);
        TelaCarrinho.setVisible(true);
    }//GEN-LAST:event_botaoBuscarCActionPerformed

    private void botaoBuscarU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarU1ActionPerformed
        this.dispose();
        FormDetalheCompra TelaUsuario = new FormDetalheCompra(usuario);
        TelaUsuario.setVisible(true);
    }//GEN-LAST:event_botaoBuscarU1ActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        try {
            int novaQuantidade = Integer.parseInt(campoNovaQuantidade.getText());

            if (novaQuantidade > 0) {
                ItemCarrinhoDAO itemCarrinhoDAO = new ItemCarrinhoDAO();
                boolean atualizadoComSucesso = itemCarrinhoDAO.atualizarQuantidadeItem(usuario.getId(), novaQuantidade);
                if (atualizadoComSucesso) {
                    popularCombo();
                    popularLista();
                    JOptionPane.showMessageDialog(null, "Nova Quantidade atualizada");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar quantidade do item", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Quantidade precisa ser positiva e maior que 0", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira a quantidade corretamente", "Erro", JOptionPane.ERROR_MESSAGE);;
        }

    }//GEN-LAST:event_botaoAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVendas(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> adicionarCombo;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoBuscarC;
    private javax.swing.JButton botaoBuscarU1;
    private javax.swing.JButton botaoComprar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoNovaQuantidade;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JTextPane campoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaCarrinho;
    private javax.swing.JComboBox<String> novaQuantidadeCombo;
    private javax.swing.JComboBox<String> removerCombo;
    // End of variables declaration//GEN-END:variables
}
