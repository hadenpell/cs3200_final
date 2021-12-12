package com.example.springtemplate.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="added")
public class Added implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne(targetEntity = Song.class)
  @JoinColumn(name = "song_id")
  private Integer songId;
  @ManyToOne(targetEntity = Playlist.class)
  @JoinColumn(name = "playlist_id")
  private Integer playlistId;
  private Date dateAdded;


  public Integer getId() {return id;}
  public void setId(Integer id) {this.id = id;}
  public Integer getSongId() {return songId;}
  public void setSongId(Integer songId) {this.songId = songId;}
  public Integer getPlaylistId() {return playlistId;}
  public void setPlaylistId(Integer playlistId) {this.playlistId = playlistId;}
  public Date getDateAdded() {return dateAdded;}
  public void setDateAdded(Date dateAdded) {this.dateAdded = dateAdded;}

  public Added(Integer songId, Integer playlistId, Date dateAdded) {
    this.songId = songId;
    this.playlistId = playlistId;
    this.dateAdded = dateAdded;
  }

  public Added() {}
}