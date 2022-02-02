package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Feb 1, 2022
 */
@Entity
@Table(name="pets")
public class Pet {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="Type")
	private String type;
	@Column(name="Name")
	private String name;
	@Column(name="diet")
	private String diet;
	
	public Pet(){
		super();
	}
	
	public Pet(String type, String name, String diet) {
		super();
		this.type = type;
		this.name = name;
		this.diet = diet;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the diet
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * @param diet the diet to set
	 */
	public void setDiet(String diet) {
		this.diet = diet;
	}
	
	public String returnPetDetails() {
		return "ID: " + this.id + "\nType: " + this.type + "\nName: " + this.name + "\nDiet: " + this.diet;
	}
	
}
