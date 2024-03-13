package dev.patika.business.abstracts;

import dev.patika.entities.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    Publisher get(int id);
    Page<Publisher> cursor (int page, int pageSize);
    boolean delete(int id);
}
