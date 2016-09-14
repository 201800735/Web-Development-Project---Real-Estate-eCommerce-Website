package com.neu.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.SellerDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/addcity.htm")
public class AddCityFormController 
{
	@Autowired
	@Qualifier("sellerValidator")
	ValidatorSeller sellerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(sellerValidator);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("city") Seller seller, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			return "ErrorPage";
			
		}
		sellerValidator.validate(seller, result);
		if(result.hasErrors())
		{
			return "addCityForm2";
		}
		

		
		
		try
		{
			SellerDAO sellerDAO = new SellerDAO();
			if(sellerDAO.get(seller.getCity()) == null)
			{
				sellerDAO.create(seller.getCity());
				List list = sellerDAO.list();
			}
			else
			{
//			       out.println("<script type=\"text/javascript\">");
//			       out.println("alert('City Already Exists');");
//			       out.println("</script>");
//			       //response.sendRedirect("index.jsp");    
			}
				
		}
		catch (Exception e)
        {
			System.out.println(e.getMessage());
            session.invalidate();
            return "ErrorPage";
        }
        return "addedCity";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("city")Seller seller, BindingResult result) { 
   
		
        return "addCityForm2"; 
    }
}
