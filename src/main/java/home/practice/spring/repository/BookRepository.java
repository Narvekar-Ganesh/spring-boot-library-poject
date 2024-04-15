package home.practice.spring.repository;

import home.practice.spring.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookName(String bookName);

    Book findByAutherName(String autherName);

    Book findByBookNameAndAutherName(String bookName ,String autherName);

    Long deleteByBookName(String bookName);
}
