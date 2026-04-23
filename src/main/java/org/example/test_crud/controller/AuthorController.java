package org.example.test_crud.controller;

import lombok.RequiredArgsConstructor;
import org.example.test_crud.model.dto.request.AuthorRequest;
import org.example.test_crud.model.dto.response.ApiResponse;
import org.example.test_crud.model.entity.Author;
import org.example.test_crud.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthor(){
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        "get All Author is successfully",
                        authors,
                        HttpStatus.CREATED.value(),
                        LocalDateTime.now()
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Author>> createAuthor(@RequestBody AuthorRequest authorRequest){

        Author authors = authorService.createAuthor(authorRequest);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(
                new ApiResponse<>(
                        "create Author is successfully",
                        authors,
                        HttpStatus.CREATED.value(),
                        LocalDateTime.now()
                )
        );
    }

    @PutMapping("/{authors_id}")
    public ResponseEntity<ApiResponse<Author>>  updateAuthor(@PathVariable("authors_id") Long authorId, @RequestBody AuthorRequest authorRequest){
        Author authors = authorService.updateAuthor(authorId, authorRequest);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(
                new ApiResponse<>(
                        "update Author is successfully",
                        authors,
                        HttpStatus.CREATED.value(),
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/{authors_id}")
    public ResponseEntity<ApiResponse<Author>> deleteAuthor(@PathVariable("authors_id") Long authorId){
        Author authors = authorService.deleteAuthor(authorId);
        return ResponseEntity.status(HttpStatus.OK.value()).body(
                new ApiResponse<>(
                        "delete Author is successfully",
                        authors,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("/{authors_id}")
    public ResponseEntity<ApiResponse<Author>> getAuthorById(@PathVariable("authors_id") Long authorId){
        Author authors = authorService.getAuthorById(authorId);
        return ResponseEntity.status(HttpStatus.OK.value()).body(
                new ApiResponse<>(
                        "get Author is successfully",
                        authors,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }
}
