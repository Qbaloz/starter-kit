package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.Mapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private Mapper mapper;
	
    @Autowired
	public BookServiceImpl(BookDao bookDao, Mapper mapper) {
		this.bookDao = bookDao;
		this.mapper = mapper;
	}

    @Override
    @Cacheable("booksCache")
    public List<BookTo> findAllBooks() {
    	List<BookTo> bookTo = mapper.bookEntityList2BookToList(bookDao.findAll());
    	return bookTo;
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {	
    	List<BookTo> bookTo = mapper.bookEntityList2BookToList(bookDao.findBookByTitle(title));
    	return bookTo;
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
    	List<BookTo> bookTo = new ArrayList<>();
    	bookTo = mapper.bookEntityList2BookToList(bookDao.findBooksByAuthor(author));
    	return bookTo;
    }

    @Override
    public BookTo saveBook(BookTo book) {
    	BookEntity bookEntity = mapper.bookTo2BookEntity(book);
    	BookEntity savedBook = bookDao.save(bookEntity);
        return mapper.bookEntity2BookTo(savedBook);
    }
    
}
