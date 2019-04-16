package com.ethero.euclisstickers.repository;

import com.ethero.euclisstickers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
