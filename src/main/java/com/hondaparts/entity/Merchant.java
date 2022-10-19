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

    /**
     * Instantiates a new Merchant.
     *
     * @param name                  the name
     * @param logoImageFileLocation the logo image file location
     * @param website               the website
     * @param partsMerchants        the parts merchants
     */
    public Merchant(String name, String logoImageFileLocation, String website, Set<PartsMerchants> partsMerchants) {
        this.name = name;
        this.logoImageFileLocation = logoImageFileLocation;
        this.website = website;
        this.partsMerchants = partsMerchants;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets logo image file location.
     *
     * @return the logo image file location
     */
    public String getLogoImageFileLocation() {
        return logoImageFileLocation;
    }

    /**
     * Sets logo image file location.
     *
     * @param logoImageFileLocation the logo image file location
     */
    public void setLogoImageFileLocation(String logoImageFileLocation) {
        this.logoImageFileLocation = logoImageFileLocation;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets parts merchants.
     *
     * @return the parts merchants
     */
    public Set<PartsMerchants> getPartsMerchants() {
        return partsMerchants;
    }

    /**
     * Sets parts merchants.
     *
     * @param partsMerchants the parts merchants
     */
    public void setPartsMerchants(Set<PartsMerchants> partsMerchants) {
        this.partsMerchants = partsMerchants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return id == merchant.id && Objects.equals(name, merchant.name) && Objects.equals(logoImageFileLocation, merchant.logoImageFileLocation) && Objects.equals(website, merchant.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, logoImageFileLocation, website);
    }
}
