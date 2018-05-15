package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "ITEMS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "TITLE")
    private Title title;

    @Column(name = "STATUS")
    private ItemStatus status;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Borrow.class,
            mappedBy = "item"
    )
    private List<Borrow> borrowList = new ArrayList<>();

    public Item(Title title, ItemStatus status) {
        this.title = title;
        this.status = status;
    }

    public Item(int id, ItemStatus status, List<Borrow> borrowList) {
        this.id = id;
        this.status = status;
        this.borrowList = borrowList;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
