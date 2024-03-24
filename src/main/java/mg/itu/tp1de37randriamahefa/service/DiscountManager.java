/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1de37randriamahefa.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tp1de37randriamahefa.entity.Discount;

/**
 *
 * @author USER
 */
@RequestScoped
public class DiscountManager {
    /**
     * Entity manager for handling persistence operations.
     */
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }
    
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
