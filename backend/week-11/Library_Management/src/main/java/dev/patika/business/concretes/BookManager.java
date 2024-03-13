package dev.patika.business.concretes;

import dev.patika.business.abstracts.IBookService;
import dev.patika.dao.AuthorRepo;
import dev.patika.dao.BookRepo;
import dev.patika.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {
    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;

    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepo.save(book);
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        this.bookRepo.delete(this.get(id));
        return true;
    }

    @Override
    public List<Book> findAllByIds(List<Integer> ids) {
        return this.bookRepo.findAllById(ids);
    }


}
