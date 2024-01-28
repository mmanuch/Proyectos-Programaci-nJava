/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruletasuerte;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Ruleta {
    /*
     * OPCIONES DE LA RULETA:
     * 1: quiebra
     * 2: pierde turno
     * 3: comodín
     * 4: x2
     * 5: 1/2
     */

    private static final int[] ruleta = { 200, 1, 4, 100, 50, 100, 150, 2, 150,
            100, 50, 100, 200, 50, 150, 12, 50, 150, 100, 3, 150, 100, 50, 100 };
    private static int premio, letras = 0;
    private static String letra;

    /**
     * Utilizamos un Math.random y un switch case
     * para elegir una de las opciones de la ruleta aleatoriamente.
     * @return 
     */
    public static int tirar() {
        
        Scanner sc = new Scanner(System.in);
        premio = 0;
        int opcion = (int) (Math.random() * 24);

        switch (ruleta[opcion]) {
            case 1 -> {
                return 10000;
            }
            case 2 -> {
                return 20000;
            }
            case 3 -> {
                return 30000;
            }
            case 4-> {
                return 40000;
            }
            case 5-> {
                return 50000;
            }
            default -> {
                Paneles.mostrarPanel(CodigoPartida.getPanel());
                System.out.println("Dime una letra");
                letra = sc.nextLine();
                letras = Paneles.buscarLetra(letra.charAt(0), CodigoPartida.getPanel());
                premio += ruleta[opcion] * letras;
            }
        }
        return premio;
    }
}
