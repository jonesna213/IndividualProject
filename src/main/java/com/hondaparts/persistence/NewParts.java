package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Merchant;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.PartsMerchants;

/**
 * This class is for inserting new parts into the database
 *
 * @author Navy Jones
 */
public class NewParts {
    private final GenericDao<Part> partDao = new GenericDao<>(Part.class);
    private final GenericDao<Category> catDao = new GenericDao<>(Category.class);
    private final GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
    private final GenericDao<PartsMerchants> pmDao = new GenericDao<>(PartsMerchants.class);

    /**
     * For inserting new parts into the database
     *
     * @param partName the part name
     * @param partNumber the part number
     * @param description the part description
     * @param imageLocation the imageLocation of the part
     * @param linkToPart the link to the part on the merchants website
     * @param price the price of the part
     * @param categoryName the category the part belongs too
     * @param merchantName the merchant the part belongs too
     */
    public void insertNewPart(String partName, String partNumber, String description, String imageLocation, String linkToPart, String price, String categoryName, String merchantName) {
        Part newPart = new Part();
        PartsMerchants pm = new PartsMerchants();
        Category category = catDao.getByPropertyEqual("category", categoryName).get(0);
        Merchant merchant = merchantDao.getByPropertyEqual("name", merchantName).get(0);

        //Creating part object and adding to database if it's not already there
        if (partDao.getByPropertyEqual("partNumber", partNumber).size() == 0) {
            newPart.setPartName(partName);
            newPart.setPartNumber(partNumber);
            newPart.setPartDescription(description);
            newPart.setPartImageFileLocation(imageLocation);
            newPart.setCategory(category);
            pm.setPart(newPart);
            newPart.getPartsMerchants().add(pm);
            partDao.insert(newPart);
        } else {
            pm.setPart(partDao.getByPropertyEqual("partNumber", partNumber).get(0));
        }
        pm.setMerchant(merchant);
        pm.setPrice(price);
        pm.setLinkToPart(linkToPart);

        pmDao.saveOrUpdate(pm);

    }
}
