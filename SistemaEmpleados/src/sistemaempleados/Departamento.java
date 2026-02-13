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
public class Departamento {
    // Atributos
    private String nombre;
    private double presupuestoAnual;
    private Empleado director;
    private Empleado[] empleados;
    
    // Constructores
    // Constructor por defecto
    public Departamento(){
        this.nombre = "";
        this.presupuestoAnual = 0;
        this.director = null;
        this.empleados = new Empleado[0];
    }
    
    // Constructor por parámetros
    public Departamento(
        String nombre,
        double presupuesto,
        Empleado director,
        Empleado[] empleados){
        this.nombre = nombre;
        this.presupuestoAnual = presupuesto;
        this.empleados = empleados;
        // Constrolamos que el director, si se pasa, está dentro del array de empleados
        this.setDirector(director);
    }
    
    // Constructor de copia
    public Departamento(Departamento d){
        this.nombre = d.nombre;
        this.presupuestoAnual = d.presupuestoAnual;
        this.director = d.director;
        this.empleados = d.empleados;
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public double getPresupuestoAnual(){
        return this.presupuestoAnual;
    }

    public Empleado getDirector(){
        return this.director;
    }
    
    public Empleado[] getEmpleados(){
        return this.empleados;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPresupuestoAnual(double presupuesto){
        this.presupuestoAnual = presupuesto;
    }
    
    public void setDirector(Empleado director){
        // Comprobar si el director está en el departamento
        boolean directorEnListaDeEmpleados = false;
        if(director != null){
            directorEnListaDeEmpleados = comprobarDirectorPerteneceADepartamento(director);
        }
        if(!directorEnListaDeEmpleados){
            this.aniadirNuevoEmpleado(director);
        }
        this.director = director;
    }
    
    public void setEmpleados(Empleado[] empleados){
        this.empleados = empleados;
    }
    
    // Métodos de apoyo
    private boolean comprobarDirectorPerteneceADepartamento(Empleado director){
        boolean directorEnDepartamento = false;
        for(int i = 0; i < this.empleados.length; i++){
            if(this.empleados[i] == director){
                directorEnDepartamento = true;
                break;
            }
        }
        
        return directorEnDepartamento;
    }
    
    private void aniadirNuevoEmpleado(Empleado nuevoEmpleado){  
        Empleado[] nuevoArray = new Empleado[this.empleados.length + 1];
        for(int i = 0; i < this.empleados.length; i++){
            nuevoArray[i] = this.empleados[i];
        }
        nuevoArray[nuevoArray.length - 1] = nuevoEmpleado;
        this.empleados = nuevoArray;
    }
    
    // Métodos personalizados
    // No hay ninguno
    
    // toString
    public String toString(){
        String cadena = "Nombre departamento: " + this.nombre +
                "\nPresupuesto anual: " + this.presupuestoAnual +
                "\nDirector: ";
        
        if(this.director != null){
            cadena += this.director.getNombre();
        }
        else{
            cadena += "Este departamento no tiene director";
        }
        
        cadena += "\nEmpleados: ";
        
        for(int i = 0; i < this.empleados.length; i++){
            cadena += "\n" + this.empleados[i].getNombre();
        }
        
        return cadena;
    }
    
}
