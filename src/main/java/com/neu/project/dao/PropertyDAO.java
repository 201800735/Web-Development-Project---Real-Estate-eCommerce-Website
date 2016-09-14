package com.neu.project.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.User;


public class PropertyDAO extends DAO
{
	public Property create(String street, String city, String state, String zip, int bhk, int rent, int price, String desc, Date postdate, User user, long seller_id, String cityname)
	throws AdException
	{
		try
		{
			begin();
			Property property = new Property(street, city, state, zip, bhk, rent, price, desc, postdate, user, seller_id, cityname);
			getSession().save(property);
			commit();
			return property;
		}catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while creating property: " + e.getMessage());
		}
	}
	
	public Property searchById(int id) throws AdException
	 {
		 try
		 {
			 begin();
			 Query q = getSession().createQuery("from Property where propertyID= :id");
			 q.setInteger("id", id);
			 Property property = (Property) q.uniqueResult();
			 return property;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No property found with id " + id + " " +e.getMessage());
		 }
	 }
	
	public List searchByUser(long personID) throws AdException
	 {
		 try
		 {
			 begin();
			 Query q = getSession().createQuery("from Property where user = :personID");
			 q.setLong("personID", personID);
			 List list = q.list();
			 return list;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No property found with user " + personID + " " +e.getMessage());
		 }
	 }
	
	public List searchByUser(int page, User user) throws AdException
	 {
		 try
		 {
			 begin();
			 Criteria crit = getSession().createCriteria(Property.class);
			 crit.add(Restrictions.eq("user", user));
			 crit.setFirstResult(page);
			 crit.setMaxResults(3);
			 List<Property> results = crit.list();
			 return results;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No properties found " +e.getMessage());
		 }
	 }
	
	
	public List listAllProperties(int page) throws AdException
	 {
		 try
		 {
			 begin();
			 Criteria crit = getSession().createCriteria(Property.class);
			 crit.setFirstResult(page);
			 crit.setMaxResults(3);
			 List<Property> results = crit.list();
			 return results;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No properties found " +e.getMessage());
		 }
	 }
	
	public List searchByRangenCity(int lt, String city, int bhk) throws AdException
	{
		List<Property> results;
		try
		{
			begin();
			Criteria crit = getSession().createCriteria(Property.class);
			crit.add(Restrictions.lt("rent", lt));
			crit.add(Restrictions.eq("city", city));
			crit.add(Restrictions.eq("bhk", bhk));
			results = crit.list();
		}
		catch(HibernateException e)
		{
			 rollback();
			 throw new AdException("No property found in Range. " + lt + " " +e.getMessage());
		}
		return results;
		
	}
	
	public List searchByRangenZip(int lt, String zip, int bhk) throws AdException
	{
		List<Property> results;
		try
		{
			begin();
			Criteria crit = getSession().createCriteria(Property.class);
			crit.add(Restrictions.lt("rent", lt));
			crit.add(Restrictions.eq("zip", zip));
			crit.add(Restrictions.eq("bhk", bhk));
			results = crit.list();
		}
		catch(HibernateException e)
		{
			 rollback();
			 throw new AdException("No property found in Range. " + lt + " " +e.getMessage());
		}
		return results;
		
	}
	
	
	
	public void delete(Property property)
            throws AdException {
        try {
            begin();
            getSession().delete(property);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete property", e);
        }
    }
}
