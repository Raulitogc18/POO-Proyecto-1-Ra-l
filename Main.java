import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador(scanner);
        
        // 1. Nombres de entrenadores
        System.out.print("Nombre del Entrenador 1: ");
        String nombre1 = scanner.nextLine();
        
        System.out.print("Nombre del Entrenador 2: ");
        String nombre2 = scanner.nextLine();
        controlador.inicializarEntrenadores(nombre1, nombre2);

        // 2. Mostrar pool de Pokémon
        System.out.println("\n--- Selección de Pokémon ---");
        List<String> poolInfo = controlador.getPoolPokemonInfo();
        for(String pokemonInfo : poolInfo) {
            System.out.println(pokemonInfo);
        }

        // 3. Selección de Pokémon
        for(int j = 0; j < 4; j++) {
            System.out.print(nombre1 + ", elige tu Pokémon #" + (j+1) + " (0-7): ");
            controlador.seleccionarPokemonEntrenador1(scanner.nextInt());
        }
        
        for(int j = 0; j < 4; j++) {
            System.out.print(nombre2 + ", elige tu Pokémon #" + (j+1) + " (0-7): ");
            controlador.seleccionarPokemonEntrenador2(scanner.nextInt());
        }

        // 4. Jugar rondas
        for(int ronda = 1; ronda <= 4; ronda++) {
            System.out.println("\n=== Ronda " + ronda + " ===");
            
            System.out.print(nombre1 + ", elige tu Pokémon para esta ronda (0-3): ");
            int p1 = scanner.nextInt();
            
            System.out.print(nombre2 + ", elige tu Pokémon para esta ronda (0-3): ");
            int p2 = scanner.nextInt();
            
            System.out.print(nombre1 + ", ¿usar habilidad? (Si/No): ");
            boolean hab1 = scanner.nextBoolean();
            
            System.out.print(nombre2 + ", ¿usar habilidad? (Si/No): ");
            boolean hab2 = scanner.nextBoolean();

            String resultado = controlador.jugarRonda(p1, p2, hab1, hab2);
            System.out.println(resultado);
        }

        // 5. Resultado final
        System.out.println("\n" + controlador.obtenerResultadoFinal());
        scanner.close();
    }
}
