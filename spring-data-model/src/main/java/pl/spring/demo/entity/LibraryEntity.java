package pl.spring.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(nullable = false, length = 50)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "LIBRARY_BOOKID",
            joinColumns = {@JoinColumn(name = "LIBRARY_ID", nullable = false, updatable = true)},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = true)}
    )
	private Set<BookEntity> books = new HashSet<>();

	// for hibernate
	protected LibraryEntity(){
	}
	
	public LibraryEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
