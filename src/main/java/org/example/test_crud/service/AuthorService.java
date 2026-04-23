package org.example.test_crud.service;

import org.example.test_crud.model.dto.request.AuthorRequest;
import org.example.test_crud.model.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();


    Author createAuthor(AuthorRequest authorRequest);

    Author updateAuthor(Long authorId, AuthorRequest authorRequest);


    Author deleteAuthor(Long authorId);


    Author getAuthorById(Long authorId);
}
