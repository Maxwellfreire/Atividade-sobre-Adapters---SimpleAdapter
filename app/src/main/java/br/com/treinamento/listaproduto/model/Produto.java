package br.com.treinamento.listaproduto.model;



public class Produto {

    int id;
    String nome;
    String descricao;
    double valor;
    String NCM;

    public Produto(int id, String nome, String descricao, double valor, String NCM) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.NCM = NCM;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", NCM='" + NCM + '\'' +
                '}';
    }
}
