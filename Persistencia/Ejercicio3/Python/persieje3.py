import pickle
import os

class ArchivoCliente:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo

    class Cliente:
        def __init__(self, id, nombre, telefono):
            self.id = id
            self.nombre = nombre
            self.telefono = telefono

        def __str__(self):
            return f"Cliente(id={self.id}, nombre={self.nombre}, telefono={self.telefono})"

    def crear_archivo(self):
        with open(self.nombre_archivo, 'wb') as f:
            pickle.dump([], f)

    def guarda_cliente(self, cliente):
        clientes = self._leer()
        clientes.append(cliente)
        self._escribir(clientes)

    def buscar_cliente(self, id):
        for c in self._leer():
            if c.id == id:
                return c
        return None

    def buscar_celular_cliente(self, id):
        return self.buscar_cliente(id)

    def _leer(self):
        if not os.path.exists(self.nombre_archivo):
            return []
        with open(self.nombre_archivo, 'rb') as f:
            return pickle.load(f)

    def _escribir(self, lista):
        with open(self.nombre_archivo, 'wb') as f:
            pickle.dump(lista, f)

# --- Main ---
if __name__ == "__main__":
    archivo = ArchivoCliente("clientes.pkl")
    archivo.crear_archivo()

    cli1 = ArchivoCliente.Cliente(1, "Andrea", 7894561)
    cli2 = ArchivoCliente.Cliente(2, "Luis", 7123456)

    archivo.guarda_cliente(cli1)
    archivo.guarda_cliente(cli2)

    print("Buscar cliente con ID 1:", archivo.buscar_cliente(1))
    print("Buscar celular de cliente ID 2:", archivo.buscar_celular_cliente(2))
