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
public class Participantes {

    private int dinero = 0;
    private int dineroTotal = 0;
    private int comodin;
    private int cosasRuleta;
    private boolean juega;
    private String nombre;

    public Participantes(String nombre, boolean juega) {
        this.nombre = nombre;
        this.juega = juega;
    }

    public void setDineroTotal(int d) {
        dineroTotal += d;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int d) {
        dinero = d;
    }

    public boolean getJuega() {
        return juega;
    }

    public void setJuega(boolean juega) {
        this.juega = juega;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Invoca el método de la clase ruleta de tirar y actua en consecuencia
     *
     * @return
     */
    public String tirarRuleta() {
        cosasRuleta = Ruleta.tirar();
        String opcion;
        Scanner sc = new Scanner(System.in);

        switch (cosasRuleta) {
            case 10000 -> {
                dinero = 0;
                juega = false;
                System.out.println("OOOH, QUIEBRA");
                System.out.println(nombre + " tienes " + dinero + "€");
            }
            case 20000 -> {
                juega = false;
                System.out.println("OOOH, PIERDES TURNO");
                System.out.println(nombre + " tienes " + dinero + "€");
            }
            case 30000 -> {
                comodin++;
                System.out.println("ENHORABUENA!! HAS CONSEGUIDO UN COMODÍN");
                System.out.println(nombre + " tienes " + dinero + "€");
            }
            case 40000 -> {
                dinero *= 2;
                System.out.println("HAS CONSEGUIDO MULTIPLICAR TU DINERO POR DOS");
                System.out.println(nombre + " tienes " + dinero + "€");
            }
            default -> {
                dinero += cosasRuleta;
                System.out.println(nombre + " tienes " + dinero + "€");
            }
        }

        System.out.println("QUÉ QUIERES HACER AHORA?");
        System.out.println("[1] Tirar De La Ruleta");
        System.out.println("[2] Resolver El Panel");
        System.out.println("[3] Comprar Una Vocal");
        opcion = sc.nextLine();

        return opcion;
    }


    /*
     * Este método usa el método de buscar letra condicionando el dinero y que sea una vocal
     */
    public void comprarVocal() {
        Scanner s = new Scanner(System.in);
        String l;
        char vocal;
        int lol = 0;
        if (dinero >= 100) {

            System.out.println("¿Qué vocal quieres?");
            l = s.nextLine();
            vocal = Character.toLowerCase(l.charAt(0));
            if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
                dinero -= 50;
                lol = Paneles.buscarLetra(vocal, CodigoPartida.getPanel());
                if (lol == 0) {
                    System.out.println("Lo sentimos, no está esa vocal, pierdes el turno");
                    juega = false;

                }
            } else {
                System.out.println("Te has confundido, mete una vocal");
                comprarVocal();
            }

        } else {
            System.err.println("Necesitas como mínimo tener 100€ para comprar una vocal");
        }
    }

    /*
     * Este método añade una letra que elija el jugador
     */
    public void pedirLetra() {
        Scanner metida = new Scanner(System.in);
        String letraMetida;
        char letra;
        int aux;

        System.out.println("Ingrese una letra");
        letraMetida = metida.nextLine();
        letra = Character.toLowerCase(letraMetida.charAt(0));
        /*
         * El método buscar letra retorna el numero de letras acertadas dependiendo de si acierta o no
         */
        aux = Paneles.buscarLetra(letra, CodigoPartida.getPanel());

        //si tiene un comodín no pierde el turno
        if (aux == 0) {
            if (comodin > 0) {
                comodin--;
                System.out.println("El comodín te ha salvado");
            } else {
                juega = false;
            }
        }
    }
}
