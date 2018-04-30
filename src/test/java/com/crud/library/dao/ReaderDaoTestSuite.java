package com.crud.library.dao;

import com.crud.library.domain.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReaderDaoTestSuite {
    @Autowired
    ReaderDao readerDao;

    @Test
    public void createReader() {
        // Given
        Reader reader = new Reader("John", "Smith", LocalDateTime.now());

        // When
        readerDao.save(reader);
        int id = reader.getId();

        // Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        readerDao.delete(id);
    }

}