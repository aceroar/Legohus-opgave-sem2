package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static ArrayList oldOrders( User user ) throws LoginSampleException {
        return OrderMapper.oldOrders(user);
    }
    
    public static void newOrder(int length, int width, int height, int userid) throws LoginSampleException {
        OrderMapper.newOrder(length, width, height, userid);
    }
    
    public static void sendOrderYes(int id) throws LoginSampleException {
        OrderMapper.sendOrderYes(id);
    }
    
    public static void sendOrderNo(int id) throws LoginSampleException {
        OrderMapper.sendOrderNo(id);
    }

}
