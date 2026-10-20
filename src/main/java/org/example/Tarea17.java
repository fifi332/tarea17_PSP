package org.example;

import java.util.Scanner;

class Contador {
    int valor = 0;

    synchronized void incrementar(int cantidad) {
        valor += cantidad;
    }
}

class Hilo extends Thread {
    Contador contador;
    char consonante;
    String texto;
    int resultado = 0;

    Hilo(Contador c, char consonante, String texto) {
        contador = c;
        this.consonante = consonante;
        this.texto = texto;
    }

    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i)) ==
                    Character.toLowerCase(consonante)) {
                resultado++;
            }
        }
        contador.incrementar(resultado);
        System.out.println(consonante + ": " + resultado);
    }
}

public class Tarea17 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] consonantes = new char[5];

        for (int i = 0; i < 5; i++) {
            char letra;
            boolean esConsonante;

            do {
                System.out.print("Introduce una consonante: ");
                letra = sc.nextLine().toLowerCase().charAt(0);

                esConsonante = Character.isLetter(letra)
                        && "aeiouáéíóúü".indexOf(letra) == -1;

                if (!esConsonante) {
                    System.out.println("No es una consonante.");
                }
            } while (!esConsonante);

            consonantes[i] = letra;
        }

        System.out.print("Introduce el texto: ");
        String texto = sc.nextLine();

        Contador c = new Contador();
        Hilo[] hilos = new Hilo[5];

        for (int i = 0; i < 5; i++) {
            hilos[i] = new Hilo(c, consonantes[i], texto);
            hilos[i].start();
        }

        for (int i = 0; i < 5; i++) {
            hilos[i].join();
        }

        System.out.println("Total compartido: " + c.valor);
        sc.close();
    }
}