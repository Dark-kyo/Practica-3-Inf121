package Ejercicio5;

import java.util.Stack;

public class Pila<T> {
    private Stack<T> elementos;
    public Pila() {
        elementos = new Stack<>();
    }
    public void apilar(T elemento) {
        elementos.push(elemento);
    }
    public T desapilar() {
        if (!elementos.isEmpty()) {
            return elementos.pop();
        } else {
            System.out.println("La pila está vacía.");
            return null;
        }
    }
    public void mostrar() {
        System.out.println("Contenido de la pila: " + elementos);
    }
    public class MainPila {
        public static void main(String[] args) {
            Pila<Integer> pilaEnteros = new Pila<>();
            pilaEnteros.apilar(10);
            pilaEnteros.apilar(20);
            pilaEnteros.apilar(30);
            pilaEnteros.apilar(50);
            pilaEnteros.mostrar();
            System.out.println("Elemento desapilado: " + pilaEnteros.desapilar());
            pilaEnteros.mostrar();
            Pila<String> pilaTextos = new Pila<>();
            pilaTextos.apilar("A");
            pilaTextos.apilar("B");
            pilaTextos.apilar("C");
            pilaTextos.mostrar();
            System.out.println("Elemento desapilado: " + pilaTextos.desapilar());
            pilaTextos.mostrar();
        }
    }

}
