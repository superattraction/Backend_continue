package edu.pnu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.UserEntity;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, String> {
	public boolean existsByEmailAndPassword(String email, String password);
}