package idv.owen.Application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idv.owen.Application.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
