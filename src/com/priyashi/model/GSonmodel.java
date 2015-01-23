package com.priyashi.model;

import com.google.gson.annotations.SerializedName;


public class GSonmodel {
	@SerializedName("name")
	private String  name="";
	
	@SerializedName("email")
	private String email="";
	
	@SerializedName("phone")
	private Phone phone;
	
	class Phone {
		public String home="";
		public String mobile="";
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "HOME :  "+home+"    Mobile :  "+mobile;
		}
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 return "NAME  :  "+name+"    Email :  "+email + "   Phone data :  "+phone.toString() ;
	}

}
