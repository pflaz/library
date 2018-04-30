package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "READERS")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Reader {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CREATED")
    private LocalDateTime created;

    public Reader(String firstName, String lastName, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }
}
