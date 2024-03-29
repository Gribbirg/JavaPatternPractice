package ru.mirea.practice15.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.practice15.models.Author;
import ru.mirea.practice15.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.getAllBy().orElseThrow();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Integer deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id).orElseThrow();
    }
}
