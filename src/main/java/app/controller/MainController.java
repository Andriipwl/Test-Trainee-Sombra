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
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    @GetMapping("/showAuthors")
    public List<Authors> show() {
        return authorService.findAll();
    }


    @PostMapping("/saveAuthor")
    public void saveBook(@RequestBody Authors authors) throws ParseException {
        boolean b = true;
        List<Authors> authors1 = authorService.findAll();
        for (Authors authors2 : authors1) {
            if (authors2.getName().equals(authors.getName())  && authors2.getGender().equals(authors.getGender())) {
                authorService.update(authors.getName(), authors.getBorn(), authors.getGender());
                b = false;
            }
        }
        if (b) {
            authorService.save(authors);
        }
    }

    @GetMapping("/allAuthors")
    public List<Authors> all() {
        return authorService.findAll();
    }

    @PostMapping("/deleteByName")
    public void deleteByName(@RequestBody Authors authors) {
        System.out.println(authors.getName());
        authorService.deleteByName(authors.getName());

    }


    @GetMapping("/showOlderThan")
    public List<Authors> showOlderThan() {
        return authorService.findOlderThan();
    }

    @GetMapping("/getAuthorWhichHasTheMostBook")
    public String getAuthorWhichHasTheMostBook() {
        System.out.println(authorService.getAuthorWhichHasTheMostBook());
        return authorService.getAuthorWhichHasTheMostBook();
    }
}
