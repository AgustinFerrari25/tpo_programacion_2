package Implementacion;

import Interface.Conjunto;

public class ConjuntoEstatico implements Conjunto {
    private int[] elementos;
    private int cant;

    public ConjuntoEstatico(){
        elementos = new int[100];
        cant = 0;
    }

    @Override
    public void IncializarConjunto() {
        cant = 0;
    }

    @Override
    public boolean Agregar(int x) {
        if(!Pertenece(x)) {
            if (cant < elementos.length) {
                elementos[cant] = x;
                cant++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Sacar(int x) {
        for (int i = 0; i < cant; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cant - 1];
                cant--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Pertenece(int x) {
        for (int i = 0; i < cant; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    public int[] getElementos() {
        int[] copiaElementos = new int[cant];
        for (int i = 0; i < cant; i++) {
            copiaElementos[i] = elementos[i];
        }
        return copiaElementos;
    }

    public int getCantidad() {
        return cant;
    }
}