package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.demo.mapper.AuthorMapper;
import pl.spring.demo.repository.AuthorRepository;
import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorTo> findAllAuthors() {
		return AuthorMapper.map2To(authorRepository.findAll());
	}

}
