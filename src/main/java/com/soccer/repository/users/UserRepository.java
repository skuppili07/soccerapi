package com.soccer.repository.users;

import com.soccer.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {
    List<Users> findByUsername (String userName);
}
