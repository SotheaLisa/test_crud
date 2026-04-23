package org.example.test_crud.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.test_crud.model.dto.request.BookRequest;
import org.example.test_crud.model.dto.response.ApiResponse;
import org.example.test_crud.model.entity.Book;
import org.example.test_crud.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBook(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        List<Book> books = bookService.getAllBook(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        "get All Book is successfully",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody BookRequest bookRequest){
        Book books = bookService.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        "add Book is successfully",
                        books,
                        HttpStatus.CREATED.value(),
                        LocalDateTime.now()
                )
        );
    }

    @PutMapping("/{books_id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable("books_id") Long bookId, @RequestBody BookRequest bookRequest){
        Book books  = bookService.updateBook(bookId, bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        "update Book is successfully",
                        books,
                        HttpStatus.CREATED.value(),
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/{books_id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable("books_id") Long bookId){
        Book books = bookService.delteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        "delete Book is successfully",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }
}

