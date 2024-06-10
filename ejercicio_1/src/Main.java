import impl.pila_dinamica;

public class Main {
    public static void main(String[] args) {
        pila_dinamica pila=new pila_dinamica(5);

        for (int i = 0; i < 6; i++) {
            pila.add(i+1);
            System.out.println("Tope de la pila: " + pila.first());
        }
    }
}