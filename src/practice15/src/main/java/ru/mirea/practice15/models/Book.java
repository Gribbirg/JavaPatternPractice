package ru.mirea.practice15.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;

    public Book(Long id, String name, String creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Book() {}

    public Book(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(creationDate, book.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }
}
