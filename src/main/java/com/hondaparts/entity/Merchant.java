package com.hondaparts.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.merchant", cascade=CascadeType.ALL)
    private Set<PartsMerchants> partsMerchants = new HashSet<>();

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

    public Merchant(String name, String logoImageFileLocation, String website, Set<PartsMerchants> partsMerchants) {
        this.name = name;
        this.logoImageFileLocation = logoImageFileLocation;
        this.website = website;
        this.partsMerchants = partsMerchants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageFileLocation() {
        return logoImageFileLocation;
    }

    public void setLogoImageFileLocation(String logoImageFileLocation) {
        this.logoImageFileLocation = logoImageFileLocation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<PartsMerchants> getPartsMerchants() {
        return partsMerchants;
    }

    public void setPartsMerchants(Set<PartsMerchants> partsMerchants) {
        this.partsMerchants = partsMerchants;
    }


}
