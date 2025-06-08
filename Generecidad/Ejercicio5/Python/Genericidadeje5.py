from typing import Generic, TypeVar, List, Optional

T = TypeVar('T')
class Pila(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []
    def apilar(self, elemento: T) -> None:
        self.elementos.append(elemento)
    def desapilar(self) -> Optional[T]:
        if self.elementos:
            return self.elementos.pop()
        print("La pila está vacía.")
        return None
    def mostrar(self) -> None:
        print("Contenido de la pila:", self.elementos)
 # Pila de enteros
pila_enteros = Pila[int]()
pila_enteros.apilar(10)
pila_enteros.apilar(20)
pila_enteros.apilar(30)
pila_enteros.mostrar()
print("Elemento desapilado:", pila_enteros.desapilar())
pila_enteros.mostrar()

# Pila de textos
pila_textos = Pila[str]()
pila_textos.apilar("A")
pila_textos.apilar("B")
pila_textos.apilar("C")
pila_textos.mostrar()
print("Elemento desapilado:", pila_textos.desapilar())
pila_textos.mostrar()

