package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity (name = "ITEMS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "TITLE")
    private Title title;

    @Column(name = "STATUS")
    private ItemStatus status;

    public Item(Title title, ItemStatus status) {
        this.title = title;
        this.status = status;
    }
}
