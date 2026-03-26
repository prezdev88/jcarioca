import barajas.Carta;
import barajas.Mazo;
import jcarioca.Carioca;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Carioca carioca = new Carioca(Mazo.DESORDENADO, 2);

        int opcion;
        while (true) {
            System.out.println("=====================");
            System.out.println("MENÚ [ACTUAL: " + carioca.getJugadorActual() + "]");
            System.out.println("=====================");
            System.out.println("1.- Ver montoncito");
            System.out.println("2.- Sacar carta de montoncito");
            System.out.println("3.- Sacar carta del mazo");
            System.out.println("4.- Jugar");
            System.out.println("5.- Ver mis cartas");
            System.out.println("OP: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    carioca.imprimirMontoncito();
                    break;

                case 2:
                    Carta carta = carioca.sacarCartaDeMontoncito();
                    if (carta != null) {
                        System.out.println("Carta sacada del montón: " + carta);
                        carioca.getJugadorActual().addCarta(carta);
                    }else{
                        System.out.println("No hay cartas en el montoncito");
                    }
                    break;

                case 3:
                    carta = carioca.sacarCartaDelMazo();
                    System.out.println("Carta sacada del mazo: " + carta);
                    carioca.getJugadorActual().addCarta(carta);
                    break;

                case 4:
                    // jugar
                    carioca.getJugadorActual().imprimirCartas();
                    System.out.print("ID CARTA: ");
                    int idCarta = scan.nextInt();
                    // juega el jugador actual, que es un objeto guardado en Carioca
                    carioca.jugar(idCarta);
                    carioca.switchJugador();
                    break;

                case 5:
                    carioca.getJugadorActual().imprimirCartas();
                    break;
            }

        }
//        carioca.getJugador(0).imprimirCartas();
//        carioca.getJugador(1).imprimirCartas();

    }

}
