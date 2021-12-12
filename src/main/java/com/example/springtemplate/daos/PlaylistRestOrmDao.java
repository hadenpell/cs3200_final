package com.example.springtemplate.daos;

import com.example.springtemplate.models.Playlist;
import com.example.springtemplate.repositories.PlaylistRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PlaylistRestOrmDao {
  @Autowired
  PlaylistRestRepository playlistRepository;

  @PostMapping("/api/playlists")
  public Playlist createPlaylist(@RequestBody Playlist playlist) {
    return playlistRepository.save(playlist);
  }

  @GetMapping("/api/playlists")
  public List<Playlist> findAllPlaylists() {
    return playlistRepository.findAllPlaylists();
  }

  @GetMapping("/api/playlists/{playlistId}")
  public Playlist findPlaylistById(
      @PathVariable("playlistId") Integer id) {
    return playlistRepository.findPlaylistById(id);
  }

  @PutMapping("/api/playlists/{playlistId}")
  public Playlist updateUser(
      @PathVariable("playlistId") Integer id,
      @RequestBody Playlist playlistUpdates) {
    Playlist playlist = playlistRepository.findPlaylistById(id);
    playlist.setName(playlistUpdates.getName());
    playlist.setCreateDate(playlistUpdates.getCreateDate());
    playlist.setUserId(playlistUpdates.getUserId());
    return playlistRepository.save(playlist);
  }

  @DeleteMapping("/api/playlists/{playlistId}")
  public void deletePlaylist(
      @PathVariable("playlistId") Integer id) {
    playlistRepository.deleteById(id);
  }

  @GetMapping("/api/songs/{songId}/playlists")
  public List<Playlist> findPlaylistsBySongId(
      @PathVariable("songId") Integer id) {
    return playlistRepository.findPlaylistsBySongId(id);
  }

  @GetMapping("/api/users/{userId}/playlists")
  public List<Playlist> findPlaylistsByUserId(
      @PathVariable("userId") Integer id) {
    return playlistRepository.findPlaylistsByUserId(id);
  }
}