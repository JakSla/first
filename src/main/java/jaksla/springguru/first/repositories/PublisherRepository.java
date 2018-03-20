package jaksla.springguru.first.repositories;

import jaksla.springguru.first.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
