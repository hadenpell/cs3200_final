package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playlists")
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Date createDate;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id")
  private Integer userId;

  @OneToMany(mappedBy = "playlistId", targetEntity = Added.class)
  @JsonIgnore
  private List<Song> songs;

  public Integer getId() {return id;}
  public void setId(Integer id) {this.id = id;}
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public Date getCreateDate() {return createDate;}
  public void setCreateDate(Date createDate) {this.createDate = createDate;}
  public Integer getUserId() {return userId;}
  public void setUserId(Integer userId) {this.userId = userId;}
  public List<Song> getSongs() {return this.songs;}
  public void setSongs(List<Song> songs) {this.songs = songs;}

  public Playlist(String name, Date createDate, Integer userId) {
    this.name = name;
    this.createDate = createDate;
    this.userId = userId;
  }

  public Playlist() {}
}