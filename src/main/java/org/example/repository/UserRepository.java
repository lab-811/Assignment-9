package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM is_User u Where u.email=?1 and u.password=?2", nativeQuery = true)
    User findUser(String email, String password);

    User findByUsername(String username);
}
