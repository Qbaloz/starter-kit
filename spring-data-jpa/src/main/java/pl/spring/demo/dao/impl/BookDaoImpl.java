package pl.spring.demo.dao.impl;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class BookDaoImpl implements BookDao {

    private final Set<BookEntity> ALL_BOOKS = new HashSet<>();
    
    public BookDaoImpl() {
        addTestBooks();
    }

    @Override
    public List<BookEntity> findAll() {
        return new ArrayList<>(ALL_BOOKS);
    }

    @Override
    public List<BookEntity> findBookByTitle(String title) {
        return null;
    }

    @Override
    public List<BookEntity> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    @NullableId
    public BookEntity save(BookEntity book) {
        ALL_BOOKS.add(book);
        return book;
    }

    private void addTestBooks() {
        ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Wiliam", "Szekspir")))));
        ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Hanna", "Ożogowska")))));
        ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Jan", "Parandowski")))));
        ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Edmund", "Niziurski")))));
        ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Zbigniew", "Nienacki")))));
        ALL_BOOKS.add(new BookEntity(6L, "Zemsta", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Aleksander", "Fredro")))));
    }
}
