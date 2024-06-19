package Interfaces;

import Implementacion.Nodo;

public interface IGrafo {
    void agregarVertice(int id);
    void agregarArista(int origenId, int destinoId);
    Nodo obtenerVertice(int id);

}
