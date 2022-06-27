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

import com.project.spotify.entities.Song;
import com.project.spotify.exceptions.SongNotFoundException;
import com.project.spotify.service.SongService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class SongController {
	
	@Autowired
	private SongService sService;
	
	@PostMapping("/song/new")
	public Song createSong(@Valid @RequestBody Song s) {
		return sService.createSong(s);
	}
	
	@GetMapping("/song/all")
	public List<Song> getAllSongs(){
		return sService.getAllSongs();
	}
	
	@GetMapping("/song/songName/{songName}")
	public ResponseEntity<Song> getSongByName( @PathVariable(value = "songName") String sName) throws SongNotFoundException{
		 Song s = sService.getSongBySongName(sName).orElseThrow(()-> new SongNotFoundException("No Song found with this name"));
		 return ResponseEntity.ok().body(s);
	}
	
	@PutMapping("/song/update/{songName}")
	public ResponseEntity<Song> updateSong(@PathVariable(value = "songName") String sname, @Valid @RequestBody Song sUp) throws SongNotFoundException {
		Song s = sService.getSongBySongName(sname).orElseThrow(()-> new SongNotFoundException("Song not found! :"+ sname));
		s.setSongName(sUp.getSongName());
		Song updatedS = sService.updateSong(s);
		return ResponseEntity.ok(updatedS);
	}
	
	@DeleteMapping("/song/delete/{songName}")
	public Map<String, Boolean> deleteSong(@PathVariable(value = "songName") String sname) throws SongNotFoundException {
		Song s = sService.getSongBySongName(sname).orElseThrow(()-> new SongNotFoundException("Song not found! :"+sname));
		sService.deleteSong(s);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

}
