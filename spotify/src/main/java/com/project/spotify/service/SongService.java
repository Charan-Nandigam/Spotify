package com.project.spotify.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.project.spotify.entities.Song;

public interface SongService {

	public Song createSong(Song s);
	public List<Song> getAllSongs();
	public Optional<Song> getSongBySongName(String sName);
	public Song updateSong(@Valid Song sUp);
	public void deleteSong(Song s);

}
