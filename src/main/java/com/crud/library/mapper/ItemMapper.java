package com.crud.library.mapper;

import com.crud.library.domain.Item;
import com.crud.library.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    @Autowired
    BorrowMapper borrowMapper;

    public Item mapToItem(ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getStatus(),
                borrowMapper.mapToBorrowList(itemDto.getBorrowDtoList())
        );
    }

    public ItemDto mapToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getStatus(),
                borrowMapper.mapToBorrowDtoList(item.getBorrowList())
        );
    }

    public List<Item> mapToItemList(List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(itemDto -> new Item(
                        itemDto.getId(),
                        itemDto.getStatus(),
                        borrowMapper.mapToBorrowList(itemDto.getBorrowDtoList())
                )).collect(Collectors.toList());
    }

    public List<ItemDto> mapToItemDtoList(List<Item> itemList) {
        return itemList.stream()
                .map(item -> new ItemDto(
                        item.getId(),
                        item.getStatus(),
                        borrowMapper.mapToBorrowDtoList(item.getBorrowList())
                )).collect(Collectors.toList());
    }
}
