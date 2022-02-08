package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Register;

//will handle singleton instance
@Repository
public interface UserRepository extends JpaRepository<Register, String> {
	boolean existsByEmail(String email);
}