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
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Owner taylor = new Owner("Taylor");

		Pet scar = new Pet("Cat", "Scar", "Salmon");
		Pet ghost = new Pet("Dog", "Ghost", "Dry Food");

		List<Pet> taylorsPets = new ArrayList<Pet>();
		taylorsPets.add(scar);
		taylorsPets.add(ghost);

		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails taylorsList = new ListDetails("Taylor's List", taylor);
		taylorsList.setListOfPets(taylorsPets);

		ldh.insertNewListDetails(taylorsList);

		List<ListDetails> allLists = ldh.getLists();

		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
}