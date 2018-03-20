package jaksla.springguru.first.repositories;

import jaksla.springguru.first.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
