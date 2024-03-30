package ru.mirea.practice17.repositories;

import ru.mirea.practice17.models.Author;
import ru.mirea.practice17.models.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findBooksByCriteria(String name, String creationDate, Long authorId);
}
