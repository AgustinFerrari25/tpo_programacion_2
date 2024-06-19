//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Implementacion.Grafo;
import Implementacion.Nodo;
import Algoritmos.Tarjan;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Añadir vértices manualmente
        for (int i = 1; i <= 5; i++) {
            grafo.agregarVertice(i);
        }

        // Añadir aristas según el grafo simplificado
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 1);
        grafo.agregarArista(4, 5);
        grafo.agregarArista(5, 4);

        Tarjan tarjan = new Tarjan();
        Nodo[][] cfc = tarjan.encontrarCFC(grafo);
        int cfcCount = tarjan.getCfcCount();  // Utilizar el método getter

        System.out.println("Componentes Fuertemente Conexos:");
        for (int i = 0; i < cfcCount; i++) {
            System.out.print("Componente " + (i + 1) + ": ");
            for (Nodo nodo : cfc[i]) {
                if (nodo != null) {
                    System.out.print(nodo.getId() + " ");
                }
            }
            System.out.println();
        }
    }
}