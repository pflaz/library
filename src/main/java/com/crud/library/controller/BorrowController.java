package com.crud.library.controller;

import com.crud.library.domain.ItemStatus;
import com.crud.library.dto.BorrowDto;
import com.crud.library.dto.ItemDto;
import com.crud.library.mapper.BorrowMapper;
import com.crud.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/borrow")
//@CrossOrigin(origins = "*")
public class BorrowController {
    @Autowired
    DbService dbService;
    @Autowired
    BorrowMapper borrowMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrows")
    public List<BorrowDto> getAllBorrows() {
        return borrowMapper.mapToBorrowDtoList(
                dbService.getAllBorrows()
        );
    }

    @RequestMapping(method = RequestMethod.POST, value="borrowBook", consumes = APPLICATION_JSON_VALUE)
    public BorrowDto borrowBook(@RequestParam int readerId, @RequestParam int itemId, @RequestBody BorrowDto borrowDto) throws ReaderNotExistsException, ItemNotExistsException, ItemIsNotFreeException {
        return borrowMapper.MapToBorrowDto(
                dbService.addBorrowToReaderAndItem(
                        borrowMapper.MapToBorrow(borrowDto), readerId, itemId
                )
        );
    }

    @RequestMapping(method = RequestMethod.PUT, value="setBorrowStatus", consumes = APPLICATION_JSON_VALUE)
    public BorrowDto setBorrowStatus(@RequestParam int borrowId, @RequestParam ItemStatus itemStatus) throws ItemNotExistsException, BorrowNotExistsException {
        return borrowMapper.MapToBorrowDto(
                dbService.saveBorrowAndSetItemStatus(
                        borrowId, itemStatus
                )
        );
    }
}
