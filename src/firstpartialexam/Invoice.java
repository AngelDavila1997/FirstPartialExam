/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpartialexam;

import java.util.ArrayList;
import java.util.ListIterator;
/**
 *
 * @author Alumno
 */
public class Invoice {
    //Declaracion de atributos
    private String id;
    private Customer customer;
    private double amount;
    private ArrayList<InvoiceItem> items;
    //Constructor
    public Invoice(String id, int customerID, String name, double discount) {
        customer = new Customer(customerID, name, discount);
        this.id = id;
        this.amount = 0;
        this.items = new ArrayList<>();
    }
    public Invoice(String id, Customer customer){
        this.customer = customer;
        this.id = id;
        this.amount = 0;
        this.items = new ArrayList<>();
    }
    //get y set
    public String getID(){//Obtiene el id proporcionado por el usuario
        return this.id;
    }
    public Customer getCustomer(){//Obtiene el cliente proporcionado por el usuario
        return this.customer;
    }
    public void setCustomer(Customer customer) {//Permite modificar el cliente
        this.customer = customer;
    }
    public double getAmount() {//Calcula el total de la factura sin el descuento
        return this.amount;
    }
    public double getAmountAfterDiscount(){//Obtiene el total despues del descuento
        double discount= this.amount * this.customer.getDiscount() / 100;
        return this.amount - discount;
    }
    private void recaulculateAmount(){//Recalcula el total de la factura despues de una modificacion
        this.amount = 0;
        
        for (InvoiceItem item : items) {
            this.amount += item.getTotal();
        }
    }
    public String getCustomerName(){//Obtiene el nombre del cliente
        return this.customer.getName();
    }
    //Metodos
    //Permite añadir InvoiceItem a el arreglo de items
    // This method adds an item to the items ArrayList.  It receives the item
    // data separately, so we create a new InvoiceItem instance to add to the
    // ArrayList.  The method returns a boolean stating if the addition was
    // successful or not.
    public boolean addItem(String id, String description, int quantity,
            double unitPrice) {
        
        // If the item is not already in the list, we add it
        if (!findItem(id)) {
            this.items.add(new InvoiceItem(id, description, quantity,
                    unitPrice));
            return true;
        } else {
            return false;
        }
    }
    
    // This method adds an item to the items ArrayList.  It receives an instance
    // of the InvoiceItem, so we need not to create a new instance.  The method
    // returns a boolean stating if the addition was successful or not.
    public boolean addItem(InvoiceItem item) {
        
        // If the item is not already in the list, we add it
        if (!findItem(item.getId())) {
            this.items.add(item);
            return true;
        } else {
            return false;
        }
    }
    
    // This method removes an item of the items ArrayList.  It receives the item
    // id.  The method returns a boolean stating if the removal was successful
    // or not.
    public boolean removeItem(String id) {
        
        // If the item ID can be find in the ArrayList...
        if (findItem(id)) {
            
            // We use an iterator to locate the desired item
            ListIterator it = this.items.listIterator();
            while (it.hasNext()) {
                InvoiceItem temp = (InvoiceItem) it.next();
                
                // Once located, we remove the item from the ArrayList
                if (temp.getId() == id) {
                    it.remove();
                    return true;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    // This method removes an item of the items ArrayList.  It receives an
    // instance of the InvoiceItem class.  The method returns a boolean stating
    // if the removal was successful or not.
    public boolean removeItem(InvoiceItem item) {
        
        // We call the other removeItem method, sending this item ID.
        return removeItem(item.getId());
    }
    
    // This method tries to update the description of an item within the items
    // array list
    public void updateItem(String id, String desc) {
        // If the items array is not empty, then we iterate the array
        if(!this.items.isEmpty()) {
            for(InvoiceItem tempItem : items) {
                // If the id could be found, update the description
                if (tempItem.getId() == id) {
                    tempItem.setDescription(desc);
                }
            }
        }
    }
    
    // This method tries to update the quantity of an item within the items
    // array list.  The method returns a boolean indicating if the update was
    // successful or not.
    public boolean updateItem(String id, int quantity) {
        // If the items array is not empty, then we iterate the array
        if(!this.items.isEmpty()) {
            for(InvoiceItem tempItem : items) {
                // If the id could be found and the current quantity is not
                // equal to the new quantity, then update the quantity
                if ((tempItem.getId() == id) 
                        && (tempItem.getQuantity() != quantity)) {
                    tempItem.setQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
    
    // This method tries to update the unit price of an item within the items
    // array list.  The method returns a boolean indicating if the update was
    // successful or not.
    public boolean updateItem(String id, double unitPrice) {
        // If the items array is not empty, then we iterate the array
        if(!this.items.isEmpty()) {
            for(InvoiceItem tempItem : items) {
                // If the id could be found and the current unit prices is not
                // equal to the new unit price, then update the unit price
                if ((tempItem.getId() == id)
                        && (tempItem.getUnitPrice() != unitPrice)) {
                    tempItem.setUnitPrice(unitPrice);
                    return true;
                }
            }
        }
        return false;
    }
    
    //This method tries to update the data of an item within the items array
    // list.  The method returns a boolean indicating if the update was
    // successful or not.
    public boolean updateItem(InvoiceItem item) {
        updateItem(item.getId(), item.getDescription());
        return (updateItem(item.getId(), item.getQuantity())
                || updateItem(item.getId(), item.getUnitPrice()));
    }
    @Override
    public String toString(){
        String temp;
        
        // We start building the string with the invoice id and the customer
        // data
        temp = "Invoice[id=" + this.id + ",customer id=" +
                this.customer.getID() + ",customer name=" +
                this.customer.getName() + ",Items={";
        
        // We iterate throughout the items ArrayList to retreive the items data
        for(InvoiceItem tempItem : items) {
            temp += "Item[id=" + tempItem.getId() + ",description=" +
                    tempItem.getDescription() + ",quantity=" + 
                    tempItem.getQuantity() + ",unit price=" + 
                    tempItem.getUnitPrice() + ",line total=" +
                    tempItem.getTotal() + "],";
        }
        
        // We end the string with the invoice amounts
        temp += "},gross amount=" + this.amount + ",discount amount=" +
                this.amount * this.customer.getDiscount() / 100 +
                ",amount after discount=" + this.getAmountAfterDiscount() + "]";
        
        return temp;
    }
    private boolean findItem(String id) {
        // If the items array is not empty, then we iterate the array
        if (!this.items.isEmpty()) {
            for(InvoiceItem tempItem : items) {
                // If the id could be found, returns true
                if (tempItem.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
}
