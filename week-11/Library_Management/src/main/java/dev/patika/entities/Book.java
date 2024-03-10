package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private int id;

    @NotNull(message = "Kitap ismi boş olamaz.")
    @Column(name = "book_name")
    private String name;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book2categories",
            joinColumns = {@JoinColumn (name = "book2categories_book_id")},
            inverseJoinColumns = {@JoinColumn (name = "book2categories_category_id")}
    )
    private List<Category> categoryList;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;
}
