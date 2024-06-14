public class Tarjan {
    private int index = 0;
    private Nodo[] stack = new Nodo[1000];
    private int stackSize = 0;
    private int[] indices = new int[1000];
    private int[] lowlinks = new int[1000];
    private boolean[] onStack = new boolean[1000];
    private Nodo[][] componentesFuertementeConexos = new Nodo[1000][];
    private int cfcCount = 0;

    public Nodo[][] encontrarCFC(Grafo grafo) {
        Nodo v = grafo.vertices;
        while (v != null) {
            if (indices[v.id] == 0) {
                strongConnect(v, grafo);
            }
            v = v.siguiente;
        }
        return componentesFuertementeConexos;
    }

    private void strongConnect(Nodo v, Grafo grafo) {
        indices[v.id] = index + 1;
        lowlinks[v.id] = index + 1;
        index++;
        stack[stackSize++] = v;
        onStack[v.id] = true;

        NodoArista arista = v.aristas;
        while (arista != null) {
            Nodo w = arista.destino;
            if (indices[w.id] == 0) {
                strongConnect(w, grafo);
                lowlinks[v.id] = Math.min(lowlinks[v.id], lowlinks[w.id]);
            } else if (onStack[w.id]) {
                lowlinks[v.id] = Math.min(lowlinks[v.id], indices[w.id]);
            }
            arista = arista.siguiente;
        }

        if (lowlinks[v.id] == indices[v.id]) {
            Nodo[] componente = new Nodo[1000];
            int size = 0;
            Nodo w;
            do {
                w = stack[--stackSize];
                onStack[w.id] = false;
                componente[size++] = w;
            } while (w != v);
            Nodo[] componenteFinal = new Nodo[size];
            System.arraycopy(componente, 0, componenteFinal, 0, size);
            componentesFuertementeConexos[cfcCount++] = componenteFinal;
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 1);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(4, 5);
        grafo.agregarArista(5, 4);

        Tarjan tarjan = new Tarjan();
        Nodo[][] cfc = tarjan.encontrarCFC(grafo);
        System.out.println("Componentes Fuertemente Conexos:");
        for (int i = 0; i < tarjan.cfcCount; i++) {
            System.out.print("Componente " + (i + 1) + ": ");
            for (Nodo nodo : cfc[i]) {
                if (nodo != null) {
                    System.out.print(nodo.id + " ");
                }
            }
            System.out.println();
        }
    }
}