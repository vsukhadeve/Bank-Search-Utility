package com.tch.banksearchutil.model;

import java.util.Objects;

public class Person {
	    private String name;
	    private String surname;
	    private String address;

	    public Person(String name, String surname, String address) {
	        this.name = name;
	        this.surname = surname;
	        this.address = address;
	    }

	    @Override
	    public String toString() {
	        return "Person{" +
	                "name='" + name + '\'' +
	                ", surname='" + surname + '\'' +
	                ", address='" + address + '\'' +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Person person = (Person) o;
	        return Objects.equals(name, person.name) &&
	                Objects.equals(surname, person.surname) &&
	                Objects.equals(address, person.address);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name, surname, address);
	    }
}
