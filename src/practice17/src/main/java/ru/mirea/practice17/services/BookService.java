package ru.mirea.practice17.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.practice17.dto.AuthorDto;
import ru.mirea.practice17.dto.BookDto;
import ru.mirea.practice17.models.Author;
import ru.mirea.practice17.models.Book;
import ru.mirea.practice17.repositories.BookRepository;
import ru.mirea.practice17.repositories.BookRepositoryCustom;
import ru.mirea.practice17.repositories.BookRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookRepositoryCustom repositoryCustom;

    public List<Book> getAllBooks() {
        return repository.getAllBy().orElseThrow();
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public Integer deleteBookById(Long id) {
        return repository.deleteBookById(id).orElseThrow();
    }

    public List<BookDto> findByFilter(Book book) {
        return repositoryCustom
                .findBooksByCriteria(
                        book.getName(),
                        book.getCreationDate(),
                        book.getAuthorId()
                )
                .stream()
                .map(Book::toDto)
                .toList();
    }
}
