/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolucionexament6t7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author EAG
 */
public class ResolucionExamenT6T7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Primero creamos el objeto de tipo File que enlace con el fichero mensajes.txt
        File archivo = new File("./archivos/mensajes.txt");
        
        // Ejercicio 1
        try {
            // Creamos el Scanner
            Scanner sc = new Scanner(archivo);
            
            // Contar las líneas del archivo
            int numLineas = 0;
            while(sc.hasNextLine()){
                sc.nextLine();
                numLineas++;
            }
            sc.close();
            
            // Creamos un array de objetos Mensaje
            Mensaje[] mensajes = new Mensaje[numLineas];
            int siguienteMensaje = 0;
            
            // Leemos el archivo y para cada línea creamos un mensaje
            sc = new Scanner(archivo);
            
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                // Procesar las líneas
                String [] elementos = linea.split("\\|");
                String [] elementos2 = {"", "", ""};
                for(int i=0; i<elementos.length; i++){
                    elementos2[i] = elementos[i].split("=")[1];
                }
                
                // Transformamos las variables a los tipos que me interesan
                String usuario = elementos2[0].trim();
                String mensaje = elementos2[1].trim();
                int clave = Integer.parseInt(elementos2[2].trim());
                
                Mensaje m = new Mensaje(usuario, mensaje, clave);
                mensajes[siguienteMensaje] = m;
                siguienteMensaje++;
            }
            sc.close();
            
            for(int i=0; i<mensajes.length; i++){
                System.out.println(mensajes[i]);
            }
            
            // Ejercicio 2
            
            // Crear la carpeta mensajesCifrados si no existe
            String carpetaMensajesCifrados = "./mensajesCifrados";
            File carpetaCifrados = new File(carpetaMensajesCifrados);
            
            if(!carpetaCifrados.exists()){
                carpetaCifrados.mkdir();
            }
            
            for(int i=0; i<mensajes.length; i++){
                String mensajeCifrado = mensajes[i].cifrarMensaje();
                String nombreArchivo = "mensaje_" + mensajes[i].getUsuario() + ".txt";
                String rutaFichero = carpetaMensajesCifrados + "/" + nombreArchivo;
                File fichero = new File(rutaFichero);
                fichero.createNewFile();
                
                FileWriter fw = new FileWriter(rutaFichero);
                PrintWriter pw = new PrintWriter(fw);
                
                // Escribimos el contenido de los archivos
                pw.println("Usuario: " + mensajes[i].getUsuario());
                pw.println("Mensaje cifrado: " + mensajeCifrado);
                pw.println("Clave: " + mensajes[i].getClave());
                
                fw.close();
                pw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("No se puede transformar a número");
            e.printStackTrace();
        } catch (MensajeInvalidoException e) {
            System.out.println("No se puede crear un mensaje con esas variables");
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Se ha intentado acceder a un elemento del array que no existe");
            e.printStackTrace();
        } catch(IOException e){
            System.out.println("No se pudo crear el archivo");
            e.printStackTrace();
        }
    }   
}