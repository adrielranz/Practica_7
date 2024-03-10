package com.mycompany.practica_7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class funciones {
    public static void suma(String usuario) {
        System.out.print("Ingrese el primer valor: ");
        int num1 = leerDatos.leerInt();
        System.out.print("Ingrese el segundo valor: ");
        int num2 = leerDatos.leerInt();
        int resultado = num1 + num2;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String operacion = num1 + " + " + num2 + " = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
        System.out.println("El resultado de la suma es: " + resultado);
        String nombreArchivoHistorial = usuario + "_operaciones.txt";
        String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
        guardarHistorialPersonal(rutaArchivoHistorial, operacion);
    }

    public static void resta(String usuario) {
        System.out.print("Ingrese el primer valor: ");
        int num1 = leerDatos.leerInt();
        System.out.print("Ingrese el segundo valor: ");
        int num2 = leerDatos.leerInt();
        int resultado = num1 - num2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String operacion = num1 + " - " + num2 + " = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
        System.out.println("El resultado de la resta es: " + resultado);
        String nombreArchivoHistorial = usuario + "_operaciones.txt";
        String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
        guardarHistorialPersonal(rutaArchivoHistorial, operacion);
    }

    public static void multiplicacion(String usuario) {
        System.out.print("Ingrese el primer valor: ");
        int num1 = leerDatos.leerInt();
        System.out.print("Ingrese el segundo valor: ");
        int num2 = leerDatos.leerInt();
        int resultado = num1 * num2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String operacion = num1 + " * " + num2 + " = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
        System.out.println("El resultado de la multiplicacion es: " + resultado);
        String nombreArchivoHistorial = usuario + "_operaciones.txt";
        String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
        guardarHistorialPersonal(rutaArchivoHistorial, operacion);
    }

    public static void division(String usuario) {
        System.out.print("Ingrese el primer valor: ");
        int num1 = leerDatos.leerInt();
        System.out.print("Ingrese el segundo valor: ");
        int num2 = leerDatos.leerInt();

        try {
            int resultado = num1 / num2;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String operacion = num1 + " / " + num2 + " = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
            System.out.println("El resultado de la division es: " + resultado);
            String nombreArchivoHistorial = usuario + "_operaciones.txt";
            String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
            guardarHistorialPersonal(rutaArchivoHistorial, operacion);
        } catch (ArithmeticException e) {
            System.out.print("No se puede dividir entre 0");
        } catch (Exception e) {
            System.out.println("Error inesperado");
            return;
        }
    }

    public static void raicesCuadradas(String usuario) {
        System.out.print("Ingrese el valor: ");
        int num1 = leerDatos.leerInt();

        try {
            if (num1 < 0) {
                throw new ArithmeticException();
            }
            double resultado = Math.sqrt(num1);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String operacion = "sqrt(" + num1 + ") = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
            System.out.println("El resultado de la raiz cuadrada es: " + resultado);
            String nombreArchivoHistorial = usuario + "_operaciones.txt";
            String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
            guardarHistorialPersonal(rutaArchivoHistorial, operacion);
        } catch (ArithmeticException e) {
            System.out.println("No se puede calcular la raiz cuadrada de un numero negativo");
            return;
        } catch (Exception e) {
            System.out.println("Error inesperado");
            return;
        }
    }

    public static void potencias(String usuario) {
        System.out.print("Ingrese el numero: ");
        int num1 = leerDatos.leerInt();
        System.out.print("Ingrese la potencia: ");
        int num2 = leerDatos.leerInt();
        double resultado = Math.pow(num1, num2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String operacion = num1 + "^" + num2 + " = " + resultado + " (Realizado en: " + dtf.format(now) + ")";
        System.out.println("El resultado de la potencia es: " + resultado);
        String nombreArchivoHistorial = usuario + "_operaciones.txt";
        String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
        guardarHistorialPersonal(rutaArchivoHistorial, operacion);
    }

    //MOSTRAR EL HISOTIAL DE OPERACIONES
    public static void mostrarHistorial(String usuario){
        try {
            String nombreArchivoHistorial = usuario + "_operaciones.txt";
            String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;

            Scanner scanner = new Scanner(new File(rutaArchivoHistorial));

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    //REGISTRO DE USUARIOS
    public static void buscarOcrearArchivo() {
        String ruta = "./almacenamiento/usuarios.json";

        if (Files.exists(Paths.get(ruta))) {
            System.out.println("El archivo existe");
        } else {
            File archivo = new File(ruta);

            try {
                archivo.createNewFile();
                System.out.println("El archivo se ha creado");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
            } finally {
            }
        }
    }

    public static void crearCarpeta() {
        String ruta = "./almacenamiento";
        File directorio = new File(ruta);
        directorio.mkdir();
    }

    public static void leerOcrearUsuarios(String usuario, String contrasena) {
        String rutaJson = "./almacenamiento/usuarios.json";
        try {
            File file = new File(rutaJson);
            if (file.length() == 0) {
                FileWriter writer = new FileWriter(rutaJson);
                writer.write("{}");
                writer.close();
            }

            String contenido = new String(Files.readAllBytes(Paths.get(rutaJson)));
            JSONObject json = new JSONObject(contenido);

            if (json.has(usuario)) {
            // Si el usuario existe pero la contraseña es incorrecta, pedir la contraseña de nuevo
                while (!json.getString(usuario).equals(contrasena)) {
                    System.out.print("Contraseña incorrecta. Inténtalo de nuevo: ");
                    contrasena = leerDatos.leerString();
                }
            } else {
                json.put(usuario, contrasena);

                FileWriter writer = new FileWriter(rutaJson);
                writer.write(json.toString(4));
                writer.close();
            }

            // Escribir en el archivo de historial
            String nombreArchivoHistorial = usuario + "_operaciones.txt";
            String rutaArchivoHistorial = "./almacenamiento/" + nombreArchivoHistorial;
            FileWriter writerHistorial = new FileWriter(rutaArchivoHistorial, true);
            writerHistorial.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    //METODO PARA GUARDAR EL HISOTIAL DE OPERACIONES
    public static void guardarHistorialPersonal(String rutaArchivoHistorial, String operacion){

        try {
            FileWriter writer = new FileWriter(rutaArchivoHistorial, true);
            writer.write(operacion + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el historial personal");
        }
    }

}

