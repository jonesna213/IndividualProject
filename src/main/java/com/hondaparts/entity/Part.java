package com.hondaparts.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Part Object.
 *
 * @author Navy Jones
 * @version 1.0 10/11/2022
 */
@Entity(name = "Part")
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String partName;
    private String partNumber;
    private String partDescription;
    private String partImageFileLocation;
    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            targetEntity = User.class)
    @JoinTable(name = "savedparts",
            joinColumns = {@JoinColumn(name = "user_id") },
            inverseJoinColumns = {@JoinColumn(name = "parts_id") })
    private Set<User> users = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.part", cascade=CascadeType.ALL)
    private Set<PartsMerchants> partsMerchants = new HashSet<>();


    /**
     * Empty Constructor
     */
    public Part() {
    }

    /**
     * Instantiates a new Part.
     *
     * @param partName              the part name
     * @param partNumber            the part number
     * @param partDescription       the part description
     * @param partImageFileLocation the part image file location
     */
    public Part(String partName, String partNumber, String partDescription, String partImageFileLocation) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.partImageFileLocation = partImageFileLocation;
    }

    /**
     * Instantiates a new Part.
     *
     * @param partName              the part name
     * @param partNumber            the part number
     * @param partDescription       the part description
     * @param partImageFileLocation the part image file location
     * @param category              the category
     * @param partsMerchants        the parts merchants
     */
    public Part(String partName, String partNumber, String partDescription, String partImageFileLocation, Category category, Set<PartsMerchants> partsMerchants) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.partImageFileLocation = partImageFileLocation;
        this.category = category;
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
     * Gets part name.
     *
     * @return the part name
     */
    public String getPartName() {
        return partName;
    }

    /**
     * Sets part name.
     *
     * @param partName the part name
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * Gets part number.
     *
     * @return the part number
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Sets part number.
     *
     * @param partNumber the part number
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     * Gets part description.
     *
     * @return the part description
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * Sets part description.
     *
     * @param partDescription the part description
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    /**
     * Gets part image file location.
     *
     * @return the part image file location
     */
    public String getPartImageFileLocation() {
        return partImageFileLocation;
    }

    /**
     * Sets part image file location.
     *
     * @param partImageFileLocation the part image file location
     */
    public void setPartImageFileLocation(String partImageFileLocation) {
        this.partImageFileLocation = partImageFileLocation;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
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

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) {
        users.remove(user);
    }

}
