package com.hondaparts.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * The object PartsMerchantsId
 *
 * @author Navy Jones
 */
@Embeddable
public class PartsMerchantsId implements java.io.Serializable{
    @ManyToOne
    private Part part;
    @ManyToOne
    private Merchant merchant;

    /**
     * Gets part.
     *
     * @return the part
     */
    public Part getPart() {
        return part;
    }

    /**
     * Sets part.
     *
     * @param part the part
     */
    public void setPart(Part part) {
        this.part = part;
    }

    /**
     * Gets merchant.
     *
     * @return the merchant
     */
    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * Sets merchant.
     *
     * @param merchant the merchant
     */
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PartsMerchantsId that = (PartsMerchantsId) o;
        return Objects.equals(part, that.part) && Objects.equals(merchant, that.merchant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(part, merchant);
    }
}
