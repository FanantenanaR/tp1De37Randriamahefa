/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tp1de37randriamahefa.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.tp1de37randriamahefa.entity.Customer;
import mg.itu.tp1de37randriamahefa.entity.Discount;
import mg.itu.tp1de37randriamahefa.service.CustomerManager;
import mg.itu.tp1de37randriamahefa.service.DiscountManager;

/**
 *
 * @author USER
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;
    private List<Discount> discounts;

    @Inject
    private CustomerManager customerManager;
    
    @Inject
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        System.out.println("updating");
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    /**
     * Retourne la liste de tous les Discount.
     * @return 
     */
    public List<Discount> getDiscounts() {
        if (discounts == null) {
            discounts = discountManager.getAllDiscounts();
        }
        return discounts;
    }
}
