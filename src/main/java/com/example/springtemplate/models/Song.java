package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String artist;
  private String genre;
  private Date releaseDate;

  @OneToMany(mappedBy = "songId", targetEntity = Added.class)
  @JsonIgnore
  List<Playlist> playlists;

  public Integer getId() {return id;}
  public void setId(Integer id) {this.id = id;}
  public String getTitle() {return title;}
  public void setTitle(String name) {this.title = name;}
  public String getArtist() {return artist;}
  public void setArtist(String artist) {this.artist = artist;}
  public Date getReleaseDate() {return releaseDate;}
  public void setReleaseDate(Date releaseDate) {this.releaseDate = releaseDate;}
  public String getGenre() {return genre;}
  public void setGenre(String genre) {this.genre = genre;}
  public List<Playlist> getPlaylists() {return this.playlists;}
  public void setPlaylists(List<Playlist> playlists) {this.playlists = playlists;}

  public Song(String title, String artist, String genre, Date releaseDate) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.releaseDate = releaseDate;
  }

  public Song() {}
}