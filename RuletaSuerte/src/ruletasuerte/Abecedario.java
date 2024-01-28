/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruletasuerte;

/**
 *
 * @author Manuel
 */
public class Abecedario {

    /*
     * l de libre
     * t de tachado
     */
    private char[][] letra = {{'a', 't'}, {'b', 't'}, {'c', 't'}, {'d', 't'},
        {'e', 't'}, {'f', 't'}, {'g', 't'}, {'h', 't'}, {'i', 't'}, {'j', 't'},
        {'k', 't'}, {'l', 't'}, {'m', 't'}, {'n', 't'}, {'ñ', 't'}, {'o', 't'},
        {'p', 't'}, {'q', 't'}, {'r', 't'}, {'s', 't'}, {'t', 't'}, {'u', 't'},
        {'v', 't'}, {'w', 't'}, {'x', 't'}, {'y', 't'}, {'z', 't'}};

    /*
     * Mostramos las letras ingresadas en el array
     */
    
    public void mostrarLetras() {
        for (int i = 0; i < 27; i++) {
            if (letra[i][1] == 'l') {
                System.out.println(letra[i][0]);
            }
        }
    }

    /*
     * Modificamos la posicion de las letras y mostramos el cambio
     */
    
    public void modificarLetra(int posicion, char l) {
        letra[posicion][1] = l;
        mostrarLetras();
    }
}
