import java.util.Arrays;
import java.util.Scanner;

public class DepuracionTransacciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas transacciones deseas registrar?: ");
        int n = scanner.nextInt();

        int[] transaccionesOriginales = new int[n];
        System.out.println("Ingresa los " + n + " identificadores de transacciones:");
        for (int i = 0; i < n; i++) {
            System.out.print("  - Transacción " + (i + 1) + ": ");
            transaccionesOriginales[i] = scanner.nextInt();
        }

        System.out.println("\nArreglo original: " + Arrays.toString(transaccionesOriginales));

        int[] copiaOrdenada = Arrays.copyOf(transaccionesOriginales, transaccionesOriginales.length);
        Arrays.sort(copiaOrdenada);

        int[] tempDepurado = new int[transaccionesOriginales.length];
        int contadorUnicos = 0;

        for (int i = 0; i < transaccionesOriginales.length; i++) {
            int actual = transaccionesOriginales[i];
            boolean yaExiste = false;

            for (int j = 0; j < contadorUnicos; j++) {
                if (tempDepurado[j] == actual) {
                    yaExiste = true;
                    break;
                }
            }

            if (!yaExiste) {
                tempDepurado[contadorUnicos++] = actual;
            }
        }

        int[] arregloDepurado = Arrays.copyOf(tempDepurado, contadorUnicos);
        
        // Ordenar
        Arrays.sort(arregloDepurado);

        int registrosEliminados = transaccionesOriginales.length - arregloDepurado.length;

        System.out.print("Identificadores duplicados: ");
        boolean primerDuplicado = true;
        boolean hayDuplicados = false;

        for (int i = 0; i < copiaOrdenada.length - 1; i++) {
            if (copiaOrdenada[i] == copiaOrdenada[i + 1]) {
                if (i == 0 || copiaOrdenada[i] != copiaOrdenada[i - 1]) {
                    if (!primerDuplicado) {
                        System.out.print(", ");
                    }
                    System.out.print(copiaOrdenada[i]);
                    primerDuplicado = false;
                    hayDuplicados = true;
                }
            }
        }

        if (!hayDuplicados) {
            System.out.print("Ninguno");
        }
        System.out.println();

        System.out.println("Arreglo depurado (ordenado): " + Arrays.toString(arregloDepurado));
        System.out.println("Registros eliminados: " + registrosEliminados);

        
        boolean continuar = true;
        while (continuar) {
            System.out.print("\n¿Deseas agregar más transacciones? (s/n): ");
            char respuesta = scanner.next().toLowerCase().charAt(0);

            if (respuesta == 's') {
                System.out.print("¿Cuántas transacciones deseas agregar?: ");
                int nExtras = scanner.nextInt();

                int[] arregloAmpliado = Arrays.copyOf(arregloDepurado, arregloDepurado.length + nExtras);
                System.out.println("Ingresa los " + nExtras + " nuevos identificadores:");
                for (int i = 0; i < nExtras; i++) {
                    System.out.print("  - Nueva Transacción " + (i + 1) + ": ");
                    arregloAmpliado[arregloDepurado.length + i] = scanner.nextInt();
                }

                Arrays.sort(arregloAmpliado);
                int[] tempAmpliado = new int[arregloAmpliado.length];
                int contadorAmpliadoUnicos = 0;

                for (int i = 0; i < arregloAmpliado.length; i++) {
                    int actual = arregloAmpliado[i];
                    boolean yaExiste = false;

                    for (int j = 0; j < contadorAmpliadoUnicos; j++) {
                        if (tempAmpliado[j] == actual) {
                            yaExiste = true;
                            break;
                        }
                    }

                    if (!yaExiste) {
                        tempAmpliado[contadorAmpliadoUnicos++] = actual;
                    }
                }

                arregloDepurado = Arrays.copyOf(tempAmpliado, contadorAmpliadoUnicos);
                System.out.println("\nArreglo actualizado y ordenado: " + Arrays.toString(arregloDepurado));
            } else {
                continuar = false;
                System.out.println("¡Programa finalizado!");
            }
        }

        scanner.close();
    }
}