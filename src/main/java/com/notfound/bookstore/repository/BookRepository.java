package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    // Tìm kiếm theo tên sách
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // Tìm theo thể loại
    Page<Book> findByCategoryId(UUID categoryId, Pageable pageable);

    // Tìm theo tác giả
    Page<Book> findByAuthorId(UUID authorId, Pageable pageable);

    // Sách liên quan (cùng thể loại, trừ sách hiện tại)
    @Query("SELECT b FROM Book b WHERE b.category.id = :categoryId AND b.id != :bookId ORDER BY b.createdAt DESC")
    List<Book> findRelatedBooks(UUID categoryId, UUID bookId, Pageable pageable);

    // Sách bán chạy (top N)
    @Query("SELECT b FROM Book b LEFT JOIN OrderItem oi ON b.id = oi.book.id GROUP BY b.id ORDER BY COUNT(oi.id) DESC")
    List<Book> findBestSellingBooks(Pageable pageable);

    // Sách mới nhất
    Page<Book> findByOrderByCreatedAtDesc(Pageable pageable);

    // Sách giảm giá
    Page<Book> findByDiscountGreaterThan(Double discount, Pageable pageable);

    // Tìm kiếm tổng hợp
    @Query("SELECT b FROM Book b WHERE " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.author.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Book> searchBooks(String keyword, Pageable pageable);

    // Lọc theo giá
    Page<Book> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    // Lọc theo đánh giá
    @Query("SELECT b FROM Book b LEFT JOIN Review r ON b.id = r.book.id " +
            "GROUP BY b.id HAVING AVG(r.rating) >= :minRating")
    Page<Book> findByAverageRatingGreaterThanEqual(Double minRating, Pageable pageable);
}
