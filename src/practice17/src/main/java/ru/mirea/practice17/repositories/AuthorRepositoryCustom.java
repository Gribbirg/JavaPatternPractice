package ru.mirea.practice17.repositories;

import ru.mirea.practice17.models.Author;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Author> findAuthorsByCriteria(String firstName, String lastName, String middleName, String birthDate);
}
