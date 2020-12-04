package ru.specialist.java.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.specialist.java.spring.entity.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle(String title);

    List<Post> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

//Home Worke------------------------------------------------------------------------------------------------------------
    @Query(value = "SELECT * FROM post AS p JOIN \"user\" AS u ON p.user_id=u.user_id WHERE LOWER(u.username) =  LOWER(?)", nativeQuery = true)
    List<Post> findByPostsWithUserName(String username);

    @Query(value = "SELECT * FROM post AS p JOIN post_tag AS pt ON p.post_id = pt.post_id JOIN tag AS t ON pt.tag_id = t.tag_id WHERE LOWER(t.name) = LOWER(?);", nativeQuery = true)
    List<Post> findByPostsWithTagName(String tagname);
//Home Worke------------------------------------------------------------------------------------------------------------

    @Query(value = "select p.* from post p join post_tag pt on p.post_id = pt.post_id join tag t on (pt.tag_id = t.tag_id and lower(t.name) = lower(?))", nativeQuery = true)
    List<Post> findByTagName(String tagName);


//    1) Найти посты, содержащие в тексте(content) заданную подстроку (оператор like в SQL)
    List<Post> findByContentLikeIgnoreCase(String ssbstring);

//    TODO
//    2) Получить все посты, отсортированные по количеству тегов

    @Query(value = "select p.from post p join post_tag pt on p.post_id = pt.post_id group by p.post_id order by count(*) desc", nativeQuery = true)
    List<Post> findSortedTagSorted();
}
