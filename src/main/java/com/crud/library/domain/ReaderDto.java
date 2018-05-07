package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("borrowList")
    private List<Borrow> borrowList;

}
