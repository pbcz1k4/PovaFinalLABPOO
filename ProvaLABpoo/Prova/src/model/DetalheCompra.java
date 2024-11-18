/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class DetalheCompra {
    private int usuarioId;
    private String usuarioNome;
    private String produtoNome;
    private double produtoPreco;
    private int carrinhoQuantidade;
    private double carrinhoTotal;
    private Timestamp historicoDataHora; 



    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public int getCarrinhoQuantidade() {
        return carrinhoQuantidade;
    }

    public void setCarrinhoQuantidade(int carrinhoQuantidade) {
        this.carrinhoQuantidade = carrinhoQuantidade;
    }

    public double getCarrinhoTotal() {
        return carrinhoTotal;
    }

    public void setCarrinhoTotal(double carrinhoTotal) {
        this.carrinhoTotal = carrinhoTotal;
    }

    public Timestamp getHistoricoDataHora() { // Corrigido para Timestamp
        return historicoDataHora;
    }

    public void setHistoricoDataHora(Timestamp historicoDataHora) { // Corrigido para Timestamp
        this.historicoDataHora = historicoDataHora;
    }
}
