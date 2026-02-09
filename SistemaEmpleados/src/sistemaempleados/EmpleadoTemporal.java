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
public class EmpleadoTemporal extends Empleado{
    // Atributos
    private int horasTrabajadas;
    private double precioHora;
    
    // Constructores
    // Constructor por defecto
    public EmpleadoTemporal(){
        super();
        this.horasTrabajadas = 0;
        this.precioHora = 0;
    }
    
    // Constructor por parámetros
    public EmpleadoTemporal(String nombre, double salario, int horas, double precioHora){
        super(nombre, salario);
        this.horasTrabajadas = horas;
        this.precioHora = precioHora;
    }
    
    // Constructor de copia
    public EmpleadoTemporal(EmpleadoTemporal e){
        super(e);
        this.horasTrabajadas = e.horasTrabajadas;
        this.precioHora = e.precioHora;
    }
    
    // Getters
    public int getHorasTrabajadas(){
        return this.horasTrabajadas;
    }
    
    public double getPrecioHora(){
        return this.precioHora;
    }
    
    // Setters
    public void setHorasTrabajadas(int horas){
        this.horasTrabajadas = horas;
    }
    
    public void setPrecioHora(double precio){
        this.precioHora = precio;
    }
    
    // Métodos personalizados
    @Override
    public double calcularSalario(){
        double salario = this.salarioBase + this.horasTrabajadas * this.precioHora;
        return salario;
    }
    
    // toString
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\nHoras Trabajadas: " + this.horasTrabajadas +
                "\nPrecio por hora: " + this.precioHora;
        return cadena;
    }    
}
