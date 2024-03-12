package ru.mirea.practice14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice14.models.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    private ArrayList<Book> books = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Book> getAuthors() {
        return books.stream().toList();
    }

    @PostMapping
    @ResponseBody
    public Book addAuthor(
            @RequestBody Book book
    ) {
        int lenBefore = books.size();
        books.add(book);
        if (books.size() != lenBefore)
            return book;
        else
            return null;
    }

    @DeleteMapping
    @ResponseBody
    public Book deleteAuthor(
            @RequestBody Book book
    ) {
        int lenBefore = books.size();
        books = new ArrayList<>(
                books.stream()
                        .filter((authorListItem -> !authorListItem.equals(book)))
                        .toList()
        );
        if (books.size() != lenBefore)
            return book;
        else
            return null;
    }
}
