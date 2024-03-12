package ru.mirea.practice15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice15.models.Book;
import ru.mirea.practice15.services.BookService;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @PostMapping
    @ResponseBody
    public void addBook(
            @RequestBody Book book
    ) {
        service.addBook(book);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteBook(
            @RequestBody Long id
    ) {
        service.deleteBook(id);
    }
}
