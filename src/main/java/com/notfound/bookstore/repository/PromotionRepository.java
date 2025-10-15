package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Book;
import com.notfound.bookstore.model.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, UUID> {
    // Mã giảm giá còn hiệu lực
    @Query("SELECT p FROM Promotion p WHERE p.code = :code AND " +
            "p.startDate <= :now AND p.endDate >= :now AND p.usageCount < p.usageLimit")
    Optional<Promotion> findValidPromotionByCode(String code, LocalDateTime now);

    // Khuyến mãi đang hoạt động
    @Query("SELECT p FROM Promotion p WHERE p.startDate <= :now AND p.endDate >= :now")
    List<Promotion> findActivePromotions(LocalDateTime now);
}
