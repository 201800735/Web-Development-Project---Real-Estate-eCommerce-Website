//package com.neu.project.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import java.util.Iterator;
//
//import com.neu.project.dao.SellerDAO;
//import com.neu.project.exception.AdException;
//import com.neu.project.pojo.Property;
//import com.neu.project.pojo.Seller;
//import com.neu.project.pojo.User;
//
//
//@Controller
//@RequestMapping("/listproperties")
//public class ListPropertiesController 
//{
//	@RequestMapping(method=RequestMethod.GET)
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
//	{
//		User loggedUser = (User) session.getAttribute("loggedUser");
//		if(loggedUser == null)
//		{
//			ModelAndView mv = new ModelAndView("ErrorPage");
//			return mv;
//		}
//		
//		int page = 1;
//		int recordsPerPage = 5;
//		if(request.getParameter("page") != null)
//			page = Integer.parseInt(request.getParameter("page"));
//		
//		SellerDAO cities = null;
//		List cityList = null;
//		List propertyList = new ArrayList();
//		
//		try
//		{
//			cities = new SellerDAO();
//			cityList = cities.list();
//			
//			Iterator cityIterator = cityList.iterator();
//			
//			while(cityIterator.hasNext())
//			{
//				Seller city = (Seller) cityIterator.next();
//				
//				Iterator propertyIterator = city.getProperties().iterator();
//				
//				while(propertyIterator.hasNext())
//				{
//					Property property = (Property) propertyIterator.next();
//					propertyList.add(property);
//				}
//			}
//		}
//		catch (AdException e) {
//            System.out.println(e.getMessage());
//        }
//		
//		ModelAndView mv = new ModelAndView("viewProperties", "properties", propertyList);
//        return mv;
//		
//	}
//}
