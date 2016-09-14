package com.neu.project.controller;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.project.dao.PropertyDAO;
import com.neu.project.dao.SellerDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;



@Controller
@RequestMapping("/addproperty.htm")
public class AddPropertyFormController 
{
	@Autowired
	@Qualifier("propertyValidator")
	ValidatorProperty propertyValidator;
	
	@Autowired
	ServletContext context;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(propertyValidator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("property") Property property, BindingResult result, HttpServletRequest request, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			return "ErrorPage";
		}
		
		propertyValidator.validate(property, result);
		if(result.hasErrors())
		{
			return "addPropertyForm";
		}
		try
		{
		String username = property.getPostedBy();
		String street = property.getStreet();
		String city = property.getCity();
		String state = property.getState();
		String zip = property.getZip();
		int bhk = property.getBhk();
		int rent = property.getRent();
		int price = property.getPrice();
		String desc = property.getDescription();
		Date postdate = new Date();
		String city_name = property.getCity_name();
		
//-----------------------------------------------------------------		
//		   Property prop;
//		   File file;
//	       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
//	       String path = null;
//	       if(check.equalsIgnoreCase("\\")) {
//	        path = context.getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
//	    }
//	    
//	        if(check.equalsIgnoreCase("/")) {
//	       path = context.getRealPath("").replace("build/","");
//	       path += "/"; //Adding trailing slash for Mac systems.
//
//	    }
//	        
//	        if(prop.getPhoto() != null)
//	        {
//	        	String filenameWithExt = System.currentTimeMillis() + prop.getPhoto().getOriginalFilename();
//	        	file = new File(path+filenameWithExt);
//	        	String con = context.getContextPath();
//	        	
//	        	prop.getPhoto().transferTo(file);
//	        	prop.setPhotoName(con + "/" + filenameWithExt);
//	        	
//	        }
	        
//-------------------------------------------------------------------------------	        
		
		
			UserDAO users = new UserDAO();
			SellerDAO sellers = new SellerDAO();
			PropertyDAO properties = new PropertyDAO();
				
			User user = users.get(username);
			
			Seller seller = sellers.get(city_name);
			
			Property prop = properties.create(street, city, state, zip, bhk, rent, price, desc, postdate, user, seller.getId(), seller.getCity());
			
			seller.addProperty(prop);
			sellers.save(seller);
			
		}
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            session.invalidate();
            return "ErrorPage";
            
        }
		return "addedProperty";
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("property")Property property, BindingResult result) { 
   
        return "addPropertyForm"; 
    }
}
