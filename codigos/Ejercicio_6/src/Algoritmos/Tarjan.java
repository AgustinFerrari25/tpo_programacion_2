package Algoritmos;

import Implementacion.Grafo;
import Implementacion.Nodo;
import Implementacion.NodoArista;
import Interfaces.IGrafo;
public class Tarjan {
    private int index = 0;
    private Nodo[] stack = new Nodo[1000];
    private int stackSize = 0;
    private int[] indices = new int[1000];
    private int[] lowlinks = new int[1000];
    private boolean[] onStack = new boolean[1000];
    private Nodo[][] componentesFuertementeConexos = new Nodo[1000][];
    private int cfcCount = 0;

    public Nodo[][] encontrarCFC(IGrafo grafo) {
        Nodo v = ((Grafo) grafo).vertices;
        while (v != null) {
            if (indices[v.getId()] == 0) {
                strongConnect(v, grafo);
            }
            v = v.siguiente;
        }
        return componentesFuertementeConexos;
    }

    private void strongConnect(Nodo v, IGrafo grafo) {
        indices[v.getId()] = index + 1;
        lowlinks[v.getId()] = index + 1;
        index++;
        stack[stackSize++] = v;
        onStack[v.getId()] = true;

        NodoArista arista = v.aristas;
        while (arista != null) {
            Nodo w = arista.destino;
            if (indices[w.getId()] == 0) {
                strongConnect(w, grafo);
                lowlinks[v.getId()] = Math.min(lowlinks[v.getId()], lowlinks[w.getId()]);
            } else if (onStack[w.getId()]) {
                lowlinks[v.getId()] = Math.min(lowlinks[v.getId()], indices[w.getId()]);
            }
            arista = arista.siguiente;
        }

        if (lowlinks[v.getId()] == indices[v.getId()]) {
            Nodo[] componente = new Nodo[1000];
            int size = 0;
            Nodo w;
            do {
                w = stack[--stackSize];
                onStack[w.getId()] = false;
                componente[size++] = w;
            } while (w != v);
            Nodo[] componenteFinal = new Nodo[size];
            System.arraycopy(componente, 0, componenteFinal, 0, size);
            componentesFuertementeConexos[cfcCount++] = componenteFinal;
        }


    }

    public int getCfcCount() {
        return cfcCount;
    }
}
