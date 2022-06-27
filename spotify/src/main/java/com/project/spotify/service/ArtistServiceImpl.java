package com.project.spotify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.entities.Artist;
import com.project.spotify.repository.ArtistRepository;
@Service
public class ArtistServiceImpl implements ArtistService {

@Autowired
private ArtistRepository artrep;
@Override
public Artist createArtist(Artist art) {
// TODO Auto-generated method stub
return(artrep.save(art));
}

@Override
public List<Artist> getAllArtists() {
// TODO Auto-generated method stub
return(artrep.findAll());
}

@Override
public Optional<Artist> findByName(String name) {
// TODO Auto-generated method stub
return artrep.findByName(name);
}

@Override
public Artist updateArtist(Artist art) {
// TODO Auto-generated method stub
return artrep.save(art);
}

@Override
public void deleteArtist(Artist art) {
artrep.delete(art);

}

}
