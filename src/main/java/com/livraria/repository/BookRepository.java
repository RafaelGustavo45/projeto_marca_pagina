package com.livraria.repository;

import com.livraria.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações CRUD na entidade Book.
 * Herda JpaRepository, fornecendo métodos CRUD básicos prontos.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Métodos personalizados podem ser adicionados aqui, se necessário.
    // Para o CRUD básico, os métodos já são herdados.
}
