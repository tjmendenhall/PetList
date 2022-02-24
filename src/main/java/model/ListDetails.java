package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Feb 21, 2022
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Pet> listOfPets;

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, Owner owner, List<Pet> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, Owner owner, List<Pet> listOfPets) {
		super();
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, Owner owner) {
		super();
		this.listName = listName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Pet> getListOfPets() {
		return listOfPets;
	}

	public void setListOfPets(List<Pet> listOfPets) {
		this.listOfPets = listOfPets;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", owner=" + owner.getOwnerName() + ", listOfPets=" + listOfPets + "]";
	}

}