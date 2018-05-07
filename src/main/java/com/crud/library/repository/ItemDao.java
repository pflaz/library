package com.crud.library.repository;

import com.crud.library.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemDao extends CrudRepository<Item, Integer> {
    @Override
    List<Item> findAll();

    Optional<Item> findById(int id);

    @Override
    Item save(Item item);

    @Override
    void delete(Integer id);
}
