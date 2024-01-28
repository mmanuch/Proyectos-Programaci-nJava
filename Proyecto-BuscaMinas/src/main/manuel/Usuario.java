/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.manuel;

import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Usuario {

    Scanner sc = new Scanner(System.in);
    int filas, columnas, minas;
    int fila, columna;

    public void mostrarMenu() {
        String opt;

        do {
            System.out.println("Bienvenido al juego del busca minas, creado por Manuel");
            System.out.println("Introduzca que modo de juego quiere jugar");
            System.out.println("[1]- Jugar 6x6");
            System.out.println("[2]- Jugar a tu modo");
            System.out.println("[3]- Salir");
            opt = sc.nextLine();

            switch (opt.charAt(0)) {
                case '1' -> {
                    jugar6x6();
                }
                case '2' -> {
                    jugarTu();
                }
                case '3' -> {
                    System.out.println("Hasta la próxima, te esperamos con ansias");
                }
            }

        } while (opt.charAt(0) != '3');
    }

    public void jugarTu() {

        // Pedimos os datos ao usuario
        System.out.print("Introduza el número de filas con el que quieras jugar: ");
        int filas = sc.nextInt();
        System.out.print("Introduza el número de columnas con el que quieras jugar: ");
        int columnas = sc.nextInt();
        System.out.print("Introduza el número de minas con el que quieras jugar: ");
        int minas = sc.nextInt();

        // Creamos o obxecto da clase xogo
        Xogo miXogo = new Xogo(filas, columnas, minas);

        // Bucle principal do xogo
        boolean gameOver = false;
        while (!gameOver) {
            boolean marcarCela = false;
            // Mostramos o taboleiro
            miXogo.mostrarTaboleiro();

            //preguntamos se quere abrir ou marcar unha cela
            System.out.println("Deseas abrir (1) ou marcar (2) alguna celda?");
            int eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ha seleccionado abrir Cela:");
                    System.out.println("Cual desea abrir?");
                    marcarCela = false;
                    break;
                case 2:
                    System.out.println("Ha seleccionado marcar Cela");
                    System.out.println("Cual desea marcar?");
                    marcarCela = true;
                    break;
                default:
                    throw new AssertionError();
            }

            if (marcarCela) {
                System.out.print("Introduza la fila: ");
                int fila = sc.nextInt();
                System.out.print("Introduza la columna: ");
                int columna = sc.nextInt();

                Cela c = miXogo.getCela(fila, columna);
                c.setEstado(Cela.marcada);
            }

            if (!marcarCela) {
                // Pedimos ao usuario as coordenadas da cela a abrir
                System.out.print("Introduza la fila: ");
                int fila = sc.nextInt();
                System.out.print("Introduza la columna: ");
                int columna = sc.nextInt();

                // Abrimos a cela e comprobamos se ha perdido ou gañado o xogo
                Cela c = miXogo.getCela(fila, columna);
                if (c.getMinada()) {
                    // Se perdeu o xogo
                    miXogo.abrirTodasMinas();
                    System.out.println("¡BOOM! Lo sentimos, ha perdido.");
                    gameOver = true;
                    // Se abren as minas e se mostra o taboleiro
                    miXogo.mostrarTaboleiro();
                } else {
                    // Se ha aberto unha cela
                    miXogo.abrirCela(c);
                    if (miXogo.comprobarCelasAbrir()) {
                        // Se han aberto todas as celas no minadas, se gañou o xogo
                        System.out.println("¡Enhorabuena! Has desactivado las bombas");
                        gameOver = true;
                    }
                }
            }
        }
    }

    public void jugar6x6() {

        filas = 6;
        columnas = 6;
        minas = 8;

        // Creamos o obxecto da clase xogo
        Xogo miXogo = new Xogo(filas, columnas, minas);

        // Bucle principal do xogo
        boolean gameOver = false;
        while (!gameOver) {
            boolean marcarCela = false;
            // Mostramos o taboleiro
            miXogo.mostrarTaboleiro();

            //preguntamos se quere abrir ou marcar unha cela
            System.out.println("Deseas abrir (1) ou marcar (2) alguna celda?");
            int eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ha seleccionado abrir Cela:");
                    System.out.println("Cual desea abrir?");
                    marcarCela = false;
                    break;
                case 2:
                    System.out.println("Ha seleccionado marcar Cela");
                    System.out.println("Cual desea marcar?");
                    marcarCela = true;
                    break;
                default:
                    throw new AssertionError();
            }

            if (marcarCela) {
                System.out.print("Introduza a fila: ");
                int fila = sc.nextInt();
                System.out.print("Introduza a columna: ");
                int columna = sc.nextInt();

                Cela c = miXogo.getCela(fila, columna);
                c.setEstado(Cela.marcada);
            }

            if (!marcarCela) {
                // Pedimos ao usuario as coordenadas da cela a abrir
                System.out.print("Introduza a fila: ");
                int fila = sc.nextInt();
                System.out.print("Introduza a columna: ");
                int columna = sc.nextInt();

                // Abrimos a cela e comprobamos se ha perdido ou gañado o xogo
                Cela c = miXogo.getCela(fila, columna);
                if (c.getMinada()) {
                    // Se perdeu o xogo
                    miXogo.abrirTodasMinas();
                    System.out.println("¡BOOM! Lo sentimos, ha perdido.");
                    gameOver = true;
                    // Se abren as minas e se mostra o taboleiro
                    miXogo.mostrarTaboleiro();
                } else {
                    // Se ha aberto unha cela
                    miXogo.abrirCela(c);
                    if (miXogo.comprobarCelasAbrir()) {
                        // Se han aberto todas as celas no minadas, se gañou o xogo
                        System.out.println("¡Enhorabuena! Has desactivado las bombas");
                        gameOver = true;
                    }
                }
            }
        }

    }

}
