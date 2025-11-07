package model;

import java.io.Serializable;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private TamanhoProduto tamanho;
    private EmbalagemProduto embalagem;

    public Categoria() {
    }

    public Categoria(int id, String nome, TamanhoProduto tamanho, EmbalagemProduto embalagem) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    // Getters e Setters
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

    public TamanhoProduto getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoProduto tamanho) {
        this.tamanho = tamanho;
    }

    public EmbalagemProduto getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(EmbalagemProduto embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return nome;
    }
}
