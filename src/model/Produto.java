package src.model;

import src.exception.DadosInvalidosException;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;

    public Produto(String codigo, String nome, double preco) throws DadosInvalidosException {
        if (codigo == null || codigo.isBlank()) {
            throw new DadosInvalidosException("O codigo do produto nao pode ser vazio.");
        }
        if (preco <= 0) {
            throw new DadosInvalidosException("O preco do produto deve ser maior que zero.");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %.2f", codigo, nome, preco);
    }
}
