package ru.mirea.practice21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.practice21.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends
        JpaRepository<Author, Long>,
        JpaSpecificationExecutor<Author> {
    Optional<List<Author>> getAllBy();

    Optional<Integer> deleteAuthorById(Long id);
}