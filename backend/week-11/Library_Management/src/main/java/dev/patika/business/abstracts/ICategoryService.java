package dev.patika.business.abstracts;

import dev.patika.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category update(Category category);
    Category get(int id);
    Page<Category> cursor (int page, int pageSize);
    boolean delete(int id);
    List<Category> findAllByIds(List<Integer> ids);
}
