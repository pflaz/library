package com.crud.library.controller;

import com.crud.library.dto.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/reader")
//@CrossOrigin(origins = "*")
public class ReaderController {

    @Autowired
    private DbService dbService;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(dbService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(
                dbService.saveReader(
                        readerMapper.mapToReader(readerDto)
                )
        );

    }
}
