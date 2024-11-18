/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



public class Usuario {
    

    private int id;
    private String nome;
    private String email;
    private String senha;
    
   
    
    
    public Usuario(int id , String name, String email, String password) {
        this.email = email;
        this.senha = password;
        this.nome = name;
        this.id = id;
    }
   
    public Usuario(String name, String email, String password ) {
        this.email = email;
        this.senha = password;
        this.nome = name;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.senha = password;

    }
    
     public Usuario() {
    }

       public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId() {
        return id;
    }
    

    public void setNome(String name) {
        this.nome = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String password) {
        this.senha = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId() + getNome() + getEmail() + getSenha();
    }

}
