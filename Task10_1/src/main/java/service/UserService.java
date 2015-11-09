package service;


import entity.UserEntity;
import org.apache.log4j.Logger;
import user.UserDao;

/**
 * Created by Tetiana_Matiunina on 09.11.2015.
 */
public class UserService {

    private UserDao userDao;
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(UserEntity user) {
        userDao.add(user);
    }


    public boolean isLoginRegistered(String login) {
        for (UserEntity user : userDao.getUserEntities()) {

            LOGGER.debug("Users "+user.getLoginName()+"  "+login);
            if (user.getLoginName().equals(login)) {
                return true;
            }
        }
        return false;
    }


    public boolean isUserExist(String login, String password) {
        for (UserEntity user : userDao.getUserEntities()) {
            if (user.getLoginName().equals(login) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    public UserEntity getUser(String login) {
        for (UserEntity user : userDao.getUserEntities()) {
            if (user.getLoginName().equals(login))
                return user;
        }
        return null;
    }
}
