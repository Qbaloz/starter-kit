package pl.spring.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.IdAware;

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
	
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(idAware,..)")
	private void checkNotNullId(IdAware idAware){
		if(idAware.getId() != null){
			throw new BookNotNullIdException();
		}
	}
	
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(book,..)")
	private void setIdAutomatically(BookTo book){
		if (book.getId() == null) {
			book.setId(sequence.nextValue(bookDao.findAll()));
		}
	}
	
	
}
