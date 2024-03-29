package dev.patika.dto.response.book;

import dev.patika.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String name;
    private int publicationYear;
    private int stock;
    private int authorId;
    private int publisherId;
    private List<Category> categories;
}
