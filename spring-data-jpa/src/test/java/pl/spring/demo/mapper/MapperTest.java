package pl.spring.demo.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class MapperTest {

	@Autowired
	private Mapper mapper;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShouldMapBookTo2BookEntityAndCheckAuthor() {
		//given
		BookTo bookTo = new BookTo(1L, "Bob Budowniczy", "Jan Kowalski");
		BookEntity bookEntity = new BookEntity();
		//when
		bookEntity = mapper.bookTo2BookEntity(bookTo);
		//then
		String firstName = bookEntity.getAuthors().get(0).getFirstName();
		String lastName = bookEntity.getAuthors().get(0).getLastName();
		String bookEntityAuthor = firstName + lastName;
		assertEquals(bookTo.getAuthors(),bookEntityAuthor);
	}
	
	@Test
	public void testShouldMapBookTo2BookEntityAndCheckId() {
		//given
		BookTo bookTo = new BookTo(1L, "Bob Budowniczy", "Jan Kowalski");
		BookEntity bookEntity = new BookEntity();
		//when
		bookEntity = mapper.bookTo2BookEntity(bookTo);
		//then
		assertEquals(bookTo.getId(),bookEntity.getId());
	}
	
	@Test
	public void testShouldMapBookTo2BookEntityAndCheckTitle() {
		//given
		BookTo bookTo = new BookTo(1L, "Bob Budowniczy", "Jan Kowalski");
		BookEntity bookEntity = new BookEntity();
		//when
		bookEntity = mapper.bookTo2BookEntity(bookTo);
		//then
		assertEquals(bookTo.getTitle(),bookEntity.getTitle());
	}
	
	@Test
	public void testShouldMapBookEntity2BookToAndCheckAuthor() {
		//given
		BookTo bookTo = new BookTo();
		BookEntity bookEntity = new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Wiliam", "Szekspir"))));
		String firstName = bookEntity.getAuthors().get(0).getFirstName();
		String lastName = bookEntity.getAuthors().get(0).getLastName();
		String bookEntityAuthor = firstName + " " + lastName;
		//when
		bookTo = mapper.bookEntity2BookTo(bookEntity);
		//then
		assertEquals(bookTo.getAuthors(),bookEntityAuthor);
	}
	
	@Test
	public void testShouldMapBookEntity2BookToAndCheckId() {
		//given
		BookTo bookTo = new BookTo();
		BookEntity bookEntity = new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Wiliam", "Szekspir"))));
		//when
		bookTo = mapper.bookEntity2BookTo(bookEntity);
		//then
		assertEquals(bookTo.getId(),bookEntity.getId());
	}
	
	@Test
	public void testShouldMapBookEntity2BookToAndCheckTitle() {
		//given
		BookTo bookTo = new BookTo();
		BookEntity bookEntity = new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6L, "Wiliam", "Szekspir"))));
		//when
		bookTo = mapper.bookEntity2BookTo(bookEntity);
		//then
		assertEquals(bookTo.getTitle(),bookEntity.getTitle());
	}
	
	@Test
	public void testShouldMapBookEntity2BookToWithOneParameter() {
		//given
		BookTo bookTo = new BookTo();
		BookEntity bookEntity = new BookEntity(6L, null, new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(null, null, null))));
		//when
		bookTo = mapper.bookEntity2BookTo(bookEntity);
		//then
		assertEquals(bookTo.getTitle(),bookEntity.getTitle());
	}
	
}
