package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.pojo.User;

@Controller
@RequestMapping("/Logout.htm")
public class LogoutController 
{
	@RequestMapping(method = RequestMethod.POST)
	protected String doLogout(@ModelAttribute("user") User user, HttpSession session, BindingResult result, HttpServletRequest request) throws Exception
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			return "ErrorPage";
		}
		
		session.invalidate();
		request.getSession().invalidate();
		return "LoginForm";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, HttpSession session, BindingResult result, HttpServletRequest request)
	{
		session.invalidate();
		request.getSession().invalidate();
		return "LoginForm";
	}
}
