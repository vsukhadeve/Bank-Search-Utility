package com.tch.banksearchutil.model;

import java.util.Objects;

public class Bank {



	private String id;
	private String name;
	private String type;
	private String city;
	private String state;
	private String zipcode;

	public Bank(String id, String name, String type, String city, String state, String zipcode) {

		this.id = id;
		this.name = name;
		this.type = type;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", type=" + type + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}

	 @Override
	    public int hashCode() {
	        return Objects.hash(id,name, type, city,state,zipcode);
	    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) &&
                Objects.equals(name, bank.name) &&
                Objects.equals(type, bank.type) &&
                Objects.equals(city, bank.city) &&
                Objects.equals(state, bank.state) &&
                Objects.equals(zipcode, bank.zipcode);
    }
              
    

}
