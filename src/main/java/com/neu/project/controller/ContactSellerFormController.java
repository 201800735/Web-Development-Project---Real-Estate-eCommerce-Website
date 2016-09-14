package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.pojo.User;

@Controller
@RequestMapping("/ContactSeller.htm")
public class ContactSellerFormController 
{
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		
		try
		{
		String sellerEmail = request.getParameter("email").toString();
		System.out.println(sellerEmail);
		User user = (User) session.getAttribute("loggedUser");
		System.out.println(user.getName());
		System.out.println("Contact Controller");
		
		ModelAndView mv = new ModelAndView("ContactSeller", "email", sellerEmail);
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
