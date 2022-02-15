package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Feb 1, 2022
 */
public class PetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetList");

	public void insertPet(Pet p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public List<Pet> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allPets = em.createQuery("SELECT i FROM Pet i").getResultList();
		return allPets;
	}

	public void deletePet(Pet toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select li from Pet li where li.id = :selectedId and li.name = :selectedName", Pet.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		//typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setMaxResults(1);
		Pet result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	public Pet searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found = em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}

	public void updatePet(Pet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Pet> searchForPetByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select li from Pet li where li.name =	:selectedName",Pet.class);
		typedQuery.setParameter("selectedName", name);
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public List<Pet> searchForPetByType(String type) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select li from Pet li where li.type = :selectedType",Pet.class);
		typedQuery.setParameter("selectedType", type);
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
