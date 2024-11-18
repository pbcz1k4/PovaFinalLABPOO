package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import view.FormLogin;


                
public class Conexao {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USR = "postgres";
    private static final String PWD = "pedroz1k4";
    private static final String DRIVER = "org.postgresql.Driver";
    
    public static Connection conectar(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USR,PWD);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public static void desconectar(Connection con){
        try {
            
            if(con != null) con.close();
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Connection con = Conexao.conectar();
        if (con != null){
            FormLogin lg = new FormLogin();
            lg.setVisible(true);
            System.out.println("Conexão Estabelecida!");
        }
        Conexao.desconectar(con);
    }
    
}

