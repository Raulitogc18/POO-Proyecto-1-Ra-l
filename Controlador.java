import java.util.*;

public class Controlador {
    private Batalla batalla;
    private List<Pokemon> poolPokemon;
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Controlador(Scanner scanner) {

        poolPokemon = Arrays.asList(
            new Pokemon("Charmander", Tipo.FUEGO, 50, 30, new Habilidad("Llama Final", Efecto.AUMENTA_ATAQUE, 15, 0.3)),
            new Pokemon("Squirtle", Tipo.AGUA, 45, 40, new Habilidad("Escudo Natural", Efecto.AUMENTA_DEFENSA, 20, 0.4)),
            new Pokemon("Bulbasaur", Tipo.PLANTA, 48, 35, new Habilidad("Latigazo", Efecto.DANYA_ENEMIGO, 10, 0.5)),
            new Pokemon("Diglett", Tipo.TIERRA, 55, 25, new Habilidad("Come Tierra", Efecto.AUMENTA_ATAQUE, 12, 0.4)),
            new Pokemon("Sandshrew", Tipo.TIERRA, 52, 38, new Habilidad("Excavar", Efecto.AUMENTA_DEFENSA, 18, 0.3)),
            new Pokemon("Vulpix", Tipo.FUEGO, 49, 28, new Habilidad("Fuego Fatuo", Efecto.DANYA_ENEMIGO, 14, 0.4)),
            new Pokemon("Poliwag", Tipo.AGUA, 47, 32, new Habilidad("Burbuja", Efecto.AUMENTA_ATAQUE, 10, 0.5)),
            new Pokemon("Oddish", Tipo.PLANTA, 46, 34, new Habilidad("Drenadoras", Efecto.AUMENTA_DEFENSA, 16, 0.4))
        );
        batalla = new Batalla(entrenador1, entrenador2);
    }

    public void inicializarEntrenadores(String nombre1, String nombre2) {
        this.entrenador1 = new Entrenador(nombre1);
        this.entrenador2 = new Entrenador(nombre2);
        this.batalla = new Batalla(entrenador1, entrenador2);
    }

    public List<String> getPoolPokemonInfo() {
        List<String> info = new ArrayList<>();
        for(int i = 0; i < poolPokemon.size(); i++) {
            info.add(i + ": " + poolPokemon.get(i).getNombre());
        }
        return info;
    }

    public void seleccionarPokemonEntrenador1(int index) {
        entrenador1.agregarPokemon(poolPokemon.get(index));
    }

    public void seleccionarPokemonEntrenador2(int index) {
        entrenador2.agregarPokemon(poolPokemon.get(index));
    }

    public String jugarRonda(int indexP1, int indexP2, boolean usarHabilidad1, boolean usarHabilidad2) {
        Pokemon p1 = entrenador1.getPokemon(indexP1);
        Pokemon p2 = entrenador2.getPokemon(indexP2);

        Ronda ronda = new Ronda(p1, p2);
        ronda.calcularResultado(usarHabilidad1, usarHabilidad2, entrenador1, entrenador2);

        if (ronda.getGanador() == null) {
            return "Empate en la ronda.";
        } else {
            return "Ganador de la ronda: " + ronda.getGanador().getNombre();
        }
    }

    public String obtenerResultadoFinal() {
        
        int victorias1 = entrenador1.getRondasGanadas();
        int victorias2 = entrenador2.getRondasGanadas();
        if (victorias1 > victorias2) {
            return "¡" + entrenador1.getNombre() + " es el ganador de la batalla!";
        } else if (victorias2 > victorias1) {
            return "¡" + entrenador2.getNombre() + " es el ganador de la batalla!";
        } else {
            return "¡La batalla termina en empate!";
        }
    }
}
