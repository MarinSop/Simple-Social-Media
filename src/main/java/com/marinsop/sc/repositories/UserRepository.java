package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
