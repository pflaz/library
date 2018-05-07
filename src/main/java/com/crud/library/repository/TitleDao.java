package com.crud.library.repository;

import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleDao extends CrudRepository<Title, Integer> {
    @Override
    List<Title> findAll();

    Optional<Title> findById(Integer id);

    @Override
    Title save(Title title);

    @Override
    void delete(Integer id);
}
