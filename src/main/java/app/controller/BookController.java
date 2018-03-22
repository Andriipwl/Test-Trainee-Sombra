package app.controller;

import app.model.AnswerStatisticForGenre;
import app.model.Authors;
import app.model.Books;
import app.service.AuthorService;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/showBooks")
    public List<Books> show() {
        return bookService.findAll();
    }

    @PostMapping("/saveBook")
    public void save(@RequestBody Books books) throws ParseException {
        boolean b = true;
        List<Books> books1 = bookService.findAll();
        for (Books books2 : books1) {
            if (books2.getName().equals(books.getName())  && books2.getGenre().equals(books.getGenre())) {
                bookService.update(books.getName(), books.getGenre(), books.getPublished(), books.getRating());
                b = false;
            }
        }
        if (b) {
            Authors authors = authorService.findOne(books.getAuthors().getName());
            books.setAuthors(authors);
            bookService.save(books);
        }

//        books.setAuthors(authors);
//        bookService.save(books);
    }

    @PostMapping("/deleteBookByName")
    public void deleteBookByName(@RequestBody Books books) {
        System.out.println(books.getName());
        bookService.deleteByName(books.getName());
    }


    @GetMapping("/findBookWithAuthor")
    public List<Books> findBookWithAuthor() {
        return bookService.findBookWithAuthor();
    }

    @GetMapping("/findByGenreCount")
    public List<AnswerStatisticForGenre> findByGenreCount() {
        return bookService.findByGenreCount();
    }


    @GetMapping("/booksWhoseAuthorHasMoreThanOneWrittenBooks")
    public List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks() {
        return bookService.booksWhoseAuthorHasMoreThanOneWrittenBooks();

    }
}
