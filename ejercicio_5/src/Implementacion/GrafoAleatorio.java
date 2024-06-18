package Implementacion;

import Interfaz.*;

public class GrafoAleatorio implements GrafoTDA {
    static int tamanio = 50;
    double[][] matriz;
    int[] vertices;
    int cantNodos;

    @Override
    public void InicializarGrafo() {
        matriz = new double[tamanio][tamanio];
        vertices = new int[tamanio];
        cantNodos = 0;
    }

    @Override
    public void agregarVertice(int v) {
        if (buscarIndiceVertice(v) != -1) {
            System.out.println("El vértice " + v + " ya existe en el grafo.");
        } else {
            vertices[cantNodos] = v;
            for (int i = 0; i <= cantNodos; i++) {
                matriz[cantNodos][i] = 0.0;
                matriz[i][cantNodos] = 0.0;
            }
            cantNodos++;
        }
    }

    @Override
    public void eliminarVertice(int v) {
        int ind = buscarIndiceVertice(v);
        if (ind == -1) { 
            System.out.println("El vértice " + v + " no se puede eliminar porque no existe en el grafo.");
        } else {
            for (int i = 0; i < cantNodos; i++) {
                matriz[i][ind] = matriz[i][cantNodos - 1];
            }
            for (int i = 0; i < cantNodos; i++) {
                matriz[ind][i] = matriz[cantNodos - 1][i];
            }
            vertices[ind] = vertices[cantNodos - 1];
            cantNodos--;
        }
    }

    private int buscarIndiceVertice(int v) {
        int i = cantNodos - 1;
        while (i >= 0 && vertices[i] != v)
            i--;
        return i;
    }

    @Override
    public void agregarArista(int v1, int v2, double probabilidad) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);

        if (origen == -1 && destino == -1) {
            System.out.println("Los vértices " + v1 + " y " + v2 + " no existen. No se puede agregar arista.");
        } else if (origen == -1) {
            System.out.println("El vértice " + v1 + " no existe. No se puede agregar arista.");
        } else if (destino == -1) {
            System.out.println("El vértice " + v2 + " no existe. No se puede agregar arista.");
        } else {
            if (probabilidad < 0.0 || probabilidad > 100.0) {
                System.out.println("La probabilidad debe estar entre 0.0 y 100.0");
                return;
            }
            matriz[origen][destino] = probabilidad;
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        if (origen == -1 || destino == -1) {
            System.out.println("Uno o ambos vértices no existen en el grafo.");
            return;
        }
        matriz[origen][destino] = 0.0;
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        if (origen == -1 || destino == -1) {
            return false;
        }
        return matriz[origen][destino] != 0.0;
    }

    @Override
    public double probabilidadArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        if (origen == -1 || destino == -1) {
            return 0.0;
        }
        return matriz[origen][destino];
    }
}
