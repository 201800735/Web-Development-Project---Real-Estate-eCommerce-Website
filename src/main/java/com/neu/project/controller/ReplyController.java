package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.UserDAO;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/reply.htm")
public class ReplyController 
{
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		try
		{
		User logUser = (User) session.getAttribute("loggedUser");
		if(logUser == null)
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		
		UserDAO userDao = new UserDAO();
		User userReceiver = userDao.get(request.getParameter("replyTo"));
		User loggedUser = (User) session.getAttribute("loggedUser");
		ModelAndView mv = new ModelAndView("replyForm","userReceiver", userReceiver);
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
