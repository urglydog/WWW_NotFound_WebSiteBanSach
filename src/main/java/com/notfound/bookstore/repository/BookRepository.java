package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    // Tìm kiếm theo tên sách
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    //Tìm theo category (many-to-many)
    @Query("SELECT DISTINCT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
    Page<Book> findByCategoryId(@Param("categoryId") UUID categoryId, Pageable pageable);

    //Tìm theo author (many-to-many)
    @Query("SELECT DISTINCT b FROM Book b JOIN b.authors a WHERE a.id = :authorId")
    Page<Book> findByAuthorId(@Param("authorId") UUID authorId, Pageable pageable);

    //Sách liên quan (cùng category, trừ sách hiện tại)
    @Query("SELECT DISTINCT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId AND b.id != :bookId ORDER BY b.createdAt DESC")
    List<Book> findRelatedBooks(@Param("categoryId") UUID categoryId, @Param("bookId") UUID bookId, Pageable pageable);

    //Sách bán chạy
    @Query("SELECT b FROM Book b LEFT JOIN b.orderItems oi GROUP BY b.id ORDER BY COUNT(oi.orderItemID) DESC")
    List<Book> findBestSellingBooks(Pageable pageable);

    // Sách mới nhất
    Page<Book> findByOrderByCreatedAtDesc(Pageable pageable);

    // Sách giảm giá
    Page<Book> findByDiscountPriceIsNotNull(Pageable pageable);

    //Tìm kiếm tổng hợp
    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN b.authors a " +
            "LEFT JOIN b.categories c " +
            "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Book> searchBooks(@Param("keyword") String keyword, Pageable pageable);

    // Lọc theo giá
    Page<Book> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    // Lọc theo đánh giá trung bình
    @Query("SELECT b FROM Book b LEFT JOIN b.reviews r " +
            "GROUP BY b.id HAVING AVG(r.rating) >= :minRating")
    Page<Book> findByAverageRatingGreaterThanEqual(@Param("minRating") Double minRating, Pageable pageable);

    //Tìm theo nhiều categories
    @Query("SELECT DISTINCT b FROM Book b JOIN b.categories c WHERE c.id IN :categoryIds")
    Page<Book> findByCategoryIds(@Param("categoryIds") List<UUID> categoryIds, Pageable pageable);

    //Tìm theo nhiều authors
    @Query("SELECT DISTINCT b FROM Book b JOIN b.authors a WHERE a.id IN :authorIds")
    Page<Book> findByAuthorIds(@Param("authorIds") List<UUID> authorIds, Pageable pageable);

    //Tìm theo status
    Page<Book> findByStatus(Book.Status status, Pageable pageable);

    //Tìm sách còn hàng
    Page<Book> findByStockQuantityGreaterThan(Integer minStock, Pageable pageable);

    //Tìm theo ISBN
    Book findByIsbn(String isbn);
}
