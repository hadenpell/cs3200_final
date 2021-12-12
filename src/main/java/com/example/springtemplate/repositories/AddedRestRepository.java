package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Added;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddedRestRepository
    extends CrudRepository<Added, Integer> {
  @Query(value = "SELECT * FROM added",
      nativeQuery = true)
  public List<Added> findAllAdded();

  @Query(value = "SELECT * FROM added WHERE id=:addedId",
      nativeQuery = true)
  public Added findAddedById(@Param("addedId") Integer id);
  
}