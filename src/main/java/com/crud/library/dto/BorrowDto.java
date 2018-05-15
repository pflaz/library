package com.crud.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("item")
    private ItemDto itemDto;
    @JsonProperty("reader")
    private ReaderDto readerDto;
    @JsonProperty("borrowDateTime")
    private LocalDateTime borrowDateTime;
    @JsonProperty("returnDateTime")
    private LocalDateTime returnDateTime;

    public BorrowDto(int id, LocalDateTime borrowDateTime, LocalDateTime returnDateTime) {
        this.id = id;
        this.borrowDateTime = borrowDateTime;
        this.returnDateTime = returnDateTime;
    }
}
