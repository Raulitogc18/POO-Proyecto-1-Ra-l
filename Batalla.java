public class Batalla {
    private final Entrenador entrenador1;
    private final Entrenador entrenador2;
    private int rondaActual;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondaActual = 1;
    }

    public Entrenador determinarGanador() {
        if (entrenador1.getRondasGanadas() > entrenador2.getRondasGanadas()) {
            return entrenador1;
        } else if (entrenador2.getRondasGanadas() > entrenador1.getRondasGanadas()) {
            return entrenador2;
        } else {
            return null;
        }
    }
}
