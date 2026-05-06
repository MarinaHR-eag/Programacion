package resolucionexament6t7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EAG
 */
public class Mensaje {
    // Atributos
    private String usuario, mensaje;
    private int clave;
    
    // Constructor por parámetros
    public Mensaje(String usuario, String mensaje, int clave) throws MensajeInvalidoException{
        if(clave <= 0){
            throw new MensajeInvalidoException("La clave no puede ser menor o igual a 0");
        }
        else if(mensaje.equals("")){
            throw new MensajeInvalidoException("El mensaje no puede estar vacío");
        }
        else{
            this.usuario = usuario;
            this.mensaje = mensaje;
            this.clave = clave;
        }
    }
    
    // Getters
    public String getUsuario(){
        return this.usuario;
    }
    
    public String getMensaje(){
        return this.mensaje;
    }
    
    public int getClave(){
        return this.clave;
    }
    
    // Ejercicio 2
    public String cifrarMensaje() throws MensajeInvalidoException{
        // Comprobamos que el mensje es válido
        if(!this.mensaje.matches("[a-zA-Z ]+")){
            throw new MensajeInvalidoException("El mensaje no tiene un formato válido");
        }
                String mensajeCifrado = "";
        // Recorremos el mensaje caracter a caracter
        for(int i=0; i<this.mensaje.length(); i++){
            char letra = this.mensaje.charAt(i);
            if(letra != ' '){
                mensajeCifrado += (char) (letra + this.clave);
            }else{
                mensajeCifrado += letra;
            }
        }
        return mensajeCifrado;
    }
    
    // toString
    @Override
    public String toString(){
        String cadena = "Usuario: " + this.usuario + "\n"+
                "Mensaje: " + this.mensaje + "\n" +
                "Clave: " + this.clave;
        
        return cadena;
    }
}