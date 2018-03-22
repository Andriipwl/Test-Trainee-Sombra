package app.service;

import app.model.AnswerStatisticForGenre;
import app.model.Authors;

import java.util.Date;
import java.util.List;

public interface AuthorService {
    void save(Authors authors);
    List<Authors> findAll();
    Authors findOne(String name);
    void deleteByName(String name);
    void update(String name, Date born, String gender);
    List<Authors> findOlderThan();
    String getAuthorWhichHasTheMostBook();
}
