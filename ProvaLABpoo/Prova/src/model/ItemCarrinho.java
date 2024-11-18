/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ItemCarrinho {

    private int idUsuario;
    private int idProduto;
    private String nomeProduto;
    private double preco;
    private int quantidade;
    private double total;

    public ItemCarrinho(int idProduto, String nomeProduto, double preco, int quantidade) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.total = preco * quantidade;
    }

    public ItemCarrinho(int idUsuario, int idProduto, String nomeProduto, double preco, int quantidade, double total) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.total = total;
    }

    public ItemCarrinho(int idUsuario, int idProduto, String nomeProduto, double preco, int quantidade) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nomeProduto + " Quantidade: " + quantidade + " SubTotal: " + total;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.total = this.preco * quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
