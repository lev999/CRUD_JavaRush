package com.lev.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column(columnDefinition ="BOOLEAN")
	private boolean isAdmin;
	@Column(columnDefinition ="TIMESTAMP")
	private Date date;

	public boolean getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

	public User(int id, String name, int age, boolean isAdmin,
			Date date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
		this.date = date;
	}

	public User(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
