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
@Table(name="artist",uniqueConstraints= {
@UniqueConstraint(name="uni_art",columnNames="name")
})
public class Artist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long code;
	@NotEmpty(message="Name required")
	@Column(unique=true)
	private String name;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date dob;
	private String bio;
	
	
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artist(long code, @NotEmpty(message = "Name required") String name, Date dob, String bio) {
		super();
		this.code = code;
		this.name = name;
		this.dob = dob;
		this.bio = bio;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "Artist [code=" + code + ", name=" + name + ", dob=" + dob + ", bio=" + bio + "]";
	}
	
	
}
