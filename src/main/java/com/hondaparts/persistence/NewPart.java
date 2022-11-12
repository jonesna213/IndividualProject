package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Merchant;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.PartsMerchants;

public class NewPart {
    GenericDao<Part> partDao = new GenericDao<>(Part.class);
    GenericDao<Category> catDao = new GenericDao<>(Category.class);
    GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
    GenericDao<PartsMerchants> pmDao = new GenericDao<>(PartsMerchants.class);

    public void insertNewPart(String partName, String partNumber, String description, String imageLocation, String linkToPart, String price, String categoryName, String merchantName) {
        Part newPart = new Part();
        PartsMerchants pm = new PartsMerchants();
        Category category = catDao.getByPropertyEqual("category", categoryName).get(0);
        Merchant merchant = merchantDao.getByPropertyEqual("name", merchantName).get(0);

        //Creating part object and adding to database if its not already there
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
