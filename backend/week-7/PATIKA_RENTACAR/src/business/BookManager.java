package business;

import dao.BookDao;
import entity.Book;

public class BookManager {
    private BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public boolean save(Book book) {
        return this.bookDao.save(book);
    }
}
