package ru.mirea.practice16.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice16.dto.AuthorDto;
import ru.mirea.practice16.models.Author;
import ru.mirea.practice16.services.AuthorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping
    @ResponseBody
    public List<AuthorDto> getAuthors() {
        return service.getAllAuthors().stream().map(Author::toDto).toList();
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
