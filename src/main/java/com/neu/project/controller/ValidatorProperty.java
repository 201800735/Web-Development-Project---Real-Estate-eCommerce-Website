package com.neu.project.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Property;



@Component
public class ValidatorProperty implements Validator {

	
	private static final String NON_NUMERIC = "([A-Za-z]+)";
	private static final String NON_ALPHA = "([0-9]+)";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Property.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Property property = (Property) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.property", "Street Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.property", "City Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.property", "State Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.property", "ZIP Code Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rent", "error.invalid.property", "Rent Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.property", "Property Price Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.property", "Description Required");
    
    
        Pattern patternNonNumeric = Pattern.compile(NON_NUMERIC);
        Pattern patternNonAlpha = Pattern.compile(NON_ALPHA);
        
        Matcher matcherCT = patternNonNumeric.matcher(property.getCity());
        Matcher matcherST = patternNonNumeric.matcher(property.getState());
        Matcher matcherZIP = patternNonAlpha.matcher(property.getZip());
        
        if(!matcherCT.matches())
        {
        	errors.rejectValue("city", "Test", "Alphabets only!");
        }
        if(!matcherST.matches())
        {
        	errors.rejectValue("state", "Test", "Alphabets only!");
        }
        if(!matcherZIP.matches())
        {
        	errors.rejectValue("zip", "Test", "Numbers only!");
        }
    }
    
   
}
