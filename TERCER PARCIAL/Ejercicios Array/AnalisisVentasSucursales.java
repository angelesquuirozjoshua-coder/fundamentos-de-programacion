import java.util.Arrays;
import java.util.Scanner;

public class AnalisisVentasSucursales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        System.out.print("¿Cuántas sucursales deseas registrar?: ");
        int numSucursales = scanner.nextInt();
        scanner.nextLine(); 

        String[] sucursales = new String[numSucursales];
        double[][] ventas = new double[numSucursales][12];

       
        for (int i = 0; i < numSucursales; i++) {
            System.out.print("\nIntroduce el nombre de la sucursal " + (i + 1) + ": ");
            sucursales[i] = scanner.nextLine();

            System.out.println("Ingresa las ventas de los 12 meses para " + sucursales[i] + ":");
            for (int j = 0; j < 12; j++) {
                System.out.print("  - Mes de " + meses[j] + ": ");
                ventas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }

        double[] totalesAnuales = new double[numSucursales];
        double[] promediosMensuales = new double[numSucursales];
        int[] mejoresMeses = new int[numSucursales];
        double sumaGlobalTotal = 0;

    
        for (int i = 0; i < numSucursales; i++) {
            double sumaAnual = 0;
            double maxVenta = ventas[i][0];
            int mejorMes = 0;

            for (int j = 0; j < 12; j++) {
                sumaAnual += ventas[i][j];
                if (ventas[i][j] > maxVenta) {
                    maxVenta = ventas[i][j];
                    mejorMes = j;
                }
            }

            totalesAnuales[i] = sumaAnual;
            promediosMensuales[i] = sumaAnual / 12.0;
            mejoresMeses[i] = mejorMes;
            sumaGlobalTotal += sumaAnual;
        }

        double promedioGlobalEmpresa = sumaGlobalTotal / (numSucursales * 12);

    
        System.out.println("\n=== REPORTE DE VENTAS POR SUCURSAL ===");
        for (int i = 0; i < numSucursales; i++) {
            System.out.println("\n" + sucursales[i] + ":");
            System.out.println("  - Total Anual: $" + String.format("%.2f", totalesAnuales[i]));
            System.out.println("  - Promedio Mensual: $" + String.format("%.2f", promediosMensuales[i]));
            System.out.println("  - Mejor Mes: " + meses[mejoresMeses[i]] + " ($" + String.format("%.2f", ventas[i][mejoresMeses[i]]) + ")");
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Promedio global mensual de la empresa: $" + String.format("%.2f", promedioGlobalEmpresa));

        
        System.out.println("\nSucursales con ventas anuales promedio superiores al global:");
        for (int i = 0; i < numSucursales; i++) {
            if (promediosMensuales[i] > promedioGlobalEmpresa) {
                System.out.println("  * " + sucursales[i] + " (Promedio: $" + String.format("%.2f", promediosMensuales[i]) + ")");
            }
        }


double[] totalesOrdenados = Arrays.copyOf(totalesAnuales, totalesAnuales.length);
Arrays.sort(totalesOrdenados);

System.out.println("\n=== RANKING DE SUCURSALES (De mayor a menor venta anual) ===");
boolean[] impreso = new boolean[numSucursales];


int puesto = 1;
for (int i = totalesOrdenados.length - 1; i >= 0; i--) {
    for (int j = 0; j < totalesAnuales.length; j++) {
        if (totalesAnuales[j] == totalesOrdenados[i] && !impreso[j]) {
            System.out.println(puesto + ". " + sucursales[j] + " - Total: $" + String.format("%.2f", totalesAnuales[j]));
            impreso[j] = true;
            puesto++;
            break;
        }
    }
}
        
        scanner.close();
    }
}