import java.util.*;

public class SistemaEstudiantes {

    void main() {
        Scanner ed = new Scanner(System.in);

        List<String> matricula = new LinkedList<>();
        List<String> nombre = new LinkedList<>();
        List<Double> calificacion = new LinkedList<>();

        int op = 0;

        System.out.println("========= SISTEMA DE ADMINISTRACION DE ESTUDIANTES ============\n");

        do {
            mostrarMenu();
            op = ed.nextInt();

            switch (op) {
                case 1:
                    int existe = 0;
                    do {
                        System.out.print("\nMatricula: ");
                        String matri = ed.next();

                        if (matricula.contains(matri)) {
                            System.out.println("\nMatricula existente\n");      
                            existe = -1;
                        } else {
                            matricula.add(matri);
                            break;
                        }
                    } while (existe == -1);

                    System.out.print("Nombre: ");
                    String nom = ed.next();
                    nombre.add(nom);

                    System.out.print("Calificacion: ");
                    Double cali = ed.nextDouble();
                    calificacion.add(cali);
                    break;
                
                case 2: 
                    System.out.println("Alumnos, de forma ordenada: \n");
                    List<Integer> indices = new LinkedList<>();
                    for (int i = 0; i < nombre.size(); i++) {
                        indices.add(i);
                    }

                    indices.sort((i1, i2) -> nombre.get(i1).compareToIgnoreCase(nombre.get(i2)));

                    for (int i : indices) {
                        System.out.println("Matricula: " + matricula.get(i) + 
                                           " | Nombre: " + nombre.get(i) + 
                                           " | Calificacion: " + calificacion.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la matricula: ");
                    String matri = ed.next();
                    int indice = matricula.indexOf(matri);

                    if (indice == -1) {
                        System.out.println("Alumno no encontrado");
                    } else {
                        System.out.println("Nombre: " + nombre.get(indice));
                        System.out.println("Matricula: " + matricula.get(indice));
                        System.out.println("Calificacion: " + calificacion.get(indice));
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la matricula: ");
                    matri = ed.next();

                    if (matricula.contains(matri)) {
                        indice = matricula.indexOf(matri);
                        System.out.print("Nueva calificacion: ");
                        Double nueva_c = ed.nextDouble();
                        calificacion.set(indice, nueva_c);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la matricula: ");
                    matri = ed.next();
                    indice = matricula.indexOf(matri);

                    if (matricula.contains(matri)) {
                        matricula.remove(indice);
                        nombre.remove(indice);
                        calificacion.remove(indice);
                        System.out.println("Eliminado");
                    } else {
                        System.out.println("Alumno no encontrado!");
                    }
                    break;

                case 6:
                    int longitud = calificacion.size();
                    if (longitud == 0) {
                        System.out.println("\nNo hay calificaciones registradas.");
                        break;
                    }
                    Double promedio_general = 0.0; 
                    double suma = 0;

                    for (Double calificaciones : calificacion) {
                        suma += calificaciones; 
                    }
                    promedio_general = suma / longitud;
                    System.out.println("\nEl promedio general del grupo es: " + promedio_general);
                    break;
                
                case 7:
                    if (calificacion.isEmpty()) {
                        System.out.println("\nNo hay estudiantes registrados.");
                        break;
                    }
                    System.out.println("=== ESTUDIANTE CON CALIFICACIÓN MÁS ALTA Y MÁS BAJA ===\n");
                    
                    List<Integer> indicesOrdenados = new LinkedList<>();
                    for (int i = 0; i < nombre.size(); i++) {
                        indicesOrdenados.add(i);
                    }

                 
                    indicesOrdenados.sort((i1, i2) -> Double.compare(calificacion.get(i2), calificacion.get(i1)));

                   
                    int idxMayor = indicesOrdenados.get(0);
                    int idxMenor = indicesOrdenados.get(indicesOrdenados.size() - 1);

                    System.out.println(" Calificación MÁS ALTA:");
                    System.out.println("Matricula: " + matricula.get(idxMayor) + 
                                       " | Nombre: " + nombre.get(idxMayor) + 
                                       " | Calificacion: " + calificacion.get(idxMayor));

                    System.out.println("\n Calificación MÁS BAJA:");
                    System.out.println("Matricula: " + matricula.get(idxMenor) + 
                                       " | Nombre: " + nombre.get(idxMenor) + 
                                       " | Calificacion: " + calificacion.get(idxMenor));
                    break;
                        
                case 8:
                    System.out.println("Calificacion de mayores a 9 \n");
                    indices = new LinkedList<>();
                    for (int i = 0; i < nombre.size(); i++) {
                        indices.add(i);
                    }

                    indices.sort((i1, i2) -> Double.compare(calificacion.get(i2), calificacion.get(i1)));
                    
                    for (int i : indices) {
                        String resultado = calificacion.get(i) > 9 ? "Matricula: " + matricula.get(i) + 
                                           " | Nombre: " + nombre.get(i) + 
                                           " | Calificacion: " + calificacion.get(i) : "";
                        if (!resultado.isEmpty()) {
                            System.out.println(resultado);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida!");
                    break;
            }

        } while (op != 0);

        ed.close();
    }

    static void mostrarMenu() {
        System.out.println("\n1. Registrar estudiante");
        System.out.println("2. Mostrar estudiantes alfabeticamente");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Modificar calificacion");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Promedio general");
        System.out.println("7. Calificacion mayor y menor");
        System.out.println("8. Estudiantes con promedio mayor a 9");
        System.out.println("0. Salir\n");
        System.out.print("Selecciona una opcion: ");
    }
}