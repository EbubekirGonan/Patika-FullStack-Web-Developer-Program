package dev.patika.business.abstracts;

import dev.patika.entities.Book;
import dev.patika.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    Book save(Book book);
    Book update(Book book);
    Book get(int id);
    Page<Book> cursor (int page, int pageSize);
    boolean delete(int id);
    List<Book> findAllByIds(List<Integer> ids);
}
