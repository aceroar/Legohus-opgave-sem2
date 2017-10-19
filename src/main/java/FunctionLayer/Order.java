/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Bruger
 */
public class Order
{

    public Order(int id ,int length, int width, int height, int userid, String sent)
    {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.userid = userid;
        this.sent = sent;
    }

    private int id;
    private int length;
    private int width;
    private int height;
    private int userid;
    private String sent;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public String getSent()
    {
        return sent;
    }

    public void setSent(String sent)
    {
        this.sent = sent;
    }

    @Override
    public String toString()
    {
        return "<br />" + "Order id: " + id + ". Length: " + length + ". Width: " + width + ". Height: " + height + ". User id: " + userid + ". Sent: " + sent;
    }
}
