package org.example.test_crud.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.test_crud.model.entity.Author;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookRequest {
    private String title;
    private Timestamp publishedDate;
    private Long authorId;
    private List<Long> categoryId;
}
