package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        ArchFarmacia archivo = new ArchFarmacia("farmacias.dat");
        archivo.crearArchivo();
        Medicamento m1 = new Medicamento("Golpex", 101, "Tos", 12.5);
        Medicamento m2 = new Medicamento("Jarabe T", 102, "Tos", 8.0);
        Medicamento m3 = new Medicamento("Gripol", 103, "Resfrío", 10.0);
        Farmacia f1 = new Farmacia("FarmaSalud", 1, "Av. Siempre Viva 123");
        f1.agregarMedicamento(m1);
        f1.agregarMedicamento(m3);
        Farmacia f2 = new Farmacia("Farmamed", 2, "Calle Luna 456");
        f2.agregarMedicamento(m2);
        archivo.adicionar(f1);
        archivo.adicionar(f2);
        // b) Mostrar medicamentos para la tos de sucursal 1
        System.out.println("Medicamentos para la Tos en Sucursal 1:");
        archivo.mostrarMedicamentosTos(1);

        // c) Mostrar sucursal y dirección que tienen Golpex
        System.out.println("\nSucursales que tienen Golpex:");
        archivo.buscarGolpex();
    }
}
