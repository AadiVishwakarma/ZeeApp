package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {

	Optional<Episode> findById(long id);

	void deleteById(Long id);

}
