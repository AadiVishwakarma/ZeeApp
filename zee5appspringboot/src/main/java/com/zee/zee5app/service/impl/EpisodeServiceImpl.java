package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	
	@Autowired
	private EpisodeRepository episodeRepository;

	@Override
	public Episode addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		Episode episode2 = episodeRepository.save(episode);
		if (episode2!=null)
			return episode2;
		else
			return null;
	}


//	@Override
//	public Episode[] getAllEpisode() {
//		// TODO Auto-generated method stub
//		List<Episode> list = episodeRepository.findAll();
//		Episode[] episodes = new Episode[list.size()];
//		return list.toArray(episodes);
//	}


	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}


	@Override
	public Optional<Episode> getEpisodeById(long id) {
		// TODO Auto-generated method stub
		return episodeRepository.findById(id);
	}

	@Override
	public Optional<List<Episode>> getAllEpisode() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}

	@Override
	public String deleteEpisode(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episode> optional = this.getEpisodeById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("episode record not found");
		else {
			episodeRepository.deleteById(id);
			return "success";
		}
	}

}
