package com.project.spotify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entities.Artist;
import com.project.spotify.exceptions.ArtistNotFoundException;
import com.project.spotify.service.ArtistService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class ArtistController {

	@Autowired
	private ArtistService artService;

	@PostMapping("/artist/newart")
	public Artist createArtist(@Valid @RequestBody Artist art) {
	return artService.createArtist(art);
	}

	@GetMapping("/artist/all")
	public List<Artist> getAllArtists(){
	return artService.getAllArtists();
	}


	@PutMapping("/artist/update/{name}")
	public ResponseEntity<Artist> updateEmployee(@PathVariable(value = "name") String name, @Valid @RequestBody Artist art) throws ArtistNotFoundException {
	Artist arti = artService.findByName(name).orElseThrow(()-> new ArtistNotFoundException("Artist not found with this name: "+ name));
	arti.setName(art.getName());
	Artist updatedArt = artService.updateArtist(arti);
	return ResponseEntity.ok(updatedArt);
	}

	@DeleteMapping("/artist/delete/{name}")
	public Map<String, Boolean> deleteEmployee( @PathVariable(value = "name") String name) throws ArtistNotFoundException {
	Artist art = artService.findByName(name).orElseThrow(()-> new ArtistNotFoundException("Artist not found with this name : "+ name));
	artService.deleteArtist(art);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Deleted", Boolean.TRUE);
	return response;
	}

	@GetMapping("/artist/name/{name}")
	public Artist getArtistByName(@PathVariable(value = "name") String name) throws ArtistNotFoundException{
	Artist art= artService.findByName(name).orElseThrow(()-> new ArtistNotFoundException("Artist not found with this name : "+ name));
	return art;
	}
}
