/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Produto;
import model.Usuario;

public class FormCardapio extends javax.swing.JFrame {

    private Usuario usuario;

    public FormCardapio(Usuario us) {
        initComponents();
        this.usuario = us;
        this.setLocationRelativeTo(null);
        this.setTitle("Cardapio");
        popularLista();
        popularCombo();

    }

    public void popularCombo() {
        DefaultComboBoxModel limpar = new DefaultComboBoxModel<>();
        removerCombo.setModel(limpar);
        novoPrecoCombo.setModel(limpar);
        List<Produto> lista = new ProdutoDAO().listarProdutos();
        DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
        for (Produto p : lista) {
            combo.addElement(p);
        }
        removerCombo.setModel(combo);
        novoPrecoCombo.setModel(combo);

    }

    public void popularLista() {
        DefaultListModel<String> Limpar = new DefaultListModel<>();
        listaProdutos.setModel(Limpar);
        List<Produto> lista = new ProdutoDAO().listarProdutos();
        DefaultListModel<String> listaModel = new DefaultListModel<>();

        for (Produto p : lista) {
            String item = "ID: " + p.getId() + " - " + " Nome: " + p.getNome() + " - " + " Preço: " + p.getPreco() + " - " + " Tipo: " + p.getTipo();
            listaModel.addElement(item);
        }
        listaProdutos.setModel(listaModel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoVoltar = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoPreco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        removerCombo = new javax.swing.JComboBox<>();
        botaoRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JList<>();
        novoPrecoCombo = new javax.swing.JComboBox<>();
        campoNovoPreco = new javax.swing.JTextField();
        botaoAtualizar = new javax.swing.JButton();
        NovoPreco = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        botaoBuscarP = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 100, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 69, -1, -1));

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        getContentPane().add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 91, 80, -1));

        campoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(campoPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 91, 80, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Preço");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 69, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 69, -1, -1));

        campoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoActionPerformed(evt);
            }
        });
        getContentPane().add(campoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 91, 80, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 68, -1, -1));

        campoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIDActionPerformed(evt);
            }
        });
        getContentPane().add(campoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 20, -1));

        removerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        removerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerComboActionPerformed(evt);
            }
        });
        getContentPane().add(removerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 174, 141, -1));

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 100, -1));

        jScrollPane1.setViewportView(listaProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 391, -1));

        novoPrecoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(novoPrecoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 283, 141, -1));

        campoNovoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNovoPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(campoNovoPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 283, 77, -1));

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 100, -1));

        NovoPreco.setForeground(new java.awt.Color(255, 255, 255));
        NovoPreco.setText("Novo Preço");
        getContentPane().add(NovoPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 261, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Cadastrar Produto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Atualizar Preço");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Remover Produto");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("Cardapio");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        botaoBuscarP.setText("Buscar Produtos");
        botaoBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarPActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 238, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradient.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 610));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        FormPrincipal TelaPrincipal = new FormPrincipal(usuario);
        TelaPrincipal.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecoActionPerformed

    private void campoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTipoActionPerformed

    private void campoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIDActionPerformed

    private void campoNovoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNovoPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNovoPrecoActionPerformed

    private void removerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removerComboActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        Produto produtoSelecionado = (Produto) removerCombo.getSelectedItem();
        if (produtoSelecionado != null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o produto selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                if (produtoDAO.removerProduto(produtoSelecionado.getId())) {
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

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed

        if (!campoNome.getText().isBlank() && !campoPreco.getText().isBlank() && !campoTipo.getText().isBlank() && !campoID.getText().isBlank()) {
            try {
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                String tipo = campoTipo.getText();
                int id = Integer.parseInt(campoID.getText());

                ProdutoDAO produtoDAO = new ProdutoDAO();
                if (preco >= 0 && id >= 0) {
                    if (!produtoDAO.produtoJaRegistrado(id)) {
                        Produto p = new Produto(id, nome, preco, tipo);

                        if (produtoDAO.adicionarProduto(p)) {
                            campoNome.setText("");
                            campoPreco.setText("");
                            campoTipo.setText("");
                            campoID.setText("");
                            popularLista();
                            popularCombo();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao adicionar no carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto já registrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Preço ou id não podem ser negativos", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Preço ou ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        Produto produtoSelecionado = (Produto) novoPrecoCombo.getSelectedItem();
        if (produtoSelecionado != null) {
            try {
                double novoPreco = Double.parseDouble(campoNovoPreco.getText());
                ProdutoDAO produtoDAO = new ProdutoDAO();
                if (produtoDAO.atualizarPrecoProduto(produtoSelecionado, novoPreco)) {
                    popularLista();
                    JOptionPane.showMessageDialog(null, "Preço do produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar o preço do produto!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor válido para o novo preço!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar o preço!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarPActionPerformed
        this.dispose();
        FormBuscarProduto TelaProduto = new FormBuscarProduto(usuario);
        TelaProduto.setVisible(true);
    }//GEN-LAST:event_botaoBuscarPActionPerformed

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
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCardapio(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NovoPreco;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoBuscarP;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNovoPreco;
    private javax.swing.JTextField campoPreco;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listaProdutos;
    private javax.swing.JComboBox<String> novoPrecoCombo;
    private javax.swing.JComboBox<String> removerCombo;
    // End of variables declaration//GEN-END:variables
}
