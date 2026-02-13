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
        this.empleados = empleados.clone();
        // Constrolamos que el director, si se pasa, está dentro del array de empleados
        this.setDirector(director);
    }
    
    // Constructor de copia
    public Departamento(Departamento d){
        this.nombre = d.nombre;
        this.presupuestoAnual = d.presupuestoAnual;
        this.director = d.director;
        this.empleados = d.empleados.clone();
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
        return this.empleados.clone();
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPresupuestoAnual(double presupuesto){
        this.presupuestoAnual = presupuesto;
    }
    
    public void setDirector(Empleado director){
        // Si hemos pasado un empleado para ser director, comprobamos si ya
        // pertenece al departamento, y en el caso de que no, lo añadimos a la
        // lista de empleados del departamento
        if(director != null){
            // Comprobar si el director está en el departamento
            boolean directorEnListaDeEmpleados = comprobarEmpleadoPerteneceADepartamento(director);
            if(!directorEnListaDeEmpleados){
                this.aniadirNuevoEmpleado(director);
            }
        }
        this.director = director;
    }
    
    public void setEmpleados(Empleado[] empleados){
        this.empleados = empleados.clone();
        // Además de añadir los empleados, cambiamos su departamento por mantener la consistencia
        for(int i = 0; i < empleados.length; i++){
            empleados[i].setDepartamento(this);
        }
    }
    
    // Métodos de apoyo
    private boolean comprobarEmpleadoPerteneceADepartamento(Empleado empleado){
        boolean empleadoEnDepartamento = false;
        for(int i = 0; i < this.empleados.length; i++){
            if(this.empleados[i] == empleado){
                empleadoEnDepartamento = true;
                break;
            }
        }
        
        return empleadoEnDepartamento;
    }
    
    private void aniadirNuevoEmpleado(Empleado nuevoEmpleado){  
        // Comprobamos que no nos han pasado un valor nulo
        if(nuevoEmpleado != null){
            // Comprobamos que el empleado no está ya en el departamento
            boolean empleadoYaAniadido = comprobarEmpleadoPerteneceADepartamento(nuevoEmpleado);
            if(!empleadoYaAniadido){
                // Comprobamos que el empleado no estaba antes en otro departamento
                // Y en caso de que sí lo estuviese, lo borramos de la lista de 
                // empleados de ese departamento
                Departamento departamento = nuevoEmpleado.getDepartamento();
                if(departamento != null && departamento != this){
                    departamento.eliminarEmpleado(nuevoEmpleado);
                }
                Empleado[] nuevoArray = new Empleado[this.empleados.length + 1];
                for(int i = 0; i < this.empleados.length; i++){
                    nuevoArray[i] = this.empleados[i];
                }
                nuevoArray[nuevoArray.length - 1] = nuevoEmpleado;
                this.empleados = nuevoArray;
                nuevoEmpleado.setDepartamento(this);
            } 
        }
    }
    
    // Creamos un método para eliminar un empleado de un departamento en el caso de
    // que este cambie de departamento o haya que borrarlo definitivamente
    private void eliminarEmpleado(Empleado empleadoAEliminar){
        // Inicialmente comprobamos si el empleado que queremos eliminar pertenece al departamento
        boolean empleadoPertenece = comprobarEmpleadoPerteneceADepartamento(empleadoAEliminar);
        if(empleadoPertenece){
            // Creamos un array auxiliar de empleados con 1 empleado menos que el que tenemos
            Empleado[] nuevoArray = new Empleado[this.empleados.length - 1];
            // Creamos un iterador para ir añadiendo empleados en el nuevo array
            int iterador = 0;
            for(int i = 0; i < this.empleados.length; i++){
                // En el caso de que el empleado que estamos recorriendo sea
                // distinto al que queremos eliminar, lo añadimos al array auxiliar
                if(this.empleados[i] != empleadoAEliminar){
                    nuevoArray[iterador] = this.empleados[i];
                    iterador++;
                }
            }
            this.empleados = nuevoArray;
        }
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
