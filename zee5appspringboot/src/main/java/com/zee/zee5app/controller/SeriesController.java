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

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SeriesService;
@CrossOrigin("*")
@RestController

@RequestMapping("/api/series")
public class SeriesController {

	@Autowired
	SeriesService seriesService;
	
	@PostMapping("/addSeries")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addSeries(@Valid @RequestBody Series series) throws AlreadyExistsException {
        Series result = seriesService.addSeries(series);
        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public ResponseEntity<?> getSeriesById(@PathVariable("id") long id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
        Optional<Series> optional = seriesService.getSeriesById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No series found");
        }
        return ResponseEntity.status(200).body(optional.get());
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public ResponseEntity<?> getAllSeries() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException {
        Optional<List<Series>> optional = seriesService.getAllSeries();
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No series found");
        }
        return ResponseEntity.status(200).body(optional.get());
    }
}
