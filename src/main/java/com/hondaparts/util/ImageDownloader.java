package com.hondaparts.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * This class is for downloading part's images.
 *
 * Inspired by https://www.javacodeexamples.com/jsoup-download-images-from-webpage-example/815
 *
 * @author Navy Jones
 */
public class ImageDownloader {
    private static final String IMAGE_DESTINATION_FOLDER = "src/main/webapp/partImages";
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Downloads the image
     *
     * @param strImageURL the url of the image
     * @return the location of the image in the directory structure
     */
    public String downloadImage(String strImageURL) {

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        logger.info("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();
            in.close();

            logger.info("Image saved");

        } catch (IOException e) {
            logger.error("Error with downloading image", e);
        }
        return "partImages/" + strImageName;
    }
}
