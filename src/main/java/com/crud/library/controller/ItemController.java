package com.crud.library.controller;

import com.crud.library.domain.Item;
import com.crud.library.dto.ItemDto;
import com.crud.library.mapper.ItemMapper;
import com.crud.library.service.DbService;
import com.crud.library.service.TitleNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/item")
@CrossOrigin(origins = "*")

public class ItemController {

    @Autowired
    DbService dbService;
    @Autowired
    ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getItems")
    public List<ItemDto> getAllItems() {
        return itemMapper.mapToItemDtoList(
                dbService.getAllItems()
        );
    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestParam int titleId, @RequestBody ItemDto itemDto) throws TitleNotExistsException {
            return itemMapper.mapToItemDto(
                    dbService.saveTitleAndItem(titleId,
                            itemMapper.mapToItem(itemDto)
                    )
            );
    }

    @RequestMapping(method = RequestMethod.GET, value = "freeItems")
    public long getFreeItemCountByTitleId(@RequestParam int titleId) throws TitleNotExistsException{
        return dbService.getFreeItemCountByTitleId(titleId);
    }
}
