package com.neu.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Iterator;

import com.neu.project.dao.PropertyDAO;
import com.neu.project.dao.SellerDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;


@Controller
@RequestMapping("/listproperties")
public class ListPropertiesController2 
{
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, HttpSession session)
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
		
		SellerDAO cities = null;
		List cityList = null;
		List propertyList = new ArrayList();
		
		PropertyDAO propDao = new PropertyDAO();
		propertyList = propDao.listAllProperties(page);
		request.setAttribute("noOfPages", 5);
		request.setAttribute("currentPage", page);
		
		ModelAndView mv = new ModelAndView("viewProperties", "properties", propertyList);
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
