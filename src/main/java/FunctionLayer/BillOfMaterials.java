/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class BillOfMaterials
{

    public ArrayList BOM(Order order)
    {
        int type4x2;
        int type2x2;
        int type1x2;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= order.getHeight(); i++) {
            if (i % 2 == 1) {
                int a = order.getLength() % 4;
                type4x2 = (order.getLength() - a) / 4;
                int b = a % 2;
                type2x2 = (a - b) / 2;
                type1x2 = b;
                arr.add(type4x2);
                arr.add(type2x2);
                arr.add(type1x2);
                a = (order.getWidth() - 4) % 4;
                type4x2 = (order.getWidth() - 4 - a) / 4;
                b = a % 2;
                type2x2 = (a - b) / 2;
                type1x2 = b;
                arr.add(type4x2);
                arr.add(type2x2);
                arr.add(type1x2);
            }
            else {
                int a = order.getWidth() % 4;
                type4x2 = (order.getWidth() - a) / 4;
                int b = a % 2;
                type2x2 = (a - b) / 2;
                type1x2 = b;
                arr.add(type4x2);
                arr.add(type2x2);
                arr.add(type1x2);
                a = (order.getLength() - 4) % 4;
                type4x2 = (order.getLength() - 4 - a) / 4;
                b = a % 2;
                type2x2 = (a - b) / 2;
                type1x2 = b;
                arr.add(type4x2);
                arr.add(type2x2);
                arr.add(type1x2);
            }
            
        }
        return arr;
    }
    
    public String toString(Order order) {
        int t4 = 0;
        int t2 = 0;
        int t1 = 0;
        for (int i = 0; i < BOM(order).size(); i = i+3) {
           t4 += (int) BOM(order).get(i);
           t2 += (int) BOM(order).get(i+1);
           t1 += (int) BOM(order).get(i+2);
        }
        return "<br />" + "Type 4x2: " + t4 + " Type 2x2: " + t2 + " Type 1x2: " + t1;
    }
}
