package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("itemStatus")
    private ItemStatus itemStatus;
    @JsonProperty("borrowList")
    private List<Borrow> borrowList;

}
