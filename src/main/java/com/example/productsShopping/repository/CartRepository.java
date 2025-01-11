package com.example.productsShopping.repository;

import com.example.productsShopping.entity.Cartitem;
import com.example.productsShopping.entity.User;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cartitem, Long> {
    List<Cartitem> findByUser_Username(String username);
    Optional<Cartitem> findByUser_UsernameAAndProduct_Id(String username, Long productId);


    void deleteByUser(User user);
}
