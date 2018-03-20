package jaksla.springguru.first.bootstrap;

import jaksla.springguru.first.model.Author;
import jaksla.springguru.first.model.Book;
import jaksla.springguru.first.model.Publisher;
import jaksla.springguru.first.repositories.AuthorRepository;
import jaksla.springguru.first.repositories.BookRepository;
import jaksla.springguru.first.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher britishPublisher = new Publisher();
        britishPublisher.setName("British Publisher");
        Publisher doubleDayInc = new Publisher();
        doubleDayInc.setName("Double Day Inc");

        publisherRepository.save(britishPublisher);
        publisherRepository.save(doubleDayInc);


        //Terry
        Author terry = new Author("Terry", "Pratchett");
        Book foc = new Book("Feet of Clay", "1111", britishPublisher);
        terry.getBooks().add(foc);
        foc.getAuthors().add(terry);

        authorRepository.save(terry);
        bookRepository.save(foc);

        //Isaac
        Author isaac = new Author("Isaac", "Asimov");
        Book foundation = new Book("Foundation", "1112", doubleDayInc);
        isaac.getBooks().add(foundation);
        foundation.getAuthors().add(isaac);

        authorRepository.save(isaac);
        bookRepository.save(foundation);

    }
}
