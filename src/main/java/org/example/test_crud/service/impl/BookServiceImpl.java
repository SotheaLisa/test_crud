package org.example.test_crud.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.test_crud.model.dto.request.BookRequest;
import org.example.test_crud.model.entity.Author;
import org.example.test_crud.model.entity.Book;
import org.example.test_crud.repository.BookCategoryRepo;
import org.example.test_crud.repository.BookRepo;
import org.example.test_crud.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;
    private final BookCategoryRepo bookCategoryRepo;

    @Override
    public List<Book> getAllBook(int page, int size) {
        int offset = (page - 1) * size;
        return bookRepo.getAllBook(offset, size);
    }

    @Override
    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        Author author = new Author();
        author.setAuthorId(bookRequest.getAuthorId());
        book.setAuthor(author);
        Book savedBook = bookRepo.addBook(book);

        if(bookRequest.getCategoryId() != null){
            for(Long categoryId : bookRequest.getCategoryId()){
                bookCategoryRepo.insertBookCategory(savedBook.getBookId(), categoryId);
            }
        }

        //refect book id
        return bookRepo.getBookById((long) savedBook.getBookId()); //note
    }

    @Override
    public Book updateBook(Long bookId, BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        Author author = new Author();
        author.setAuthorId(bookRequest.getAuthorId());
        book.setAuthor(author);
        bookRepo.updateBook(bookId, bookRequest);

        //delete old category
        bookCategoryRepo.deleteBookCategory(Long.valueOf(bookId));

        //insert new category
        if(bookRequest.getCategoryId() != null){
            for(Long categoryId : bookRequest.getCategoryId()){
                bookCategoryRepo.insertBookCategory((long) bookId, categoryId);
            }
        }

        //re-fetch
        return bookRepo.getBookById(bookId);
    }

    @Override
    public Book delteBook(Long bookId) {

        //get full book with category
        Book book = bookRepo.getBookById(bookId);

        //delete book_category
        bookCategoryRepo.deleteByBookId((long) bookId);

        //delete the book
        bookRepo.delteBook(bookId);

        //return previously fetch-book
        return book;
    }
}
