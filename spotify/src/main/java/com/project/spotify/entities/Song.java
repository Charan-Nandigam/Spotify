package com.project.spotify.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "song", uniqueConstraints = {
		@UniqueConstraint(name = "song_uni",
				columnNames = {"songName"})
})
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sId;
	
	@NotEmpty(message = "Name Required!")
	@Column(unique=true)
	private String songName;
	
	@JsonFormat(pattern  = "yyyy-mm-dd")
	private Date releaseDate;
	
	
	
	public Song() {
		super();
	}
	public Song(Long sId, String songName, Date releaseDate) {
		super();
		this.sId = sId;
		this.songName = songName;
		this.releaseDate = releaseDate;
	}
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Song [sId=" + sId + ", songName=" + songName + ", releaseDate=" + releaseDate + "]";
	}

	

}
