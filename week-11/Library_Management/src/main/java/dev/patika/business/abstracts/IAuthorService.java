package dev.patika.business.abstracts;

import dev.patika.entities.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author update(Author author);
    Author get(int id);
    Page<Author> cursor (int page, int pageSize);
    boolean delete(int id);
}
