public class Pokemon {
    private final String nombre;
    private final Tipo tipo;
    private final int ataque;
    private final int defensa;
    private final Habilidad habilidad;

    public Pokemon(String nombre, Tipo tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public int calcularAtaque(Pokemon enemigo, boolean usarHabilidad, String nombreEntrenador) {
        int ataqueTotal = this.ataque;
        boolean habilidadActivada = false;

        // Decidir acción
        if (usarHabilidad) {
            System.out.println(nombreEntrenador + " ordena a " + nombre + " usar " + habilidad.getNombre() + "!");
            habilidadActivada = habilidad.activar();
            if (habilidadActivada) {
                System.out.println("¡La habilidad se activa!");
                switch (habilidad.getEfecto()) {
                    case AUMENTA_ATAQUE:
                        ataqueTotal += habilidad.getValorEfecto();
                        break;
                    case DANYA_ENEMIGO:
                        ataqueTotal += habilidad.getValorEfecto();
                        break;
                    case AUMENTA_DEFENSA:
                        System.out.println(nombre + " aumenta su defensa.");
                        break;
                }
            } else {
                System.out.println("¡La habilidad falló!");
            }
        } else {
            System.out.println(nombreEntrenador + " ordena a " + nombre + " atacar normalmente.");
        }

        // Efectividad de tipo
        int modificadorTipo = 0;
        if ((this.tipo == Tipo.FUEGO && enemigo.tipo == Tipo.PLANTA) ||
            (this.tipo == Tipo.PLANTA && enemigo.tipo == Tipo.AGUA) ||
            (this.tipo == Tipo.AGUA && enemigo.tipo == Tipo.FUEGO) ||
            (this.tipo == Tipo.TIERRA && enemigo.tipo == Tipo.AGUA)) {
            modificadorTipo = 20;
            System.out.println("¡Es súper efectivo contra " + enemigo.getNombre() + "!");
        } else if (this.tipo == Tipo.FUEGO && (((enemigo.tipo == Tipo.AGUA || (this.tipo == Tipo.PLANTA && enemigo.tipo == Tipo.FUEGO)) || (this.tipo == Tipo.AGUA && enemigo.tipo == Tipo.PLANTA)) || (this.tipo == Tipo.AGUA && enemigo.tipo == Tipo.TIERRA))) {
            modificadorTipo = -10;
            System.out.println("No es muy efectivo contra " + enemigo.getNombre() + "...");
        } else {
        }

        ataqueTotal += modificadorTipo;

        int ataqueFinal = ataqueTotal - enemigo.defensa;
        return Math.max(ataqueFinal, 0);
    }

    public String getNombre() { return nombre; }
}
