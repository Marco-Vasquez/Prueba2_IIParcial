/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2_iiparcial;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author andres
 */
public class GestorArchivos {
    private File archivo;
    public GestorArchivos(String nombreArch){
        archivo=new File(nombreArch);
    }
    public ArrayList<String> leerTareas(){
        ArrayList<String> tareas=new ArrayList<>();
        if(!archivo.exists()){
            return tareas;
        }
        try{
            FileReader lector=new FileReader(archivo);
            String linea="";
            int caracter;
            while((caracter=lector.read())!=-1){
                if((char) caracter=='\n'){
                    if(!linea.isEmpty()){
                        tareas.add(linea);
                    }
                    linea="";
                }
                else{
                    linea+=(char) caracter;
                }
            }
            if(!linea.isEmpty()){
                tareas.add(linea);
            }
            lector.close();
        }
        catch(IOException e){
            System.out.println("Error al leer el archivo");
        }
        return tareas;
    }
    public void guardarTareas(ArrayList<String> tareas){
        try{
            FileWriter escritor=new FileWriter(archivo,false);
            for(String tarea:tareas){
                escritor.write(tarea+"\n");
            }
            escritor.close();
        }
        catch(IOException e){
            System.out.println("Error al guardar el archivo");
        }
    }
}
