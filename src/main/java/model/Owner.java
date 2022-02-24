package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Feb 21, 2022
 */
@Entity
@Table(name = "owner")
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String ownerName;

	public Owner() {
		super();
// TODO Auto-generated constructor stub
	}

	public Owner(int id, String name) {
		super();
		this.id = id;
		this.ownerName = name;
	}

	public Owner(String name) {
		super();
		this.ownerName = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String name) {
		this.ownerName = name;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerName=" + ownerName + "]";
	}
}
