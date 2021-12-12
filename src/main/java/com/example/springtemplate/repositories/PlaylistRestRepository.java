package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRestRepository
    extends CrudRepository<Playlist, Integer> {
  @Query(value = "SELECT * FROM playlists",
      nativeQuery = true)
  public List<Playlist> findAllPlaylists();
  @Query(value = "SELECT * FROM playlists WHERE id=:playlistId",
      nativeQuery = true)
  public Playlist findPlaylistById(@Param("playlistId") Integer id);

  @Query(value = "SELECT * FROM playlists WHERE playlists.id in\n"
      + "(SELECT playlist_id FROM added WHERE song_id=:songId)",
      nativeQuery = true)
  public List<Playlist> findPlaylistsBySongId(@Param("songId") Integer id);

  @Query(value = "SELECT * FROM playlists WHERE playlists.user_id=:userId",
      nativeQuery = true)
  public List<Playlist> findPlaylistsByUserId(@Param("userId")Integer id);

}
