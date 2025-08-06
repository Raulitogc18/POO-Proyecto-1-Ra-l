public class Ronda {
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;
    private Entrenador ganador;

    public Ronda(Pokemon p1, Pokemon p2) {
        this.pokemon1 = p1;
        this.pokemon2 = p2;
    }

    public void calcularResultado(boolean usarHabilidad1, boolean usarHabilidad2, 
            Entrenador e1, Entrenador e2) {
        System.out.println("\n" + e1.getNombre() + " envía a " + pokemon1.getNombre());
        System.out.println(e2.getNombre() + " envía a " + pokemon2.getNombre());

        int ataque1 = pokemon1.calcularAtaque(pokemon2, usarHabilidad1, e1.getNombre());
        int ataque2 = pokemon2.calcularAtaque(pokemon1, usarHabilidad2, e2.getNombre());

        System.out.println("Resultado del turno:");
        System.out.println(pokemon1.getNombre() + " inflige " + ataque1 + " de daño.");
        System.out.println(pokemon2.getNombre() + " inflige " + ataque2 + " de daño.");

        if (ataque1 > ataque2) {
            ganador = e1;
            e1.ganarRonda();
            System.out.println("Ganador de la ronda: " + e1.getNombre());
        } else if (ataque2 > ataque1) {
            ganador = e2;
            e2.ganarRonda();
            System.out.println("Ganador de la ronda: " + e2.getNombre());
        } else {
            ganador = null;
            System.out.println("Empate en la ronda.");
        }
    }

    public Entrenador getGanador() {
        return ganador;
    }
}