package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class OrderMapper
{

    public static ArrayList oldOrders(User user) throws LoginSampleException
    {
        ArrayList arr = new ArrayList<>();
        try {
            if (user.getRole().equalsIgnoreCase("employee")) {
                Connection con = Connector.connection();
                String SQL = "select * from orders";
                PreparedStatement ps = con.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    arr.add(rs.getInt("id"));
                    arr.add(rs.getInt("length"));
                    arr.add(rs.getInt("width"));
                    arr.add(rs.getInt("height"));
                    arr.add(rs.getInt("userid"));
                    arr.add(rs.getString("sent"));
                }
            }
            else {
                Connection con = Connector.connection();
                String SQL = "select * from orders where userid = ?";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1, user.getId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    arr.add(rs.getInt("id"));
                    arr.add(rs.getInt("length"));
                    arr.add(rs.getInt("width"));
                    arr.add(rs.getInt("height"));
                    arr.add(rs.getInt("userid"));
                    arr.add(rs.getString("sent"));
                }
            }
            return arr;
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void newOrder(int length, int width, int height, int userid) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "insert into orders (length, width, height, userid, sent) values (?,?,?,?,'No')";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, length);
            ps.setInt(2, width);
            ps.setInt(3, height);
            ps.setInt(4, userid);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            Order neworder = new Order(id, length, width, height, userid, "No");
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void sendOrderYes(int id) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "update orders set sent = 'Yes' where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static void sendOrderNo(int id) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "update orders set sent = 'No' where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
