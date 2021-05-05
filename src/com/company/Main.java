package com.company;

public class Main {

    public static void main(String[] args) {
        Stack pila = new Stack();

        System.out.println("<<-- Ejemplo de Pila -->>\n\n");

        pila.addStack(4);
        pila.addStack(16);
        pila.addStack(12);
        pila.addStack(8);
        pila.addStack(65);

        System.out.println("<<-- Pila -->>");
        pila.list();
        System.out.println("\n<<-- Tamaño -->");
        System.out.println(pila.getLength());

        System.out.println("\n<<-- Retirar el elemento del tope de la pila -->>");
        pila.removeStack();
        pila.list();
        System.out.println("Tamaño: " + pila.getLength());

        System.out.println("\n<<-- Actualizar el valor del nodo con el valor 12 por 44 -->>");
        pila.edit(12, 44);
        pila.list();
        System.out.println("Tamaño: " + pila.getLength());

        System.out.println("\n<<-- Eliminar el nodo con el valor 16 -->>");
        pila.remover(16);
        pila.list();
        System.out.println("Tamaño: " + pila.getLength());

        System.out.println("\n<<-- Consulta si existe el valor 65 -->>");
        System.out.println(pila.find(65));

        System.out.println("\n<<-- Elimina la pila -->>");
        pila.delete();

        System.out.println("\n<<-- Consulta si la pila esta vacia -->>");
        System.out.println(pila.isEmpty());

        System.out.println("\n\n<<-- Fin de ejemplo pila -->>");
    }
}
