package app.repository;

import app.model.AnswerStatisticForGenre;
import app.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {


    void deleteByName(@Param("name") String name);
    @Modifying
    @Transactional
    @Query("update Books set name =:name, genre =:genre, published =:published, rating = :rating where name = :name and genre =:genre")
    void update(@Param("name") String name, @Param("genre") String genre, @Param("published") Date published, @Param("rating") int rating);
    @Query(value = "SELECT* FROM books", nativeQuery = true)
    List<Books> findBookWithAuthor();

    //    find book by genre count
    @Query( " SELECT b.genre as name, count(b.id) as count from Books b group by b.genre")
    List<AnswerStatisticForGenre> findByGenreCount();


    @Query(value = "select b.name from books b join book_author a  where a.author_id in (select a.author_id from book_author a group by a.author_id having COUNT(a.author_id) > 1) ",nativeQuery = true)
    List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks();
}
