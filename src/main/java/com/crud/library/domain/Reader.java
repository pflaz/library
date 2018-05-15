package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "READERS")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Reader {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CREATED")
    private LocalDateTime created;
    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Borrow.class,
            mappedBy = "reader"
    )
    private List<Borrow> borrowList = new ArrayList<>();

    public Reader(String firstName, String lastName, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
