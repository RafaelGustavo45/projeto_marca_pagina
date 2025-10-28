package com.livraria.controller;

import com.livraria.model.Book;
import com.livraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações CRUD de Livros.
 * Mapeado para o caminho base "/api/books".
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // 1. CREATE: Cria um novo livro (POST /api/books)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        // O Spring JPA salva o objeto e o retorna, com o ID preenchido
        return bookRepository.save(book);
    }

    // 2. READ ALL: Retorna todos os livros (GET /api/books)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 3. READ ONE: Retorna um livro por ID (GET /api/books/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get()); // 200 OK com o livro
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // 4. UPDATE: Atualiza um livro existente (PUT /api/books/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            Book existingBook = book.get();
            // Atualiza os campos com os detalhes da requisição
            existingBook.setNome(bookDetails.getNome());
            existingBook.setAutor(bookDetails.getAutor());
            existingBook.setCodigoISBN(bookDetails.getCodigoISBN());
            existingBook.setQuantidadePaginas(bookDetails.getQuantidadePaginas());

            // Salva e retorna o livro atualizado
            return ResponseEntity.ok(bookRepository.save(existingBook));
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // 5. DELETE: Remove um livro por ID (DELETE /api/books/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
