package com.hondaparts.entity;

import javax.persistence.*;

/**
 * The Object PartsMerchants (join table)
 *
 * @author Navy Jones
 */
@Entity(name = "PartMerchants")
@Table(name = "partsmerchants")
@AssociationOverrides({
        @AssociationOverride(name = "pk.part",
                joinColumns = @JoinColumn(name = "parts_id")),
        @AssociationOverride(name = "pk.merchant",
                joinColumns = @JoinColumn(name = "merchants_id")) })
public class PartsMerchants {
    @EmbeddedId
    private PartsMerchantsId pk = new PartsMerchantsId();
    private String linkToPart;
    private String price;

    /**
     * Gets pk.
     *
     * @return the pk
     */
    public PartsMerchantsId getPk() {
        return pk;
    }

    /**
     * Sets pk.
     *
     * @param pk the pk
     */
    public void setPk(PartsMerchantsId pk) {
        this.pk = pk;
    }

    /**
     * Gets link to part.
     *
     * @return the link to part
     */
    public String getLinkToPart() {
        return linkToPart;
    }

    /**
     * Sets link to part.
     *
     * @param linkToPart the link to part
     */
    public void setLinkToPart(String linkToPart) {
        this.linkToPart = linkToPart;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets part.
     *
     * @return the part
     */
    @Transient
    public Part getPart() {
        return getPk().getPart();
    }

    /**
     * Sets part.
     *
     * @param part the part
     */
    public void setPart(Part part) {
        getPk().setPart(part);
    }

    /**
     * Gets merchant.
     *
     * @return the merchant
     */
    @Transient
    public Merchant getMerchant() {
        return getPk().getMerchant();
    }

    /**
     * Sets merchant.
     *
     * @param merchant the merchant
     */
    public void setMerchant(Merchant merchant) {
        getPk().setMerchant(merchant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PartsMerchants that = (PartsMerchants) o;

        return getPk() != null ? getPk().equals(that.getPk()) : that.getPk() == null;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
