package com.example.springtemplate.daos;

import com.example.springtemplate.models.Song;
import com.example.springtemplate.repositories.SongRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SongRestOrmDao {
  @Autowired
  SongRestRepository songRestRepository;

  @PostMapping("/api/songs")
  public Song createSong(@RequestBody Song song) {
    return songRestRepository.save(song);
  }

  @GetMapping("/api/songs")
  public List<Song> findAllSongs() {
    return songRestRepository.findAllSongs();
  }

  @GetMapping("/api/songs/{songId}")
  public Song findSongById(
      @PathVariable("songId") Integer id) {
    return songRestRepository.findSongById(id);
  }

  @GetMapping("/api/playlists/{playlistId}/songs")
  public List<Song> findSongsByPlaylistId(
      @PathVariable("playlistId") Integer id) {
    return songRestRepository.findSongsByPlaylistId(id);
  }

  @PutMapping("/api/songs/{songId}")
  public Song updateSong(
      @PathVariable("songId") Integer id,
      @RequestBody Song songUpdates) {
    Song song = songRestRepository.findSongById(id);
    song.setTitle(songUpdates.getTitle());
    song.setArtist(songUpdates.getArtist());
    song.setGenre(songUpdates.getGenre());
    song.setReleaseDate(songUpdates.getReleaseDate());
    return songRestRepository.save(song);
  }

  @DeleteMapping("/api/songs/{songId}")
  public void deleteSong(
      @PathVariable("songId") Integer id) {
    songRestRepository.deleteById(id);
  }
}