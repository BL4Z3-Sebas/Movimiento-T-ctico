package nodelo;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Jugador {

    private int velocidad;
    private int posesion;
    private int remate;
    private String nombre;
    private ArrayList<Jugador> adyacentes;

    public Jugador(String nombre, int velocidad, int posesion, int remate) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.posesion = posesion;
        this.remate = remate;
        this.adyacentes = new ArrayList<>();
    }

    public Jugador(String nombre, int velocidad, int posesion, int remate, ArrayList adyacencia) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.posesion = posesion;
        this.remate = remate;
        this.adyacentes = adyacencia;
    }

    public Jugador(int velocidad, int posesion, int remate) {

    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPosesion() {
        return posesion;
    }

    public void setPosesion(int posesion) {
        this.posesion = posesion;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public ArrayList getJugadores() {
        return adyacentes;
    }

    public void addJugador(Jugador jugador) {
        this.adyacentes.add(jugador);
        jugador.getJugadores().add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + ", " + velocidad + ", " + posesion + ", " + remate;
    }

}
