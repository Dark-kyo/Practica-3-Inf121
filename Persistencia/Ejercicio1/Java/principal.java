package Ejercicio1;

public class principal {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.dat");
        archivo.crearArchivo();

        archivo.guardarEmpleado(new Empleado("Carlos", 30, 5000));
        archivo.guardarEmpleado(new Empleado("Lucía", 28, 6200));
        archivo.guardarEmpleado(new Empleado("Pedro", 35, 4800));

        Empleado buscado = archivo.buscaEmpleado("Lucía");
        System.out.println("Buscado: " + buscado);

        Empleado mejorSalario = archivo.mayorSalario(5000);
        System.out.println("Empleado con mayor salario: " + mejorSalario);
    }
}
