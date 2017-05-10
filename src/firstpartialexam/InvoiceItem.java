/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpartialexam;

/**
 *
 * @author Alumno
 */
public class InvoiceItem {
    //Declaracion de atributos
    private String id;
    private String description;
    private int quantity;
    private double unitPrice;
    //Constructor
    public InvoiceItem(String id, String description, int quantity, double unitPrice) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    //get y set
    public String getId() {//Obtiene el id proporcionado por el usuario
        return this.id;
    }
    public String getDescription() {//Obtiene la descripcion por el usuario
        return this.description;
    }
    public void setDescription(String description) { //Permite modificar la descripcion
        this.description = description;
    }
    public int getQuantity() {//Obtiene la cantidad proporcionada por el usuario
        return this.quantity;
    }
    public boolean setQuantity(int quantity) {//Permite modificar la cantidad regresando un boolean
        if(this.quantity != quantity){
            this.quantity = quantity;
            return true;
        }else{
            return false;
        }
    }
    public double getUnitPrice() {//Obtiene el precio unitario proporcionada por el usuario
        return this.unitPrice;
    }
    public boolean setUnitPrice(double unitPrice) {//Permite modificar el unitPrice regresando un boolean
        if(this.unitPrice != unitPrice){
            this.unitPrice = unitPrice;
            return true;
        }else{
            return false;
        }
    }
    //Metodos
    public double getTotal(){//Obtiene el total multiplicando el precio unitario por la cantidad
        return this.unitPrice * this.quantity;
    }
    @Override
    public String toString(){//Regresa una cadena con la informacion
        return "InvoiceItem[id=" + this.id + ",description=" + this.description 
               + ",quantity=" + this.quantity + ",unitPrice=" + this.unitPrice + "]";
    }
}
