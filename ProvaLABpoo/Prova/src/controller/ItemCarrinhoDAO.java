/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ItemCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class ItemCarrinhoDAO {

    private final Connection con;

    public ItemCarrinhoDAO() {
        this.con = Conexao.conectar();
    }

    public boolean adicionarItem(ItemCarrinho item) {
        String SQL = "INSERT INTO tb_carrinho (id_usuario , id_produto, nome_produto, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, item.getIdUsuario());
            cmd.setInt(2, item.getIdProduto());
            cmd.setString(3, item.getNomeProduto());
            cmd.setDouble(4, item.getPreco());
            cmd.setInt(5, item.getQuantidade());
            cmd.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removerItem(ItemCarrinho item) {
        String SQL = "DELETE FROM tb_carrinho WHERE id_usuario = ? AND id_produto = ? AND quantidade = ? AND total = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, item.getIdUsuario());
            cmd.setInt(2, item.getIdProduto());
            cmd.setInt(3, item.getQuantidade());
            cmd.setDouble(4, item.getTotal());
            cmd.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public double calcularTotalUsuario(int usuarioId) {
        String SQL = "SELECT SUM(total) AS total_usuario FROM tb_carrinho WHERE id_usuario = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, usuarioId);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total_usuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean atualizarQuantidadeItem(int usuarioId, int novaQuantidade) {
        String SQL = "UPDATE tb_carrinho SET quantidade = ? WHERE id_usuario = ?";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, novaQuantidade);
            cmd.setInt(2, usuarioId);
            int rowsAffected = cmd.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ItemCarrinho> listarItens(int usuarioId) {
        List<ItemCarrinho> itens = new ArrayList<>();
        String SQL = "SELECT * FROM tb_carrinho WHERE id_usuario = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, usuarioId);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                int idProduto = rs.getInt("id_produto");
                String nomeProduto = rs.getString("nome_produto");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("total");
                ItemCarrinho item = new ItemCarrinho(idUsuario, idProduto, nomeProduto, preco, quantidade);
                item.setTotal(total);
                itens.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    public boolean limparCarrinho(int idUsuario) {
        String SQL = "DELETE FROM tb_carrinho WHERE id_usuario = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, idUsuario);

            int affectedRows = cmd.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao limpar carrinho do usuário " + idUsuario + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<ItemCarrinho> obterCarrinhoPeloIdUsuario(int idUsuario) {
        List<ItemCarrinho> carrinhoList = new ArrayList<>();
        String SQL = "SELECT * FROM tb_carrinho WHERE id_usuario = ?";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, idUsuario);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idProduto = rs.getInt("id_produto");
                String nomeProduto = rs.getString("nome_produto");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("total");

                ItemCarrinho item = new ItemCarrinho(idUsuario, idProduto, nomeProduto, preco, quantidade, total);
                carrinhoList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Ou lançar uma exceção específica se necessário
        }

        return carrinhoList;
    }
}
