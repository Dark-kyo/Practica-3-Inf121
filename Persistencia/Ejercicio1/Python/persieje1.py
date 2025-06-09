import pickle
import os

class ArchivoEmpleado:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo

    class Empleado:
        def __init__(self, nombre, edad, salario):
            self.nombre = nombre
            self.edad = edad
            self.salario = salario

        def __str__(self):
            return f"Empleado(nombre={self.nombre}, edad={self.edad}, salario={self.salario})"

    def crear_archivo(self):
        with open(self.nombre_archivo, 'wb') as f:
            pickle.dump([], f)

    def guardar_empleado(self, empleado):
        empleados = self._leer()
        empleados.append(empleado)
        self._escribir(empleados)

    def busca_empleado(self, nombre):
        for emp in self._leer():
            if emp.nombre.lower() == nombre.lower():
                return emp
        return None

    def mayor_salario(self, sueldo):
        for emp in self._leer():
            if emp.salario > sueldo:
                return emp
        return None

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
    archivo = ArchivoEmpleado("empleados.pkl")
    archivo.crear_archivo()

    emp1 = ArchivoEmpleado.Empleado("Carlos", 30, 5000)
    emp2 = ArchivoEmpleado.Empleado("Lucía", 28, 6200)

    archivo.guardar_empleado(emp1)
    archivo.guardar_empleado(emp2)

    print("Buscar 'Lucía':", archivo.busca_empleado("Lucía"))
    print("Mayor salario que 5100:", archivo.mayor_salario(5100))
