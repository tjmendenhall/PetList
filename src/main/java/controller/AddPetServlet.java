package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("species");
		String name = request.getParameter("name");
		String diet = request.getParameter("diet");
		
		if (type.isEmpty() || name.isEmpty() || diet.isEmpty() || type == null || name == null || diet == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Pet p = new Pet(type, name, diet);
			PetHelper dao = new PetHelper();
			dao.insertPet(p);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
