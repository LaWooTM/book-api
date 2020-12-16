package com.tmobile.bookapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).get();
    }
}
