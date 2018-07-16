package net.abdelmalek.benali.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="test")

public class UserBO {
	@Id
	@Column(name="client_id")
	String id ;
	
	@Column(name="client_firstname")
	String firstName ; 
	
	@Column(name="client_lastname")
	String lastName ;
	
	@Column(name="client_city")
	String city; 
	
	@Column(name="client_adress")
	String adress ;
	
	@Column(name="client_zipcode")
	String zipCode ;
	
	@Column(name="client_birthdate")
	Date birthDate ; 
	
	@Column(name="client_mail")
	String mail ;
	

}
