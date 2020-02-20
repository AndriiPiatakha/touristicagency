package com.itbulls.learnit.pojos;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String username;
	private char[] password;
	private String mail;
	private Date birthday;
	private int role;
	private List<Order> orders;

	public User(int id, String username, char[] password, String mail, Date birthday, int role, List<Order> orders) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.birthday = birthday;
		this.role = role;
		this.orders = orders;
	}

	public User(int id, String username, char[] password, String mail, Date birthday, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.birthday = birthday;
		this.role = role;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
