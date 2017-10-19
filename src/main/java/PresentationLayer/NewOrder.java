/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruger
 */
public class NewOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        if (request.getParameter("complete").equals("no")) {
            String s = "no";
            HttpSession session = request.getSession();
            session.setAttribute("success", s);
            return "neworderpage";
        }
        String s = "yes";
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        LogicFacade.newOrder(length, width, height, userid);
        HttpSession session = request.getSession();
        session.setAttribute("success", s);
        return "neworderpage";
    }

}
