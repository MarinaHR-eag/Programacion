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
public abstract class Empleado {
    // Bloque atributos
    protected String nombre;
    protected double salarioBase;
    protected Departamento departamento;
    protected static int totalEmpleados = 0;
    
    // Constructores
    // Constructor por defecto
    public Empleado(){
        this.nombre = "";
        this.salarioBase = 0;
        totalEmpleados++;
    }
    
    // Constructor por parámetros
    public Empleado(String nombre, double salario){
        this.nombre = nombre;
        this.salarioBase = salario;
        totalEmpleados++;
    }
    
    // Constructor de copia
    public Empleado(Empleado e){
        this.nombre = e.nombre;
        this.salarioBase = e.salarioBase;
        totalEmpleados++;
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public double getSalarioBase(){
        return this.salarioBase;
    }
    
    public static int getTotalEmpleados(){
        return totalEmpleados;
    }
    
    public Departamento getDepartamento(){
        return this.departamento;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setSalarioBase(double salario){
        this.salarioBase = salario;
    }
    
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }
    
    // No hacemos un setter del atributo totalEmpleados porque no queremos que nadie lo modifique
    
    // Métodos personalizados
    public abstract double calcularSalario();
    
    // toString
    @Override
    public String toString(){
        String cadena = "Nombre empleado: " + this.nombre +
                "\nSalario base: " + this.salarioBase + 
                "\nDepartamento: " + this.departamento.getNombre();
        return cadena;
    }
}
