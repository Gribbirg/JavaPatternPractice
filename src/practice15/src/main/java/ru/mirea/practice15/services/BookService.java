package ru.mirea.practice15.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mirea.practice15.models.Book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    void close() {
        session.close();
    }

    public List<Book> getBooks() {
        return session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public void addBook(Book book) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
    }

    public void deleteBook(Long id) {
        session.createQuery("DELETE FROM Book WHERE id=:" + id);
    }
}
