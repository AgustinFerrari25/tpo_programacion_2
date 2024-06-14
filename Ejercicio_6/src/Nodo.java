class Nodo {
    int id;
    Nodo anterior;
    Nodo siguiente;
    NodoArista aristas;

    Nodo(int id) {
        this.id = id;
        this.anterior = null;
        this.siguiente = null;
        this.aristas = null;
    }
}