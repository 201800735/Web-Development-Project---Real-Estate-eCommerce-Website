package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID") //making personID as a primary key to this table
public class User extends Person{
	
	@Column(name="name")
    private String name;
	
	@Column(name="password")
    private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="personID")
	private Set<Messages> messages = new HashSet<Messages>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.messages = new HashSet<Messages>();
    }

    User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Set<Messages> getMessages() {
		return messages;
	}

	public void setMessages(Set<Messages> messages) {
		this.messages = messages;
	}

    public void addMessage(Messages message)
    {
    	getMessages().add(message);
    }
}
