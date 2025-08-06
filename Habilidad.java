public class Habilidad {
    private final String nombre;
    private final Efecto efecto;
    private final int valorEfecto;
    private final double probabilidadActivacion; // 0.3 = 30%

    public Habilidad(String nombre, Efecto efecto, int valorEfecto, double probabilidadActivacion) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valorEfecto = valorEfecto;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public boolean activar() {
        int numero = (int)(Math.random() * 100);
        return numero < (probabilidadActivacion * 100);
    }

    public String getNombre() { return nombre; }
    public Efecto getEfecto() { return efecto; }
    public int getValorEfecto() { return valorEfecto; }
}