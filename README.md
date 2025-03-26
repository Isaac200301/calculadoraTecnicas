# Calculadora en Java con GUI (JOptionPane)

## Descripción
Este proyecto es una calculadora desarrollada en Java que utiliza `JOptionPane` para mostrar una interfaz gráfica de usuario (GUI). Permite realizar operaciones matemáticas básicas como suma, resta, multiplicación y división, además de evaluaciones con operadores relacionales, de bits, booleanos e incrementales.

## Contenido del Código
El código se organiza en tres clases principales:
- `Calcular`: Contiene métodos estáticos para realizar operaciones matemáticas y lógicas.
- `Menu`: Se encarga de la interfaz gráfica y la interacción con el usuario.
- `Calculadora`: La clase principal que inicia la aplicación.

---

## Explicación del Código

### 1. **Clase `Calcular`**
Esta clase contiene métodos estáticos que ejecutan diferentes operaciones matemáticas y lógicas. Veamos cada uno de sus métodos:

#### 📌 **Métodos Aritméticos**
Estos métodos realizan operaciones básicas y devuelven un string con el resultado formateado.

```java
public static String sumar(double a, double b) {
    return a + " + " + b + " = " + (a + b);
}
```
🔹 **Explicación:**
- Recibe dos números (`a` y `b`).
- Devuelve una cadena de texto con la operación y el resultado.

Los métodos de resta, multiplicación y división funcionan de manera similar:

```java
public static String dividir(double a, double b) {
    return (b == 0) ? "Error: No se puede dividir por cero" : a + " / " + b + " = " + (a / b);
}
```
🔹 **Explicación:**
- Si `b` es `0`, devuelve un mensaje de error para evitar una división por cero.
- Si `b` es diferente de `0`, realiza la división normalmente.

#### 📌 **Método `operadoresRelacionales`**
Evalúa comparaciones entre dos números y devuelve los resultados.

```java
public static String operadoresRelacionales(double a, double b) {
    return a + " > " + b + " = " + (a > b) + "\n" +
           a + " < " + b + " = " + (a < b) + "\n" +
           a + " == " + b + " = " + (a == b);
}
```
🔹 **Explicación:**
- Evalúa si `a` es mayor, menor o igual a `b`.
- Devuelve los resultados en un formato legible.

#### 📌 **Método `operadoresBits`**
Realiza operaciones bit a bit (&, |, ^) y las muestra en formato decimal y binario.

```java
public static String operadoresBits(int a, int b) {
    return String.format("%d & %d = %d (%s & %s = %s)\n", a, b, (a & b), binario(a), binario(b), binario(a & b)) +
           String.format("%d | %d = %d (%s | %s = %s)\n", a, b, (a | b), binario(a), binario(b), binario(a | b)) +
           String.format("%d ^ %d = %d (%s ^ %s = %s)", a, b, (a ^ b), binario(a), binario(b), binario(a ^ b));
}
```
🔹 **Explicación:**
- Convierte los números en binario y muestra la comparación entre ellos.
- Operaciones bit a bit:
  - `&` (AND)
  - `|` (OR)
  - `^` (XOR)

El método `binario(int num)` convierte un número entero a una representación binaria:

```java
private static String binario(int num) {
    return String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
}
```

#### 📌 **Método `operadoresBooleanos`**
```java
public static String operadoresBooleanos(boolean a, boolean b) {
    return a + " AND " + b + " = " + (a && b) + "\n" +
           a + " OR " + b + " = " + (a || b);
}
```
🔹 **Explicación:**
- Realiza operaciones lógicas AND (`&&`) y OR (`||`) entre dos valores booleanos.

#### 📌 **Método `operadoresIncrementales`**

```java
public static String operadoresIncrementales(int a, String operador) {
    StringBuilder resultado = new StringBuilder("Número inicial: " + a + "\n");
    for (int i = 1; i <= 3; i++) {
        switch (operador) {
            case "++x": resultado.append("Pre-incremento (++x): ").append(++a).append("\n"); break;
            case "x++": resultado.append("Post-incremento (x++): ").append(a++).append("\n"); break;
            case "--x": resultado.append("Pre-decremento (--x): ").append(--a).append("\n"); break;
            case "x--": resultado.append("Post-decremento (x--): ").append(a--).append("\n"); break;
            default: return "Operador no válido";
        }
    }
    return resultado.toString();
}
```
🔹 **Explicación:**
- Ejecuta un operador incremental o decremental sobre un número y muestra su efecto durante tres iteraciones.

---

### 2. **Clase `Menu`**
Se encarga de mostrar la interfaz gráfica y manejar la interacción con el usuario.

#### 📌 **Método `mostrarMenu`**
```java
public void mostrarMenu() {
    while (true) {
        String opcion = JOptionPane.showInputDialog(null, "Seleccione una operación:", "Calculadora", JOptionPane.QUESTION_MESSAGE);
        if (opcion == null || opcion.equals("10")) break;
```
🔹 **Explicación:**
- Muestra un cuadro de diálogo con opciones de cálculo.
- Si el usuario elige `10`, el programa se cierra.

Cada opción llama a un método de `Calcular`, solicitando los datos al usuario:

```java
num1 = obtenerNumero("Ingrese el primer número:");
num2 = obtenerNumero("Ingrese el segundo número:");
resultado = Calcular.sumar(num1, num2);
```

### 3. **Clase `Calculadora`**

Esta es la clase principal que ejecuta la calculadora:

```java
public class Calculadora {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
```
🔹 **Explicación:**
- Crea una instancia de `Menu` y llama al método `mostrarMenu()` para iniciar la aplicación.

---


