package Ejercicio3;

public class Principal {
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.dat");
        archivo.crearArchivo();

        archivo.guardaCliente(new Cliente(101, "Andrea", 7894561));
        archivo.guardaCliente(new Cliente(102, "Luis", 7123456));

        Cliente encontrado = archivo.buscarCliente(101);
        System.out.println("Cliente encontrado: " + encontrado);

        Cliente conTelefono = archivo.buscarCelularCliente(102);
        System.out.println("Cliente con celular: " + conTelefono);
    }
}
