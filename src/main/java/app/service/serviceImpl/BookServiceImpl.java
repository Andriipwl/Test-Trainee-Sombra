package app.service.serviceImpl;

import app.model.AnswerStatisticForGenre;
import app.model.Books;
import app.repository.BookRepository;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Books books) {
        bookRepository.save(books);
    }

    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteByName(String name) {
        bookRepository.deleteByName(name);
    }

    @Override
    public void update(String name, String genre, Date published, int rating) {
        bookRepository.update(name,genre, published,rating);
    }

    @Override
    public List<Books> findBookWithAuthor() {
        return bookRepository.findBookWithAuthor();
    }

    @Override
    public List<AnswerStatisticForGenre> findByGenreCount() {
        return bookRepository.findByGenreCount();
    }

    @Override
    public List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks() {
        return bookRepository.booksWhoseAuthorHasMoreThanOneWrittenBooks();
    }
}
