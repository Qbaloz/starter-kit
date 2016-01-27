package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.LibraryEntity;

public interface LibraryService {
	
	List<LibraryEntity> findAllLibraries();
	void deleteLibrary(long id);

}
