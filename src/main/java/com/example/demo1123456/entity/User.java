package com.example.demo1123456.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor//lambok dependencies add
@AllArgsConstructor//lambok dependencies add
@Data//lambok dependencies add

public class User {
    @Id
    public int id;
    public String name;
    public String address;
    public int count;

//    @Id
//    private int id;
//    private String name;
//    private String address;
//    private int count;
//    private LocalDate countdownEndDate;


}
