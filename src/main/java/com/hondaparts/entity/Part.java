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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "parts")
    private Set<User> users = new HashSet<>();



    /**
     * Empty Constructor
     */
    public Part() {
    }

    public Part(String partName, String partNumber, String partDescription, String partImageFileLocation) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.partImageFileLocation = partImageFileLocation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return id == part.id && Objects.equals(partName, part.partName) && Objects.equals(partNumber, part.partNumber) && Objects.equals(partDescription, part.partDescription) && partImageFileLocation.equals(part.partImageFileLocation) && Objects.equals(category, part.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, partNumber, partDescription, partImageFileLocation, category);
    }
}
