package Ejecucion;

import Implementacion.GrafoAleatorio;
import Implementacion.GrafoAleatorio;

public class Main {
    private static GrafoAleatorio grafo;

    public static void main(String[] args) {
        grafo = new GrafoAleatorio();
        grafo.InicializarGrafo();

        grafo.agregarVertice(18);
        grafo.agregarVertice(6);
        grafo.agregarVertice(57);
        grafo.agregarVertice(23);

        grafo.agregarArista(18,6,10);
        grafo.agregarArista(18,23,5);
        grafo.agregarArista(57,18,15);

        System.out.println("Probabilidad entre 18 y 6: "+grafo.probabilidadArista(18,6));
        System.out.println("Probabilidad entre 18 y 23: "+grafo.probabilidadArista(18,23));
        System.out.println("Probabilidad entre 57 y 18: "+grafo.probabilidadArista(57,18));


    }
}