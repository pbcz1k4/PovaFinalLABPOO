/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.security.Timestamp;
import java.util.List;
import model.DetalheCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class DetalhesCompraDAO {

    private final Connection con;

    public DetalhesCompraDAO() {
        this.con = Conexao.conectar();
    }

    public List<DetalheCompra> obterDetalhesComprasUsuario(int usuarioId) {
        List<DetalheCompra> detalhesCompras = new ArrayList<>();
        String SQL = "SELECT "
                + "usuario.id AS usuario_id, "
                + "usuario.nome AS usuario_nome, "
                + "produto.nome AS produto_nome, "
                + "produto.preco AS produto_preco, "
                + "carrinho.quantidade AS carrinho_quantidade, "
                + "carrinho.total AS carrinho_total "
                + "FROM "
                + "tb_carrinho carrinho "
                + "JOIN "
                + "tb_usuario usuario ON carrinho.id_usuario = usuario.id "
                + "JOIN "
                + "tb_produto produto ON carrinho.id_produto = produto.id "
                + "WHERE "
                + "usuario.id = ? ";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, usuarioId);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                DetalheCompra detalhe = new DetalheCompra();
                detalhe.setUsuarioId(rs.getInt("usuario_id"));
                detalhe.setUsuarioNome(rs.getString("usuario_nome"));
                detalhe.setProdutoNome(rs.getString("produto_nome"));
                detalhe.setProdutoPreco(rs.getDouble("produto_preco"));
                detalhe.setCarrinhoQuantidade(rs.getInt("carrinho_quantidade"));
                detalhe.setCarrinhoTotal(rs.getDouble("carrinho_total"));
                LocalDateTime agora = LocalDateTime.now();
                java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(agora);
                detalhe.setHistoricoDataHora(timestamp);
                detalhesCompras.add(detalhe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalhesCompras;
    }

}
