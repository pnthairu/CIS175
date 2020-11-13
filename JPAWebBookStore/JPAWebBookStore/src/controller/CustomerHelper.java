package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

public class CustomerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookStore");
	
	public void insertCustomer(Customer c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public List<Customer> showAllCustomer() {
			EntityManager em = emfactory.createEntityManager();
			List<Customer> allCustomer = em.createQuery("SELECT c FROM Customer c").getResultList();
			return allCustomer;
	}
	
	public Customer findCustomer(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select sh from Customer sh where sh.customerName = :selectedName", Customer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Customer foundCustomer;
		try {
			foundCustomer = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCustomer = new Customer(nameToLookUp);
		}
		em.close();

		return foundCustomer;
	}

}
