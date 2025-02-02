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
import java.util.stream.Collectors;
import mg.itu.tp1de37randriamahefa.entity.Customer;
import mg.itu.tp1de37randriamahefa.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList.
 * @author USER 
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    private List<Customer> customerList;
    private List<String> stateList;
    
    @Inject  
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
    /** 
        * Retourne la liste des clients pour affichage dans une DataTable.
   */  
    public List<Customer> getCustomers() {
        if (customerList == null) {
          customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }
    
    /**
     * Obtenir une liste d'Etat depuis notre customers list.
     * 
     * @return a list of unique state values
     */
    public List<String> getStateList() {
        if (customerList == null){
            customerList = getCustomers();
        }
        if (stateList == null) {
            stateList = customerList.stream()
                .map(Customer::getState)
                .distinct() 
                .collect(Collectors.toList()); 
        }
        return stateList;
    }
    
}
