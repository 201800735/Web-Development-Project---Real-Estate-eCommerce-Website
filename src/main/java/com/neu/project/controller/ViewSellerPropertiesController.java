package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.PropertyDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/sellerProperties.htm")
public class ViewSellerPropertiesController 
{
	//private static final String NON_ALPHA = "([0-9]+)";
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		try
		{
		int page = 1;
		int recordsPerPage = 5;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		User user = (User) session.getAttribute("loggedUser");
		List list = null;
		
			PropertyDAO propDao = new PropertyDAO();
			list = propDao.searchByUser(page, user);
			request.setAttribute("noOfPages", 5);
			request.setAttribute("currentPage", page);
			ModelAndView mv = new ModelAndView("sellerProperties", "properties", list);
			return mv;
		}
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            session.invalidate();
            ModelAndView mv = new ModelAndView("ErrorPage");
            return mv;
        }
	
		
		
	}
}
