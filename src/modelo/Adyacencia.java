package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alfonso
 */
public enum Adyacencia {
    adj1(new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}),
    adj2(new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}),
    adj3(new int[]{1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}),
    adj4(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}),
    adj5(new int[]{0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0}),
    adj6(new int[]{0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0}),
    adj7(new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}),
    adj8(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}),
    adj9(new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}),
    adj10(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}),
    adj11(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0});

    private final int[] adyacentes;

    private Adyacencia(int[] adyacentes) {
        this.adyacentes = adyacentes;
    }

    public ArrayList getAdyacentes() {
        return new ArrayList<>(Arrays.asList(this.adyacentes));
    }

    public static void mostrarMatriz() {
        for (Adyacencia value : values()) {
            System.out.println(value.getAdyacentes());
        }
    }
}
