package com.livraria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade que representa um Livro no sistema.
 */
@Entity
public class Book {

    // Chave primária auto-incrementada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nome do livro
    private String nome;

    // Autor do livro
    private String autor;

    // Código ISBN (deve ser 'long' conforme especificado)
    private Long codigoISBN;

    // Quantidade de páginas
    private Integer quantidadePaginas;

    // Construtor padrão (necessário para JPA)
    public Book() {
    }

    // Construtor com todos os campos (útil para testes)
    public Book(String nome, String autor, Long codigoISBN, Integer quantidadePaginas) {
        this.nome = nome;
        this.autor = autor;
        this.codigoISBN = codigoISBN;
        this.quantidadePaginas = quantidadePaginas;
    }

    // --- Getters e Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(Long codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
}
