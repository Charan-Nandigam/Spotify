package com.project.spotify.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

	//methodname should be findby*column_Name*
	public Optional<Song> findBySongName(String sName);

}
