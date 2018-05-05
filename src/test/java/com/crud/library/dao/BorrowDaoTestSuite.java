package com.crud.library.dao;

import com.crud.library.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowDaoTestSuite {

    @Autowired
    ReaderDao readerDao;
    @Autowired
    TitleDao titleDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    BorrowDao borrowDao;

    @Test
    public void testCreateBorrow() {
        //Given
        Reader reader = new Reader("John", "Smith", LocalDateTime.now());
        readerDao.save(reader);
        Title title = new Title("W pustyni i w puszczy", "Sienkiewicz Henryk", 2000);
        titleDao.save(title);
        Item item = new Item(title, ItemStatus.BORROWED);
        title.getItemList().add(item);
        itemDao.save(item);

        Borrow borrow = new Borrow(item, reader, LocalDateTime.now());
        item.getBorrowList().add(borrow);
        reader.getBorrowList().add(borrow);

        // When
        borrowDao.save(borrow);
        itemDao.save(item);
        readerDao.save(reader);

        // Then
        Assert.assertNotEquals(0, item.getId());
        Assert.assertEquals(1, reader.getBorrowList().size());
        Assert.assertEquals(1, item.getBorrowList().size());

        //CleanUp
        borrowDao.delete(borrow);
        item.getBorrowList().remove(borrow);
        reader.getBorrowList().remove(borrow);
        titleDao.delete(title);
        readerDao.delete(reader);
    }
}