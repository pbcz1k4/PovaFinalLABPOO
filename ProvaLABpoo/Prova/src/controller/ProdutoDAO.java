/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final Connection con;

    public ProdutoDAO() {
        this.con = Conexao.conectar();
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String SQL = "SELECT * FROM tb_produto";

        try (PreparedStatement cmd = con.prepareStatement(SQL); ResultSet rs = cmd.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("tipo")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public Produto obterProdutoPorId(int id) {
        String SQL = "SELECT * FROM tb_produto WHERE id = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, id);
            try (ResultSet rs = cmd.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getString("tipo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean produtoJaRegistrado(int ID) {
        String SQL = "SELECT * FROM tb_produto WHERE id= ?";
        try {
            PreparedStatement cmd = con.prepareStatement(SQL);
            cmd.setInt(1, ID);
            ResultSet rs = cmd.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean adicionarProduto(Produto produto) {
        String SQL = "INSERT INTO tb_produto (id, nome, preco, tipo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, produto.getId());
            cmd.setString(2, produto.getNome());
            cmd.setDouble(3, produto.getPreco());
            cmd.setString(4, produto.getTipo());
            int rowsAffected = cmd.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean atualizarPrecoProduto(Produto produto, double preco) {
        String SQL = "UPDATE tb_produto SET preco = ? WHERE id = ?";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setDouble(1, preco);
            cmd.setInt(2, produto.getId());
            int rowsAffected = cmd.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removerProduto(int id) {
        String SQL = "DELETE FROM tb_produto WHERE id = ?";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, id);
            int rowsAffected = cmd.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
