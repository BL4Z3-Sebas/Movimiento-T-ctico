package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Campo {

    private ArrayList<Jugador> jugadores;
    private int[][] matrizAdyacencia;

    // Constructor que inicializa la lista de jugadores y la matriz de adyacencia
    public Campo(ArrayList<Jugador> jugadores, int[][] matrizAdyacencia) {
        this.jugadores = jugadores;
        this.matrizAdyacencia = matrizAdyacencia;
    }

    // Método para agregar un jugador a la lista
    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    // Método para obtener un jugador por su nombre de manera iterativa
    public Jugador getJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;  // Retorna null si no se encuentra el jugador
    }

    // Método para realizar el recorrido basado en velocidad
    public ArrayList<Jugador> recorridoVelocidad(String nombre1, String nombre2) {
        Jugador jugadorInicial = getJugador(nombre1);
        Jugador jugadorFinal = getJugador(nombre2);

        if (jugadorInicial == null || jugadorFinal == null) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarCaminoOptimo(jugadorInicial, jugadorFinal, "velocidad");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }

    // Método para encontrar el camino óptimo basado en un atributo (velocidad, posesión, remate)
    private ArrayList<Jugador> encontrarCaminoOptimo(Jugador jugadorInicial, Jugador jugadorFinal, String criterio) {
        int numJugadores = jugadores.size();
        boolean[] visitado = new boolean[numJugadores];
        int[] distancias = new int[numJugadores];
        int[] predecesores = new int[numJugadores]; // Para reconstruir el camino

        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        int indiceInicial = jugadores.indexOf(jugadorInicial);
        distancias[indiceInicial] = 0;

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>((a, b) -> Integer.compare(distancias[a], distancias[b]));
        colaPrioridad.offer(indiceInicial);

        while (!colaPrioridad.isEmpty()) {
            int indiceActual = colaPrioridad.poll();
            if (visitado[indiceActual]) {
                continue;
            }
            visitado[indiceActual] = true;

            for (int i = 0; i < numJugadores; i++) {
                if (matrizAdyacencia[indiceActual][i] == 1 && !visitado[i]) {
                    int peso = 0;
                    if (criterio.equals("velocidad")) {
                        peso = jugadores.get(i).getVelocidad();
                    } else if (criterio.equals("posesión")) {
                        peso = jugadores.get(i).getPosesion();
                    } else if (criterio.equals("remate")) {
                        peso = jugadores.get(i).getRemate();
                    }
                    int nuevaDistancia = distancias[indiceActual] + peso;

                    if (nuevaDistancia < distancias[i]) {
                        distancias[i] = nuevaDistancia;
                        predecesores[i] = indiceActual;
                        colaPrioridad.offer(i);
                    }
                }
            }
        }

        // Reconstruir el camino desde el jugadorFinal
        ArrayList<Jugador> camino = new ArrayList<>();
        int indiceFinal = jugadores.indexOf(jugadorFinal);
        for (int at = indiceFinal; at != -1; at = predecesores[at]) {
            camino.add(0, jugadores.get(at)); // Agregar al principio
        }

        // Verificar si se encontró un camino
        if (camino.size() == 1 && !camino.get(0).equals(jugadorInicial)) {
            return null; // No se encontró camino
        }
        return camino;
    }

// Método para realizar el recorrido basado en posesión
    public ArrayList<Jugador> recorridoPosesion(String nombre1, String nombre2) {
        Jugador jugadorInicial = getJugador(nombre1);
        Jugador jugadorFinal = getJugador(nombre2);

        if (jugadorInicial == null || jugadorFinal == null) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarCaminoOptimo(jugadorInicial, jugadorFinal, "posesión");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }

// Método para realizar el recorrido basado en remate
    public ArrayList<Jugador> recorridoRemate(String nombre1, String nombre2) {
        Jugador jugadorInicial = getJugador(nombre1);
        Jugador jugadorFinal = getJugador(nombre2);

        if (jugadorInicial == null || jugadorFinal == null) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarCaminoOptimo(jugadorInicial, jugadorFinal, "remate");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }
}
