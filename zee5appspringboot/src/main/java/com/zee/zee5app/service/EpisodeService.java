package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.IdNotFoundException;

public interface EpisodeService {

	public Episode addEpisode(Episode episode);

	public Optional<Episode> getEpisodeById(long id);

	public Optional<List<Episode>> getAllEpisode();

	public String deleteEpisode(Long id) throws IdNotFoundException;

	public Optional<List<Episode>> getAllEpisodeDetails();

}
