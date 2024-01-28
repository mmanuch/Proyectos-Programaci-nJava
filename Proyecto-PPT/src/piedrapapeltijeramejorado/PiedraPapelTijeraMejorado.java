package piedrapapeltijeramejorado;

import java.util.Scanner;

/**
 *
 * @author a22manuelach
 * 
 */
public class PiedraPapelTijeraMejorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bien venido al juego de 'Piedra, papel o tijera'");
        System.out.println("A continuación, jugaremos hasta que ganes o hasta que te rindas");
        System.out.println("De acuerdo?");
        System.out.println("Comencemos!!!!!");
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        int contador_maquina = 0;
        int contador_jugador = 0;

        do {
            if (contador_jugador <= contador_maquina) {/* Siempre que la máquina vaya ganando 
                o empatando, juega limpio, se le puede ganar pero solo dentro de unas
                circuntancias específicas*/
                System.out.println("Qué vas a escoger? [1=Piedra---2=papel---0=tijera]");
                int r = teclado.nextInt();
                int numero = new java.util.Random().nextInt(3);
                /*Número aleatorio entre el 0 y el 2, ya que siempre escoge 
                aleatoriamente entre el rango de 0 y el número anterior al que 
                introduciste*/

                System.out.println("El ordenador a escogido ");
                switch (numero) {//Como hay tres posibilidades, pues hay que hacer tres casos
                    case 1 -> {
                        System.out.println("Piedra");
                        switch (r) {//Para cada caso pueden pasar tres opciones, las cuales son:
                            
                            case 1 -> {
                                System.out.println("Empate!");
                            }
                            case 2 -> {
                                System.out.println("Ganaaste!");
                                contador_jugador++;//contador para el jugador
                            }
                            case 0 -> {
                                System.out.println("Perdiste :( ");
                                contador_maquina++;//Contador para la máquina
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Papel");
                        switch (r) {
                            case 2 -> {
                                System.out.println("Empate!");
                            }
                            case 0 -> {
                                System.out.println("Ganaaste!");
                                contador_jugador++;
                            }
                            case 1 -> {
                                System.out.println("Perdiste :( ");
                                contador_maquina++;
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println("Tijera");
                        switch (r) {
                            case 0 -> {
                                System.out.println("Empate!");
                            }
                            case 1 -> {
                                System.out.println("Ganaaste!");
                                contador_jugador++;
                            }
                            case 2 -> {
                                System.out.println("Perdiste :( ");
                                contador_maquina++;
                            }

                        }
                    }
                }
            } else {//Cuando la máquina va perdiendo empieza a hacer trampas
                System.out.println("Qué vas a escoger? [1=Piedra---2=papel---0=tijera]");
                int r = teclado.nextInt();
                
                System.out.println("El ordenador a escogido ");
                switch (r) {
                    case 1 -> {
                        System.out.println("Papel");
                        System.out.println("Perdiste :(");
                        contador_maquina++;
                    }
                    case 2 -> {
                        System.out.println("Tijera");
                        System.out.println("Perdiste :(");
                        contador_maquina++;
                    }
                    case 0 -> {
                        System.out.println("Piedra");
                        System.out.println("Perdiste :(");
                        contador_maquina++;
                    }
                }
            }
        } while (contador_jugador < 3 && contador_maquina < 3);/*Bucle para
        que finalice la partida cuando uno de los dos haya hecho tres puntos*/
        /* En este modo, se le puede ganar a la maquina 3-2, ya que somos generosos*/
        if (contador_jugador == 3) {
            System.out.println("Felicidades has ganado, habéis quedado "
                    + contador_jugador + "-" + contador_maquina);
        }
        if (contador_maquina == 3) {
            System.out.println("Lo siento, has perdido, habéis quedado "
                    + contador_jugador + "-" + contador_maquina);
        }
    }

}
