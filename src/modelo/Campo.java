package modelo;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Campo {

    ArrayList<Jugador> Jugadores;
// public static int[][] matriz=new int[11][11];;
    public Campo() {
        this.Jugadores = new ArrayList<>();
    }

    public void addJugador(Jugador jugadorx) {
        Jugadores.add(jugadorx);
    }

    public Jugador getJugador(String nombre) {
        return getJugadorRecursivo(this.Jugadores, nombre, 0);
    }

    public Jugador getJugadorRecursivo(ArrayList<Jugador> jugadores, String nombre, int i) {
        if (jugadores.get(i) == null) {
            return null;
        }
        if (jugadores.get(i).getNombre().equals(nombre)) {
            return jugadores.get(i);
        }
        return getJugadorRecursivo(jugadores, nombre, i + 1);
    }

    public void recorridoVelocidad(String nombre1, String nombre2) {
        Camino camino = new Camino();
        Jugador jugadori = this.getJugador(nombre1);
        Jugador jugadorf = this.getJugador(nombre2);
        recorridoVelocidadRecursivo(nombre1, nombre2, camino, 0);

    }

    public static int[][] generarMatrizAdyasencia(ArrayList<String> equipos) {
        int [][] matriz=new int[11][11];
        for (String equipo : equipos) {
            String[] marcas=equipo.split(",");
         
            for (int i = 1; i < equipos.size(); i++) {        
                matriz[equipos.indexOf(equipo)][i-1]=Integer.parseInt(marcas[i]);
            }
        }
        return matriz;
    }
    public  void creacionFormacion(ArrayList<Jugador> jugadores,int [][] matriz){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(matriz[i][j]==1){
                    jugadores.get(i).addJugador(jugadores.get(j));
                }
            }
        }
        
      }  
    public void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.print("\n");
        }
        
    }
    public void recorridoVelocidadRecursivo(String nombre1, String nombre2, Camino camino, int i) {

    }

    public void recorridoPosesion() {

    }

    public void recorridoRemate() {

    }

}
