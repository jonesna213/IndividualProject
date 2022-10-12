package com.hondaparts.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

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
    private String partImageFileLocation;

    @ManyToOne
    private Category category;

    /**
     * Empty Constructor
     */
    public Part() {
    }

    /**
     * Constructor to create the part object.
     * @param partName the parts name
     * @param partNumber the parts number
     * @param partImageFileLocation the parts image file location
     * @param category the parts category
     */
    public Part(String partName, String partNumber, String partImageFileLocation, Category category) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partImageFileLocation = partImageFileLocation;
        this.category = category;
    }
}
