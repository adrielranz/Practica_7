package com.mycompany.practica_7;

import java.util.Scanner;

public class Practica_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Raíz Cuadrada");
            System.out.println("6. Exponente");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }

            double resultado = 0;

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el primer número:");
                    double suma1 = scanner.nextDouble();
                    System.out.println("Ingrese el segundo número:");
                    double suma2 = scanner.nextDouble();
                    resultado = suma1 + suma2;
                    break;
                case 2:
                    System.out.println("Ingrese el primer número:");
                    double resta1 = scanner.nextDouble();
                    System.out.println("Ingrese el segundo número:");
                    double resta2 = scanner.nextDouble();
                    resultado = resta1 - resta2;
                    break;
                case 3:
                    System.out.println("Ingrese el primer número:");
                    double multiplicacion1 = scanner.nextDouble();
                    System.out.println("Ingrese el segundo número:");
                    double multiplicacion2 = scanner.nextDouble();
                    resultado = multiplicacion1 * multiplicacion2;
                    break;
                case 4:
                    System.out.println("Ingrese el dividendo:");
                    double division1 = scanner.nextDouble();
                    System.out.println("Ingrese el divisor:");
                    double division2 = scanner.nextDouble();
                    if (division2 != 0) {
                        resultado = division1 / division2;
                    } else {
                        System.out.println("¡Error! No se puede dividir por cero.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el número para calcular su raíz cuadrada:");
                    double radicando = scanner.nextDouble();
                    if (radicando >= 0) {
                        resultado = Math.sqrt(radicando);
                    } else {
                        System.out.println("¡Error! No se puede calcular la raíz cuadrada de un número negativo.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese la base:");
                    double base = scanner.nextDouble();
                    System.out.println("Ingrese el exponente:");
                    double exponente = scanner.nextDouble();
                    resultado = Math.pow(base, exponente);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("El resultado es: " + resultado);
        }

        scanner.close();
    }
}
