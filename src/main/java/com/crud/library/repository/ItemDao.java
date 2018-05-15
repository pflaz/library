package com.crud.library.repository;

import com.crud.library.domain.Borrow;
import com.crud.library.domain.Item;
import com.crud.library.domain.ItemStatus;
import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ItemDao extends CrudRepository<Item, Integer> {
    @Override
    List<Item> findAll();

    Optional<Item> findById(int id);

    long countByTitleAndStatus (Title title, ItemStatus status);

    Optional<Item> findByBorrowListContains(Borrow borrow);

    @Override
    Item save(Item item);

    @Override
    void delete(Integer id);
}
