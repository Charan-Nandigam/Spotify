package com.project.spotify.service;

import java.util.List;
import java.util.Optional;

import com.project.spotify.entities.Artist;


public interface ArtistService {
public Artist createArtist(Artist art);
public List<Artist> getAllArtists();
public Optional<Artist>  findByName(String name);
public Artist updateArtist(Artist art);
public void deleteArtist(Artist art);

}
