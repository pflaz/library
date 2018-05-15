package com.crud.library.controller;

import com.crud.library.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/title")
//@CrossOrigin(origins = "*")

public class TitleController {
    @Autowired
    DbService dbService;
    @Autowired
    TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(dbService.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public TitleDto createTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(
                dbService.saveTitle(
                        titleMapper.mapToTitle(titleDto)
                )
        );
    }
}
