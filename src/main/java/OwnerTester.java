import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Owner;
import model.Pet;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Feb 21, 2022
 */
public class OwnerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner taylor = new Owner("Taylor");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Pet dune = new Pet("Cat", "Dune", "Fish");
		Pet mamba = new Pet("Dog", "Mamba", "Beef");
		
		List<Pet> taylorsPets = new ArrayList<Pet>();
		
		taylorsPets.add(dune);
		taylorsPets.add(mamba);
		
		ListDetails taylorsList = new ListDetails("Taylor's List", taylor);
		taylorsList.setListOfPets(taylorsPets);
		
		ldh.insertNewListDetails(taylorsList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}

	}

}
