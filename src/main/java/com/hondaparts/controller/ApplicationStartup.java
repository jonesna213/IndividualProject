package com.hondaparts.controller;

import com.hondaparts.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/applicationStartup" },
        loadOnStartup = 1
)

/**
 * This servlet is the startup for the application.
 *
 * @author Navy Jones
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    public Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    public static String CLIENT_ID;
    public static String LOGIN_URL;
    public static String SIGNUP_URL;
    public static String SIGN_OUT_URL;
    public static String REDIRECT_URL;
    public static String SIGN_OUT_REDIRECT_URL;
    public static String CLIENT_SECRET;
    public static String OAUTH_URL;
    public static String REGION;
    public static String POOL_ID;

    /**
     * This method sets up the initialization of the application.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL = properties.getProperty("oauthURL");
            LOGIN_URL = properties.getProperty("loginURL");
            SIGNUP_URL = properties.getProperty("signupURL");
            SIGN_OUT_URL = properties.getProperty("signOutURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            SIGN_OUT_REDIRECT_URL = properties.getProperty("signOutRedirectURL");
            REGION = properties.getProperty("region");
            POOL_ID = properties.getProperty("poolId");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }

        context.setAttribute("clientId", CLIENT_ID);
        context.setAttribute("clientSecret", CLIENT_SECRET);
        context.setAttribute("oAuthURL", OAUTH_URL);
        context.setAttribute("loginURL", LOGIN_URL);
        context.setAttribute("signupURL", SIGNUP_URL);
        context.setAttribute("signOutURL", SIGN_OUT_URL);
        context.setAttribute("redirectURL", REDIRECT_URL);
        context.setAttribute("signOutRedirectURL", SIGN_OUT_REDIRECT_URL);
        context.setAttribute("region", REGION);
        context.setAttribute("poolId", POOL_ID);

    }
}
