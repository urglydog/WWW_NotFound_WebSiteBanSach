package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Address;
import com.notfound.bookstore.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findByUser(User user);
    List<Address> findByUserId(UUID userId);
}
