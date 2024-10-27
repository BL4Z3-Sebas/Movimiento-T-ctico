package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author andre
 */
public class Campo {

    private String nombre;
    private int formacion;
    private ArrayList<Jugador> jugadores;
    private int[][] matrizAdyacencia;

    public Campo() {
        this.jugadores = new ArrayList<>();
//        matrizAdyacencia = new int[11][11];
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Jugador getJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;  // Retorna null si no se encuentra el jugador
    }

    public void setListaJugadores(ArrayList lista_jugadores) {
        this.jugadores = lista_jugadores;
    }

    public void setMatrizAdyacencia(int[][] matriz_adyacencia) {
        this.matrizAdyacencia = matriz_adyacencia;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFormacion() {
        return formacion;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public double[] getPromedio() {
        double[] promedio = new double[11];
        for (int i = 0; i < 11; i++) {
            Jugador j = jugadores.get(i);
            promedio[0] += j.getVelocidad();
            promedio[1] += j.getPosesion();
            promedio[2] += j.getRemate();
        }
        promedio[0] = promedio[0] / 11;
        promedio[1] = promedio[1] / 11;
        promedio[2] = promedio[2] / 11;

        return promedio;
    }

    //========================================================================//
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
                    switch (criterio) {
                        case "velocidad":
                            peso = jugadores.get(i).getVelocidad();
                            break;
                        case "posesión":
                            peso = jugadores.get(i).getPosesion();
                            break;
                        case "remate":
                            peso = jugadores.get(i).getRemate();
                            break;
                        default:
                            break;
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

    public void imprimirMatriz(int[][] matriz) {
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz1[j] + " ");
            }
            System.out.print("\n");
        }
    }

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
