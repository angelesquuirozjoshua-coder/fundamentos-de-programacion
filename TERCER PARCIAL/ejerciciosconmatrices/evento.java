import java.util.Scanner;

public class evento {
    public static void main(String[]args) {
    Scanner scanner = new Scanner(System.in);
    boolean accesopermitido =true;


    System.out.print ("Ingrese la edad:");
    int edad = scanner.nextInt ();
    
    System.out.print ("¿Tiene pase VIP? true/false:");
    boolean tienevip = scanner.nextBoolean ();

    System.out.print ("Se encuentra baneado? true/false:");
    boolean baneado = scanner.nextBoolean ();
    
   if (baneado) {
        System.out.println("Acceso denegado");
        }
    else if (edad >= 18 || tienevip) {
        System.out.println ("Acceso permitido");
        
        System.out.print ("¿De que color es tu ropa?:");
        String ropa = scanner.next();

        if (ropa.equalsIgnoreCase("Negro")){
        System.out.println("¡Bienvenido a la zona VIP!");
        } else {
            System.out.println("¡Bienvenido!");
        }
    }
    else {
        System.out.println("Acceso denegado");
    }

    }
    }
