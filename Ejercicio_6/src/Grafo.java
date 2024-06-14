class Grafo {
    Nodo vertices;

    Grafo() {
        this.vertices = null;
    }

    void agregarVertice(int id) {
        Nodo nuevo = new Nodo(id);
        nuevo.siguiente = vertices;
        if (vertices != null) {
            vertices.anterior = nuevo;
        }
        vertices = nuevo;
    }

    Nodo obtenerVertice(int id) {
        Nodo actual = vertices;
        while (actual != null) {
            if (actual.id == id) return actual;
            actual = actual.siguiente;
        }
        return null;
    }

    void agregarArista(int origenId, int destinoId) {
        Nodo origen = obtenerVertice(origenId);
        Nodo destino = obtenerVertice(destinoId);
        if (origen == null) {
            agregarVertice(origenId);
            origen = obtenerVertice(origenId);
        }
        if (destino == null) {
            agregarVertice(destinoId);
            destino = obtenerVertice(destinoId);
        }
        NodoArista nuevaArista = new NodoArista(destino);
        nuevaArista.siguiente = origen.aristas;
        origen.aristas = nuevaArista;
    }
}