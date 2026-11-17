import java.util.Scanner;

public class Cola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 5;
        String[] cola = new String[max];
        int frente = 0;
        int fin = -1;
        int cantidad = 0;
        
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n==================================");
            System.out.println("    SISTEMA DE COLAS (FIFO)");
            System.out.println("==================================");
            System.out.println("1. Insertar dato (Enqueue)");
            System.out.println("2. Sacar dato de uno en uno (Dequeue)");
            System.out.println("3. Mostrar estado de la cola");
            System.out.println("4. Sacar varios elementos (N elementos)");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (cantidad >= max) {
                        System.out.println("¡ERROR! Desbordamiento. La cola está llena.");
                    } else {
                        System.out.print("Ingresa el elemento a guardar: ");
                        String nuevoDato = scanner.nextLine();
                        
                        fin++;
                        cola[fin] = nuevoDato;
                        cantidad++;
                        System.out.println("¡Éxito! Se agregó '" + nuevoDato + "'.");
                    }
                    break;

                case 2:
                    if (cantidad == 0) {
                        System.out.println("¡ERROR! Subdesbordamiento. La cola está vacía.");
                    } else {
                        System.out.println("Salió el elemento: " + cola[frente]);
                        cola[frente] = null;
                        
                        for (int i = 0; i < fin; i++) {
                            cola[i] = cola[i + 1];
                        }
                        cola[fin] = null;
                        fin--;
                        cantidad--;
                        
                        System.out.println("Elemento extraído correctamente.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- ESTADO ACTUAL DE LA COLA ---");
                    
                    if (cantidad == 0) {
                        System.out.println("[ Cola vacía ]");
                    } else {
                        for (int i = 0; i <= fin; i++) {
                            System.out.println("Posición " + i + " -> " + cola[i]);
                        }
                        System.out.println("-> El FRENTE está en: " + 0);
                        System.out.println("-> El FIN está en: " + fin);
                    }
                    break;

                case 4:
                    System.out.println("\n--- VACIAR COLA ---");
                    if (cantidad == 0) {
                        System.out.println("La cola está vacía, no hay nada que sacar.");
                    } else {
                        System.out.print("¿Cuántos elementos deseas sacar? (Hay " + cantidad + " disponibles): ");
                        int aSacar = scanner.nextInt();
                        scanner.nextLine();

                        if (aSacar <= 0) {
                            System.out.println("Número no válido.");
                        } else if (aSacar > cantidad) {
                            System.out.println("No puedes sacar tantos. Solo hay " + cantidad + " elementos en la cola.");
                        } else {
        
                            for (int k = 0; k < aSacar; k++) {
                                System.out.println("Salió: " + cola[frente]);
                                
                                for (int i = 0; i < fin; i++) {
                                    cola[i] = cola[i + 1];
                                }
                                cola[fin] = null;
                                fin--;
                                cantidad--;
                            }
                            System.out.println("Se extrajeron " + aSacar + " elementos correctamente.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Elige un número del 1 al 5.");
                    break;
            }
        }
        
        scanner.close();
    }
}