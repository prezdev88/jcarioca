package jcarioca;

import barajas.Carta;
import barajas.Mazo;
import java.util.LinkedList;

public class Carioca {

    private Mazo mazo;
    private LinkedList<Jugador> jugadores;
    private LinkedList<Carta> montoncito; // son las cartas que se dejan cuando un jugador juega
    private Jugador actual;

    public Carioca(boolean orden, int cantJugadores) {
        mazo = new Mazo(orden);
        jugadores = new LinkedList<>();
        montoncito = new LinkedList<>();

        for (int i = 0; i < cantJugadores; i++) {
            jugadores.add(
                    new Jugador("j" + i)
                    .setCartas(mazo.getCartas(12))
            //                    .imprimirCartas()
            );
        }
        switchJugador();
//        mazo.imprimir();
    }
    
    public final void switchJugador(){
        if(actual == null){
            actual = jugadores.get(0);
        }else if(actual == jugadores.get(0)){
            actual = jugadores.get(1);
        }else{
            actual = jugadores.get(0);
        }
    }
    
    public Jugador getJugadorActual(){
        return actual;
    }
    
    public Carta sacarCartaDelMazo(){
        return mazo.sacarCarta();
    }

    public Jugador getJugador(int indice) {
        return jugadores.get(indice);
    }

    public LinkedList<Carta> getCartas(int indiceJugador) {
        return jugadores.get(indiceJugador).getCartas();
    }

    /**
     * Juega el jugador actual, el id de la carta
     * @param idCarta 
     */
    public void jugar(int idCarta) {
        Carta carta = actual.getCarta(idCarta);
        actual.remover(carta);
        montoncito.add(carta);

        imprimirMontoncito();
    }

    public LinkedList<Carta> getMontoncito() {
        return montoncito;
    }

    public Carta sacarCartaDeMontoncito() {
        Carta ultima = montoncito.peekLast();
        montoncito.remove(ultima);
        return ultima;
    }

    public void imprimirMontoncito() {
        System.out.println("=======================");
        System.out.println("Montoncito:");
        System.out.println("=======================");
        for (Carta c : montoncito) {
            System.out.println(c);
        }
        System.out.println("=======================");
    }
}
