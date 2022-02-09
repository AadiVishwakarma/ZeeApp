package com.zee.zee5app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;

@RestController

@RequestMapping("/series")
public class SeriesController {

	@Autowired
	SeriesService seriesService;
}
