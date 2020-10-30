package com.intentsg.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int smthToUpdate = 41;
}