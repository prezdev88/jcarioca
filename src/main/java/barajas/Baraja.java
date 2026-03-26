package barajas;

import util.Mezclador;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Baraja {

    private LinkedList<Carta> cartas;
    private Random random;

    /*Info inportante para construir una baraja*/
//    public static final byte CARTAS = 52;
    public static final byte JOKERS = 2;
    public static final byte CARTAS_POR_PALO = 13;

    /*Info inportante para construir una baraja*/

    public Baraja(boolean ordenada) {
        cartas = new LinkedList<>();

        /*Añado los jokers*/
        for (int i = 0; i < Baraja.JOKERS; i++) {
            // El joker no tiene rango ni palo, (0, null)
            cartas.add(new Joker());
        }

        int id = 0;
        for (Palo palo : Palo.values()) { // Ciclo para los palos
            for (int indiceCarta = 1; indiceCarta <= CARTAS_POR_PALO; indiceCarta++) { // Ciclo para las 13 cartas
                switch (palo) {
                    case CORAZON:
                        cartas.add(new Carta(id++, indiceCarta, Palo.CORAZON));
                        break;
                    case DIAMANTE:
                        cartas.add(new Carta(id++, indiceCarta, Palo.DIAMANTE));
                        break;
                    case PICA:
                        cartas.add(new Carta(id++, indiceCarta, Palo.PICA));
                        break;
                    case TREBOL:
                        cartas.add(new Carta(id++, indiceCarta, Palo.TREBOL));
                        break;
                }
            }
        }

        if (!ordenada) {
            Mezclador.mezclar(cartas);
        }
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public Carta getCartaRandom() {
        random = new Random();

        // genero un índice random y rescato la carta
        int indice = random.nextInt(cartas.size());
        Carta carta = cartas.get(indice);

        // saco la carta de la baraja
        cartas.remove(carta);

        // retorno la carta
        return carta;
    }

    @Override
    public String toString() {
        return "Baraja{" + "cartas=" + cartas + '}';
    }

    public void imprimir() {
        System.out.println("========================================");
        System.out.println("Cantidad de cartas: " + cartas.size());
        System.out.println("========================================");
        cartas.forEach((carta) -> {
            System.out.println(carta);
        });
    }

}
