package pl.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import pl.spring.demo.dao.BookSearchCriteriaDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.impl.BookSearchCriteria;

public class BookSearchCriteriaDaoImpl extends AbstractDao<BookEntity, Long> implements BookSearchCriteriaDao {

	@Override
	public List<BookEntity> findBook(BookSearchCriteria bookSearchCriteria) {
		String title = bookSearchCriteria.getTitle();
		String author = bookSearchCriteria.getAuthor();
		String libraryName = bookSearchCriteria.getLibraryName();

		TypedQuery<BookEntity> query = null;

		if (title == null && author == null && libraryName == null) {
			query = entityManager.createQuery("select book from BookEntity book", BookEntity.class);
		}

		if (title != null && author == null && libraryName == null) {
			query = entityManager.createQuery(
					"select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')",
					BookEntity.class);
			query.setParameter("title", title);
		}

		if (title == null && author != null && libraryName == null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			query = entityManager.createQuery(
					"select book from BookEntity book JOIN book.authors author where upper(author.firstName) like concat('%', upper(:firstName), '%') or upper(author.lastName) like concat('%', upper(:lastName), '%')",
					BookEntity.class);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
		}

		if (title == null && author == null && libraryName != null) {
			query = entityManager.createQuery(
					"select book from BookEntity book where upper(book.library.name) like concat(upper(:libraryName), '%')",
					BookEntity.class);
			query.setParameter("libraryName", libraryName);
		}

		if (title != null && author != null && libraryName == null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			query = entityManager.createQuery(
					"select book from BookEntity book JOIN book.authors author where upper(book.title) like concat(upper(:title), '%') and (upper(author.firstName) like concat('%', upper(:firstName), '%') or upper(author.lastName) like concat('%', upper(:lastName), '%'))",
					BookEntity.class);
			query.setParameter("title", title);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
		}

		if (title != null && author == null && libraryName != null) {
			query = entityManager.createQuery(
					"select book from BookEntity book where upper(book.title) like concat(upper(:title), '%') and upper(book.library.name) like concat(upper(:libraryName), '%')",
					BookEntity.class);
			query.setParameter("title", title);
			query.setParameter("libraryName", libraryName);
		}

		if (title == null && author != null && libraryName != null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			query = entityManager.createQuery(
					"select book from BookEntity book JOIN book.authors author where (upper(author.firstName) like concat('%', upper(:firstName), '%') or upper(author.lastName) like concat('%', upper(:lastName), '%')) and upper(book.library.name) like concat(upper(:libraryName), '%')",
					BookEntity.class);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
			query.setParameter("libraryName", libraryName);
		}

		if (title != null && author != null && libraryName != null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			query = entityManager.createQuery(
					"select book from BookEntity book JOIN book.authors author where (upper(author.firstName) like concat('%', upper(:firstName), '%') or upper(author.lastName) like concat('%', upper(:lastName), '%')) and upper(book.title) like concat(upper(:title), '%') and upper(book.library.name) like concat(upper(:libraryName), '%')",
					BookEntity.class);
			query.setParameter("title", title);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
			query.setParameter("libraryName", libraryName);

		}

		return query.getResultList();
	}

}
