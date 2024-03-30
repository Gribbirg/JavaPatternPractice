package ru.mirea.practice18.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.mirea.practice18.dto.BookDto;
import ru.mirea.practice18.models.Book;
import ru.mirea.practice18.repositories.BookRepository;

import java.util.List;

import static ru.mirea.practice18.specifications.BookSpecification.*;

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

    public List<BookDto> findByFilter(Book book) {
        Specification<Book> filters = Specification
                .where(book.getName() == null ? null : nameLike(book.getName()))
                .and(book.getCreationDate() == null ? null : creationDateLike(book.getCreationDate()))
                .and(book.getAuthorId() == null ? null : authorIdIs(book.getAuthorId()));

        return repository
                .findAll(filters)
                .stream()
                .map(Book::toDto)
                .toList();
    }
}
