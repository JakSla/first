package jaksla.springguru.first.repositories;

import jaksla.springguru.first.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
