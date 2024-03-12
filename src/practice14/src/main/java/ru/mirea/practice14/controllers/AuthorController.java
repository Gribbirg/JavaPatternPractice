package ru.mirea.practice14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.practice14.models.Author;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {
    private ArrayList<Author> authors = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Author> getAuthors() {
        return authors.stream().toList();
    }

    @PostMapping
    @ResponseBody
    public Author addAuthor(
            @RequestBody Author author
    ) {
        int lenBefore = authors.size();
        authors.add(author);
        if (authors.size() != lenBefore)
            return author;
        else
            return null;
    }

    @DeleteMapping
    @ResponseBody
    public Author deleteAuthor(
            @RequestBody Author author
    ) {
        int lenBefore = authors.size();
        authors = new ArrayList<>(
                authors.stream()
                        .filter((authorListItem -> !authorListItem.equals(author)))
                        .toList()
        );
        if (authors.size() != lenBefore)
            return author;
        else
            return null;
    }
}
