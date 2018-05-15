package com.crud.library.dto;

import com.crud.library.domain.ItemStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private TitleDto titleDto;
    @JsonProperty("status")
    private ItemStatus status;
    @JsonProperty("borrowList")
    private List<BorrowDto> borrowDtoList = new ArrayList<>();

    public ItemDto(int id, ItemStatus status, List<BorrowDto> borrowDtoList) {
        this.id = id;
        this.status = status;
        this.borrowDtoList = borrowDtoList;
    }
}
