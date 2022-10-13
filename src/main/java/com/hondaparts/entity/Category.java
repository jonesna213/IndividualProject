package com.hondaparts.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Category Object.
 *
 * @author Navy Jones
 * @version 1.0 10/11/2022
 */
@Entity(name = "Category")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Part> parts = new HashSet<>();

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     *
     * @param category the category
     */
    public Category(String category) {
        this.category = category;
    }

    /**
     * Instantiates a new Category.
     *
     * @param category the category
     * @param parts    the parts
     */
    public Category(String category, Set<Part> parts) {
        this.category = category;
        this.parts = parts;
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
     * Gets parts.
     *
     * @return the parts
     */
    public Set<Part> getParts() {
        return parts;
    }

    /**
     * Sets parts.
     *
     * @param parts the parts
     */
    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return id == category1.id && Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}
