package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testShouldFindLibraryByName(){
        // given
        final String libraryName = "Bibl";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findLibraryByName(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals("Biblioteka Miejska", libraryEntity.get(0).getName());
        assertEquals("Biblioteka Wojewódzka", libraryEntity.get(1).getName());
	}

}
