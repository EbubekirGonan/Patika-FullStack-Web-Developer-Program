package dev.patika.dto.request.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    private int id;
    private String borrowerName;
    private String borrowerEmail;
    private LocalDate borrowingDate;
    private int bookId;
}
