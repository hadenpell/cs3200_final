package com.example.springtemplate.daos;

import com.example.springtemplate.models.Added;
import com.example.springtemplate.repositories.AddedRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AddedRestOrmDao {
  @Autowired
  AddedRestRepository addedRestRepository;

  @PostMapping("/api/added")
  public Added createAdded(@RequestBody Added added) {
    return addedRestRepository.save(added);
  }

  @GetMapping("/api/added")
  public List<Added> findAllAdded() {
    return addedRestRepository.findAllAdded();
  }

  @GetMapping("/api/added/{addedId}")
  public Added findAddedById(
      @PathVariable("addedId") Integer id) {
    return addedRestRepository.findAddedById(id);
  }

  @PutMapping("/api/added/{addedId}")
  public Added updateAdded(
      @PathVariable("addedId") Integer id,
      @RequestBody Added addedUpdates) {
    Added a = addedRestRepository.findAddedById(id);
    a.setSongId(addedUpdates.getSongId());
    a.setPlaylistId(addedUpdates.getPlaylistId());
    a.setDateAdded(addedUpdates.getDateAdded());
    return addedRestRepository.save(a);
  }

  @DeleteMapping("/api/added/{addedId}")
  public void deleteAdded(
      @PathVariable("addedId") Integer id) {
    addedRestRepository.deleteById(id);
  }
}