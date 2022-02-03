package com.zee.zee5app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {
	
	//custom jpa method : for this method we will not write any definiton ,just only signature
	//need to follow a specifice way
	Boolean existsByEmailAndContactNumber(String email, String contactNumber);
//	Boolean existsByContactNumber(String contactNumber);
}
