package com.crud.library.repository;

import com.crud.library.domain.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class TitleDaoTestSuite {
    @Autowired
    TitleDao titleDao;

    @Test
    public void testCreateTitle() {
        //Given
        Title title = new Title("W pustyni i w puszczy", "Sienkiewicz Henryk", 2000);

        //When
        titleDao.save(title);
        int id = title.getId();

        //Then
        Assert.assertNotEquals(0, id);


        // CleanUp
        titleDao.delete(id);
    }

}