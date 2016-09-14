package com.neu.project.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.json.simple.JSONObject;
import com.neu.project.dao.UserDAO;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/checkusername.htm")

public class UsernameCheckController
{
	public UsernameCheckController()
	{
		
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{
		System.out.println("Checking Username Availability!");
		String username = request.getParameter("name");
		UserDAO userDao = new UserDAO();
		User u = userDao.get(username);
		
		System.out.println("JSON");
		JSONObject obj = new JSONObject();
		if(u != null)
		{
			obj.put("Message", "Username Already Exists!");
		}
		else
		{
			obj.put("Message", "Username Available!");
			
		}
		PrintWriter out = response.getWriter();
		System.out.println("Printwriter");
		out.println(obj);
		return null;
	}
}
