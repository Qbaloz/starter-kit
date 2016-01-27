package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.service.impl.BookSearchCriteria;

public interface BookSearchCriteriaDao {

	List<BookEntity> findBook (BookSearchCriteria bookSearchCriteria);
	
}
