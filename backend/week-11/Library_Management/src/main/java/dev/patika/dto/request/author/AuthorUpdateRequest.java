package dev.patika.dto.request.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.PrimitiveIterator;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    private int id;
    private String name;
    private LocalDate birthday;
    private String country;
}
