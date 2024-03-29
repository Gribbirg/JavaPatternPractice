package ru.mirea.practice15.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice15.models.Author;
import ru.mirea.practice15.services.AuthorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping
    @ResponseBody
    public List<Author> getAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    @ResponseBody
    public Author addAuthor(
            @RequestBody Author author
    ) {
        service.addAuthor(author);
        return author;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        return "Count: " + service.deleteAuthorById(id);
    }
}
