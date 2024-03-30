package ru.mirea.practice17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.practice17.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> getAllBy();

    Optional<Integer> deleteBookById(Long id);
}