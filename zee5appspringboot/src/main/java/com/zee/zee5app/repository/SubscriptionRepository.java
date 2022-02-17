package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

	public void deleteById(Long id);
	public Optional<Subscription> findById(Long id);
}
