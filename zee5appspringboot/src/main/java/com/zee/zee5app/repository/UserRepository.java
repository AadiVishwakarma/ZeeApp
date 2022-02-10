package com.zee.zee5app.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//custom jpa method : for this method we will not write any definiton ,just only signature
	//need to follow a specifice way
	Boolean existsByEmailAndContactNumber(String email, BigInteger contactNumber);
//	Boolean existsByContactNumber(BigDecimal contactNumber);
	
	Optional<User> findByUserName(String username);
}
