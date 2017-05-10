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
public class Customer {
    //Declaracion de atributos
    private int id;
    private String name;
    private double discount;
    //Constructor
    public Customer(int id, String name, double discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }
    //Get y set
    public int getID(){//Obtiene el id proporcionado por el usuario
        return this.id;
    }
    public String getName(){//Obtiene el nombre proporcionado por el usuario
        return this.name;
    }
    public double getDiscount(){//Obtiene el descuento proporcionado por el usuario
        return this.discount;
    }
    public void setDiscount(double discount){//Modifica el descuento proporcionado por el usuario
        this.discount = discount;
    }
    //Metodos
    @Override
    public String toString(){//Regresa una cadena con la informacion
        return this.name + "(" + this.id + ")";
    }
    
}
