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
public class Empresa {
    // Atributos
    private String nombre;
    private Departamento[] departamentos;
    
    // Constructores
    // Constructor por defecto
    public Empresa(){
        this.nombre = "";
        this.departamentos = new Departamento[0];
    }
    
    // Constructor por parámetros
    public Empresa(String nombre, Departamento[] departamentos){
        this.nombre = nombre;
        this.departamentos = departamentos;
    }
    
    // Constructor de copia
    public Empresa(Empresa e){
        this.nombre = e.nombre;
        this.departamentos = e.departamentos;
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public Departamento[] getDepartamentos(){
        return this.departamentos;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDepartamentos(Departamento[] departamentos){
        this.departamentos = departamentos;
    }
    
    // Métodos personalizados
    public void crearNuevoDepartamento(
        String nombre,
        double presupuesto,
        Empleado director,
        Empleado[] empleadosDepartamento){
        
        Departamento nuevoDepartamento = new Departamento(
                nombre, 
                presupuesto, 
                director, 
                empleadosDepartamento
        );
        
        Departamento[] nuevoArray = new Departamento[this.departamentos.length + 1];
        for(int i = 0; i < this.departamentos.length; i++){
            nuevoArray[i] = this.departamentos[i];
        }
        nuevoArray[nuevoArray.length - 1] = nuevoDepartamento;
        
        this.departamentos = nuevoArray;
    }
    
    // toString
    public String toString(){
        String cadena = "Nombre empresa: " + this.nombre +
                "Departamentos: ";
        for (int i = 0; i < this.departamentos.length; i++){
            cadena += "\n" + this.departamentos[i].toString();
        }
        
        return cadena;
    }
}
