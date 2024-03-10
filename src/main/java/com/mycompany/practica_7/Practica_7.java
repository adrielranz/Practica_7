package com.mycompany.practica_7;

public class Practica_7 {
    public static void main(String[] args) {
        funciones.crearCarpeta();
        funciones.buscarOcrearArchivo();

        System.out.print("Ingrese su usuario: ");
        String usuario = leerDatos.leerString();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = leerDatos.leerString();

        funciones.leerOcrearUsuarios(usuario, contrasena);

        Boolean condicion = false;

        while(!condicion){
        //menu
        System.out.println();
        System.out.println("--------------MENU---------------");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Raiz cuadrada");
        System.out.println("6. Potencia");
        System.out.println("7. Historial de operaciones");
        System.out.println("8. Salir");
        System.out.println();
        System.out.print("Que operación quieres hacer: ");
        int eleccion = leerDatos.leerInt();

        if(eleccion == 1){
            funciones.suma(usuario);
        }else if(eleccion == 2){
            funciones.resta(usuario);
        }else if(eleccion == 3){
            funciones.multiplicacion(usuario);
        }else if(eleccion == 4){
            funciones.division(usuario);
        }else if(eleccion == 5){
            funciones.raicesCuadradas(usuario);
        }else if(eleccion == 6){
            funciones.potencias(usuario);
        }else if(eleccion == 7){
            System.out.println("----------Historial de operaciones----------");
            funciones.mostrarHistorial(usuario);
        }else if(eleccion == 8){
            condicion = true;
            System.out.println("Saliendo del programa...");
        }else{
            System.out.println("Opcion no valida");
        }
        }
    }
}
       