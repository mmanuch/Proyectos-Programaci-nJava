/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruletasuerte;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class CodigoPartida {
    private String opcion, nombre;
    private final ArrayList<Participantes> jugadores = new ArrayList<Participantes>();
    private int numResueltos = 0;
    private boolean panelResuelto;
    private static int panel = 0;

    public static int getPanel () {
        return panel;
    }
    
    public void juego() {
        mostrarMenu();
    }

    /*
    * Mostramos el menú para el usuario
     */
    private void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("[1]- Jugar");
            System.out.println("[2]- Salir");
            opcion = sc.nextLine();

            switch (opcion.charAt(0)) {
                case '1' -> {
                    if( jugadores.size() != 3) {
                        jugadores();
                    } else {
                        jugar();
                    }
                }
                case '2' -> System.out.println("Hasta la proxima, os esperamos com ansias");
            }

        } while (opcion.charAt(0) != '2');
    }

    private void jugar() {
        panel = Paneles.elegirPanel();
        Scanner sc = new Scanner(System.in);

        for ( int i = 0; i < jugadores.size(); i++ ){
            if( i == 0 ) {
                jugadores.get(i).setJuega(true);
            } else {
                jugadores.get(i).setJuega(false);
            }
        }

        

        while (numResueltos < 5) {

            for ( int i = 0; i < jugadores.size(); i++ ){
                while (jugadores.get(i).getJuega()) {
                    System.out.println("Turno de " + jugadores.get(i).getNombre());
                    opcion = jugadores.get(i).tirarRuleta();
                    

                    System.out.println(jugadores.get(i).getJuega());
                    if ( !jugadores.get(i).getJuega() ) {
                        if( i == 2 ) {
                            jugadores.get(0).setJuega(true);
                        } else {
                            jugadores.get(i+1).setJuega(true);
                        }
                    }
    
    
                    switch (opcion.charAt(0)) {
                        case '1' -> {
                            jugadores.get(i).tirarRuleta();
                            if(Paneles.estaResuelto( CodigoPartida.getPanel() )) {
                                numResueltos++;
                                jugadores.get(i).setDinero(0);
                                jugadores.get(i).setDineroTotal( jugadores.get(i).getDinero() );
                                System.out.println("HAS RESUELTO EL PANEL");
                                System.out.println("HAS GANADO " + jugadores.get(i).getDinero() + "€");
                                jugar();
                            }
                        }
                        case '2' -> {
                            System.out.println("Escribe el panel");
                            String str = sc.nextLine();
                            panelResuelto = Paneles.resolverPanel(str, panel);
                            if(panelResuelto) {
                                numResueltos++;
                                jugadores.get(i).setDinero(0);
                                jugadores.get(i).setDineroTotal( jugadores.get(i).getDinero() );
                                System.out.println("HAS RESUELTO EL PANEL");
                                System.out.println("HAS GANADO " + jugadores.get(i).getDinero() + "€");
                                jugar();
                            }
                        }
                        case '3' -> {
                            jugadores.get(i).comprarVocal();
                            if(Paneles.estaResuelto( CodigoPartida.getPanel() )) {
                                numResueltos++;
                                jugadores.get(i).setDinero(0);
                                jugadores.get(i).setDineroTotal( jugadores.get(i).getDinero() );
                                System.out.println("HAS RESUELTO EL PANEL");
                                System.out.println("HAS GANADO " + jugadores.get(i).getDinero() + "€");
                                jugar();
                            }
                        }
                    }
                }
            }
            

 
        }
    }

    /*
     * Pidiendo los nombres de los jugadores para crear la partida
     */
    private void jugadores() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la Ruleta de la suerte!!!");
        for( int i = 0; i < 3; i++ ) {
            
            System.out.println("Quien va ha ser el jugador " + (i+1) + " ?");
            nombre = sc.nextLine();
            jugadores.add(new Participantes(nombre, false));
        }

        jugar();
    }
}
