package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    int id;

    @NotNull(message = "Yazar ismi boş olamaz")
    @Column(name = "author_name")
    private String name;

    @Column(name = "author_birthday")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
