package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.to.AuthorTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class AuthorServiceImplTest {

	@Autowired
	private AuthorService authorService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShouldFindAllAuthors() {
        // when
        List<AuthorTo> allAuthors = authorService.findAllAuthors();
        // then
        assertNotNull(allAuthors);
        assertFalse(allAuthors.isEmpty());
        assertEquals(3, allAuthors.size());
	}

}
