package Ejercicio3;

import java.io.*;
import java.util.ArrayList;

public class ArchivoCliente {
    private String nomA;
    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
    }
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(new ArrayList<Cliente>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardaCliente(Cliente c) {
        ArrayList<Cliente> lista = leerClientes();
        lista.add(c);
        escribirClientes(lista);
    }
    public Cliente buscarCliente(int c) {
        ArrayList<Cliente> lista = leerClientes();
        for (Cliente cli : lista) {
            if (cli.getId() == c) {
                return cli;
            }
        }
        return null;
    }
    public Cliente buscarCelularCliente(int c) {
        return buscarCliente(c);
    }
    // Métodos auxiliares
    private ArrayList<Cliente> leerClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();  // Si hay error, retorna lista vacía
        }
    }
    private void escribirClientes(ArrayList<Cliente> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
