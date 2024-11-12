import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();
        int opcion, calculo;

        System.out.println("\n=== Calculadora de área y de perímetro ===");

        do {
            System.out.println("\nSelecciona una figura: ");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Potencias");
            System.out.println("7. Mostrar Resultados");
            System.out.println("8. Salir");
            System.out.print("\nOpción: ");
            try {
                opcion = scanner.nextInt();
                if (opcion == 8) break;

                if (opcion == 7) {
                    System.out.println("\nResultados:");
                    for (String res : resultados) System.out.println(res);
                    continue;
                }
                if (opcion == 6) {
                    calcularPotencia(scanner, resultados);
                    continue;
                }

                if (opcion < 1 || opcion > 6) {
                    System.out.println("ERR: Opción inválida. Intente de nuevo.");
                    continue;
                }

                System.out.println("\nSeleccione una opción: ");
                System.out.println("1. Área\n2. Perímetro");
                System.out.print("\nOpción: ");
                calculo = scanner.nextInt();

                if (calculo < 1 || calculo > 2) {
                    System.out.println("ERR: Opción inválida. Intente de nuevo.");
                    continue;
                }

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Escriba el radio (m): ");
                        double r = scanner.nextDouble();
                        if (calculo == 1) {
                            resultados.add("Área del Círculo: " + (Math.PI * r * r));
                        } else {
                            resultados.add("Perímetro del Círculo: " + (2 * Math.PI * r));
                        }
                    }
                    case 2 -> {
                        System.out.print("Escriba el lado (m): ");
                        double l = scanner.nextDouble();
                        if (calculo == 1) {
                            resultados.add("Área del Cuadrado: " + (l * l));
                        } else {
                            resultados.add("Perímetro del Cuadrado: " + (4 * l));
                        }
                    }
                    case 3 -> {
                        System.out.print("Digite la base del triángulo (m): ");
                        double b = scanner.nextDouble();
                        System.out.print("Ingrese la altura (m): ");
                        double h = scanner.nextDouble();
                        if (calculo == 1) {
                            resultados.add("Área del Triángulo: " + (b * h / 2));
                        } else {
                            System.out.print("Ingrese los lados restantes (m): ");
                            double lado1 = scanner.nextDouble();
                            double lado2 = scanner.nextDouble();
                            resultados.add("Perímetro del Triángulo: " + (b + lado1 + lado2));
                        }
                    }
                    case 4 -> {
                        System.out.print("Escriba la base del rectángulo (m): ");
                        double base = scanner.nextDouble();
                        System.out.print("Escriba la altura del rectángulo (m): ");
                        double altura = scanner.nextDouble();
                        if (calculo == 1) {
                            resultados.add("Área del Rectángulo: " + (base * altura));
                        } else {
                            resultados.add("Perímetro del Rectángulo: " + (2 * (base + altura)));
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite el lado del pentágono (m): ");
                        double lado = scanner.nextDouble();
                        double apotema = lado / (2 * Math.tan(Math.toRadians(36)));
                        if (calculo == 1) {
                            resultados.add("Área del Pentágono: " + (5 * lado * apotema / 2));
                        } else {
                            resultados.add("Perímetro del Pentágono: " + (5 * lado));
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ERR: Entrada inválida. Intente de nuevo.");
                scanner.next();
            }
        } while (true);

        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    private static void calcularPotencia(Scanner scanner, ArrayList<String> resultados) {
        System.out.print("Digite la base: ");
        double base = scanner.nextDouble();
        System.out.print("Digite el exponente: ");
        int exponente = scanner.nextInt();
        double resultado = calcularRecursividad(base, exponente);
        resultados.add("Potencia de " + base + " ^ " + exponente + " = " + resultado);
    }

    private static double calcularRecursividad(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) return 1 / calcularRecursividad(base, -exponente);
        return base * calcularRecursividad(base, exponente - 1);
    }
}
