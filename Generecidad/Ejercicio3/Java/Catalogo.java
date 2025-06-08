package Ejercicio3;

import java.util.ArrayList;

public class Catalogo<T> {
    private ArrayList<T> elementos;
    public Catalogo() {
        elementos = new ArrayList<>();
    }
    public void agregar(T elemento) {
        elementos.add(elemento);
    }
    public boolean buscar(T elemento) {
        return elementos.contains(elemento);
    }
    public void mostrar() {
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }
    public class MainCatalogo {
        public static void main(String[] args) {
            Catalogo<String> libros = new Catalogo<>();
            libros.agregar("El Quijote");
            libros.agregar("Cien años de soledad");
            System.out.println("Catálogo de libros:");
            libros.mostrar();
            System.out.println("¿Contiene 'El Quijote'? " + libros.buscar("El Quijote"));
            Catalogo<String> productos = new Catalogo<>();
            productos.agregar("Laptop");
            productos.agregar("Mouse");
            System.out.println("Catálogo de productos:");
            productos.mostrar();
            System.out.println("¿Contiene 'Teclado'? " + productos.buscar("Teclado"));
        }
    }

}
