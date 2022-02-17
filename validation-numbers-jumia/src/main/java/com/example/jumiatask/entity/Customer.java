package com.example.jumiatask.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    @Transient
    private String state;
    @Transient
    private String country;

    public Customer(int id , String name , String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}