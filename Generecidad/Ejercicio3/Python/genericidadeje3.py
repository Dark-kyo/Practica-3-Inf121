from typing import Generic, TypeVar, List

T = TypeVar('T')
class Catalogo(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []
    def agregar(self, elemento: T) -> None:
        self.elementos.append(elemento)
    def buscar(self, elemento: T) -> bool:
        return elemento in self.elementos
    def mostrar(self) -> None:
        for elemento in self.elementos:
            print(elemento)
# Catálogo de libros
libros = Catalogo[str]()
libros.agregar("El Quijote")
libros.agregar("Cien años de soledad")
print("📚 Catálogo de libros:")
libros.mostrar()
print("¿Contiene 'El Quijote'?", libros.buscar("El Quijote"))
# Catálogo de productos
productos = Catalogo[str]()
productos.agregar("Laptop")
productos.agregar("Mouse")
print("\n🛒 Catálogo de productos:")
productos.mostrar()
print("¿Contiene 'Teclado'?", productos.buscar("Teclado"))
