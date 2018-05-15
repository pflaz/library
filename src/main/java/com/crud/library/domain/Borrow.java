package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "BORROWS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Borrow {
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "READER")
    private Reader reader;
    @Column(name = "BORROW_DATE")
    private LocalDateTime borrowDateTime;
    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDateTime;

    public Borrow(Item item, Reader reader, LocalDateTime borrowDateTime) {
        this.item = item;
        this.reader = reader;
        this.borrowDateTime = borrowDateTime;
    }

    public Borrow(int id, LocalDateTime borrowDateTime, LocalDateTime returnDateTime) {
        this.id = id;
        this.borrowDateTime = borrowDateTime;
        this.returnDateTime = returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBorrowDateTime(LocalDateTime borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }
}
