import java.util.Scanner;
public class ine {
    public static  void main(String[] Args) {
  Scanner scanner = new Scanner(System.in);

System.out.print ("Ingrese su edad:");
int edad = scanner.nextInt();

System.out.print ("¡Tienes Ine? true/false:");
boolean tieneine = scanner.nextBoolean();

if (edad >= 18 && tieneine) {
    System.out.println ("Puedes entrar");
    } else {
    System.out.println ("No puedes entrar");
}
  scanner.close();
}
}