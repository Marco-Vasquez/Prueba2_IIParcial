/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2_iiparcial;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author andres
 */
public class Menu {
    private GestorArchivos gestor;
    private Scanner lea;
    public Menu(){
        gestor=new GestorArchivos("tareas.txt");
        lea=new Scanner(System.in);
    }
    public void ejecutar(){
        int opcion;
        do{
            System.out.println("\nGESTOR DE TAREAS");
            System.out.println("================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tarea");
            System.out.println("3. Completar tareas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion=Integer.parseInt(lea.nextLine());
            switch(opcion){
                case 1: 
                    agregarTarea();
                    break;
                case 2:
                    mostrarTarea();
                    break;
                case 3:
                    completarTarea();
                    break;
                case 4: 
                    System.exit(0);
                    break;
            }
        }
        while(opcion!=4);
    }
    private void agregarTarea(){
        System.out.print("Ingresa la nueva tarea: ");
        String nombreTarea=lea.nextLine();
        ArrayList<String> tareas;
        tareas=gestor.leerTareas();
        tareas.add("[ ] "+nombreTarea);
        gestor.guardarTareas(tareas);
        System.out.println("\nÉxito. Tarea agregada: "+nombreTarea);
    }
    private void mostrarTarea(){
        ArrayList<String> tareas;
        tareas=gestor.leerTareas();
        System.out.println("\nLISTA DE TAREAS");
        System.out.println("===============");
        if(tareas.isEmpty()){
            System.out.println("No hay tareas por mostrar");
            return;
        }
        for(int control=0;control<tareas.size();control++){
            System.out.println((control+1)+". "+tareas.get(control));
        }
    }
    private void completarTarea(){
        System.out.print("Número de tarea a completar: ");
        int numero;
        numero=Integer.parseInt(lea.nextLine());
        ArrayList<String> tareas;
        tareas=gestor.leerTareas();
        if(numero<1 || numero>tareas.size()){
            System.out.println("Número inválido");
            return;
        }
        String nombreTarea;
        nombreTarea=tareas.get(numero-1).substring(4);
        tareas.set(numero-1,"[✓] "+nombreTarea);
        gestor.guardarTareas(tareas);
        System.out.println("\n✓“ Tarea #"+numero+" completada: "+nombreTarea);
    }
}
