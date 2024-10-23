package ista; 


import java.util.List;

import nodelo.Jugador;
import reader.LeerJugadores;
import reader.LeerMatriz;

/**
 *
 * @author andre
 */
public class Movimiento_Tactico {

    public static void main(String[] args) {
        // Leer la lista de jugadores desde el archivo CSV
        List<Jugador> jugadores = LeerJugadores.leerArchivoJugadores("src/recursos/jugadores.csv");
        
        // Leer la matriz de adyacencia desde el archivo CSV
        int[][] matrizAdyacencia = LeerMatriz.leerMatriz("src/recursos/matriz_adyacencia.csv");
        
        // Crear el objeto Campo con los jugadores y la matriz de adyacencia
        //Campo campo = new Campo(new ArrayList<>(jugadores), matrizAdyacencia);

        // Simulación de algunos recorridos
        String jugadorInicial = "Jugador1";
        String jugadorFinal = "Jugador5";

        // Recorrido basado en velocidad
        System.out.println("Recorrido basado en velocidad:");
        //campo.recorridoVelocidad(jugadorInicial, jugadorFinal);

        // Recorrido basado en posesión
        System.out.println("Recorrido basado en posesión:");
        //campo.recorridoPosesion(jugadorInicial, jugadorFinal);

        // Recorrido basado en remate
        System.out.println("Recorrido basado en remate:");
        //campo.recorridoRemate(jugadorInicial, jugadorFinal);
    }
}
