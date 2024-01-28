/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruletasuerte;

import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class Paneles {
    private static final ArrayList<Integer> panelesUsados = new ArrayList<Integer>();

    private static boolean resuelto = false;

    /**
     * Las pistas para saber con que esta relacionado un panel.
     */
    private static final String[] pistas = { 
        "Verano en Galicia",
        "Cuatro de mayo",
        "Tres ciudades gallegas",
        "Crea incerteza",
        "Juego sobrevalorado",
        "Receta típica de verano",
        "El canto del loco",
        "Rick Astley is",
        "Directores de culto",
        "Comida madrileña",
        "Efecto pasillo",
        "Campeón del mundo argentino"
    };


    /*
     * Array que contiene las soluciones de los paneles en string
     */
    private static String[] soluciones = {
        "FAI UN SOL DE CARALLO",
        "QUE LA FUERZA TE ACOMPAÑE",
        "VIGO, LUGO E FERROL",
        "ENTREGAR PRIMERO UN EXAMEN",
        "LA RULETA DE LA SUERTE",
        "PAELLA A LA VALENCIANA",
        "SI NO TE GUSTAS ES QUE NO ESTAS VIVO",
        "NEVER GONNA GIVE YOU UP",
        "STEVEN SPIELBERG Y ALFRED HITCHCOCK",
        "BOCATA DE CALAMARES",
        "PAN Y MANTEQUILLA",
        "LIONEL ANDRES MESSI"
    };
    
    
    
    /**
     * Los paneles enteros divididos por letras.
     */
    private static final char[][][] paneles = {
            {
                    { 'F', 't' },
                    { 'A', 't' },
                    { 'Y', 't' },
                    { ' ', 't' },
                    { 'U', 't' },
                    { 'N', 't' },
                    { ' ', 't' },
                    { 'S', 't' },
                    { 'O', 't' },
                    { 'L', 't' },
                    { ' ', 't' },
                    { 'D', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'C', 't' },
                    { 'A', 't' },
                    { 'R', 't' },
                    { 'A', 't' },
                    { 'L', 't' },
                    { 'L', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },

            {
                    { 'Q', 't' },
                    { 'U', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'F', 't' },
                    { 'U', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { 'Z', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'T', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'A', 't' },
                    { 'C', 't' },
                    { 'O', 't' },
                    { 'M', 't' },
                    { 'P', 't' },
                    { 'A', 't' },
                    { 'Ñ', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },

            {
                    { 'V', 't' },
                    { 'I', 't' },
                    { 'G', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { 'L', 't' },
                    { 'U', 't' },
                    { 'G', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { 'Y', 't' },
                    { ' ', 't' },
                    { 'F', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { 'R', 't' },
                    { 'O', 't' },
                    { 'L', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },
            {
                    { 'E', 't' },
                    { 'N', 't' },
                    { 'T', 't' },
                    { 'R', 't' },
                    { 'E', 't' },
                    { 'G', 't' },
                    { 'A', 't' },
                    { 'R', 't' },
                    { ' ', 't' },
                    { 'P', 't' },
                    { 'R', 't' },
                    { 'I', 't' },
                    { 'M', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { 'U', 't' },
                    { 'N', 't' },
                    { ' ', 't' },
                    { 'E', 't' },
                    { 'X', 't' },
                    { 'A', 't' },
                    { 'M', 't' },
                    { 'E', 't' },
                    { 'N', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },
            {
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'R', 't' },
                    { 'U', 't' },
                    { 'L', 't' },
                    { 'E', 't' },
                    { 'T', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'D', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'S', 't' },
                    { 'U', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { 'T', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },{
                    { 'P', 't' },
                    { 'A', 't' },
                    { 'E', 't' },
                    { 'L', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'V', 't' },
                    { 'A', 't' },
                    { 'L', 't' },
                    { 'E', 't' },
                    { 'N', 't' },
                    { 'C', 't' },
                    { 'I', 't' },
                    { 'A', 't' },
                    { 'N', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },{
                    { 'S', 't' },
                    { 'I', 't' },
                    { ' ', 't' },
                    { 'N', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { 'T', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'G', 't' },
                    { 'U', 't' },
                    { 'S', 't' },
                    { 'T', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'E', 't' },
                    { 'S', 't' },
                    { ' ', 't' },
                    { 'Q', 't' },
                    { 'U', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'N', 't' },
                    { 'O', 't' },
                    { ' ', 't' },
                    { 'E', 't' },
                    { 'S', 't' },
                    { 'T', 't' },
                    { 'A', 't' },
                    { 'S', 't' },
            },{
                    { 'N', 't' },
                    { 'E', 't' },
                    { 'V', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { ' ', 't' },
                    { 'G', 't' },
                    { 'O', 't' },
                    { 'N', 't' },
                    { 'N', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'G', 't' },
                    { 'I', 't' },
                    { 'V', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'U', 't' },
                    { 'P', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },{
                    { 'S', 't' },
                    { 'T', 't' },
                    { 'E', 't' },
                    { 'V', 't' },
                    { 'E', 't' },
                    { 'N', 't' },
                    { ' ', 't' },
                    { 'S', 't' },
                    { 'P', 't' },
                    { 'I', 't' },
                    { 'E', 't' },
                    { 'L', 't' },
                    { 'B', 't' },
                    { 'E', 't' },
                    { 'R', 't' },
                    { 'G', 't' },
                    { ' ', 't' },
                    { 'Y', 't' },
                    { ' ', 't' },
                    { 'A', 't' },
                    { 'L', 't' },
                    { 'F', 't' },
                    { 'R', 't' },
                    { 'E', 't' },
                    { 'D', 't' },
                    { ' ', 't' },
                    { 'C', 't' },
                    { 'O', 't' },
                    { 'C', 't' },
                    { 'K', 't' },
            },
            {
                    { 'B', 't' },
                    { 'O', 't' },
                    { 'C', 't' },
                    { 'A', 't' },
                    { 'T', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { 'D', 't' },
                    { 'E', 't' },
                    { ' ', 't' },
                    { 'C', 't' },
                    { 'A', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { 'M', 't' },
                    { 'A', 't' },
                    { 'R', 't' },
                    { 'E', 't' },
                    { 'S', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },
            {
                    { 'P', 't' },
                    { 'A', 't' },
                    { 'N', 't' },
                    { ' ', 't' },
                    { 'Y', 't' },
                    { ' ', 't' },
                    { 'M', 't' },
                    { 'A', 't' },
                    { 'N', 't' },
                    { 'T', 't' },
                    { 'E', 't' },
                    { 'Q', 't' },
                    { 'U', 't' },
                    { 'I', 't' },
                    { 'L', 't' },
                    { 'L', 't' },
                    { 'A', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
                    { ' ', 't' },
            },
            {
                    { 'L', 't' },
                    { 'I', 't' },
                    { 'O', 't' },
                    { 'N', 't' },
                    { 'E', 't' },
                    { 'L', 't' },
                    { ' ', 't' },
                    { 'A', 't' },
                    { 'N', 't' },
                    { 'D', 't' },
                    { 'R', 't' },
                    { 'E', 't' },
                    { 'S', 't' },
                    { ' ', 't' },
                    { 'M', 't' },
                    { 'E', 't' },
                    { 'S', 't' },
                    { 'S', 't' },
                    { 'I', 't' },
                    { ' ', 't' },
                    { 'C', 't' },
                    { 'U', 't' },
                    { 'C', 't' },
                    { 'C', 't' },
                    { 'I', 't' },
                    { 'T', 't' },
                    { 'T', 't' },
                    { 'I', 't' },
                    { 'N', 't' },
                    { 'I', 't' },
            },

    };

    /**
     * Este método escoge un panel al azar.
     * @return 
     */
    public static int elegirPanel() {
        int random;

        
        do {
            random = (int) (Math.random() * 12);
        } while ( panelesUsados.contains(random) );

        panelesUsados.add( random );
        for (int i = 0; i < paneles[random].length; i++) {
            if(paneles[random][i][0] == ' ') paneles[random][i][1] = 'l';
        }
        return random;
    }

    /**
     * Este método muestra todas las letras del panel.
     * @param n
     */
    public static void mostrarPanel(int n) {
        for (int i = 0; i < paneles[n].length; i++) {

            if (paneles[n][i][1] == 'l') {
                System.out.print(paneles[n][i][0] + " ");
            } else {
                System.out.print("#" + " ");
            }

        }
        System.out.println("");
        System.out.println(pistas[n]);
    }

    /**
     * Este método permite al jugador la opcion de resolver el panel entero.
     * @param cadena
     * @param n
     * @return 
     */
    public static boolean resolverPanel( String cadena, int n ) {
        return ( cadena.equalsIgnoreCase(soluciones[n]) );
    }

    /**
     * Este método cambia el estado de la letra escogida por el jugador
     * y cambia, y llama a mostrarP
     * @param letra
     * @param n
     * @return 
     */
    public static int buscarLetra(char letra, int n) {

        int contador = 0;

        for (int i = 0; i < paneles[n].length; i++) {

            if (Character.toLowerCase(paneles[n][i][0]) == Character.toLowerCase(letra)) {
                paneles[n][i][1] = 'l';
                contador++;
            }
        }
        mostrarPanel(n);
        return contador;
    }

    public static boolean estaResuelto(int n) {
        boolean r = true;
        for ( int i = 0; i < paneles[n].length; i++ ) {
            if( paneles[n][i][1] != 'l' ) r = false;
        }
        return r;
    }
}
