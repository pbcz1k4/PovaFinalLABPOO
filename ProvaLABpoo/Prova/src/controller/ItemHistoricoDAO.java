package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemHistorico;
import java.sql.ResultSet;
import java.sql.Timestamp;
import model.DetalheCompra;

public class ItemHistoricoDAO {

    private Connection con;

    // Construtor que recebe a conexão com o banco de dados
    public ItemHistoricoDAO() {
        this.con = Conexao.conectar();
    }

    // Método para adicionar um ItemHistorico ao banco de dados
    public boolean adicionarItemHistorico(ItemHistorico itemHistorico) {
        String SQL = "INSERT INTO tb_historico (usuario_id, total) VALUES (?, ?)";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, itemHistorico.getUsuarioId());
            cmd.setDouble(2, itemHistorico.getTotal());

            int rowsAffected = cmd.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ItemHistorico> buscarHistoricoComprasPorUsuario(int usuarioId) {
        List<ItemHistorico> historicoCompras = new ArrayList<>();
        String SQL = "SELECT id, usuario_id, total, data_hora FROM tb_historico WHERE usuario_id = ? ORDER BY data_hora DESC";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, usuarioId);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                ItemHistorico item = new ItemHistorico();
                item.setUsuarioId(rs.getInt("usuario_id"));
                item.setTotal(rs.getDouble("total"));
                item.setDataHora(rs.getTimestamp("data_hora"));
                historicoCompras.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historicoCompras;
    }


    public List<ItemHistorico> listarHistoricos() {
        List<ItemHistorico> historicoList = new ArrayList<>();
        String SQL = "SELECT * FROM tb_historico";

        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                int usuarioId = rs.getInt("usuario_id");
                double total = rs.getDouble("total");
                Timestamp dataHora = rs.getTimestamp("data_hora");

                ItemHistorico item = new ItemHistorico(usuarioId, total, dataHora);
                historicoList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Ou lançar uma exceção específica se necessário
        }

        return historicoList;
    }

    // Método para remover um ItemHistorico do banco de dados
    public boolean removerItemHistorico(int usuarioId) {
        String SQL = "DELETE FROM tb_historico WHERE usuario_id = ?";
        try (PreparedStatement cmd = con.prepareStatement(SQL)) {
            cmd.setInt(1, usuarioId);

            int rowsAffected = cmd.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
