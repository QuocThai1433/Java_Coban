package com.example.demo.repository;

import com.example.demo.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(value = "  select u from users u where u.username = :#{#username}"
            ,nativeQuery = true)
        Optional<Users> findByFilter (String username);
}
