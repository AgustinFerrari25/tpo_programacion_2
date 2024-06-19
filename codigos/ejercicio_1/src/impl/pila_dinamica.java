package impl;
import interfaces.IStack;

public class pila_dinamica implements IStack {

    private Nodo primero;
    private int capacidad_maxima;
    private int contador;

    public pila_dinamica(int capacidad_maxima) {
        this.primero = null;
        this.capacidad_maxima = capacidad_maxima;
        this.contador = 0;
    }

    @Override
    public void inicializar() {
        primero = null;
    }

    @Override
    public void add(int a) {
        if (capacidad_maxima > contador) {
            Nodo nuevo = new Nodo();
            nuevo.info = a;
            nuevo.sig = primero;
            contador++;
            primero = nuevo;
        }else {
            System.out.println("Error, no se pudo agregar el numero. Capacidad maxima alcanzada");
        }
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            primero=primero.sig;
            contador--;
        }
    }

    @Override
    public boolean isEmpty() {
        return primero==null;
    }

    @Override
    public int first() {
        if (!isEmpty()) {
            return primero.info;
        }
        return -1;
    }

}
