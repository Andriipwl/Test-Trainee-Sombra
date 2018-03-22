package app.service.serviceImpl;

import app.model.AnswerStatisticForGenre;
import app.model.Authors;
import app.repository.AuthorRepository;
import app.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(Authors authors) {
        authorRepository.save(authors);
    }

    @Override
    public List<Authors> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteByName(String name) {
        authorRepository.deleteByName(name);
    }

    @Override
    public void update(String name, Date born, String gender) {
        authorRepository.update(name,born, gender);
    }

    @Override
    public Authors findOne(String name) {
        return authorRepository.findByAuthorName(name);
    }

    @Override
    public List<Authors> findOlderThan() {
        return authorRepository.findOlderThan();
    }


    @Override
    public String  getAuthorWhichHasTheMostBook() {
        return authorRepository.getAuthorWhichHasTheMostBook();
    }

}
