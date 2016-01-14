package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

@Component
public class Mapper {

	public BookEntity bookTo2BookEntity(BookTo book) {
		BookEntity bookEntity = new BookEntity();
		List<AuthorTo> authors = new ArrayList<AuthorTo>();
		
		String authorFullName;
		String firstName = null;
		String lastName = null;
		
		bookEntity.setId(book.getId());
		bookEntity.setTitle(book.getTitle());
		
		authorFullName = book.getAuthors();
		if (authorFullName != null && authorFullName.contains(" ")) {
			firstName = authorFullName.substring(0, authorFullName.indexOf(" "));
			lastName = authorFullName.substring(authorFullName.indexOf(" "), authorFullName.length());
		}
		
		AuthorTo authorTo = new AuthorTo();

		authorTo.setId(null);
		authorTo.setFirstName(firstName);
		authorTo.setLastName(lastName);
		
		authors.add(authorTo);
		
		bookEntity.setAuthors(authors);
		
		return bookEntity;
	}

	public BookTo bookEntity2BookTo(BookEntity bookEntity) {
		BookTo bookTo = new BookTo();
		AuthorTo authorTo = new AuthorTo();
		bookTo.setId(bookEntity.getId());
		bookTo.setTitle(bookEntity.getTitle());
		authorTo = bookEntity.getAuthors().get(0);
		bookTo.setAuthors(authorTo.getFirstName() + " " + authorTo.getLastName()); 
		
		return bookTo;
	}
	
	public List<BookTo> bookEntityList2BookToList(List<BookEntity> bookEntity){
		List<BookTo> bookTo = new ArrayList<BookTo>();
		
		for (int i = 0; i < bookEntity.size(); i++) {
			bookTo.add(0, null);
		}
		
    	for(int i = 0; i < bookEntity.size(); i++){
    		bookTo.set(i, bookEntity2BookTo(bookEntity.get(i)));
    	}
		
		return bookTo;
	}
	
	public List<BookEntity> bookToList2BookEntityList(List<BookTo> bookTo){
		List<BookEntity> bookEntity = new ArrayList<>();
		
		for (int i = 0; i < bookTo.size(); i++) {
			bookEntity.add(0, null);
		}
		
    	for(int i = 0; i < bookTo.size(); i++){
    		bookEntity.set(i, bookTo2BookEntity(bookTo.get(i)));
    	}
		
		return bookEntity;
	}

}
