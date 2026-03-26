package util;

import barajas.Baraja;
import barajas.Carta;
import barajas.Mazo;
import java.util.Collections;
import java.util.LinkedList;

public class Mezclador {
    public static void mezclar(LinkedList<Carta> cartas){
        Collections.shuffle(cartas);
    }
    
    public static void mezclar(Baraja baraja){
        Mezclador.mezclar(baraja.getCartas());
    }
    
    public static void mezclar(Mazo mazo){
        mazo.getBarajas().forEach((b) -> {
            Mezclador.mezclar(b.getCartas());
        });
    }
}
