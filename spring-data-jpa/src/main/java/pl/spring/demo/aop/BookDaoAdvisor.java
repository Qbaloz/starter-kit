package pl.spring.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.exception.BookNotNullIdException;

@Aspect
@Component
public class BookDaoAdvisor {

    private Sequence sequence;
    private BookDao bookDao;
    
    @Autowired
    public BookDaoAdvisor(BookDao bookDao, Sequence sequence){
    	this.bookDao = bookDao;
    	this.sequence = sequence;
    }
	
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(book,..)")
	private void checkNotNullId(BookEntity book){
		if(book.getId() != null){
			throw new BookNotNullIdException();
		}
	}
	
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(book,..)")
	private void setIdAutomatically(BookEntity book){
		if (book.getId() == null) {
			long id = sequence.nextValue(bookDao.findAll());
			book.setId(id);
		}
	}
	
	
}
