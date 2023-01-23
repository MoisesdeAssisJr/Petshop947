package VO;

import enums.Servicos;
import models.Clientes;
import models.Pessoa;

import java.math.BigDecimal;

public class ResponseVO {
    private int id;
    private Servicos servicos;
    private BigDecimal valor;
    private Clientes cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ResponseVO() {
    }

    public ResponseVO(int id, Servicos servicos, BigDecimal valor, Clientes cliente) {
        this.id = id;
        this.servicos = servicos;
        this.valor = valor;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Id do Cliente = " + id + '\n'
                + "Nome do serviço = " + servicos + '\n'
                + "Total do(s) serviço(s) = R$" + valor + '\n'
                + "Nome do Cliente = " + cliente.getNome() +'\n';
    }
}
