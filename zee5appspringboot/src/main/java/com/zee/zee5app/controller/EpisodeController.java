package com.zee.zee5app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.service.EpisodeService;

@RestController

@RequestMapping("/episodes")
public class EpisodeController {

	@Autowired
	EpisodeService episodeService;
}
