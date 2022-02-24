package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Owner;
import model.Pet;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetHelper lih = new PetHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String ownerName = request.getParameter("ownerName");

		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		List<Pet> selectedPetsInList = new ArrayList<Pet>();

		if (selectedPets != null && selectedPets.length > 0) {
			for (int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				Pet c = lih.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(c);
			}
		}
		Owner owner = new Owner(ownerName);
		ListDetails sld = new ListDetails(listName, owner);

		sld.setListOfPets(selectedPetsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
