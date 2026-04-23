package org.example.test_crud.repository;

import org.apache.ibatis.annotations.*;
import org.example.test_crud.model.entity.Book;
import org.example.test_crud.model.entity.Category;

import java.util.List;

@Mapper
public interface BookCategoryRepo {

    @Select("""
    select c.category_id, c.category_name
    from book_category bc inner join categories c
        on bc.category_id = c.category_id
    where books_id = #{bookId}
    """)

    @Results(id = "BookCategoryMapper", value = {
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "bookId", column = "books_id")
    })
    List<Category> getAllCategoriesByBookId(Long bookId);

    @Insert("INSERT INTO book_category(books_id, category_id) VALUES (#{bookId}, #{categoryId})")
    @ResultMap("BookCategoryMapper")
    void insertBookCategory(Long bookId, Long categoryId);

    @Delete("DELETE FROM book_category WHERE books_id = #{bookId}")
    @ResultMap("BookCategoryMapper")
    void deleteBookCategory(Long bookId);

    @Insert("INSERT INTO book_category(books_id, category_id) VALUES (#{book.bookId}, #{book.categoryId})")
    @ResultMap("BookCategoryMapper")
    void addBookCategory(Book book);

    @Delete("DELETE FROM book_category WHERE books_id = #{bookId} and category_id = #{categoryId}")
    @ResultMap("BookCategoryMapper")
    void deleteByBookId(Long aLong);
}
