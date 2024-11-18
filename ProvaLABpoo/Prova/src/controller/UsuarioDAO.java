/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import model.Usuario;


public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO() {
        this.con = Conexao.conectar();
    }

    public boolean Login(Usuario u) {
        try {
            String SQL = "SELECT * FROM tb_usuario WHERE email=? AND senha=MD5(?)";
            PreparedStatement cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getEmail());
            cmd.setString(2, u.getSenha());
            ResultSet result = cmd.executeQuery();
            return result.next();

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public Usuario obterUsuarioPeloEmail(String email) {

        String SQL = "SELECT * FROM tb_usuario WHERE email=?";
        try {
            PreparedStatement cmd = con.prepareStatement(SQL);
            cmd.setString(1, email);
            ResultSet result = cmd.executeQuery();
            if (result.next()) {
                Usuario usuario = new Usuario(result.getInt("id"), result.getString("nome"), result.getString("email"), result.getString("senha"));
                return usuario;
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        return null;

    }
    
    public Usuario obterUsuarioPeloNome(String nome) {

        String SQL = "SELECT * FROM tb_usuario WHERE nome=?";
        try {
            PreparedStatement cmd = con.prepareStatement(SQL);
            cmd.setString(1, nome);
            ResultSet result = cmd.executeQuery();
            if (result.next()) {
                Usuario usuario = new Usuario(result.getInt("id"), result.getString("nome"), result.getString("email"), result.getString("senha"));
                return usuario;
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        return null;

    }

    
    
    
    
    
    
    public boolean emailJaRegistrado(String email) {
        String SQL = "SELECT * FROM tb_usuario WHERE email=?";
        try {
            PreparedStatement cmd = con.prepareStatement(SQL);
            cmd.setString(1, email);
            ResultSet result = cmd.executeQuery();
            return result.next();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public int AdicionarUsuario(Usuario us) {
        try {
            if (emailJaRegistrado(us.getEmail())) {
                return -1;
            }
            String SQL = "INSERT INTO tb_usuario (nome, email, senha) VALUES (?, ?, MD5(?))";
            PreparedStatement cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, us.getNome());
            cmd.setString(2, us.getEmail());
            cmd.setString(3, us.getSenha());

            if (cmd.executeUpdate() > 0) {
                ResultSet result = cmd.getGeneratedKeys();
                return result.next() ? result.getInt(1) : -1;
            }
            return -1;

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            return -1;
        }

    }

}
