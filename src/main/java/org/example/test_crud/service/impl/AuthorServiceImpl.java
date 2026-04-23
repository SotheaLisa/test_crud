package org.example.test_crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.test_crud.model.dto.request.AuthorRequest;
import org.example.test_crud.model.entity.Author;
import org.example.test_crud.repository.AuthorRepo;
import org.example.test_crud.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.getAllAuthor();
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        return authorRepo.createAuthor(authorRequest);
    }

    @Override
    public Author updateAuthor(Long authorId, AuthorRequest authorRequest) {
        return authorRepo.updateAuthor(authorId, authorRequest);
    }

    @Override
    public Author deleteAuthor(Long authorId) {
        return authorRepo.deleteAuthor(authorId);
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepo.getAuthorById(authorId);
    }


}
