package com.neu.project.controller;


import java.util.ArrayList;
import java.util.List;

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

import com.neu.project.dao.PropertyDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.User;


@Controller
@RequestMapping("/searchproperty.htm")
public class SearchPropertyFormController 
{
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
		}
		List propertyList = new ArrayList();
		try
		{
			int ll = Integer.parseInt(request.getParameter("rentRange"));
			String searchElement = request.getParameter("searchElement");
			int bhk = Integer.parseInt(request.getParameter("bhk"));
			
			request.setAttribute("rentRange", ll);
			request.setAttribute("searchElement", searchElement);
			request.setAttribute("bhk", bhk);
			
			System.out.println(ll + searchElement + bhk);
			PropertyDAO propertyDao = new PropertyDAO();
			if(request.getParameter("searchBy").equals("city"))
				propertyList = propertyDao.searchByRangenCity(ll, searchElement, bhk);
			else
			{
				propertyList = propertyDao.searchByRangenZip(ll, searchElement, bhk);
			}
			ModelAndView mv = new ModelAndView("searchedProperties", "searchedProperties", propertyList);
			return mv;
		}
		catch (AdException e) 
		{
            System.out.println(e.getMessage());
            session.invalidate();
            ModelAndView mv = new ModelAndView("ErrorPage");
			return mv;
        }
		
		
	}
}
