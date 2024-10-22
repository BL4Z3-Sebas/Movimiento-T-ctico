package Modelo;

/**
 *
 * @author Alfonso
 */
public enum Equipo {

    /**
     *
     */
    j1(new Jugador("Jugador1", 85, 70, 75, Matriz.adj1.getAdyacentes())),
    j2(new Jugador("Jugador2", 80, 65, 80, Matriz.adj2.getAdyacentes())),
    j3(new Jugador("Jugador3", 75, 80, 70, Matriz.adj3.getAdyacentes())),
    j4(new Jugador("Jugador4", 70, 85, 65, Matriz.adj4.getAdyacentes())),
    j5(new Jugador("Jugador5", 82, 75, 78, Matriz.adj5.getAdyacentes())),
    j6(new Jugador("Jugador6", 78, 82, 73, Matriz.adj6.getAdyacentes())),
    j7(new Jugador("Jugador7", 75, 70, 80, Matriz.adj7.getAdyacentes())),
    j8(new Jugador("Jugador8", 79, 73, 85, Matriz.adj8.getAdyacentes())),
    j9(new Jugador("Jugador9", 81, 68, 75, Matriz.adj9.getAdyacentes())),
    j10(new Jugador("Jugador10", 73, 80, 77, Matriz.adj10.getAdyacentes())),
    j11(new Jugador("Jugador11", 77, 75, 78, Matriz.adj11.getAdyacentes()));

    private final Jugador jugador;

    private Equipo(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getInstacia() {
        return this.jugador;
    }

    public static void mostrarEquipo() {
        for (Equipo value : values()) {
            System.out.println(value.getInstacia().toString());
        }
    }
}
