package com.example.calculadora;

import javax.swing.JOptionPane;

class Calcular {
    public static String sumar(double a, double b) {
        return a + " + " + b + " = " + (a + b);
    }
    public static String restar(double a, double b) {
        return a + " - " + b + " = " + (a - b);
    }
    public static String multiplicar(double a, double b) {
        return a + " * " + b + " = " + (a * b);
    }
    public static String dividir(double a, double b) {
        return (b == 0) ? "Error: No se puede dividir por cero" : a + " / " + b + " = " + (a / b);
    }
    public static String operadoresRelacionales(double a, double b) {
        return a + " > " + b + " = " + (a > b) + "\n" +
               a + " < " + b + " = " + (a < b) + "\n" +
               a + " == " + b + " = " + (a == b);
    }
    public static String operadoresBits(int a, int b) {
        return String.format("%d & %d = %d (%s & %s = %s)\n", a, b, (a & b), binario(a), binario(b), binario(a & b)) +
               String.format("%d | %d = %d (%s | %s = %s)\n", a, b, (a | b), binario(a), binario(b), binario(a | b)) +
               String.format("%d ^ %d = %d (%s ^ %s = %s)", a, b, (a ^ b), binario(a), binario(b), binario(a ^ b));
    }
    private static String binario(int num) {
        return String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
    }
    public static String operadoresBooleanos(boolean a, boolean b) {
        return a + " AND " + b + " = " + (a && b) + "\n" +
               a + " OR " + b + " = " + (a || b);
    }
    public static String operadoresIncrementales(int a, String operador) {
        StringBuilder resultado = new StringBuilder("Número inicial: " + a + "\n");
        for (int i = 1; i <= 3; i++) {
            switch (operador) {
                case "++x":
                    resultado.append("Ciclo ").append(i).append(" - Pre-incremento (++x): ").append(++a).append("\n");
                    break;
                case "x++":
                    resultado.append("Ciclo ").append(i).append(" - Post-incremento (x++): ").append(a++).append("\n");
                    break;
                case "--x":
                    resultado.append("Ciclo ").append(i).append(" - Pre-decremento (--x): ").append(--a).append("\n");
                    break;
                case "x--":
                    resultado.append("Ciclo ").append(i).append(" - Post-decremento (x--): ").append(a--).append("\n");
                    break;
                default:
                    return "Operador no válido";
            }
        }
        return resultado.toString();
    }
}

class Menu {
    public void mostrarMenu() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(null, 
                "Seleccione una operacion:\n" +
                "1. Suma\n2. Resta\n3. Multiplicacion\n4. Division\n" +
                "5. Operadores Relacionales\n6. Operadores de Bits\n7. Operadores Booleanos\n8. Operadores Incrementales\n10. Salir", 
                "Calculadora", JOptionPane.QUESTION_MESSAGE);
            if (opcion == null || opcion.equals("10")) {
                break;
            }
            double num1 = 0, num2 = 0;
            int num1Int = 0, num2Int = 0;
            boolean bool1 = false, bool2 = false;
            String resultado = "";
            switch (opcion) {
                case "1":
                case "2":
                case "3":
                case "4":
                    num1 = obtenerNumero("Ingrese el primer numero:");
                    num2 = obtenerNumero("Ingrese el segundo numero:");
                    resultado = switch (opcion) {
                        case "1" -> Calcular.sumar(num1, num2);
                        case "2" -> Calcular.restar(num1, num2);
                        case "3" -> Calcular.multiplicar(num1, num2);
                        case "4" -> Calcular.dividir(num1, num2);
                        default -> "";
                    };
                    break;
                case "5":
                    num1 = obtenerNumero("Ingrese el primer numero:");
                    num2 = obtenerNumero("Ingrese el segundo numero:");
                    resultado = Calcular.operadoresRelacionales(num1, num2);
                    break;
                case "6":
                    num1Int = obtenerEntero("Ingrese el primer numero entero:");
                    num2Int = obtenerEntero("Ingrese el segundo numero entero:");
                    resultado = Calcular.operadoresBits(num1Int, num2Int);
                    break;
                case "7":
                    bool1 = obtenerBooleano("Ingrese el primer valor booleano (true/false):");
                    bool2 = obtenerBooleano("Ingrese el segundo valor booleano (true/false):");
                    resultado = Calcular.operadoresBooleanos(bool1, bool2);
                    break;
                case "8":
                    num1Int = obtenerEntero("Ingrese un numero entero:");
                    String operador = JOptionPane.showInputDialog(null, "Ingrese el operador (++x, x++, --x, x--):", "Seleccionar operador", JOptionPane.QUESTION_MESSAGE);
                    resultado = Calcular.operadoresIncrementales(num1Int, operador);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
            }
            JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private double obtenerNumero(String mensaje) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje, "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception e) {
            return 0;
        }
    }
    private int obtenerEntero(String mensaje) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception e) {
            return 0;
        }
    }
    private boolean obtenerBooleano(String mensaje) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
        return "true".equalsIgnoreCase(input);
    }
}

public class Calculadora {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}