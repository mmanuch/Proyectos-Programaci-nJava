/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.manuel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Manuel
 */
public class Xogo {

    private Cela[][] celas;
    private int filas;
    private int columnas;

    public Xogo(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        celas = new Cela[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celas[i][j] = new Cela(i, j);
            }
        }
        encherMinas(minas);
    }

    /**
     * getCela devolve unha cela dunha fila e columna determinadas.
     *
     * @param fila indica unha fila
     * @param columna indica unha columna
     * @return celas devolve a cela coa fila e columna determinadas
     */
    public Cela getCela(int fila, int columna) {
        return celas[fila][columna];
    }

    /**
     * getCelasAdxacentes recibe a lista de celas recibidas como parametro
     *
     * @param c Parametro da clase cela para que identifique as celas e columnas
     * desa clase
     * @return
     */
    private ArrayList<Cela> getCelasAdxacentes(Cela c) {
        ArrayList<Cela> celasAdxacentes = new ArrayList<>();
        int fila = c.getFila();
        int columna = c.getColumna();

        //bucle que recorre todas as celas ata dar coas adxacentes
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && j >= 0 && i < filas && j < columnas && !(i == fila && j == columna)) {
                    celasAdxacentes.add(celas[i][j]);
                }
            }
        }
        return celasAdxacentes;
    }

    /**
     * getMinasAdxacentes Obten a suma das minas das celas adxacentes á que se
     * recibe como parametro
     *
     * @param c Parametro da clase cela para que identifique as minas e celas
     * desa clase
     * @return
     */
    public int getMinasAdxacentes(Cela c) {
        ArrayList<Cela> celasAdxacentes = getCelasAdxacentes(c);
        int minasAdxacentes = 0;

        //bucle para aumentar a cantidade de minas dependendo de cantas haxa
        for (Cela adxacente : celasAdxacentes) {
            if (adxacente.getMinada()) {
                minasAdxacentes++;
            }
        }
        return minasAdxacentes;
    }

    /**
     * abrirCela ocupase de destapar unha cela se as minas adxacentes son
     * maiores que 0, e se son 0 destapa todas as minas tapadas.
     *
     * @param c parametro que indica as celas.
     */
    public void abrirCela(Cela c) {
        //se a cela esta tapada, non pasa nada.
        if (c.getEstado() != Cela.tapada) {
            return;
        }

        //se esta destapada, se devolve a cantidade de minas adxacentes.
        c.setEstado(Cela.destapada);
        int minasAdyacentes = getMinasAdxacentes(c);

        //se hai 0 abre todas as celas con minas.
        if (minasAdyacentes == 0) {
            ArrayList<Cela> celasAdyacentes = getCelasAdxacentes(c);

            for (Cela adxacente : celasAdyacentes) {
                abrirCela(adxacente);
            }
        }
    }

    /**
     * abrirTodasMinas destapa todas as celas con minas. Se mostra cando o
     * xogador perda.
     */
    public void abrirTodasMinas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celas[i][j].getMinada()) {
                    celas[i][j].setEstado(Cela.destapada);
                }
            }
        }
    }

    /**
     * comprobarCelasAbrir comproba se quedan celas sen minas tapadas para saber
     * se o xogador gañou.
     *
     * @return
     */
    public boolean comprobarCelasAbrir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Cela c = celas[i][j];
                if (!c.getMinada() && c.getEstado() != Cela.destapada) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * encherMinas coloca as minas no array, repartindoas aleatoriamente.
     *
     * @param m indica as minas.
     */
    private void encherMinas(int m) {
        Random rand = new Random();
        int fila, columna;

        for (int i = 0; i < m; i++) {
            // Xera coordenadas aleatorias ata que encontra unha cela que non teña mina
            do {
                fila = rand.nextInt(filas);
                columna = rand.nextInt(columnas);
            } while (getCela(fila, columna).getMinada());

            //coloca a mina na celda
            getCela(fila, columna).setMinada(true);
        }
    }

    /**
     * mostrarTaboleiro mostra de forma grafica o taboleiro para que o xogador
     * teña unha indicación visual do xogo
     */
    public void mostrarTaboleiro() {
        System.out.println();
        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.print(" " + j + "  ");
        }
        System.out.println();
        System.out.print("  ");
        for (int j = 0; j < columnas; j++) {
            System.out.print("-+--");
        }
        System.out.println("+");
        for (int i = 0; i < filas; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < columnas; j++) {
                Cela c = getCela(i, j);
                switch (c.getEstado()) {
                    case Cela.destapada:
                        if (c.getMinada()) {
                            System.out.print(" X ");
                        } else {
                            int minasAdxacentes = getMinasAdxacentes(c);
                            if (minasAdxacentes == 0) {
                                System.out.print("   ");
                            } else {
                                System.out.print(" " + minasAdxacentes + " ");
                            }
                        }
                        break;
                    case Cela.marcada:
                        System.out.print(" M ");
                        break;
                    default:
                        System.out.print(" - ");
                        break;
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.print("  ");
            for (int j = 0; j < columnas; j++) {
                System.out.print("-+--");
            }
            System.out.println("+");
        }
        System.out.println();
    }

}
