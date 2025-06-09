package Ejercicio5;

import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String nombreArchivo;

    public ArchFarmacia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void crearArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(new ArrayList<Farmacia>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Farmacia f) {
        ArrayList<Farmacia> lista = listar();
        lista.add(f);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Farmacia> listar() {
        ArrayList<Farmacia> lista = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            lista = (ArrayList<Farmacia>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return lista;
    }

    public void mostrarMedicamentosResfrio() {
        for (Farmacia f : listar()) {
            f.mostrarMedicamentos("Resfrío");
        }
    }
    public void mostrarMedicamentosTos(int sucursalX) {
        for (Farmacia f : listar()) {
            if (f.getSucursal() == sucursalX) {
                f.mostrarMedicamentos("Tos");
            }
        }
    }
    public void mostrarMedicamentosMenorTos() {
        for (Farmacia f : listar()) {
            for (Medicamento m : f.medicamentos) {
                if (m.getTipo().equalsIgnoreCase("Tos") && m.getPrecio() < 10.0) {
                    m.mostrar();
                }
            }
        }
    }

    public void buscarGolpex() {
        for (Farmacia f : listar()) {
            if (f.buscaMedicamento("Golpex")) {
                System.out.println("Sucursal: " + f.getSucursal() + ", Dirección: " + f.getDireccion());
            }
        }
    }
}
