package Implementacion;

import Interfaces.IGrafo;

public class Grafo implements IGrafo {
    public Nodo vertices;

    public Grafo() {
        this.vertices = null;
    }

    @Override
    public void agregarVertice(int id) {
        Nodo nuevo = new Nodo(id);
        nuevo.siguiente = vertices;
        if (vertices != null) {
            vertices.anterior = nuevo;
        }
        vertices = nuevo;
    }

    @Override
    public Nodo obtenerVertice(int id) {
        Nodo actual = vertices;
        while (actual != null) {
            if (actual.getId() == id) return actual;
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public void agregarArista(int origenId, int destinoId) {
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
