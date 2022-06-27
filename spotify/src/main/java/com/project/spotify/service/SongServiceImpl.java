package com.project.spotify.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.entities.Song;
import com.project.spotify.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	public SongRepository sRepository;

	@Override
	public Song createSong(Song s) {
		return sRepository.save(s);
	}

	@Override
	public List<Song> getAllSongs() {
		return sRepository.findAll();
	}

	@Override
	public Optional<Song> getSongBySongName(String sName) {
		return sRepository.findBySongName(sName);
	}

	@Override
	public Song updateSong(@Valid Song sUp) {
		return sRepository.save(sUp);
	}

	@Override
	public void deleteSong(Song s) {
		sRepository.delete(s);
	}

}
