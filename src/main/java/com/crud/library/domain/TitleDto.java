package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TitleDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("releaseYear")
    private int releaseYear;
    @JsonProperty("itemList")
    private List<Item> itemList;

}
