package listener;

import bean.User;
import entity.UserEntity;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import service.UserService;
import user.UserDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static constants.ApplicationConstants.*;
/**
 * Created by Tetiana_Matiunina on 09.11.2015.
 */
public class ServletContext implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ServletContext.class);


    public void contextInitialized(ServletContextEvent event) {
        try {
            PropertyConfigurator.configure(event.getServletContext()
                    .getRealPath("WEB-INF/log4j.properties"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        event.getServletContext().setAttribute(APP_ATTRIBUTE_NAME, userService);
        LOGGER.info("Context initialized");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context destroyed");
    }
}
