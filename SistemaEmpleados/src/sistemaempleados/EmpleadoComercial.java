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
public class EmpleadoComercial extends Empleado implements Incentivable{
    // Atributos
    private double comision;
    
    // Constructores
    // Constructor por defecto
    public EmpleadoComercial(){
        super();
        this.comision = 0;
    }
    
    // Constructor por parámetros
    public EmpleadoComercial(String nombre, double salario, double comision){
        super(nombre, salario);
        this.comision = comision;
    }
    
    // Constructor de copia
    public EmpleadoComercial(EmpleadoComercial e){
        super(e);
        this.comision = e.comision;
    }
    
    // Getters
    public double getComision(){
        return this.comision;
    }
    
    // Setters
    public void setComision(double comision){
        this.comision = comision;
    }
    
    // Métodos personalizados
    @Override
    public double calcularSalario(){
        double salario = this.salarioBase + this.comision;
        return salario;
    }
    
    @Override
    public double calcularIncentivo(){
        double salarioConIncentivo = this.calcularSalario()*1.1;
        return salarioConIncentivo;
    }
    
    // toString
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\nComisión: " + this.comision;
        return cadena;
    }
}
