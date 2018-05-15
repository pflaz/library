package com.crud.library.repository;

import com.crud.library.domain.Item;
import com.crud.library.domain.ItemStatus;
import com.crud.library.domain.Title;
import com.crud.library.exceptions.ItemNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemDaoTestSuite {
    @Autowired
    ItemDao itemDao;
    @Autowired
    TitleDao titleDao;

    @Test
    public void testCreateItem() {
        //Given
        Title title = new Title("W pustyni i w puszczy", "Sienkiewicz Henryk", 2000);
        titleDao.save(title);
        Item item = new Item(title, ItemStatus.BORROWED);
        title.getItemList().add(item);

        //When
        itemDao.save(item);
        int id = item.getId();
        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
//        titleDao.delete(title);
    }

    @Test
    public void testFindItem() throws ItemNotFoundException {
        // Given
        Title title = new Title("W pustyni i w puszczy", "Sienkiewicz Henryk", 2000);
        titleDao.save(title);
        Item item = new Item(title, ItemStatus.BORROWED);
        title.getItemList().add(item);
        itemDao.save(item);
        int itemId = item.getId();

        // When
        Item fetchedItem = itemDao.findById(itemId).orElseThrow(ItemNotFoundException::new);

        // Then
        Assert.assertEquals(ItemStatus.BORROWED, fetchedItem.getStatus());
        Assert.assertEquals("Sienkiewicz Henryk", fetchedItem.getTitle().getAuthor());
        Assert.assertEquals("W pustyni i w puszczy", fetchedItem.getTitle().getTitle());

        // CleanUp
        titleDao.delete(title);

    }

}