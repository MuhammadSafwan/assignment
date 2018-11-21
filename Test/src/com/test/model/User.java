/**
 * 
 */
package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Safwan
 *
 */
@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age_id")
	private int age_id;
	
	@Column(name = "occupation_id")
	private int occupation_id;
	
	@Column(name = "zipcode")
	private String zipcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge_id() {
		return age_id;
	}

	public void setAge_id(int age_id) {
		this.age_id = age_id;
	}

	public int getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(int occupation_id) {
		this.occupation_id = occupation_id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
	

}
