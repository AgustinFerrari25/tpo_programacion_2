package Impl;

public class NodoDoble {
    int info;
    NodoDoble sigNodo;
    NodoDoble anteriorNodo;

    public NodoDoble(int info) {
        this.info = info;
        this.sigNodo = null;
        this.anteriorNodo = null;
    }
}
