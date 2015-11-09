package user;

import entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tetiana_Matiunina on 06.11.2015.
 */
public class UserDao {

    private List<UserEntity> userEntities;

    public UserDao(){
        userEntities = new ArrayList<>();
    }

    public void add(UserEntity user){
        userEntities.add(user);
    }

    public List<UserEntity> getUserEntities(){



        return userEntities;
    }

}
