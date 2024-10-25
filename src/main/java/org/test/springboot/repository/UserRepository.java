package org.test.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}