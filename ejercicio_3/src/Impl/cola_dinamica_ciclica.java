package Impl;

import Interface.IQueue;

public class cola_dinamica_ciclica implements IQueue {
    private NodoDoble primero;
    private NodoDoble ultimo;
    private int contador;

    public cola_dinamica_ciclica() {
        this.primero = null;
        this.ultimo = null;
        this.contador = 0;
    }

    @Override
    public void add(int a) {
        NodoDoble nuevo = new NodoDoble(a);
        if (contador == 0) {
            primero = nuevo;
            ultimo = nuevo;
            primero.sigNodo = primero;
            primero.anteriorNodo = primero;
        } else {
            nuevo.anteriorNodo = ultimo;
            nuevo.sigNodo = primero;
            ultimo.sigNodo = nuevo;
            primero.anteriorNodo = nuevo;
            ultimo = nuevo;
        }
        contador++;
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            if (contador == 1) {
                primero = null;
                ultimo = null;
            } else {
                NodoDoble nuevo = primero.sigNodo;
                nuevo.anteriorNodo = ultimo;
                ultimo.sigNodo = nuevo;
                primero = nuevo;
            }
            contador--;
        }
    }

    @Override
    public boolean isEmpty() {
        return contador == 0;
    }

    @Override
    public int first() {
        if (!isEmpty()) {
            return primero.info;
        }
        return -1;
    }

    public void elementoyalrededor() {
        if (!isEmpty()) {
            NodoDoble actual = primero;
            for (int i = 0; i < contador; i++) {
                int anterior = actual.anteriorNodo.info;
                int actualInfo = actual.info;
                int siguiente = actual.sigNodo.info;
                System.out.println("Elemento: " + actualInfo + ", Anterior: " + anterior + ", Siguiente: " + siguiente);
                actual = actual.sigNodo;
            }
        }
    }
}
