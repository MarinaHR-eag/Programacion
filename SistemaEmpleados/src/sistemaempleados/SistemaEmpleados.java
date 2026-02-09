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
public class SistemaEmpleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoFijo jose = new EmpleadoFijo("Jose Jordán", 7000);
        //jose = new EmpleadoTemporal("Jose Jordán", 7000, 14, 15);
        System.out.println(jose);
        
        EmpleadoComercial laura = new EmpleadoComercial("Laura", 3000, 500);
        System.out.println(laura);
        
        double salarioJose = jose.calcularSalario();
        double salarioLaura = laura.calcularSalario();
        System.out.println("Salario Jose: " + salarioJose);
        System.out.println("Salario Laura: " + salarioLaura);
        
        double incentivoJose = jose.calcularIncentivo();
        double incentivoLaura = laura.calcularIncentivo();
    }
    
}
