package com.neu.project.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.MessageDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.pojo.Messages;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/sendMessage.htm")
public class SendMessageController 
{
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		try
		{
		UserDAO userDao = new UserDAO();
		MessageDAO msgDAO = new MessageDAO();
		
		//User loggedUser = (User) session.getAttribute("loggedUser");
		User userSender = userDao.get(loggedUser.getName());
		System.out.println(request.getParameter("to"));
		User userReceiver = userDao.byEmail(request.getParameter("to"));
		String subject = request.getParameter("subject");
		String msg = request.getParameter("message");
		Date date = new Date();
		
		
		Messages messg = msgDAO.createMessage(userReceiver.getName(), userSender.getName(), subject, msg,date, userSender, userSender.getPersonID());
		userReceiver.addMessage(messg);
		userDao.save(userReceiver);
		
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("message"));
		ModelAndView mv = new ModelAndView("msgSent", "sentTo", userReceiver);
		return mv;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
            session.invalidate();
            ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
	}
}
