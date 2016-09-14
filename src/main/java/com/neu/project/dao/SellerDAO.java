package com.neu.project.dao;

import com.neu.project.exception.AdException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.pojo.Seller;



public class SellerDAO extends DAO
{
	public Seller get(String city) throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Seller where city= :city");
			q.setString("city", city);
			Seller seller = (Seller)q.uniqueResult();
			commit();
			return seller;
		}catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named city " + city + " " + e.getMessage());
        }
	}
	
	 public List list() throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Seller");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the cities", e);
	        }
	    }
	 
	
	 
	 public Seller create(String city) throws AdException {
	        try {
	            begin();
	            Seller cat = new Seller(city);
	            getSession().save(cat);
	            commit();
	            return null;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create the category", e);
	            throw new AdException("Exception while creating city: " + e.getMessage());
	        }
	    }
	 
	 public void save(Seller city) throws AdException {
	        try {
	            begin();
	            getSession().update(city);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not save the city", e);
	        }
	    }
	 
	 public void delete(Seller city) throws AdException {
	        try {
	            begin();
	            getSession().delete(city);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete the category", e);
	        }
	    }
}
