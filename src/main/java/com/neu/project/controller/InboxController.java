package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.neu.project.dao.MessageDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/sellerInbox.htm")
public class InboxController 
{
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null )
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		
		try
		{
		String usrname = loggedUser.getName();
		List list = null;
		
			MessageDAO msgDao = new MessageDAO();
			UserDAO userDao = new UserDAO();
			//User u = userDao.get(loggedUser.getName());
			list = msgDao.listMessages(usrname);
			ModelAndView mv = new ModelAndView("userInbox", "messageList", list);
			return mv;
		}
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
        }
		
		
	}
}
