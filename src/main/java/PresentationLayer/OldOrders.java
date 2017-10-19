/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruger
 */
public class OldOrders extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {       
        User user = (User) request.getSession().getAttribute("user");        
        ArrayList oldorders = LogicFacade.oldOrders(user);
        HttpSession session = request.getSession();
        session.setAttribute("oldorders", oldorders);
        return "oldorderspage";
    }

}
