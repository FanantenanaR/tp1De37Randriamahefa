/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1de37randriamahefa.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tp1de37randriamahefa.entity.Customer;

/**
 * CustomerManager class handles operations related to Customer entity.
 * This class provides methods to persist, retrieve, and update Customer objects.
 * 
 * @author Fanantenana
 * 
 */
@RequestScoped
public class CustomerManager {
    
    /**
     * Entity manager for handling persistence operations.
     */
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Persists a new customer object into the database.
     * 
     * @param customer the Customer object to be persisted
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    /**
     * Retrieves all customers from the database using Customer.findAll.
     * 
     * @return a list of Customer objects representing all customers in the database
     */
    public List<Customer> getAllCustomers() {  
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();  
    }  

    
    /**
     * Updates an existing customer object in the database.
     * 
     * @param customer the Customer object to be updated
     * @return the updated Customer object
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
}
