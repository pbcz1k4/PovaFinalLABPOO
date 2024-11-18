
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class ItemHistorico {

    private int usuarioId;
    private double total;
    private Timestamp dataHora;

    public ItemHistorico(int usuarioId, double total, Timestamp dataHora) {
        this.usuarioId = usuarioId;
        this.total = total;
        this.dataHora = dataHora;
    }

    public ItemHistorico() {
    }

    public ItemHistorico(int usuarioId, double total) {
        this.usuarioId = usuarioId;
        this.total = total;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ItemHistorico{"
                + "usuarioId=" + usuarioId
                + ", total=" + total
                + '}';
    }
}
