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
        vertices[cantNodos] = v;
        for (int i = 0; i <= cantNodos; i++) {
            matriz[cantNodos][i] = 0.0;
            matriz[i][cantNodos] = 0.0;
        }
        cantNodos++;
    }

    @Override
    public void eliminarVertice(int v) {
        int ind = buscarIndiceVertice(v);
        for (int i = 0; i < cantNodos; i++)
            matriz[i][ind] = matriz[i][cantNodos - 1];
        for (int i = 0; i < cantNodos; i++)
            matriz[ind][i] = matriz[cantNodos - 1][i];
        vertices[ind] = vertices[cantNodos - 1];
        cantNodos--;
    }

    private int buscarIndiceVertice(int v) {
        int i = cantNodos - 1;
        while (i >= 0 && vertices[i] != v)
            i--;
        return i;
    }
    
    public void agregarArista(int v1, int v2, double probabilidad) {
        if (probabilidad < 0.0 || probabilidad > 100.0) {
            throw new IllegalArgumentException("La probabilidad debe estar entre 0.0 y 100.0");
        }
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        matriz[origen][destino] = probabilidad;
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        matriz[origen][destino] = 0.0;
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        return matriz[origen][destino] != 0.0;
    }

    @Override
    public double probabilidadArista(int v1, int v2) {
        int origen = buscarIndiceVertice(v1);
        int destino = buscarIndiceVertice(v2);
        return matriz[origen][destino];
    }
}