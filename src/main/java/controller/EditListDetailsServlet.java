package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		PetHelper lih = new PetHelper();
		OwnerHelper sh = new OwnerHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);

		String newListName = request.getParameter("listName");
		String ownerName = request.getParameter("ownerName");
		
		//find our add the new shopper
		Owner newOwner = sh.findOwner(ownerName);

		try {
			//items are selected in list to add
			String[] selectedPets = request.getParameterValues("allPetsToAdd");
			List<Pet> selectedPetsInList = new ArrayList<Pet>();

			for (int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				Pet c = lih.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(c);

			}
			listToUpdate.setListOfPets(selectedPetsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Pet> selectedPetsInList = new ArrayList<Pet>();
			listToUpdate.setListOfPets(selectedPetsInList);
		}

		listToUpdate.setListName(newListName);
		listToUpdate.setOwner(newOwner);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
