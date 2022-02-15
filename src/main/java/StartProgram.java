import java.util.List;
import java.util.Scanner;
import controller.PetHelper;
import model.Pet;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Feb 1, 2022
 */
public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static PetHelper ph = new PetHelper();

		private static void addAPet() {
			// TODO Auto-generated method stub
			System.out.print("Enter the pet's type: ");
			String type = in.nextLine();
			System.out.print("Enter the pet's name: ");
			String name = in.nextLine();
			System.out.print("Enter the pet's diet: ");
			String diet = in.nextLine();
			Pet toAdd = new Pet(type, name, diet);
			ph.insertPet(toAdd);
		}

		private static void deleteAPet() {
			// TODO Auto-generated method stub
			System.out.println("Enter the pet's ID to delete: ");
			int id = in.nextInt();
			System.out.println("Enter the pet's name to delete: ");
			String name = in.next();
			Pet toDelete = new Pet(id, name);
			ph.deletePet(toDelete);
		}

		private static void editAPet() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Type");
			System.out.println("2 : Search by Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Pet> foundPets;
			if (searchBy == 1) {
				System.out.print("Enter the pet's type: ");
				String type = in.nextLine();
				foundPets = ph.searchForPetByType(type);
			} else {
				System.out.print("Enter the pet's name: ");
				String name = in.nextLine();
				foundPets = ph.searchForPetByName(name);

			}

			if (!foundPets.isEmpty()) {
				System.out.println("Found Results.");
				for (Pet l : foundPets) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Pet toEdit = ph.searchForPetById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " as a " + toEdit.getType());
				System.out.println("1 : Update Type");
				System.out.println("2 : Update Name");
				System.out.println("3 : Update Diet");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 2) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 3) {
					System.out.print("New Diet: ");
					String newDiet = in.nextLine();
					toEdit.setDiet(newDiet);
				}

				ph.updatePet(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our list for pets! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAPet();
				} else if (selection == 2) {
					editAPet();
				} else if (selection == 3) {
					deleteAPet();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ph.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<Pet> allPets = ph.showAllPets();
			for(Pet singlePet : allPets) {
				System.out.println(singlePet.returnPetDetails());
			}

		}

	}

