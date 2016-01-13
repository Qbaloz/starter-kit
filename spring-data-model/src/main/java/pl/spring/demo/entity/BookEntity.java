package pl.spring.demo.entity;

import java.util.List;

import pl.spring.demo.author.AuthorTo;

public class BookEntity{
    private Long id;
    private String title;
    private Long authorId;
    private String firstName;
    private String lastName;

    public BookEntity() {
    }

    public BookEntity(Long id, String title, List<AuthorTo> authors) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAuthorId() {
//        return authorId;
//    }

//    public void setAuthors(String authors) {
//        this.authors = authors;
//    }
}
