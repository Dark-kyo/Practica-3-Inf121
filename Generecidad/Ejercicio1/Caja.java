package Ejercicio1;

public class Caja<T> {
	private T contenido;
	public void guardar(T valor) {
		this.contenido= valor;
	}
	public T obtener(){
		return contenido;
	}
	public class Main {
	    public static void main(String[] args) {
	        Caja<String> c1 = new Caja<>();
	        c1.guardar("Oscura");
	        Caja<Integer> c2 = new Caja<>();
	        c2.guardar(7);
	        System.out.println("Contenido de caja1: " + c1.obtener());
	        System.out.println("Contenido de caja2: " + c2.obtener());
	    }
	}
}
