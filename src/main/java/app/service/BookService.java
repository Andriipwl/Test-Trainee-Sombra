package app.service;

import app.model.AnswerStatisticForGenre;
import app.model.Books;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookService {
    void save(Books books);
    List<Books> findAll();
    void deleteByName(String name);
    void update(String name, String genre, Date published, int rating);
    List<Books> findBookWithAuthor();

    List<AnswerStatisticForGenre> findByGenreCount();

    List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks();
}
