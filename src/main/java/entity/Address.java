package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	private String city;
	private String zipcode;
	
	public Address() {}
	public Address(String street, String city, String zipcode) {
		this();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}	
	
}







