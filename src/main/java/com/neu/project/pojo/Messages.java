package com.neu.project.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messagestable")
public class Messages 
{
	@Id @GeneratedValue
	@Column(name="messageid")
	private int id;
	
	@Column(name="receiverName")
    private String receiverName;
	
	@Column(name="fromName")
    private String fromName;
	
	@Column(name="subject")
    private String subject;
	
	@Column(name="messageData")
    private String messageData;
	
	@Column(name="date")
	private Date date;
	
	@JoinColumn(name="personID")
	private long personID;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="user")
	private User user;
	
	public Messages(String receiverName, String fromName, String subject, String messageData, Date date, User user, long personID)
	{
		this.receiverName = receiverName;
		this.fromName = fromName;
		this.subject = subject;
		this.messageData = messageData;
		this.date = date;
		this.personID = personID;
		this.user = user;
	}
	
	public Messages()
	{
		
	}
    
    public int getMessageID() {
		return id;
	}
	public void setMessageID(int id) {
		this.id = id;
	}
	public String getUsrName() {
		return receiverName;
	}
	public void setUsrName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageData() {
		return messageData;
	}
	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
    
    
    
}
