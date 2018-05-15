package com.crud.library.service;

import com.crud.library.domain.*;
import com.crud.library.repository.BorrowDao;
import com.crud.library.repository.ItemDao;
import com.crud.library.repository.ReaderDao;
import com.crud.library.repository.TitleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    BorrowDao borrowDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ReaderDao readerDao;
    @Autowired
    TitleDao titleDao;

    public List<Reader> getAllReaders() {
        return readerDao.findAll();
    }

    public Optional<Reader> getReader(int id) {
        return readerDao.findById(id);
    }

    public Reader saveReader(final Reader reader) {
        if (reader.getCreated() == null) {
            reader.setCreated(LocalDateTime.now());
        }
        return readerDao.save(reader);
    }

    public List<Title> getAllTitles() {
        return titleDao.findAll();
    }

    public Item saveTitleAndItem(final int titleId, final Item item) throws TitleNotExistsException {
        Title title = getTitle(titleId).orElseThrow(TitleNotExistsException::new);
        item.setTitle(title);
        title.getItemList().add(item);
        saveItem(item);
        saveTitle(title);
        return item;
    }

    public Optional<Title> getTitle(int id) {
        return titleDao.findById(id);
    }

    public Title saveTitle(final Title title) {
        return titleDao.save(title);
    }

    public Item saveItem(final Item item) {
        return itemDao.save(item);
    }

    public List<Item> getAllItems() {
        return itemDao.findAll();
    }

    public Optional<Item> getItem(int itemId) {
        return itemDao.findById(itemId);
    }

    public List<Borrow> getAllBorrows() {
        return borrowDao.findAll();
    }

    public Optional<Borrow> getBorrow(int id) {
        return borrowDao.findById(id);
    }

    public Borrow saveBorrow(final Borrow borrow) {
        return borrowDao.save(borrow);
    }

    public Borrow addBorrowToReaderAndItem(final Borrow borrow, final int readerId, final int itemId) throws ReaderNotExistsException, ItemNotExistsException, ItemIsNotFreeException {
        Reader reader = getReader(readerId).orElseThrow(ReaderNotExistsException::new);
        Item item = getItem(itemId).orElseThrow(ItemNotExistsException::new);
        if (item.getStatus() != ItemStatus.FREE) {
            throw new ItemIsNotFreeException();
        }
        borrow.setReader(reader);
        borrow.setItem(item);
        borrow.setBorrowDateTime(LocalDateTime.now());
        saveBorrow(borrow);
        reader.getBorrowList().add(borrow);
        saveReader(reader);
        item.getBorrowList().add(borrow);
        item.setStatus(ItemStatus.BORROWED);
        saveItem(item);
        return borrow;
    }

    public Borrow saveBorrowAndSetItemStatus(int borrowId, ItemStatus itemStatus) throws ItemNotExistsException, BorrowNotExistsException {
        Borrow borrow = getBorrow(borrowId).orElseThrow(BorrowNotExistsException::new);
        Item item = itemDao.findByBorrowListContains(borrow).orElseThrow(ItemNotExistsException::new);
        borrow.setReturnDateTime(LocalDateTime.now());
        saveBorrow(borrow);
        item.setStatus(itemStatus);
        saveItem(item);
        return borrow;
    }


    public long getFreeItemCountByTitleId(int titleId) throws TitleNotExistsException {
        Title title = getTitle(titleId).orElseThrow(TitleNotExistsException::new);
        long itemCount = itemDao.countByTitleAndStatus(title, ItemStatus.FREE);
        return itemCount;

    }

}
