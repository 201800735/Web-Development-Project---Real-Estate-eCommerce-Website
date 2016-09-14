package com.neu.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.project.dao.PropertyDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/propertyDetails.htm")
public class PropertyDetailsController 
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
			Property property = null;
			PropertyDAO propDao = new PropertyDAO();
			property = propDao.searchById(Integer.parseInt(request.getParameter("id")));
			ModelAndView mv = new ModelAndView("propertyDetails", "details" , property);
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
