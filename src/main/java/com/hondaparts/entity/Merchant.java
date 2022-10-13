package com.hondaparts.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The Merchant Object.
 *
 * @author Navy Jones
 * @version 1.0 10/12/2022
 */
@Entity(name = "Merchant")
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String name;
    private String logoImageFileLocation;
    private String website;

    /**
     * Instantiates a new Merchant.
     */
    public Merchant() {
    }

    /**
     * Instantiates a new Merchant.
     *
     * @param name                  the name
     * @param logoImageFileLocation the logo image file location
     * @param website               the website
     */
    public Merchant(String name, String logoImageFileLocation, String website) {
        this.name = name;
        this.logoImageFileLocation = logoImageFileLocation;
        this.website = website;
    }

}
