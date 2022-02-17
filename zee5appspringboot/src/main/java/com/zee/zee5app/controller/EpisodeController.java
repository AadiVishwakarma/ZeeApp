package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.EpisodeService;
@CrossOrigin("*")
@RestController

@RequestMapping("/api/episodes")
public class EpisodeController {

	@Autowired
	EpisodeService episodeService;
	
	 @PostMapping("/addEpisode")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<?> addEpisode(@Valid @RequestBody Episode episode) throws AlreadyExistsException {
	        Episode result = episodeService.addEpisode(episode);
	        return ResponseEntity.status(201).body(result);
	    }

	    @GetMapping("/{id}")
	    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	    public ResponseEntity<?> getEpisodeById(@PathVariable("id") long id) throws IdNotFoundException {
	        Optional<Episode> optional = episodeService.getEpisodeById(id);
	        if (optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No episode found");
	        }
	        return ResponseEntity.status(200).body(optional.get());
	    }

	    @GetMapping("/all")
	    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	    public ResponseEntity<?> getAllEpisodes() {
	        Optional<List<Episode>> optional = episodeService.getAllEpisode();
	        if (optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No episode found");
	        }
	        return ResponseEntity.status(200).body(optional.get());
	    }
}
