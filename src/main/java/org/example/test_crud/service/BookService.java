package org.example.test_crud.service;

import org.example.test_crud.model.dto.request.BookRequest;
import org.example.test_crud.model.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook(int page, int size);

    Book addBook(BookRequest bookRequest);

    Book updateBook(Long bookId, BookRequest bookRequest);

    Book delteBook(Long bookId);
}
