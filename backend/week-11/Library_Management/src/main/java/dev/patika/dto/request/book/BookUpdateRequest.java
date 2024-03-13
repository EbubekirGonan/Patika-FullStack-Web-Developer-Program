package dev.patika.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    private int id;
    private String name;
    private int publicationYear;
    private int stock;
    private int authorId;
    private int publisherId;
    private int categoryId;

}
