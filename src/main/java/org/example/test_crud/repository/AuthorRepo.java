package org.example.test_crud.repository;

import org.apache.ibatis.annotations.*;
import org.example.test_crud.model.dto.request.AuthorRequest;
import org.example.test_crud.model.entity.Author;

import java.util.List;

@Mapper
public interface AuthorRepo {

    @Select("""
    select * from authors
    """)
    @Results(id = "AuthorMapper", value = {
            @Result(property = "authorId", column = "authors_id"),
            @Result(property = "authorName", column = "authors_name"),
            @Result(property = "gender", column = "gender"),
    })
    List<Author> getAllAuthor();

    @Select("INSERT INTO authors(authors_name, gender) VALUES (#{req.authorName}, #{req.gender}) RETURNING *")
    @ResultMap("AuthorMapper")
    Author createAuthor(@Param ("req")AuthorRequest authorRequest);

    @Select("""
        UPDATE authors SET authors_name = #{req.authorName}, gender = #{req.gender} WHERE authors_id = #{req.authorId} RETURNING *
    """)
    @ResultMap("AuthorMapper")
    Author updateAuthor(@Param("authors_id") Long authorId,@Param("req") AuthorRequest authorRequest);

    @Select("DELETE FROM authors WHERE authors_id = #{authorId} RETURNING *")
    @ResultMap("AuthorMapper")
    Author deleteAuthor(Long authorId);

    @Select("SELECT * FROM authors WHERE authors_id = #{authorId}")
    @ResultMap("AuthorMapper")
    Author getAuthorById(Long authorId);
}
