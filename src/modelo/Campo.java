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
    // Método para realizar el recorrido hacia varios posibles jugadores finales basado en velocidad
    public ArrayList<Jugador> recorridoVelocidad(String nombre1, ArrayList<String> nombresFinales) {
        Jugador jugadorInicial = getJugador(nombre1);
        ArrayList<Jugador> jugadoresFinales = new ArrayList<>();

        for (String nombreFinal : nombresFinales) {
            Jugador jugadorFinal = getJugador(nombreFinal);
            if (jugadorFinal != null) {
                jugadoresFinales.add(jugadorFinal);
            }
        }

        if (jugadorInicial == null || jugadoresFinales.isEmpty()) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarMejorCaminoOptimo(jugadorInicial, jugadoresFinales, "velocidad");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }

// Método para encontrar el mejor camino óptimo hacia múltiples jugadores finales
    private ArrayList<Jugador> encontrarMejorCaminoOptimo(Jugador jugadorInicial, ArrayList<Jugador> jugadoresFinales, String criterio) {
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

        // Encontrar el mejor camino a cualquier jugador final
        ArrayList<Jugador> mejorCamino = null;
        int mejorDistancia = Integer.MAX_VALUE;
        for (Jugador jugadorFinal : jugadoresFinales) {
            ArrayList<Jugador> caminoActual = new ArrayList<>();
            int indiceFinal = jugadores.indexOf(jugadorFinal);
            for (int at = indiceFinal; at != -1; at = predecesores[at]) {
                caminoActual.add(0, jugadores.get(at)); // Agregar al principio
            }

            // Verificar si se encontró un camino y comparar distancias
            if (!caminoActual.isEmpty() && caminoActual.get(0).equals(jugadorInicial)) {
                int distanciaFinal = distancias[indiceFinal];
                if (distanciaFinal < mejorDistancia) {
                    mejorDistancia = distanciaFinal;
                    mejorCamino = caminoActual;
                }
            }
        }

        return mejorCamino;
    }

// Método para realizar el recorrido hacia varios posibles jugadores finales basado en posesión
    public ArrayList<Jugador> recorridoPosesion(String nombre1, ArrayList<String> nombresFinales) {
        Jugador jugadorInicial = getJugador(nombre1);
        ArrayList<Jugador> jugadoresFinales = new ArrayList<>();

        for (String nombreFinal : nombresFinales) {
            Jugador jugadorFinal = getJugador(nombreFinal);
            if (jugadorFinal != null) {
                jugadoresFinales.add(jugadorFinal);
            }
        }

        if (jugadorInicial == null || jugadoresFinales.isEmpty()) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarMejorCaminoOptimo(jugadorInicial, jugadoresFinales, "posesión");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }

// Método para realizar el recorrido hacia varios posibles jugadores finales basado en remate
    public ArrayList<Jugador> recorridoRemate(String nombre1, ArrayList<String> nombresFinales) {
        Jugador jugadorInicial = getJugador(nombre1);
        ArrayList<Jugador> jugadoresFinales = new ArrayList<>();

        for (String nombreFinal : nombresFinales) {
            Jugador jugadorFinal = getJugador(nombreFinal);
            if (jugadorFinal != null) {
                jugadoresFinales.add(jugadorFinal);
            }
        }

        if (jugadorInicial == null || jugadoresFinales.isEmpty()) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarMejorCaminoOptimo(jugadorInicial, jugadoresFinales, "remate");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }
}
