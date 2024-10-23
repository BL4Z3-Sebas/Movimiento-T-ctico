package modelo; 

import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class Campo {

    ArrayList<Jugador> Jugadores;

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
    public void recorridoVelocidadRecursivo(String nombre1, String nombre2, Camino camino, int i){
        
    }

    public void recorridoPosesion() {

    }

    public void recorridoRemate() {

    }

}
