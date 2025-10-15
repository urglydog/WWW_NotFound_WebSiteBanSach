package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Author;
import com.notfound.bookstore.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
