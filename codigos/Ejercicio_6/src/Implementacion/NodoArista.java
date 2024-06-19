package Implementacion;


public class NodoArista{
    public Nodo destino;
    public NodoArista siguiente;

    NodoArista(Nodo destino) {
        this.destino = destino;
        this.siguiente = null;
    }
}