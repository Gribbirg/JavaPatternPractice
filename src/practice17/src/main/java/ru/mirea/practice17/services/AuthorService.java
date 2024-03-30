package ru.mirea.practice17.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.practice17.dto.AuthorDto;
import ru.mirea.practice17.models.Author;
import ru.mirea.practice17.repositories.AuthorRepository;
import ru.mirea.practice17.repositories.AuthorRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorRepositoryImpl authorRepositoryCustom;

    public List<Author> getAllAuthors() {
        return authorRepository.getAllBy().orElseThrow();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Integer deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id).orElseThrow();
    }

    public List<AuthorDto> findByFilter(Author author) {
        return authorRepositoryCustom
                .findAuthorsByCriteria(
                        author.getFirstName(),
                        author.getLastName(),
                        author.getMiddleName(),
                        author.getBirthDate()
                )
                .stream()
                .map(Author::toDto)
                .toList();
    }
}
