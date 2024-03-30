package ru.mirea.practice20.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice20.dto.BookDto;
import ru.mirea.practice20.models.Book;
import ru.mirea.practice20.services.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {
    private final BookService service;

    @GetMapping
    @ResponseBody
    public List<BookDto> getBooks() {
        return service.getAllBooks().stream().map(Book::toDto).toList();
    }

    @PostMapping
    @ResponseBody
    public Book addBook(
            @RequestBody Book book
    ) {
        service.addBook(book);
        return book;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        return "Count: " + service.deleteBookById(id);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<BookDto> getFilter(@RequestBody Book book) {
        return service.findByFilter(book);
    }
}
