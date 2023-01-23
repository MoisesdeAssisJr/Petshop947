package models;

import java.math.BigDecimal;

public class TabelaDeServicos {

    int id;
    String nome;
    BigDecimal preco;

    public TabelaDeServicos(int id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public TabelaDeServicos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Id = " + id + " | Nome = " + nome + " | Preco = R$" + preco + '\n';
    }
}
