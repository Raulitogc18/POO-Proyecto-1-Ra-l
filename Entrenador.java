import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> pokemones;
    private int rondasGanadas;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        this.rondasGanadas = 0;
    }

    public void agregarPokemon(Pokemon p) {
        pokemones.add(p);
    }

    public Pokemon getPokemon(int index) {
        return pokemones.get(index);
    }

    public String getNombre() {
        return nombre;
    }

    public void ganarRonda() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }
}