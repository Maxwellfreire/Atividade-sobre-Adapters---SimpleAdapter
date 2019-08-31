package br.com.treinamento.listaproduto.model;

import java.math.BigDecimal;

public class Pedido {


    Long id;
    String cliente;
    String data;
    BigDecimal valor;


    public Pedido(Long id, String cliente, String data, BigDecimal valor) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", data='" + data + '\'' +
                ", valor=" + valor +
                '}';
    }
}
