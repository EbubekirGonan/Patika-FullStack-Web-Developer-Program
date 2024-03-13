package dev.patika.business.abstracts;

import dev.patika.entities.Author;
import dev.patika.entities.Book;
import dev.patika.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);
    Page<BookBorrowing> cursor (int page, int pageSize);
    boolean delete(int id);
}
