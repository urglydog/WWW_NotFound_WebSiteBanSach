package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Cart;
import com.notfound.bookstore.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    // Tìm item trong giỏ theo book
    Optional<CartItem> findByCartIdAndBookId(UUID cartId, UUID bookId);

    // Xóa tất cả item trong giỏ
    @Modifying
    @Query("DELETE FROM CartItem ci WHERE ci.cart.id = :cartId")
    void deleteAllByCartId(UUID cartId);

    // Đếm số lượng item trong giỏ
    Long countByCartId(UUID cartId);
}
