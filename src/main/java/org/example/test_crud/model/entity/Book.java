package org.example.test_crud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Long bookId;
    private String title;
    private Timestamp publishedDate;
    private Author author;
    private List<Category> categories;
}
