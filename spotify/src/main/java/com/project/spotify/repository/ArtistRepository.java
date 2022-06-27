package com.project.spotify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long>  {
public Optional<Artist> findByName(String name);

}