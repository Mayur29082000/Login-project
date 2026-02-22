package com.application.login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.login.Entity.User;


@Repository
public interface SignUpRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

}
