package Implementacion;

import Interfaces.INodo;

public class Nodo implements INodo {
    private int id;
    public Nodo anterior;
    public Nodo siguiente;
    public NodoArista aristas;

    Nodo(int id) {
        this.id = id;
        this.anterior = null;
        this.siguiente = null;
        this.aristas = null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public NodoArista getAristas() {
        return aristas;
    }
}
