package barajas;

public class Carta {
    private int id;
    private int rango;
    private Palo palo;

    public Carta(int id, int rango, Palo palo) {
        this.id = id;
        this.rango = rango;
        this.palo = palo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" + "id=" + id + ", rango=" + rango + ", palo=" + palo + '}';
    }
    
    
    
}
