package jcarioca;

import barajas.Carta;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Jugador {

    private String nombre;
    private LinkedList<Carta> cartas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartas = new LinkedList<>();
    }

    public Jugador setCartas(LinkedList<Carta> cartas) {
        this.cartas = cartas;
        return this;
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public void addCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta getCarta(int idCarta) {
//        for(Carta c : cartas){
//            if(c.getId() == idCarta){
//                return c;
//            }
//        }
//        
//        return null;
        return cartas.stream()
                .filter(item -> item.getId() == idCarta)
                .collect(Collectors.toList()).get(0);
    }

    public void remover(Carta carta) {
        cartas.remove(carta);
    }

    public Jugador imprimirCartas() {
        System.out.println("===================================");
        System.out.println("Cartas de [" + nombre + "]");
        System.out.println("===================================");
//        int i = 0;
        for (Carta c : cartas) {
            System.out.println(/*"[" + (i++) + "] " +*/c);
        }
        System.out.println("===================================");
        return this;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }
    
    
}
