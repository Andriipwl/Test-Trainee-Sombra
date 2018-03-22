package app.repository;

import app.model.AnswerStatisticForGenre;
import app.model.Authors;
import app.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface AuthorRepository extends JpaRepository<Authors,Integer>{

    void deleteByName(@Param("name") String name);
    @Modifying
    @Transactional
    @Query("update Authors set name =:name , born =:born, gender =:gender where name =:name and gender =:gender")
    void update(@Param("name") String name, @Param("born")Date born, @Param("gender") String gender);

    @Query(value = "SELECT* from authors a where a.name = :name",nativeQuery = true)
    Authors findByAuthorName(@Param("name") String name);

    @Query("from Authors a where year(current_date())- year(a.born)>55 order by a.born")
    List<Authors> findOlderThan();

    @Query(value = "SELECT a.name FROM authors a LEFT JOIN book_author b GROUP BY a.name ORDER BY COUNT(b.book_id) DESC limit 1",nativeQuery = true)
    String getAuthorWhichHasTheMostBook();







}
