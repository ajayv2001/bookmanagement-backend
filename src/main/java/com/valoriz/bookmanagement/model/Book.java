package com.valoriz.bookmanagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title can be up to 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 50, message = "Author name can be up to 50 characters")
    private String author;

    @NotNull(message = "Publication date is required")
    private LocalDate publicationDate;

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number")
    private String isbn;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private int rating;
}
