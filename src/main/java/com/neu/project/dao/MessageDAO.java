package com.neu.project.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.HibernateException;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Messages;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.User;

public class MessageDAO extends DAO
{
	public Messages createMessage(String receiverUname, String senderUname, String subject, String message, Date date, User sender, long senderID) throws AdException
	{
		try
		{
			begin();
			Messages msg = new Messages(receiverUname, senderUname, subject, message, date, sender, senderID);
			getSession().save(msg);
			commit();
			return msg;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while sending message: " + e.getMessage());
		}
	}
	
	public List listMessages(String username) throws AdException
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Messages where receiverName = :username");
			q.setString("username", username);
			List list = q.list();
			return list;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while reading User" + username + "Messages" + e.getMessage());
		}
	}
}
