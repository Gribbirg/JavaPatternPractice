package ru.mirea.practice15.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.practice15.models.Author;
import ru.mirea.practice15.models.Book;
import ru.mirea.practice15.repositories.AuthorRepository;
import ru.mirea.practice15.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.getAllBy().orElseThrow();
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public Integer deleteBookById(Long id) {
        return repository.deleteBookById(id).orElseThrow();
    }
}
