package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Login;

//this will create singleton instance 
@Repository
public interface LoginRepository extends JpaRepository<Login,String> {
boolean existsByEmailAndPassword(String email, String password);
//	Boolean existsByEmail(String email);
}
