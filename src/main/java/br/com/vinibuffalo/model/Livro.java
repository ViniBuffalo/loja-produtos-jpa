package br.com.vinibuffalo.model;

import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
public class Livro extends Produto {

    private String autor;
    private Integer numeroDePaginas;

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        super(nome, descricao, preco, categoria);
    }

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, Integer numeroDePaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
