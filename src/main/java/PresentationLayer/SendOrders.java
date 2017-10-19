/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruger
 */
public class SendOrders extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        
        User user = (User) request.getSession().getAttribute("user");
        ArrayList oldorders = LogicFacade.oldOrders(user);
        HttpSession session = request.getSession();
        session.setAttribute("oldorders", oldorders);
        String s;
        if (request.getParameter("complete").equals("no")) {
            s = "no";
            session = request.getSession();
            session.setAttribute("success", s);
            return "sendorderspage";
        }
        int id = Integer.parseInt(request.getParameter("orderid"));
        if (request.getParameter("sent").equals("Yes")) {
            LogicFacade.sendOrderYes(id);
        }
        else if (request.getParameter("sent").equals("No")) {
            LogicFacade.sendOrderNo(id);
        }
        s = "Yes";
        session.setAttribute("success", s);
        return "sendorderspage";
    }

}
