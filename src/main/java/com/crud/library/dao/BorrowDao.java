package com.crud.library.dao;

import com.crud.library.domain.Borrow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowDao extends CrudRepository<Borrow, Integer> {
    @Override
    List<Borrow> findAll();

    Optional<Borrow> findById(int id);

    @Override
    Borrow save(Borrow borrow);

    @Override
    void delete(Integer id);



}
