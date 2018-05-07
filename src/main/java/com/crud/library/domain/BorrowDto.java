package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowDto {
    private int id;
    private Item item;
    private Reader reader;
    private LocalDateTime borrowDateTime;
    private LocalDateTime returnDateTime;

}
