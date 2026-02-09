/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaempleados;

/**
 *
 * @author EAG
 */
public class EmpleadoFijo extends Empleado implements Incentivable{
    // Atributos
    // No tiene atributos específicos
    
    // Constructores
    // Constructor por defecto
    public EmpleadoFijo(){
        super();
    }
    
    // Constructor por parámetros
    public EmpleadoFijo(String nombre, double salario){
        super(nombre, salario);
    }
    
    // Constructor de copia
    public EmpleadoFijo(EmpleadoFijo e){
        super(e);
    }
    
    // Getters
    // No hace falta poner getters porque no hay atributos propios
    
    // Setters
    // No hace falta poner setters porque no hay atributos propios
    
    // Métodos personalizados
    @Override
    public double calcularSalario(){
        return this.salarioBase;
    }
    
    @Override
    public double calcularIncentivo(){
        double salarioConIncentivo = this.calcularSalario() + 300;
        return salarioConIncentivo;
    }
    
    // toString
    // No es necesario crear el toString porque la información ya sale en el del padre
}
