package com.crud.library.repository;

import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderDao extends CrudRepository<Reader, Integer> {
    @Override
    List<Reader> findAll();

    @Override
    Reader save(Reader reader);

    Optional<Reader> findById(Integer id);

    @Override
    void delete(Integer id);
}
