package pl.spring.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import pl.spring.demo.dao.BookSearchCriteriaDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.QAuthorEntity;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.service.impl.BookSearchCriteria;

public class BookSearchCriteriaDaoImpl extends AbstractDao<BookEntity, Long> implements BookSearchCriteriaDao {

	@Override
	public List<BookEntity> findBook(BookSearchCriteria bookSearchCriteria) {

		QBookEntity bookEntity = QBookEntity.bookEntity;
		QAuthorEntity authorEntity = QAuthorEntity.authorEntity;

		JPQLQuery query = new JPAQuery(entityManager);
		List<BookEntity> books = new ArrayList<BookEntity>();

		String title = bookSearchCriteria.getTitle();
		String author = bookSearchCriteria.getAuthor();
		String libraryName = bookSearchCriteria.getLibraryName();
		
		if (title == null && author == null && libraryName == null) {
			books = query.from(bookEntity).listResults(bookEntity).getResults();
		}

		if (title != null && author == null && libraryName == null) {
			books = query.from(bookEntity).where(bookEntity.title.startsWith(title)).listResults(bookEntity)
					.getResults();
		}

		if (title == null && author != null && libraryName == null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			books = query.from(bookEntity).join(bookEntity.authors, authorEntity)
					.where(authorEntity.firstName.startsWith(firstName), authorEntity.lastName.startsWith(lastName))
					.listResults(bookEntity).getResults();
		}

		if (title == null && author == null && libraryName != null) {

			books = query.from(bookEntity).where(bookEntity.library.name.startsWith(libraryName))
					.listResults(bookEntity).getResults();
		}

		if (title != null && author != null && libraryName == null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			books = query.from(bookEntity)
					.join(bookEntity.authors, authorEntity).where(bookEntity.title.startsWith(title),
							authorEntity.firstName.startsWith(firstName), authorEntity.lastName.startsWith(lastName))
					.listResults(bookEntity).getResults();
		}

		if (title != null && author == null && libraryName != null) {

			books = query.from(bookEntity)
					.where(bookEntity.title.startsWith(title), bookEntity.library.name.startsWith(libraryName))
					.listResults(bookEntity).getResults();
		}

		if (title == null && author != null && libraryName != null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			books = query.from(bookEntity)
					.join(bookEntity.authors, authorEntity).where(authorEntity.firstName.startsWith(firstName),
							authorEntity.lastName.startsWith(lastName), bookEntity.library.name.startsWith(libraryName))
					.listResults(bookEntity).getResults();
		}

		if (title != null && author != null && libraryName != null) {
			String split[] = StringUtils.split(author);
			String firstName = split[0];
			String lastName = split[1];

			books = query.from(bookEntity).join(bookEntity.authors, authorEntity)
					.where(bookEntity.title.startsWith(title), authorEntity.firstName.startsWith(firstName),
							authorEntity.lastName.startsWith(lastName), bookEntity.library.name.startsWith(libraryName))
					.listResults(bookEntity).getResults();
		}

		return books;
	}

}
