package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "TITLES")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Title {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "RELEASE_YEAR")
    private int releaseYear;
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "title",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Item> itemList = new ArrayList<>();

    public Title(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
}
